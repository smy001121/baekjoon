import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static int cnt0 = 0;
    static int cnt1 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        char[] arr = S.toCharArray();

        if(arr[0] == '0') cnt0++;
        else cnt1++;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] != arr[i]) {
                if(arr[i] == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
        }

        System.out.println(Math.min(cnt0, cnt1));

    }
}
