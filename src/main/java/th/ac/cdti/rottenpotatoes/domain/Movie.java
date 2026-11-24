package th.ac.cdti.rottenpotatoes.domain;

import java.time.LocalDate;
import java.util.Objects;

public record Movie(String title, Rating rating,
        String description, LocalDate releaseDate)
        implements Comparable<Movie> {
    public Movie { // compact constructor
        Objects.requireNonNull(title, "title");
        Objects.requireNonNull(rating, "rating");
        Objects.requireNonNull(releaseDate, "releaseDate");
        if (title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        if (releaseDate.getYear() < 1930) {
            throw new IllegalArgumentException("release year must be 1930 or later");
        }
        title = title.strip();
        description = description == null ? "" : description;
    }

    @Override
    public int compareTo(Movie other) {
        return title.compareToIgnoreCase(other.title);
    }
}
