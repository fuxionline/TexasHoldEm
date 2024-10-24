import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Hand hand;

        hand = new Hand("S6 H2 D3 C4 S5");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: STRAIGHT)");
        System.out.println();

        hand = new Hand("SK HQ DK CQ HK");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: FULL HOUSE)");
        System.out.println();

        hand = new Hand("S4 H8 D2 C3 S3");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: PAIR)");
        System.out.println();

        hand = new Hand("S6 H3 D4 C8 S5");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: HIGH_CARD)");
        System.out.println();

        hand = new Hand("S6 H6 D6 C2 H2");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: FULL_HOUSE)");
        System.out.println();

        hand = new Hand("S6 H6 D6 C2 D3");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: THREE_OF_A_KIND)");
        System.out.println();

        hand = new Hand("S6 H6 D2 C2 D3");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: TWO_PAIRS)");
        System.out.println();

        hand = new Hand("S6 S7 S2 S9 ST");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: FLUSH)");
        System.out.println();

        hand = new Hand("H6 H2 H3 H4 H5");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: STRAIGHT_FLUSH)");
        System.out.println();

        hand = new Hand("S6 H6 D6 C6 D3");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: POKER)");
        System.out.println();

        hand = new Hand("ST SQ SJ SK SA");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: ROYAL_FLUSH)");
        System.out.println();

        hand = new Hand("ST SA SJ HK SA");
        System.out.println(hand);
        System.out.println("===============>   " + hand.getHandValue() + " (expected: NOT_VALID)");
        System.out.println();
    }
}