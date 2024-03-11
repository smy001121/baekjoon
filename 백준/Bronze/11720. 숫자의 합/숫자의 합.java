import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		String s = scan.next();
		String[] nums = s.split("");
		
		int sum = 0;
		
		for(String str : nums) {
			sum += Integer.parseInt(str);
		}
		
		System.out.println(sum);

	}

}