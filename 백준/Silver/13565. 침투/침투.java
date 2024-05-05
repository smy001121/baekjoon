import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 행
        N = Integer.parseInt(st.nextToken()); // 열
        arr = new int[M][N];
        result = "NO";

        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            String[] sarr = s.split("");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(sarr[j]);
            }
        }

        for(int j = 0; j < N; j++) {
            if(arr[0][j] == 0) {
                dfs(0,j);
            }
        }

        System.out.println(result);
    }

    static void dfs(int i, int j) {
        arr[i][j] = 1;

        if(i == M-1) {
            result = "YES";
            return;
        }

        for(int k = 0; k < 4; k++) {
            int ii = i + dr[k];
            int jj = j + dc[k];

            if(ii >= 0 && jj >= 0 && ii < M && jj < N && arr[ii][jj] == 0) {
                dfs(ii,jj);
            }
        }

    }
}
