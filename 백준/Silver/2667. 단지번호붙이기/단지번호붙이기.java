import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int N;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int count = 0;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] sarr = s.split("");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(sarr[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visit[i][j]) {
                    count++;
                    bfs(i,j);
                }
            }
        }

        cnt = new int[count];

        for(int k = 1; k <= count; k++) {
            int result = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] == k) {
                        result++;
                    }
                }
            }
            cnt[k-1] = result;
        }

        Arrays.sort(cnt);

        System.out.println(count);
        for(int val : cnt) {
            System.out.println(val);
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

                if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc] && arr[nr][nc] == 1) {
                    q.add(new int[] {nr,nc});
                    visit[nr][nc] = true;
                    arr[nr][nc] = count;
                }
            }
        }
    }
}
