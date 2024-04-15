import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] arr;
    static int result;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 상자 가로 칸의 수 - 열
        N = Integer.parseInt(st.nextToken()); // 상자 세로 칸의 수 - 행

        arr = new int[N][M];
        result = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    q.add(new int[] {i,j});
                }
            }
        }

        bfs();

    }

    static void bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0]; // 행
            int y = now[1]; // 열

            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i];
                int ny = y + dc[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if(arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        if(checkTomato()) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    result = Math.max(result, arr[i][j]);
                }
            }
            System.out.print(result - 1);
        } else {
            System.out.print(-1);
        }
    }

    static boolean checkTomato() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
