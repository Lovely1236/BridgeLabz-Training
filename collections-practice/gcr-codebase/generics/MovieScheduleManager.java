package scenario_based;
import java.util.ArrayList;
import java.util.List;
public class MovieScheduleManager {

    // List to store movie titles
    private List<String> movieTitles;

    // List to store movie showtimes
    private List<String> movieTimes;

    
    public MovieScheduleManager() {
        movieTitles = new ArrayList<>();
        movieTimes = new ArrayList<>();
    }

   
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        movieTimes.add(time);
    }

   
    public void searchMovie(String keyword) {
        boolean found = false;

        try {
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).contains(keyword)) {
                    System.out.println(formatMovie(i));
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No movie found with keyword: " + keyword);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index accessed while searching.");
        }
    }

   
    public void displayAllMovies() {
        if (movieTitles.isEmpty()) {
            System.out.println("No movies scheduled.");
            return;
        }

        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(formatMovie(i));
        }
    }

    
    public void generatePrintableReport() {
        String[] report = new String[movieTitles.size()];

        for (int i = 0; i < movieTitles.size(); i++) {
            report[i] = formatMovie(i);
        }

        System.out.println("\n--- Printable Movie Report ---");
        for (String entry : report) {
            System.out.println(entry);
        }
    }

   
    private String formatMovie(int index) {
        return String.format("Movie: %-20s Time: %s",
                movieTitles.get(index),
                movieTimes.get(index));
    }

    
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) {
            return false;
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
    }

    /**
     * Main method – program execution starts here
     */
    public static void main(String[] args) {

        MovieScheduleManager cinema = new MovieScheduleManager();

        try {
            cinema.addMovie("Inception", "18:30");
            cinema.addMovie("Interstellar", "21:00");
            cinema.addMovie("Avengers", "25:99"); // Invalid time
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- All Movies ---");
        cinema.displayAllMovies();

        System.out.println("\n--- Search Results ---");
        cinema.searchMovie("Inter");

        cinema.generatePrintableReport();
    }
}

/**
 * Custom Exception for invalid movie showtime format
 */
class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}
