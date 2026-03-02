import java.util.List;

public class Application {
    private static final int MIN_ACE = 1;
    private static final int MAX_ACE = 11;
    private static final int MAX_SUM = 21;
    private static final String TEST_CASE = "테스트 케이스 %d: ";

    public static void main (String[] args) {
        int i = 1;

        // 기본 카드로 ACE가 나온 경우
        List<Integer> cards = List.of(10);
        int ace = determineAce(cards);
        System.out.printf(TEST_CASE, i++);
        System.out.println(ace == MAX_ACE);

        // ACE를 제외한 카드들의 합이 10보다 큰 경우
        cards = List.of(10,9);
        ace = determineAce(cards);
        System.out.printf(TEST_CASE, i++);
        System.out.println(ace == MIN_ACE);

        cards = List.of(4,9,2);
        ace = determineAce(cards);
        System.out.printf(TEST_CASE, i++);
        System.out.println(ace == MIN_ACE);

        cards = List.of(8,9,3);
        ace = determineAce(cards);
        System.out.printf(TEST_CASE, i++);
        System.out.println(ace == MIN_ACE);

        // ACE를 제외한 카드들의 합이 10보다 작거나 같은 경우
        cards = List.of(2,4);
        ace = determineAce(cards);
        System.out.printf(TEST_CASE, i++);
        System.out.println(ace == MAX_ACE);

        cards = List.of(2,3,5);
        ace = determineAce(cards);
        System.out.printf(TEST_CASE, i);
        System.out.println(ace == MAX_ACE);
    }

    static int determineAce(List<Integer> cards) {
        int sum = sum(cards);
        if (isBust(sum + MAX_ACE)) {
            return MIN_ACE;
        }
        return MAX_ACE;
    }

    private static int sum(List<Integer> cards) {
        return cards.stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean isBust(int sum) {
        return sum > MAX_SUM;
    }
}
