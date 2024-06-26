import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0, 0);

        if(S == 0){
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }

    }

    static void dfs(int depth, int sum) {
        if(depth == N) {
            if(sum == S) {
                count++;
            }
            return;
        }

        dfs(depth+1, sum+arr[depth]); // 해당 원소를 선택했을 경우의 수열의 합
        dfs(depth+1, sum); // 해당 원소를 선택하지 않았을 경우의 수열의 합

    }
}
