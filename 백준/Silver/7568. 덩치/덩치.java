import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] height;
    static int[] weight;
    static int[] grade;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        height = new int[N];
        weight = new int[N];
        grade = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if(weight[i] < weight[j] && height[i] < height[j]) {
                    cnt++;
                }
            }
            grade[i] = cnt + 1;
        }

        for(int val : grade) {
            System.out.print(val + " ");
        }


    }
}
