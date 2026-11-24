package th.ac.cdti.rottenpotatoes.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class MovieTest {
    @Test
    void stripsSpacesAroundTheTitle() {
        Movie movie = new Movie("  Aladdin ", Rating.G, "", LocalDate.of(1992, 11, 25));
        assertThat(movie.title()).isEqualTo("Aladdin");
    }

    @Test
    void rejectsBlankTitle() {
        assertThatThrownBy(() -> new Movie(" ", Rating.G, "", LocalDate.of(1992, 11, 25)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("title");
    }

    @Test
    void rejectsReleaseBefore1930() {
        assertThatThrownBy(() -> new Movie("Metropolis", Rating.G, "", LocalDate.of(1927, 1, 10)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1930");
    }

    @Test
    void ordersByTitleIgnoringCase() {
        Movie a = new Movie("aladdin", Rating.G, "", LocalDate.of(1992, 11, 25));
        Movie b = new Movie("Beauty and the Beast", Rating.G, "", LocalDate.of(1991, 11, 22));
        assertThat(a).isLessThan(b);
    }
}
