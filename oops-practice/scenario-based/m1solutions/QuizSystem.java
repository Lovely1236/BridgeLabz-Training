import java.util.*;

class Student {
    String name, dept;
    int q1, q2, q3;

    Student(String n, String d, int a, int b, int c) {
        name = n; dept = d; q1 = a; q2 = b; q3 = c;
    }

    int total() { return q1 + q2 + q3; }
}

public class QuizSystem {

    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split(" ");

            if (input[0].equals("Record")) {
                Student s = new Student(input[1], input[2],
                        Integer.parseInt(input[3]),
                        Integer.parseInt(input[4]),
                        Integer.parseInt(input[5]));
                list.add(s);
                System.out.println("Record Added: " + s.name);
            }

            else if (input[0].equals("Top")) {
                if (list.isEmpty()) {
                    System.out.println("No Records Available");
                    continue;
                }

                if (input[1].equals("Q1") || input[1].equals("Q2") || input[1].equals("Q3")) {

                    int max = 0;
                    for (Student s : list) {
                        int val = input[1].equals("Q1") ? s.q1 :
                                  input[1].equals("Q2") ? s.q2 : s.q3;
                        max = Math.max(max, val);
                    }

                    for (Student s : list) {
                        int val = input[1].equals("Q1") ? s.q1 :
                                  input[1].equals("Q2") ? s.q2 : s.q3;
                        if (val == max)
                            System.out.println(s.name + " " + val);
                    }

                } else {
                    int max = 0;
                    boolean found = false;

                    for (Student s : list) {
                        if (s.dept.equals(input[1])) {
                            found = true;
                            max = Math.max(max, s.total());
                        }
                    }

                    if (!found) {
                        System.out.println("Department Not Found");
                        continue;
                    }

                    for (Student s : list) {
                        if (s.dept.equals(input[1]) && s.total() == max)
                            System.out.println(s.name + " " + s.total());
                    }
                }
            }
        }
    }
}