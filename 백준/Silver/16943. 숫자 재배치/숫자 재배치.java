import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String A;
    static int B;
    static int[] arr; // A에 포함된 숫자들 배열
    static int[] temp; // 순열 저장 배열
    static boolean[] visit; // 숫자들 방문 여부
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        String A = st.nextToken();
        String[] sarr = A.split("");
        B = Integer.parseInt(st.nextToken());

        arr = new int[sarr.length];
        temp = new int[sarr.length];
        visit = new boolean[sarr.length];

        for(int i = 0; i < sarr.length; i++) {
            arr[i] = Integer.parseInt(sarr[i]);
        }

        dfs(arr, 0);
        System.out.println(max);

    }

    static void dfs(int[] arr, int count) {

        if(count == arr.length) {
            String num = "";

            for(int i = 0; i < temp.length; i++) {
                num += Integer.toString(temp[i]);
            }

            int num2 = Integer.parseInt(num);

            if(num2 < B && Integer.toString(num2).length() == arr.length) {
                max = Math.max(max, num2);
            }
        }


        for(int i = 0; i < arr.length; i++) {
            if(!visit[i]) {
                temp[count] = arr[i];
                visit[i] = true;
                dfs(arr, count+1);
                visit[i] = false;
            }
        }
    }
}
