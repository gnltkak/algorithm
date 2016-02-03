package interview;

/*
 * input : integer array ( 편의상 각 원소는 distinct 하다고 가정한다 )
 * find : median을 keep track 하는 것이다.
 *        (data에 추가 또는 삭제가 계속해서 이루어질 수 있다)
 *        median 은 1,2,3,4 에서는 2
 *        1,2,3 에서는 2 로 한다.
 */
public class _2011_02_01_TrackMedian {
	
}

/*
 * 1.BST 이용.
 * BST의 특성을 잘 이용하면 된다.
 * 원소의 개수가 홀수이면 루트의 좌측에 k개 우측에 k개가 되도록 밸런스를 유지시킨다.
 * 원소의 개수가 짝수이면 루트의 좌측에 k-1개 우측에 k개가 되도록 밸런스를 유지시킨다.
 * 밸런스 유지는 적절한 rotation 등을 이용하면 된다.
 * 
 * 최초에 k th element selection alg. 을 이용하여 median을 구한다. O(n) 이 소요된다.
 * 이것을 BST에 맨 처음 삽입하고 ( root로 만들고 )
 * 나머지 원소들을 삽입하면 된다.
 * 
 * median lookup 은 O(1)이 되고
 * 삽입,삭제 시 밸런스 조정은 O(logn) 이 걸린다.
 * (경우에 따라 root의 successor 를 찾아야 하는 경우가 있기 때문이다) 
 * 	
 * 2.heap 2개 이용(min heap, max heap)
 * 전체를 두개의 그룹으로 나눈다. 작은 아이들(S)과 큰 아이들(L)이다.
 * S로 max heap을 만들고 L로 min heap을 만든다.
 * 원소의 개수가 홀수이면 S쪽에 median을 포함시키도록 한다.
 * 이렇게 하면 원소의 개수가 홀수이든 짝수이든 median은 S에서의 max 값이다.
 * 그러므로 median lookup은 O(1)이 된다.
 * 삽입,삭제시는 필요시 S,L간에 원소가 이동하고 heap 을 rebuild 하기도 한다.
 * 따라서 밸런스 재조정은 O(logn) 이다.
 * 
 * 최초에 S와 L로 나누는 과정을 위해 median을 찾아야 한다. O(n)이 소요된다. (linear selection)
 * 또는 linear selection을 하지 않고 S, L에 하나씩 넣어도 된다. 이래도 O(n)이다.
 * S와 L의 size는 각각 n/2 이고 (n이 홀수이면 어느 한쪽에 +1 해줘야..)
 * 처음에는 S에만 집어넣다가 S가 가득차면
 * 1) 원소가 S의 max 보다 크거나 같다 -> L에 넣음
 * 2) 원소가 S의 max 보다 작다 -> S의 max를 빼서 L에 넣고 원소는 S에 넣음
 * 이렇게 하면 된다. heap build가 O(n)이므로 이 경우도 O(n)이 된다.
 */
