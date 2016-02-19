package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * 숫자 야구 게임.
 * R,G,B,Y 를 가지고 4자리 문자열을 만들고(이게 solution)
 * guess string이 주어지면 몇번의 hit(이게 strike) 이고
 * 몇번의 pseudo-hit(이게 ball) 인지를 결정
 * (solution,guess는 4자리에 각기 다른 문자가 올 필요는 없다. 중복가능함)
 * ex) solution-RGGB, guess-YYYG : 0hit, 2pHit
 * ex) solution-YGRB, guess-YYGG : 1hit, 1pHit
 */
public class _2011_03_08_MasterMind {
	public static String masterMind(String solution,String guess) {
		return masterMind2(solution, guess);
		
		/*
		int hit = 0;
		int pHit = 0;
		int[] cnt = new int[4];
		
		//글자수 세기
		for(int i=0;i<4;i++)
			cnt[toInt(solution.charAt(i))]++;		
		
		for(int i=0;i<4;i++)
		{
			char sCh = solution.charAt(i);
			char gCh = guess.charAt(i);
			if(sCh==gCh)
			{
				cnt[toInt(sCh)]--;
				hit++;				
			}	
		}
		
		//pHit 새기
		for(int i=0;i<4;i++)
		{	
			char sCh = solution.charAt(i);
			char gCh = guess.charAt(i);
			if(sCh!=gCh && cnt[toInt(gCh)]>0)
			{
				pHit += cnt[toInt(gCh)];
				cnt[toInt(gCh)]=0;
			}			
		}
		
		return ""+hit+","+pHit;
		*/
	}

	private static int toInt(char gCh) {
		if(gCh=='R')
			return 0;
		if(gCh=='G')
			return 1;
		if(gCh=='B')
			return 2;
		if(gCh=='Y')
			return 3;
		
		return -1; //never reach here!
	}
	
	///////////////////////////////////////
	public static String masterMind2(String solution,String guess) {
		int hit = 0, pHit = 0;
		
		ArrayList<Integer> indices = new ArrayList<Integer>();
		HashSet<String> chars = new HashSet<String>();
		
		for (int i = 0; i < solution.length(); ++i) {
			char chSolution = solution.charAt(i);
			char chGuess = guess.charAt(i);
			
			if (chSolution == chGuess) {
				++hit;
			} else {
				indices.add(i);
				chars.add(chGuess + "");
			}
		}		
		
		for (String ch : chars) {
			for (int i = 0; i < indices.size(); ++i) {
				int index = indices.get(i);
				char chSolution = solution.charAt(index);
				if (chSolution == ch.charAt(0))
					++pHit;
			}
		}
		
		return hit + "," + pHit;
	}

	public static String masterMind3(String solution, String guess) {
        // R, G, B, Y -> 0, 1, 2, 3
        int[] countSolution = new int[4];
        int[] countGuess = new int[4];
        
        int hit = 0;
        int pHit = 0;
        
        for (int i = 0; i < solution.length(); ++i) {
            char solChar = solution.charAt(i);
            char guessChar = guess.charAt(i);
            
            if (solChar == guessChar) {
                ++hit;
            } else {
                ++countSolution[toInt(solChar)];
                ++countGuess[toInt(guessChar)];
            }
        }
        
        for (int i = 0; i < countSolution.length; ++i) {
            if (countGuess[i] > 0) {
                pHit = pHit + countSolution[i];
            }
        }

        return hit + "," + pHit;
    }
}

/*
 * 중복이 허용되기 때문에 고려해야할 경우가 많아진다.
 * 잘 생각해야 한다. examplify 를 통해서 생각해보자.
 * 
 * 우선 solution 을 한번 훑어서 counting array를 만든다.
 * 그리고 guess를 훑으면서 작업을 진행한다.
 * hit 인 경우는 counting array에서 -1 을 하고 진행하면 되는데
 * pHit 인 경우가 문제다.
 * 다음의 예를 보자.
 *  
 * solution : RGGB
 * guess    : YYYG
 * 
 * pHit : 2
 * 
 * guess에서 G가 한번, solution에서 G가 두번 나왔다.
 * 이것이 반대로 된다면?
 * 
 * solution : YGRB 
 * guess    : YYGG 
 * 
 * pHit : 1
 * 
 * guess에 G가 몇번 나오느냐는 중요치 않다.
 * solution에 나오는 횟수가 중요하다.
 * 
 * 그러니까 guess에서 일단 G가 발견되면 G의 카운트 만큼 pHit에 더해주고 counting array에서는 빼주면 된다.
 * 
 * 그런데 이걸로 끝이 아니다-_-
 * 
 * solution : GYRB
 * guess    : GRRY
 * 
 * guess의 앞의 R에서 counting array 값을 보고 ball 이라고 생각해버린다.
 * 뒤의 R 때문에 사실 앞의 R이 ball이 될수 없는데도..!
 * 
 * 그래서 결국 hit을 먼저 새고 pHit을 따로 새야 한다.
 * 
 * 
 * ----------------------------------------------------
 * 위 구현은 너무 더러움
 * HashSet 에 strike 아닌 guess의 문자들 다 넣고
 * ArrayList에 strike 아닌 index들 다 넣어서 사바사바 하면 됨
 */
