package th.ac.cdti.rottenpotatoes.domain;
import java.util.List;
import java.util.Optional;

public final class MovieCatalog {
  private final List<Movie> movies;
  public MovieCatalog(List<Movie> movies) { this.movies = List.copyOf(movies); }
  public List<Movie> byRating(Rating rating) { return List.of(); }
  public List<String> titlesSorted() { return List.of(); }
  public List<Movie> newestFirst(int limit) { return List.of(); }
  public Optional<Movie> findByTitle(String title) { return Optional.empty(); }
}
