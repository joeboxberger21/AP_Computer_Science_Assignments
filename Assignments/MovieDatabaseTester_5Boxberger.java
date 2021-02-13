/**
 * Array-A5: Movie Database
 * @author Joe Boxberger
 */

import java.util.Arrays;

public class MovieDatabaseTester_5Boxberger {
    public static void main(String[] args) {
        Movie starWars = new Movie("Star Wars: Episode IV - A New Hope", "Science Fiction", 125, "PG-13");
        starWars.rate(90);
        starWars.rate(95);
        starWars.rate(94);

        Movie avengers = new Movie("Marvel's The Avengers", "Action", 144, "PG-13");
        avengers.rate(87);
        avengers.rate(90);
        avengers.rate(88);

        Movie click = new Movie("Click", "Comedy", 107, "PG-13");
        click.rate(82);
        click.rate(80);
        click.rate(85);

        Movie gump = new Movie("Forrest Gump", "Drama", 142, "PG-13");
        gump.rate(92);
        gump.rate(94);

        Movie inception = new Movie("Inception", "Action", 162, "PG-13");
        inception.rate(92);
        inception.rate(88);
        
        Movie deadpool = new Movie("Deadpool", "Comedy", 109, "R");
        deadpool.rate(90);
        deadpool.rate(83);
        deadpool.rate(92);
        deadpool.rate(86);
        
        Movie ryan = new Movie("Saving Private Ryan", "Action", 170, "R");
        ryan.rate(87);
        ryan.rate(87);
        ryan.rate(91);
        
        Movie joker = new Movie("Joker", "Thriller", 122, "R");
        joker.rate(92);
        joker.rate(88);
        joker.rate(94);

        Movie matrix = new Movie("The Matrix", "Action", 136, "R");
        matrix.rate(92);
        matrix.rate(90);

        Movie superbad = new Movie("Superbad",  "Comedy", 119, "R");
        superbad.rate(92);
        superbad.rate(94);

        Movie[] testArray = {starWars, avengers, click, gump, inception, deadpool, ryan, joker, matrix, superbad};
        MovieDatabase database = new MovieDatabase(testArray);

        System.out.println("--------Random PG-13 movie--------\n" + database.getMovie("PG-13"));
        System.out.println("--------Random R movie--------\n" + database.getMovie("R"));

        System.out.println("--------Longest PG-13 movie--------\n" + database.getDateMovie("PG-13"));
        System.out.println("--------Longest R movie--------\n" + database.getDateMovie("R"));

        System.out.println("--------Best PG-13 movie--------\n" + database.getBestMovie("PG-13"));
        System.out.println("--------Best R movie--------\n" + database.getBestMovie("R"));
    }
}

/**
 * Class that holds an array of movies and has various methods to access the movies from the database
 */
class MovieDatabase {
    private Movie[] movieArray;

    private int count = 0;
    private Movie[] tempArray = new Movie[20];

    private Movie longestMovie = null;
    private Movie bestMovie = null;
    
    /**
     * @param array movie array that will be input into the database
     */
    public MovieDatabase(Movie[] array) {
        movieArray = array;
    }

    /**
     * @param rating specified MPAA rating
     * Gets random movie from list of movies with the specified MPAA rating
     */
    public Movie getMovie(String rating) {
        count = 0;
        Arrays.fill(tempArray, null);
        for(int i = 0; i < movieArray.length; i++) {
            movieArray[i].getRating();
            if(movieArray[i].getRating().equals(rating)) {
                tempArray[count] = movieArray[i];
                count++;
            }
        }
        if(tempArray[0] != null) {
            return tempArray[(int)(Math.random() * count)];
        } else {
            System.out.println("Search unsuccessful");
            return null;
        }
    }

    /**
     * @param rating specified MPAA rating
     * Gets longest movie from list of movies with specified MPAA rating
     */
    public Movie getDateMovie(String rating) {
        count = 0;
        Arrays.fill(tempArray, null);
        for(int i = 0; i < movieArray.length; i++) {
            if(movieArray[i].getRating().equals(rating)) {
                tempArray[count] = movieArray[i];
                count++;
            }
        }
        for(int i = 0; i < count - 1; i++) {
            if(tempArray[i].getLength() > tempArray[i+1].getLength()) {
                longestMovie = tempArray[i];
            } else if (tempArray[i].getLength() < tempArray[i+1].getLength()) {
                longestMovie = tempArray[i+1];
            }
        }
        if(tempArray[0] != null) {
            return longestMovie;
        } else {
            System.out.println("Search for date movie unsuccessful");
            return null;
        }
    }

    /**
     * @param rating specified MPAA rating
     * Gets best user rated movie from list of movies with specified MPAA rating
     */
    public Movie getBestMovie(String rating) {
        count = 0;
        Arrays.fill(tempArray, null);
        for(int i = 0; i < movieArray.length; i++) {
            if(movieArray[i].getRating().equals(rating)) {
                tempArray[count] = movieArray[i];
                count++;
            }
        }
        for(int i = 0; i < count - 1; i++) {
            if(tempArray[i].getUserRating() > tempArray[i+1].getUserRating()) {
                bestMovie = tempArray[i];
            } else if (tempArray[i].getUserRating() < tempArray[i+1].getUserRating()) {
                bestMovie = tempArray[i+1];
            }
        }
        if(tempArray[0] != null) {
            return bestMovie;
        } else {
            System.out.println("Search for best movie unsuccessful");
            return null;
        }
    }
}


/**
 * Movie class that represents a movie and holds the movie's information like its title, length, genre, rating, and user ratings
 */
class Movie {
    private String title;
    private String genre;
    private int length;
    private String mpaaRating;
    private int userRatingPoints = 0;
    private int userRatings = 0;
    /**
     * @param name String title of movie
     * @param genre String genre of movie
     * @param runTime int length of movie in minutes
     * @param rating String mpaa rating of movie
     */
    public Movie(String name, String genre, int runTime, String rating) {
        title = name;
        this.genre = genre;
        length = runTime;
        mpaaRating = rating;
    }
    /**
     * @param rating int from 1-100 that represents users opinion of movie
     * recieve rating from user and calculate average of all ratings
     */
    public void rate(int rating) {
        userRatings++;
        userRatingPoints += rating;
    }
    /**
     * @return return user rating or if there are no user ratings return 0 
     */
    public int getUserRating() {
        if(userRatings != 0) return userRatingPoints/userRatings;
        else return 0; 
    }
    /**
     * @return return mpaa rating String
     */
    public String getRating() {
        return mpaaRating;
    }
    /**
     * @return length of movie in minutes
     */
    public int getLength() {
        return length;
    }
    /**
     * @return return a formatted String of all of the movie's instance variables
     */
    public String toString() {
        return "Title: " + title + "\nRun time: " + length/60 + " hours and " + 
        length%60 + " minutes." + "\nGenre: " + genre + "\nRating: " + 
        mpaaRating + "\nAverage User Rating: " + getUserRating() + "\n";
    }
}