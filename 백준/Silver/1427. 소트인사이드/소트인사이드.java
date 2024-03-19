import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String sNum = scan.next();
		String[] s = sNum.split("");
		
		int nums[] = new int[s.length];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.valueOf(s[i]);
		}
		
		for(int i = 0; i < nums.length; i++) {
			int maxIndex = i;
			for(int j = i; j < nums.length; j++) {
				if(nums[maxIndex] < nums[j]) {
					maxIndex = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[maxIndex];
			nums[maxIndex] = temp;
		}
		
		for(int i : nums) {
			System.out.print(i);
		}

	}

}
