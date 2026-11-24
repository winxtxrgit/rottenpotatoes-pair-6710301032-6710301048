package th.ac.cdti.rottenpotatoes.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class MoviegoerTest {
    @Test
    void keepsNameAndEmail() {
        Moviegoer alice = new Moviegoer("Alice", "alice@example.com");
        assertThat(alice.name()).isEqualTo("Alice");
        assertThat(alice.email()).isEqualTo("alice@example.com");
    }

    @Test
    void rejectsAnEmailWithoutAtSign() {
        assertThatThrownBy(() -> new Moviegoer("Bob", "bob.example.com"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("@");
    }
}
