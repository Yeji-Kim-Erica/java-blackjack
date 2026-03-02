import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ApplicationTest {
    private static final int MIN_ACE = 1;
    private static final int MAX_ACE = 11;

    @ParameterizedTest
    @MethodSource
    void ACE를_제외한_카드들의_합이_10보다_큰_경우(List<Integer> cards) {
        int ace = Application.determineAce(cards);
        assertThat(ace).isEqualTo(MIN_ACE);
    }

    @ParameterizedTest
    @MethodSource
    void ACE를_제외한_카드들의_합이_10인_경우(List<Integer> cards) {
        int ace = Application.determineAce(cards);
        assertThat(ace).isEqualTo(MAX_ACE);
    }

    @ParameterizedTest
    @MethodSource
    void ACE를_제외한_카드들의_합이_10보다_작은_경우(List<Integer> cards) {
        int ace = Application.determineAce(cards);
        assertThat(ace).isEqualTo(MAX_ACE);
    }

    @Test
    void ACE를_제외한_카드들의_합이_21인_경우() {
        List<Integer> cards = List.of(10, 2, 9);
        int ace = Application.determineAce(cards);
        assertThat(ace).isEqualTo(MIN_ACE);
    }

    @Test
    void ACE를_제외한_카드들의_합이_21을_초과한_경우() {
        List<Integer> cards = List.of(10, 5, 9);
        int ace = Application.determineAce(cards);
        assertThat(ace).isEqualTo(MIN_ACE);
    }

    private static Stream<List<Integer>> ACE를_제외한_카드들의_합이_10보다_큰_경우() {
        return Stream.of(List.of(10,9), List.of(4,9,2), List.of(8,9,3));
    }

    private static Stream<List<Integer>> ACE를_제외한_카드들의_합이_10인_경우() {
        return Stream.of(List.of(10), List.of(2,3,5));
    }

    private static Stream<List<Integer>> ACE를_제외한_카드들의_합이_10보다_작은_경우() {
        return Stream.of(List.of(2,4), List.of(2,3,4));
    }
}
