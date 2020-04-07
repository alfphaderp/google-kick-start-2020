package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {	
	static List<List<Integer>> cumPlates = new ArrayList<>();
	static int N, K, P;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int merp = in.nextInt();
				
		for(int c = 1; c <= merp; c++) {
			N = in.nextInt();
			K = in.nextInt();
			P = in.nextInt();
			
			cumPlates.clear();
			for(int i = 0; i < N; i++) {
				List<Integer> d = new ArrayList<>();
				
				int sum = 0;
				for(int j = 0; j < K; j++) {
					sum += in.nextInt();
					d.add(sum);
				}
				
				cumPlates.add(d);
			}
			
			System.out.println(cumPlates);
			
			System.out.println(findMax(P));
		}
		
		in.close();
	}
	
	static int findMax(int P) {
		return findMax(P, 0);
	}
	
	static int findMax(int P, int stack) {
		if(P == 0 || stack > cumPlates.size() - 1)
			return 0;
		else if(stack == cumPlates.size() - 1) {
			if(P <= K)
				return cumPlates.get(stack).get(P - 1);
			else
				return Integer.MIN_VALUE;
		} else {
			int globalMax = 0;
			
			int sum = 0;
			for(int i = 0; i <= Math.min(P, K - 1); i++) {
				int maxSubSum = findMax(P - i, stack + 1);
				if(sum + maxSubSum > globalMax)
					globalMax = sum + maxSubSum;
				sum = cumPlates.get(stack).get(i);
			}
			
			return globalMax;
		}
	}
}
