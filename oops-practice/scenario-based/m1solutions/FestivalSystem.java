import java.util.*;

abstract class Festival {
    String name, location, date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void display();
}

class MusicFestival extends Festival {
    String headliner, genre;
    int price;

    MusicFestival(String n, String l, String d, String h, String g, int p) {
        super(n, l, d);
        headliner = h;
        genre = g;
        price = p;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + genre);
        System.out.println("Ticket Price: " + price);
    }
}

class FoodFestival extends Festival {
    String cuisine;
    int stalls, fee;

    FoodFestival(String n, String l, String d, String c, int s, int f) {
        super(n, l, d);
        cuisine = c;
        stalls = s;
        fee = f;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + stalls);
        System.out.println("Entry Fee: " + fee);
    }
}

class ArtFestival extends Festival {
    String artType;
    int artists, fee;

    ArtFestival(String n, String l, String d, String a, int ar, int f) {
        super(n, l, d);
        artType = a;
        artists = ar;
        fee = f;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + artists);
        System.out.println("Exhibition Fee: " + fee);
    }
}

public class FestivalSystem {
    static Map<String, Festival> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            String[] input = line.split(" ");

            if (input[0].equals("EXIT")) break;

            if (input[0].equals("ADD_FESTIVAL")) {
                String type = input[1];

                if (type.equals("MUSIC")) {
                    map.put(input[2], new MusicFestival(
                            input[2], input[3], input[4],
                            input[5], input[6],
                            Integer.parseInt(input[7])
                    ));
                } else if (type.equals("FOOD")) {
                    map.put(input[2], new FoodFestival(
                            input[2], input[3], input[4],
                            input[5],
                            Integer.parseInt(input[6]),
                            Integer.parseInt(input[7])
                    ));
                } else if (type.equals("ART")) {
                    map.put(input[2], new ArtFestival(
                            input[2], input[3], input[4],
                            input[5],
                            Integer.parseInt(input[6]),
                            Integer.parseInt(input[7])
                    ));
                }
            }

            else if (input[0].equals("DISPLAY_DETAILS")) {
                String name = input[1];
                if (map.containsKey(name))
                    map.get(name).display();
            }
        }
    }
}