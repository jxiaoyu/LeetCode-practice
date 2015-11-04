%%% -------------------------------------------------------------------
%%% Author: jiangxiaoyu
%%% Description: 提供玩家与AI对战的井字棋游戏程序
%%%
%%% Created : 2013-10-13
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
		 a/1
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
			P = gen_server:call(chess, {ai_choose_pos}),
			b(P);
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
			?PRINT("Next move: Player A.~n");
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
		   %% 打印回合数和棋盘
		   if NewRound rem 2 =:= 0 ->
				  print_round_and_board(NewRound, NewBoard);
			  true ->
				  skip
		   end,
		   Result =  check(NewBoard);
	   true ->
		   NewRound = State#state.round,
		   NewBoard = State#state.board,
		   Result = {error, "wrong position or player"}
	end,
	{reply, Result, State#state{board = NewBoard, round = NewRound}};

do_call({ai_choose_pos}, _From, State) ->
	Pos = ai_choose_pos(State#state.board),
	{reply, Pos, State};
	
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

%% AI选择位置
ai_choose_pos(Board) ->
	PosList = availabe_pos(Board),
	F = fun(Pos, Acc) ->
			{_, Score} = Acc,
			NewBoard = do_move(Pos, Board, ?B),
			Val = minmax(NewBoard, ?A),
			if Val > Score ->
				   {Pos, Val};
			   true ->
				   Acc
			end
		end,
	{P, _} = lists:foldl(F, {x, -10}, PosList),
	P.

%% 极小极大算法
minmax(Board, Player) ->
	case check(Board) of
		{victory, $X} ->
			1;
		{victory, $O} ->
			-1;
		draw ->
			0;
		ok ->
			PosList = availabe_pos(Board),
			F = fun(Pos, Acc) ->
					NewBoard = do_move(Pos, Board, Player),
					Enemy = get_enemy(Player),
					Val = minmax(NewBoard, Enemy),
					if Player =:= ?B andalso Val > Acc ->
						   Val;
					   Player =:= ?A andalso Val < Acc ->
						   Val;
					   true ->
						   Acc
					end
				end,
			Acc0 = 
				if Player =:= ?B ->
					   -10;
				   Player =:= ?A ->
					   10
				end,
			lists:foldl(F, Acc0, PosList)
	end.

%% 获取当前可走的位置列表
availabe_pos(Board) ->
	F = fun(Piece, Acc) ->
				if Piece =/= $X andalso Piece =/= $O ->
					   [(Piece - $0)|Acc];
				   true ->
					   Acc
				end
		end,
	lists:foldr(F, [], tuple_to_list(Board)).

%% 走一步棋
do_move(Pos, Board, Who) ->
	setelement(Pos, Board, Who).

%% 获取对手
get_enemy(Player) ->
	case Player of
		?A -> 
			?B;
		?B -> 
			?A
	end.

%% 检测赢棋或平局
check(Board) ->
    case Board of
		{$X, $X, $X,
         _,  _,  _,
         _,  _,  _} -> {victory, $X};

        {_,  _,  _,
         $X, $X, $X,
         _,  _,  _} -> {victory, $X};

        {_,  _,  _,
         _,  _,  _,
         $X, $X, $X} -> {victory, $X};

        {$X,  _,  _,
         $X,  _,  _,
         $X,  _,  _} -> {victory, $X};

        {_,  $X,  _,
         _,  $X,  _,
         _,  $X,  _} -> {victory, $X};

        {_,  _,  $X,
         _,  _,  $X,
         _,  _,  $X} -> {victory, $X};

        {$X,  _,  _,
         _,  $X,  _,
         _,  _,  $X} -> {victory, $X};

        {_,  _,  $X,
         _,  $X,  _,
         $X,  _,  _} -> {victory, $X};
		
		{$O, $O, $O,
         _,  _,  _,
         _,  _,  _} -> {victory, $O};

        {_,  _,  _,
         $O, $O, $O,
         _,  _,  _} -> {victory, $O};

        {_,  _,  _,
         _,  _,  _,
         $O, $O, $O} -> {victory, $O};

        {$O,  _,  _,
         $O,  _,  _,
         $O,  _,  _} -> {victory, $O};

        {_,  $O,  _,
         _,  $O,  _,
         _,  $O,  _} -> {victory, $O};

        {_,  _,  $O,
         _,  _,  $O,
         _,  _,  $O} -> {victory, $O};

        {$O,  _,  _,
         _,  $O,  _,
         _,  _,  $O} -> {victory, $O};

        {_,  _,  $O,
         _,  $O,  _,
         $O,  _,  _} -> {victory, $O};

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

