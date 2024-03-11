import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] score = new int[n];
		
		for(int i=0; i<n; i++) {
			int sum = 0;
			int add = 0;
			String s = scan.next();
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) == 'O') {
					add++;
					sum += add;
				}
				else if(s.charAt(j) == 'X') {
					add = 0;
				}
				score[i] = sum;
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(score[i]);
		}
		
		
		scan.close();
	}
}