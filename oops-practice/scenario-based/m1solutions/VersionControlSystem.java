import java.util.*;

class FileVersion {
    String version;
    int size;

    FileVersion(String v, int s) {
        version = v;
        size = s;
    }
}

public class VersionControlSystem {

    static Map<String, List<FileVersion>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split(" ");

            switch (input[0]) {

                case "UPLOAD":
                    map.putIfAbsent(input[1], new ArrayList<>());
                    boolean exists = false;

                    for (FileVersion fv : map.get(input[1])) {
                        if (fv.version.equals(input[2])) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists)
                        map.get(input[1]).add(new FileVersion(input[2], Integer.parseInt(input[3])));
                    break;

                case "FETCH":
                    if (!map.containsKey(input[1])) {
                        System.out.println("File Not Found");
                        break;
                    }

                    List<FileVersion> list = new ArrayList<>(map.get(input[1]));
                    list.sort((a, b) -> a.size == b.size ? a.version.compareTo(b.version) : a.size - b.size);

                    for (FileVersion fv : list)
                        System.out.println(input[1] + " " + fv.version + " " + fv.size);
                    break;

                case "LATEST":
                    if (!map.containsKey(input[1])) {
                        System.out.println("File Not Found");
                        break;
                    }

                    List<FileVersion> versions = map.get(input[1]);
                    FileVersion latest = versions.get(versions.size() - 1);

                    System.out.println(input[1] + " " + latest.version + " " + latest.size);
                    break;

                case "TOTAL_STORAGE":
                    if (!map.containsKey(input[1])) {
                        System.out.println("File Not Found");
                        break;
                    }

                    int sum = 0;
                    for (FileVersion fv : map.get(input[1])) sum += fv.size;

                    System.out.println(input[1] + " " + sum);
                    break;
            }
        }
    }
}