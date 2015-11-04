%%% -------------------------------------------------------------------
%%% Author: jiangxiaoyu
%%% Description: 提供两玩家对战的井字棋游戏程序
%%%
%%% Created : 2013-10-7
%%% -------------------------------------------------------------------
-module(chess).

-behaviour(gen_server).

-define(PRINT(Text),
    io:format(Text)).
-define(PRINT(Format, Args),
    io:format(Format, Args)).

-define(A, $O).
-define(B, $X).

%% -------------------------------------------------------------------
%% External exports
%% -------------------------------------------------------------------
-export([
		 start/0,
		 stop/0,
		 a/1,
		 b/1
		 ]).

%% gen_server callbacks
-export([init/1, handle_call/3, handle_cast/2, handle_info/2, terminate/2, code_change/3]).

-record(state, {
				board = {$1, $2, $3,
						 $4, $5, $6,
						 $7, $8, $9},
				round = 0
				}).

%% -------------------------------------------------------------------
%% External functions
%% -------------------------------------------------------------------
start() ->
	gen_server:start_link({local, ?MODULE}, ?MODULE, [], []).

stop() ->
	gen_server:call(?MODULE, stop).

%% A在Pos位置下一步
a(Pos) ->
	case gen_server:call(chess, {play, ?A, Pos}) of
		{victory, _} ->
			?PRINT("Player A win.~n"),
			gen_server:call(chess, {stop, win});
		draw ->
			?PRINT("Player draw.~n"),
			gen_server:call(chess, {stop, draw});
		ok ->
			?PRINT("New move: Player B.~n");
		{error, Reason} ->
			?PRINT("~s~n", [Reason]);
		_ ->
			skip
	end.

%% B在Pos位置下一步
b(Pos) ->
	case gen_server:call(chess, {play, ?B, Pos}) of
		{victory, _} ->
			?PRINT("Player B win.~n"),
			gen_server:call(chess, {stop, win});
		draw ->
			?PRINT("Player draw.~n"),
			gen_server:call(chess, {stop, draw});
		ok ->
			?PRINT("New move: Player A.~n");
		{error, Reason} ->
			?PRINT("~s~n", [Reason]);
		_ ->
			skip
	end.

%% -------------------------------------------------------------------
%% Server functions
%% -------------------------------------------------------------------
init([]) ->
	try
		do_init()
	catch
		_:Reason ->
			?PRINT("~w do_init is exception: ~w~n", [?MODULE, Reason]),
			?PRINT("get_stacktrace:~p", [erlang:get_stacktrace()]),
			{stop, normal}
	end.

handle_call(Request, From, State) ->
	try
		do_call(Request, From, State)
	catch
		_:R ->
			?PRINT("~w hanlde_call is exception: ~w, Request: ~w~n", [?MODULE, R, Request]),
			?PRINT("get_stacktrace : ~p~n", [erlang:get_stacktrace()]),
			{reply, ok, State}
	end.

handle_cast(Msg, State) ->
	try
		do_cast(Msg, State)
	catch
		_:R ->
			?PRINT("~w hanlde_cast is exception: ~w, Request: ~w~n", [?MODULE, R, Msg]),
			?PRINT("get_stacktrace : ~p~n", [erlang:get_stacktrace()]),
			{noreply, State}
	end.

handle_info(Info, State) ->
	try
		do_info(Info, State)
	catch
		_:R ->
			?PRINT("~w hanlde_info is exception: ~w, Info: ~w~n", [?MODULE, R, Info]),
			?PRINT("get_stacktrace : ~p~n", [erlang:get_stacktrace()]),
			{noreply, State}
	end.

terminate(_Reason, _State) ->  
    ok.

code_change(_OldVsn, State, _Extra) ->
    {ok, State}.

