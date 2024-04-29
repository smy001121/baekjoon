import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visit;
    static int count;
    static int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken()); // 너비 (열)
            h = Integer.parseInt(st.nextToken()); // 높이 (행)

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visit = new boolean[h][w];
            count = 0;

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visit[i][j]) {
                        dfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }

    }

    static void dfs(int i, int j) {
        visit[i][j] = true;

        for(int k = 0; k < 8; k++) {
            int ii = i + dr[k];
            int jj = j + dc[k];

            if(ii >= 0 && jj >= 0 && ii < h && jj < w && map[ii][jj] == 1 && !visit[ii][jj]) {
                dfs(ii, jj);
            }
        }

    }
}
