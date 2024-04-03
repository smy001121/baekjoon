import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N]; // A

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] find = new int[M]; // 찾아야 하는 수

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start, end, mid;
        boolean exist;

        for(int i = 0; i < M; i++) {
            int findN = find[i];
            start = 0;
            end = N - 1;
            exist = false;
            while(start <= end) {
                mid = (start + end) / 2;
                if(findN == arr[mid]) {
                    exist = true;
                    break;
                } else if(findN < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if(exist) System.out.println(1);
            else System.out.println(0);

        }
        
    }
}