%% -------------------------------------------------------------------
%% Internal functions
%% -------------------------------------------------------------------
do_init() ->
	erlang:process_flag(trap_exit, true),
	State = #state{},
	print_round_and_board(0, State#state.board),
	?PRINT("Next move: Player A.~n"),
	{ok, State}.

%% ---------------------do_call--------------------------------
do_call({play, Who, Pos}, _From, State) ->
	Flag = 
		case Who of
			?A -> 1;
			_  -> 0
		end,
	if (State#state.round + 1) rem 2 =:= Flag andalso element(Pos, State#state.board) =/= $X andalso 
		   												element(Pos, State#state.board) =/= $O ->
		   NewRound = State#state.round + 1,
		   NewBoard = do_move(Pos, State#state.board, Who),
		   NewState = State#state{board = NewBoard, round = NewRound},
		   %% 打印回合数和棋盘
		   print_round_and_board(NewRound, NewBoard),
		   Result =  check(NewBoard);
	   true ->
		   NewState = State,
		   Result = {error, "wrong position or player"}
	end,
	{reply, Result, NewState};

do_call({stop, _Reason}, _, State) ->
	{stop, normal, stopped, State};

do_call(Request, _From, State) ->
	?PRINT("~w do_call is not match ~w~n", [?MODULE, Request]),
	{reply, ok, State}.

%% ---------------------do_cast--------------------------------
do_cast(Msg, State) ->
	?PRINT("~w do_cast is not match ~w~n", [?MODULE, Msg]),
	{noreply, State}.

%%----------------------do_info----------------------------------
do_info(Info, State) ->
	?PRINT("~w do_info is not match ~w~n", [?MODULE, Info]),
	{noreply, State}.

%% 下一步棋
do_move(Pos, Board, Who) ->
	setelement(Pos, Board, Who).

%% 检测赢棋或平局
check(Board) ->
    case Board of
		{$X, $X, $X,
         _,  _,  _,
         _,  _,  _} -> {victory, x};

        {_,  _,  _,
         $X, $X, $X,
         _,  _,  _} -> {victory, x};

        {_,  _,  _,
         _,  _,  _,
         $X, $X, $X} -> {victory, x};

        {$X,  _,  _,
         $X,  _,  _,
         $X,  _,  _} -> {victory, x};

        {_,  $x,  _,
         _,  $x,  _,
         _,  $X,  _} -> {victory, x};

        {_,  _,  $X,
         _,  _,  $X,
         _,  _,  $X} -> {victory, x};

        {$X,  _,  _,
         _,  $X,  _,
         _,  _,  $X} -> {victory, x};

        {_,  _,  $X,
         _,  $X,  _,
         $X,  _,  _} -> {victory, x};
		
		{$O, $O, $O,
         _,  _,  _,
         _,  _,  _} -> {victory, o};

        {_,  _,  _,
         $O, $O, $O,
         _,  _,  _} -> {victory, o};

        {_,  _,  _,
         _,  _,  _,
         $O, $O, $O} -> {victory, o};

        {$O,  _,  _,
         $O,  _,  _,
         $O,  _,  _} -> {victory, o};

        {_,  $O,  _,
         _,  $O,  _,
         _,  $O,  _} -> {victory, o};

        {_,  _,  $O,
         _,  _,  $O,
         _,  _,  $O} -> {victory, o};

        {$O,  _,  _,
         _,  $O,  _,
         _,  _,  $O} -> {victory, o};

        {_,  _,  $O,
         _,  $O,  _,
         $O,  _,  _} -> {victory, o};

        {A, B, C,
         D, E, F,
         G, H, I} when A =/= $1 andalso B =/= $2 andalso C =/= $3 andalso
                       D =/= $4 andalso E =/= $5 andalso F =/= $6 andalso
                       G =/= $7 andalso H =/= $8 andalso I =/= $9 ->
            draw;

        _ -> ok
    end.

%% 打印回合数和棋盘
print_round_and_board(Round, Board) ->
	?PRINT("round: ~w~n", [Round]),
	?PRINT("~c, ~c, ~c~n~c, ~c, ~c~n~c, ~c, ~c~n", tuple_to_list(Board)).

