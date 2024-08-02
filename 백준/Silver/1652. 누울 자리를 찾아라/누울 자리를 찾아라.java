import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[][] room;
    static int sumR = 0; // 가로 개수
    static int sumC = 0; // 세로 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        room = new String[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] arr = s.toCharArray();
            for(int j = 0; j < N; j++) {
                room[i][j] = String.valueOf(arr[j]);
            }
        }

        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(room[i][j].equals(".")) count++;
                else {
                    if(count >= 2) {
                        sumR++;
                    }
                    count = 0;
                }
            }
            if(count >= 2) {
                sumR++;
            }
            count = 0;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(room[j][i].equals(".")) count++;
                else {
                    if(count >= 2) {
                        sumC++;
                    }
                    count = 0;
                }
            }
            if(count >= 2) {
                sumC++;
            }
            count = 0;
        }

        System.out.print(sumR + " " + sumC);
    }
}
