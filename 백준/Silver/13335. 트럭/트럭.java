import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 다리를 건너는 트럭의 수
        int w = sc.nextInt(); // 다리의 길이
        int L = sc.nextInt(); // 다리의 최대하중

        Queue<Integer> q = new LinkedList<Integer>();
        int time = 0;
        int bridge_weight = 0;
        Queue<Integer> bridge = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }

        for(int i = 0; i < w; i++) {
            bridge.add(0);
        }

        while(!bridge.isEmpty()) {
            time++;
            bridge_weight -= bridge.poll();

            if(!q.isEmpty()) {
                if(q.peek() + bridge_weight <= L) {
                    bridge_weight += q.peek();
                    bridge.add(q.poll());
                } else {
                    bridge.add(0);
                }
            }

        }

        System.out.println(time);

    }
}
