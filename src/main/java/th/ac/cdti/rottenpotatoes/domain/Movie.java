package th.ac.cdti.rottenpotatoes.domain;

import java.time.LocalDate;

public record Movie(String title, Rating rating,
        String description, LocalDate releaseDate)
        implements Comparable<Movie> {
    @Override
    public int compareTo(Movie other) {
        return 0;
    }
}
