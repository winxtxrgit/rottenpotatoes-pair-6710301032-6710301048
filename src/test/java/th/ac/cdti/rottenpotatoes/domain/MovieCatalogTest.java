package th.ac.cdti.rottenpotatoes.domain;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
class MovieCatalogTest {
  private final MovieCatalog catalog = new MovieCatalog(List.of(
      new Movie("Aladdin", Rating.G, "", LocalDate.of(1992, 11, 25)),
      new Movie("The Terminator", Rating.R, "", LocalDate.of(1984, 10, 26)),
      new Movie("When Harry Met Sally", Rating.R, "", LocalDate.of(1989, 7, 21)),
      new Movie("The Help", Rating.PG13, "", LocalDate.of(2011, 8, 10)),
      new Movie("Chocolat", Rating.PG13, "", LocalDate.of(2000, 8, 5))));

  @Test void byRatingFiltersAndSortsByTitle() {
    assertThat(catalog.byRating(Rating.R)).extracting(Movie::title)
        .containsExactly("The Terminator", "When Harry Met Sally");
  }
  @Test void titlesSortedIgnoresCase() {
    assertThat(catalog.titlesSorted()).containsExactly("Aladdin", "Chocolat", "The Help",
        "The Terminator", "When Harry Met Sally");
  }
  @Test void newestFirstKeepsOnlyTheLimit() {
    assertThat(catalog.newestFirst(2)).extracting(Movie::title)
        .containsExactly("The Help", "Chocolat");
  }
  @Test void findByTitleIgnoresCase() {
    assertThat(catalog.findByTitle("aladdin")).isPresent().get()
        .extracting(Movie::rating).isEqualTo(Rating.G);
  }
  @Test void findByTitleIsEmptyWhenMissing() {
    assertThat(catalog.findByTitle("Nope")).isEmpty();
  }
}
