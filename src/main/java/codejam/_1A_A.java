package codejam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

public class _1A_A {
	public static void main(String[] args) throws Exception {
		String input_file = "_1A_A-large.in";
		String output_file = "_1A_A-large_out.txt";
	
		BufferedReader in = new BufferedReader(new FileReader(input_file));
		PrintStream out = new PrintStream(new FileOutputStream(output_file));
		
		int case_num = 1;
		in.readLine();
		String line;
		while ((line=in.readLine()) != null) {  
			System.out.println("CASE#" + case_num);
			System.out.println(line);
			
			String[] line_str = line.split(" ");
			int typed = Integer.parseInt(line_str[0]);
			int total = Integer.parseInt(line_str[1]);
			line = in.readLine();
			line_str = line.split(" ");
			double[] prob_correct = new double[typed];
			double[] prob_incorrect = new double[typed];
			for (int i = 0; i < line_str.length; ++i) {
				prob_correct[i] = Double.parseDouble(line_str[i]);
				prob_incorrect[i] = 1 - prob_correct[i];
			}			
			
			// 하나도 안지우고 계속하는 경우
			double[] expected_sum = new double[1 + 1 + typed];
			for (int i = 0; i < (1<<typed); ++i) {
				String case_str = Integer.toBinaryString(i);
				case_str = String.format("%" + typed + "s", case_str).replace(' ', '0');
				
				//System.out.println("case_str: " + case_str);
				
				double case_prob = 1;
				for (int j = 0; j < case_str.length(); ++j) {
					if (case_str.charAt(j) == '0')
						case_prob *= prob_incorrect[j];
					else
						case_prob *= prob_correct[j];
				}
				
				//System.out.println("case_prob: " + case_prob);
				
				// expected_sum[0] 은 하나도 안지우고 계속 입력하는 경우
				// 하나도 안 틀린 경우
				if (case_str.indexOf("0") < 0)
					expected_sum[0] += case_prob * (total - typed + 1);
				// 하나라도 틀린 경우
				else					
					expected_sum[0] += case_prob * (total - typed + 1 + total + 1);
				
				// k개 지우는 경우(1 <= k <= typed)
				for (int k = 1; k <= typed; ++k) {
					//System.out.println(case_str);
					String deleted_case_str = case_str.substring(0, typed - k);
					if (deleted_case_str.indexOf("0") < 0)
						expected_sum[k] += case_prob * (k + total  - (typed - k) + 1);
					else
						expected_sum[k] += case_prob * (k + total  - (typed - k) + 1 + total + 1);
				}
			}
			
			// expected_sum[expected_sum.length - 1] 은 그냥 엔터치는 경우
			expected_sum[expected_sum.length - 1] = 1 + total + 1;
			
			/*
			for (int i = 0; i < expected_sum.length; ++i) {
				System.out.println("expected_sum[" + i + "]=" + expected_sum[i]);
			}
			*/
			
			double answer = Double.MAX_VALUE;
			for (int i = 0; i < expected_sum.length; ++i) {
				if (expected_sum[i] < answer)
					answer = expected_sum[i];
			}						
			
			out.println("Case #" + case_num + ": " + String.format("%f", answer));
			++case_num;
		}
	}
}
