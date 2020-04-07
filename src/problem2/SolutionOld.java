package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SolutionOld {	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int merp = in.nextInt();
		
		int N, K, P;
		List<List<Integer>> plates = new ArrayList<>();
		
		for(int c = 1; c <= merp; c++) {
			N = in.nextInt();
			K = in.nextInt();
			P = in.nextInt();
			
			plates.clear();
			for(int i = 0; i < N; i++) {
				List<Integer> d = new ArrayList<>();
				
				for(int j = 0; j < K; j++)
					d.add(in.nextInt());
				
				Collections.reverse(d);
				
				plates.add(d);
			}
			
			int sum = 0;
			for(int i = 0; i < P; i++) {
				int max = 0;
				int stackIndex = 0;
				for(int j = 0; j < plates.size(); j++) {
					if(!plates.get(j).isEmpty() && plates.get(j).get(plates.get(j).size() - 1) > max) {
						max = plates.get(j).get(plates.get(j).size() - 1);
						stackIndex = j;
					}
				}
				sum += max;
				plates.get(stackIndex).remove(plates.get(stackIndex).size() - 1);
			}
			
			System.out.println("Case #" + c + ": " + sum);
			
		}
		
		in.close();
	}
}
