import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T, M, N, K;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int count;
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken()); // 테스트 케이스

        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이(열)
            N = Integer.parseInt(st.nextToken()); // 세로 길이(행)
            K = Integer.parseInt(st.nextToken()); // 배추 심어져있는 위치의 개수

            arr = new int[N][M];
            visit = new boolean[N][M];
            count = 0;
            result = 0;

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                arr[r][c] = 1;
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == 1 && !visit[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    result = Math.max(result, arr[i][j]);
                }
            }

            System.out.println(result);
        }

    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        visit[i][j] = true;
        arr[i][j] = count;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for(int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nc >= 0 && nr < N && nc < M && arr[nr][nc] == 1 && !visit[nr][nc]) {
                    q.add(new int[] {nr,nc});
                    arr[nr][nc] = count;
                    visit[nr][nc] = true;
                }
            }
        }


    }
}
