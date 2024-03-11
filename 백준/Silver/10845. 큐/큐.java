import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int rear = -1, front = -1;
	static int[] queue = new int[10000];
	
public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int index = 0; index < N; index++) {
			String s = br.readLine();
			
			if(s.contains("push")) {
				String[] sa = s.split(" ");
				push(Integer.parseInt(sa[1]));
			} else if(s.contains("pop")) {
				System.out.println(pop());
			} else if(s.contains("size")) {
				System.out.println(size());
			} else if(s.contains("empty")) {
				if(isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if(s.contains("front")) {
				System.out.println(first());
			} else if(s.contains("back")) {
				System.out.println(last());
			}
		}
		
	}
	
	static boolean isEmpty() {
		return front == rear;
	}
	
	static void push(int data) {
		queue[++rear] = data;
	}
	
	static int pop() {
		if(isEmpty()) {
			return -1;
		} else {
			return queue[++front];
		}
	}
	
	static int size() {
		if(isEmpty()) {
			return 0;
		}
		return rear - front; 
	}
	
	static int first() {
		if(isEmpty()) {
			return -1;
		} else {
			return queue[front+1];
		}
	}
	
	static int last() {
		if(isEmpty()) {
			return -1;
		} else {
			return queue[rear];
		}
	}

	

}
