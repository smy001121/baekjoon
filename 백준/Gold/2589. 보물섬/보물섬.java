import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static boolean[][] visit;
    static int[][] count;
    static int N, M;
    static int result;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 크기 (행)
        M = Integer.parseInt(st.nextToken()); // 가로 크기 (열)

        map = new String[N][M];
        visit = new boolean[N][M];
        count = new int[N][M];
        result = 0;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] sarr = s.split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = sarr[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j].equals("L")) {
                    bfs(i,j);
                }
                count = new int[N][M];
                visit = new boolean[N][M];
            }
        }


        System.out.println(result);



    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        visit[i][j] = true;
        count[i][j] = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for(int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nc >= 00 && nr < N && nc < M && map[nr][nc].equals("L") && !visit[nr][nc]) {
                    q.add(new int[] {nr, nc});
                    visit[nr][nc] = true;
                    count[nr][nc] = count[r][c] + 1;
                }
            }
        }

        int max = 0;

        for(int ii = 0; ii < N; ii++) {
            for(int jj = 0; jj < M; jj++) {
                max = Math.max(max, count[ii][jj]);
            }
        }

        result = Math.max(max, result);
    }

}
