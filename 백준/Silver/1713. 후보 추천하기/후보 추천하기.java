import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static class Student {
        int id;
        int recommend;
        int time;
        boolean isPosted;

        public Student(int id, int recommend, int time, boolean isPosted) {
            this.id = id;
            this.recommend = recommend;
            this.time = time;
            this.isPosted = isPosted;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int recommend = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Student> list = new ArrayList<>();
        Student[] students = new Student[101];
        int num;

        for(int i = 0; i < recommend; i++) {
            num = Integer.parseInt(st.nextToken()); // 추천받은 학생

            if(students[num] == null) {
                students[num] = new Student(num, recommend, 0, false);
            }

            if(students[num].isPosted) {
                students[num].recommend++;
            } else {
                if(list.size() == N) {
                    Collections.sort(list, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            if(o1.recommend == o2.recommend) {
                                return o1.time - o2.time;
                            }
                            return o1.recommend - o2.recommend;
                        }
                    });
                    list.get(0).recommend = 0;
                    list.get(0).isPosted = false;
                    list.remove(0);
                }
                students[num].isPosted = true;
                students[num].time = i;
                students[num].recommend = 1;
                list.add(students[num]);
            }
        }

        Collections.sort(list, (o1, o2) -> o1.id - o2.id);
        for(Student val : list) {
            System.out.print(val.id + " ");
        }



    }
}
