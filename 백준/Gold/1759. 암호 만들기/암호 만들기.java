import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static char[] arr; // C개의 문자
    static char[] temp; // 가능한 조합
    static boolean[] visit; // 문자 사용했는지 체크
    static int idx = 0;
    static StringBuilder sb = new StringBuilder();
    static char[] vowels = {'o', 'a', 'e', 'i', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        visit = new boolean[C];
        temp = new char[L];
        arr = new char[C];

        for(int i = 0; i < C; i++) {
            sb.append(st.nextToken());
            arr[i] = sb.charAt(i);
        }

        Arrays.sort(arr);
        dfs(arr, 0, 0);
    }

    static void dfs(char[] arr, int depth, int idx) {
        if(depth == L) {
            int cntv = 0; // 모음 수
            int cntc = 0; // 자음 수
            for(int i = 0; i < L; i++) {
                for(int j = 0; j < 5; j++) {
                    if(temp[i] == vowels[j]) {
                        cntv++;
                    }
                }
            }
            cntc = L - cntv;

            if(cntv >= 1 && cntc >= 2) {
                for(char val : temp) {
                    System.out.print(val);
                }
                System.out.println();
            }
            
            return;
        }

        for(int i = idx; i < C; i++) {
            if(!visit[i]) {
                temp[depth] = arr[i];
                visit[i] = true;
                dfs(arr, depth+1, i);
                visit[i] = false;
            }

        }
    }
}
