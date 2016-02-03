package codejam;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

public class _1A_B {
	public static void main(String[] args) throws Exception {
		String input_file = "_1A_B-small-test.in";
		String output_file = "_1A_B-small-test_out.txt";
		
		BufferedReader in = new BufferedReader(new FileReader(input_file));
		PrintStream out = new PrintStream(new FileOutputStream(output_file));
		
		int case_num = 1;
		in.readLine();
		String line;
		while ((line=in.readLine()) != null) {  
			int levels = Integer.parseInt(line);
			int[][] star_required = new int[levels][2];
			for (int i = 0; i < levels; ++i) {
				line = in.readLine();
				String[] line_str = line.split(" ");
				star_required[i][0] = Integer.parseInt(line_str[0]);
				star_required[i][1] = Integer.parseInt(line_str[1]);
			}
			
			boolean changed;
			int star_earned = 0;
			int played = 0;
			int level2_cleared_total = 0;
			boolean[][] cleared = new boolean[levels][2];
			while (true) {
				changed = false;
				for (int i = 0; i < levels; ++i) {
					boolean level1_cleared = cleared[i][0];
					boolean level2_cleared = cleared[i][1];
					int level1_star_required = star_required[i][0];
					int level2_star_required = star_required[i][1];
					
					if (!level2_cleared &&  level2_star_required <= star_earned) {
						if (!level1_cleared) star_earned += 2;
						else star_earned += 1;
						cleared[i][1] = true;
						++played;
						changed = true;
						++level2_cleared_total;
					}
				}
				
				if (!changed)
					break;					
			}
			
			while (true) {
				if (level2_cleared_total == levels)
					break;
				
				changed = false;
				for (int i = 0; i < levels; ++i) {
					boolean level1_cleared = cleared[i][0];
					boolean level2_cleared = cleared[i][1];
					int level1_star_required = star_required[i][0];
					int level2_star_required = star_required[i][1];
					
					if (!level2_cleared && !level1_cleared && level1_star_required <= star_earned) {
						++star_earned;
						++played;
						changed = true;
						break;
					}
				}
				
				if (!changed)
					break;
				
				boolean changed2 = false;
				while (true) {
					changed2 = false;
					for (int i = 0; i < levels; ++i) {
						boolean level1_cleared = cleared[i][0];
						boolean level2_cleared = cleared[i][1];
						int level1_star_required = star_required[i][0];
						int level2_star_required = star_required[i][1];
						
						if (!level2_cleared &&  level2_star_required <= star_earned) {
							if (!level1_cleared) star_earned += 2;
							else star_earned += 1;
							cleared[i][1] = true;
							++played;
							changed2 = true;
							++level2_cleared_total;
						}
					}
					
					if (!changed2)
						break;
				}						
			}
			
			if (level2_cleared_total != levels)
				out.println("Case #" + case_num + ": Too Bad");
			else
				out.println("Case #" + case_num + ": " + played);
			++case_num;
		}
	}
}
