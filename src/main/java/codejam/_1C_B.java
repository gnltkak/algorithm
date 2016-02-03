package codejam;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

public class _1C_B {
	public static void main(String[] args) throws Exception {
		String input_file = "";
		String output_file = "";
		
		BufferedReader in = new BufferedReader(new FileReader(input_file));
		PrintStream out = new PrintStream(new FileOutputStream(output_file));
		
		int case_num = 1;
		in.readLine();
		String line;
		while ((line=in.readLine()) != null) {  
			String[] dna = line.split(" ");
			double d = Double.parseDouble(dna[0]);
			int n = Integer.parseInt(dna[1]);
			int a = Integer.parseInt(dna[2]);
			double[] t = new double[n];
			double[] x = new double[n];
			for (int i = 0; i < n; ++i) {
				line = in.readLine();
				String[] tx = line.split(" ");
				t[i] = Double.parseDouble(tx[0]);
				x[i] = Double.parseDouble(tx[1]);
			}
			line = in.readLine();
			String[] acc_str = line.split(" ");
			double[] acc = new double[a];
			for (int i = 0; i < a; ++i)
				acc[i] = Double.parseDouble(acc_str[i]);
			

		}
	}
}
