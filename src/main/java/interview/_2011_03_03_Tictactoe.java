package interview;

/*
 * tic-tac-toe 게임의 승자를 판별하는 알고리즘을 작성하라
 * (tic-tac-toe : 3목임-_-; 하지만 3x3 의 board size 제한이 있음)
 */
public class _2011_03_03_Tictactoe {
	
}

/*
 * 1.board가 주어졌을 때 (2차원 array)
 * 결국 모든 row, 모든 col, 모든 대각선을 체크할 수 밖에 없다.
 * 결국 O(n^2)이 된다.
 * 
 * 2.cell의 상태가 3가지(빨,파,텅빔) 이므로 이것을 일렬로 배열하면 3진수로 나타낼수 있다.
 * board의 cell의 수가 9개이므로 9자리의 3진수가 될 것이다.( 수의 범위는 0~3^9-1 가 된다)
 * 이 때, 어느한쪽이 이기는 경우, 무승부인 경우를 모두 미리 계산하여 lookup table을 만든다.
 * (lookup table의 size는 bitmap을 쓴다 해도 (3^9)/8 byte 가 될 것이다)
 * 전처리 시간이 O(3^9), lookup은 O(1)이 된다.
 * 그러나 이 방법은 n이 조금만 커져도 3^(n^2) 의 공간을 필요로 하므로 공간복잡도가 매우 커진다.
 * 
 * 3.사실 문제를 조금 떠나서 실용적으로 생각해보자.
 * 유저가 어느 한 곳에 돌을 놓을 텐데, 그 경우에 누가 승자인지를 판단하면 된다.
 * 돌을 놓은 곳의 col,row, 경우에 따라서는 대각선 을 체크하면 되기 때문에 O(n)이 된다.
 * 
 * 여기서 추가의 자료구조를 사용하면 lookup을 O(1)로 만들 수 있다.
 * 결국 우리는 하나의 col, row, 대각선의 상태만이 필요하므로
 * 각 col의 상태를 나타내는 array(size : n)와
 * 각 row의 상태를 나타내는 array(size : n)와
 * 대각선 2개의 상태를 나타내는 array(size : 2)를 이용하자.
 * 
 * 빨간유저가 놓았으면 +1, 파란유저가 놓았으면 -1 해서 각 element의 값을 정한다. 
 */