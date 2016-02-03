package interview;

/*
 * 사전에 있는 길이가 같은 두 단어가 주어졌을 때
 * 한번에 한 문자만 변경하여 한 단어를 다른 단어로 바꾸는 함수를 작성하라
 * 바꾸는 과정에서 만들어지는 각 단어는 모두 사전에 있어야 한다.
 * ex) damp,like
 * damp -> lamp -> limp -> lime -> like
 */
public class _2011_03_15_WordTransform {

}

/*
 * 우선, 어떤 단어가 사전에 있는지 없는지를 O(1)에 알기 위해 hash table을 사용한다.
 * 한 단어에서 다른 단어로 움직이는 모든 경우의 수를 다 따져봐야 할까? 그렇다-_-
 * 두 단어간의 최단 거리만을 따져서 어떻게 해보고 싶지만 안된다.
 * abc -> ade 의 경우 a는 건드리지 않고 b,c 자리만 변경하고 싶지만 a를 건드려야 할 수도 있다.
 * 그렇다면 결국 수행시간은 exponential 하게 될 것이고, BFS나 DFS를 사용해야 한다.
 * DFS보다는 BFS가 유리하다. 최단경로를 DFS 보다 먼저 발견할 확률이 더 높기 때문이다.
 * path 는 backtrace map을 사용해 저장하면 된다. ( 나는 어디에서 왔는가!) - 메모리 낭비가 좀 있다.
 * marking은 그냥 set 으로 하면된다. 아니면 단어마다 index를 붙여서 bitmap을 쓰던지..(근데 이게 메모리 낭비가 더 심할지도?)
 */
