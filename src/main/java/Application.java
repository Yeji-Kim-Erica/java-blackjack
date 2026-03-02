import java.util.List;

public class Application {
    private static final int MIN_ACE = 1;
    private static final int MAX_ACE = 11;
    private static final int MAX_SUM = 21;

    public static void main (String[] args) {
        List<Integer> cards = List.of(10);
        int ace = determineAce(cards);
        System.out.println(ace == MAX_ACE);

        cards = List.of(10,9);
        ace = determineAce(cards);
        System.out.println(ace == MIN_ACE);

        cards = List.of(4,9,2);
        ace = determineAce(cards);
        System.out.println(ace == MIN_ACE);
    }

    private static int determineAce(List<Integer> cards) {
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
