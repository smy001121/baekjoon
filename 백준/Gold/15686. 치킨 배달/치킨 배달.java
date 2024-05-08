import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] arr;
    static ArrayList<Point> house; // 집 위치를 저장하는 리스트
    static ArrayList<Point> chicken; // 치킨집 위치를 저장하는 리스트
    static boolean[] chickenVisited; // 뽑은 치킨집 체크
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb = new StringTokenizer(br.readLine());

        N = Integer.parseInt(sb.nextToken());
        M = Integer.parseInt(sb.nextToken());

        arr = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            sb = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(sb.nextToken());

                if(arr[i][j] == 1) {
                    house.add(new Point(i,j));
                } else if(arr[i][j] == 2) {
                    chicken.add(new Point(i,j));
                }
            }
        }

        result = Integer.MAX_VALUE;
        chickenVisited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(result);

    }

    static void dfs(int count, int idx) {
        // count : 문 연 치킨집
        if(count == M) { // 치킨거리 최솟값 구하기
            int total = 0; // 도시의 치킨 거리

            for(int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE; // 가장 가까운 치킨집과의 치킨 거리

                // i번째 집과 j번째 집 중 open한 치킨집의 모든 거리를 비교한다.
                // 그 중, 최소 거리를 구한다.
                for(int j = 0; j < chicken.size(); j++) { // i번째 집 ~ j번째 치킨집 거리 중 최소 구하기
                    if(chickenVisited[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }

                total += temp;
            }

            result = Math.min(result, total);
            return;
        }


        // 백트래킹
        for(int i = idx; i < chicken.size(); i++) { // 모든 치킨집들을 탐색
            if(chickenVisited[i] == false) {
                chickenVisited[i] = true;
                dfs(count+1, i+1);
                chickenVisited[i] = false;
            }
        }


    }

}
