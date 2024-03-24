import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		int len = sc.nextInt(); // 원본 암호문의 길이
			List<Integer> list = new LinkedList<>();
			
			for(int i = 0; i < len; i++) {
				list.add(sc.nextInt());
			}
			
			int num = sc.nextInt(); // 명령어 개수
			for(int i = 0; i < num; i++) {
				String s = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int j = x; j < x+y; j++) {
					list.add(j, sc.nextInt());
				}
			}
			
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

		}
	}
}
