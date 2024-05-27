import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // N = r
            M = Integer.parseInt(st.nextToken()); // M = n

            System.out.println(combi(M, N));
        }

    }

    static int combi(int n, int r) {

        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        else if(n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
}
