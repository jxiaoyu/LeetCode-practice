-module(irc).
-export([start_server/0]).
-export([start_client/1]).
-export([sendMsg/1, sendMsg/2]).

%服务器
start_server() ->
	{ok, Listen} = gen_tcp:listen(2345, [binary, {packet, 4},
										 {reuseaddr, true},
										 {active, true}]),
	register(manager, spawn(fun() -> manager([]) end)),
	spawn(fun() -> par_connect(Listen, manager) end).

%并行连接
par_connect(Listen, Manager) ->
	{ok, Socket} = gen_tcp:accept(Listen),
	Manager ! {new_conn, Socket},
	spawn(fun() -> par_connect(Listen, Manager) end),
	loop(Socket, Manager).

%管理各个socket
manager(Sockets) ->
	receive
		{new_conn, Socket} ->
			NewSockets = [Socket|Sockets],
			manager(NewSockets);
		{data, Socket, Bin} ->
			Val = binary_to_term(Bin),
			Tag = element(1, Val),
			if 
				Tag =:= name ->
					{name, Name} = Val,
					put(Socket, Name),
					put(Name, Socket);
				Tag =:= toEvery ->
					broadcast(Sockets, Bin);
				Tag =:= toWho ->
					{toWho, ToName, Msg} = Val,
					Soc = get(ToName),
					FrName = get(Socket),
					gen_tcp:send(Soc, term_to_binary({FrName, Msg}))
			end,
			manager(Sockets)
	end.

%把数据广播给各个socket
broadcast(Sockets, Bin) ->
	SendData = fun(Socket) ->  
   		gen_tcp:send(Socket, Bin)  
	end,  
	lists:foreach(SendData, Sockets).  

%服务器接收tcp数据的循环
loop(Socket, Manager) ->
	receive
		{tcp, Socket, Bin} ->
			Manager ! {data, Socket, Bin},
			loop(Socket, Manager)
	end.


%客户端
start_client(Name) ->
	register(client, spawn(fun nano_client/0)),
	client ! {send, {name, Name}}.

nano_client() ->
	{ok, Socket} =
		gen_tcp:connect("localhost", 2345, [binary, {packet, 4}]),
	client_loop(Socket).

client_loop(Socket) ->
	receive
		{send, TotalMsg} ->
			ok = gen_tcp:send(Socket, term_to_binary(TotalMsg));
		{tcp, Socket, Bin} ->
			Val = binary_to_term(Bin),
			io:format("~p~n", [Val])
	end,
	client_loop(Socket).

%发送消息
sendMsg(Msg) -> client ! {send, {toEvery, Msg}}.
sendMsg(Name, Msg) -> client ! {send, {toWho, Name, Msg}}.