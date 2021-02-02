public class MovieTester_5Boxberger {
    public static void main(String[] args) {
        Movie starWars = new Movie("Star Wars: Episode IV - A New Hope", "Science Fiction", 125, "PG-13");
        System.out.println(starWars);
        starWars.rate(90);
        starWars.rate(94);
        System.out.println(starWars);

        Movie avengers = new Movie("Marvel's The Avengers", "Action", 144, "PG-13");
        System.out.println(avengers);
        avengers.rate(91);
        avengers.rate(96);
        avengers.rate(88);
        System.out.print(avengers);
    }
}


class Movie {
    private String title;
    private String genre;
    private int length;
    private String mpaaRating;
    private int userRatingPoints = 0;
    private int userRatings = 0;

    public Movie(String name, String genre, int runTime, String rating) {
        title = name;
        this.genre = genre;
        length = runTime;
        mpaaRating = rating;
    }

    public void rate(int rating) {
        userRatings++;
        userRatingPoints += rating;
    }

    public int getRating() {
        if(userRatings != 0) return userRatingPoints/userRatings;
        else return 0; 
    }

    public String toString() {
        return "Title: " + title + "\nRun time: " + length/60 + " hours and " + length%60 + " minutes." + "\nGenre: " + genre + "\nRating: " + mpaaRating + "\nAverage User Rating: " + getRating() + "\n";
    }
}
