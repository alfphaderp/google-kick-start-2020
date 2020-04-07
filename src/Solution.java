import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int merp = in.nextInt();
		
		long N, B;
		List<Integer> prices = new ArrayList<>();
		
		for(int c = 1; c <= merp; c++) {
			N = in.nextInt();
			B = in.nextInt();
			
			prices.clear();
			for(int i = 0; i < N; i++)
				prices.add(in.nextInt());
			
			Collections.sort(prices);
			
			int count = 0, sum = 0;
			for(int p : prices) {
				sum += p;
				if(sum > B)
					break;
				count++;
			}
			
			System.out.println("Case #" + c + ": " + count);
		}
		
		in.close();
	}
}
