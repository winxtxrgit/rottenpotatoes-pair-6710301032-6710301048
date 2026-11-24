package th.ac.cdti.rottenpotatoes.domain;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
class RatingTest {
  @Test void labelOfPg13UsesHyphen() { assertThat(Rating.PG13.label()).isEqualTo("PG-13"); }
  @Test void fromLabelFindsTheRating() {
      assertThat(Rating.fromLabel("NC-17")).isEqualTo(Rating.NC17); }
  @Test void unknownLabelIsRejected() {
    assertThatThrownBy(() -> Rating.fromLabel("X")).isInstanceOf(IllegalArgumentException.class);
  }
}
