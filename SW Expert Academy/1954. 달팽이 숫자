import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
             
            int r = 0, c = 0;
            int dir = 0;
             
            for(int i = 1; i <= n*n; i++) {
                arr[r][c] = i;
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                 
                if(nr < 0 || nc < 0 || nr >= n || nc >= n || arr[nr][nc] != 0) {
                    dir = (dir + 1) % 4;
                    nr = r + dr[dir];
                    nc = c + dc[dir];
                }
                 
                r = nr;
                c = nc;
                 
            }
             
            System.out.println("#" + test_case);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
 
        }
    }
}
