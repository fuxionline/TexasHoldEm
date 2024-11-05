package texasholdem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HandTest {
    @Test
    public void testRoyalFlush() {
        assertEquals("CT CJ CQ CK CA   ROYAL_FLUSH       OK", Hand.testHand("CT CJ CQ CK CA", HandVal.ROYAL_FLUSH));
    }

    @Test
    public void testStraightFlush() {
        assertEquals("D8 DQ DJ DT D9   STRAIGHT_FLUSH    OK", Hand.testHand("D8 DQ DJ DT D9", HandVal.STRAIGHT_FLUSH));
        assertEquals("H8 HT HJ H7 H9   STRAIGHT_FLUSH    OK", Hand.testHand("H8 HT HJ H7 H9", HandVal.STRAIGHT_FLUSH));
    }

    @Test
    public void testFourOfAKind() {
        assertEquals("HT SQ ST DT CT   POKER             OK", Hand.testHand("HT SQ ST DT CT", HandVal.POKER));
        assertEquals("HT SK ST DT CT   POKER             OK", Hand.testHand("HT SK ST DT CT", HandVal.POKER));
        assertEquals("H8 SQ S8 D8 C8   POKER             OK", Hand.testHand("H8 SQ S8 D8 C8", HandVal.POKER));
        assertEquals("H7 SK S7 D7 C7   POKER             OK", Hand.testHand("H7 SK S7 D7 C7", HandVal.POKER));
    }

    @Test
    public void testFullHouse() {
        assertEquals("H2 SQ C2 D2 CQ   FULL_HOUSE        OK", Hand.testHand("H2 SQ C2 D2 CQ", HandVal.FULL_HOUSE));
        assertEquals("D2 DJ D2 D2 DJ   FULL_HOUSE        NOT_OK", Hand.testHand("D2 DJ D2 D2 DJ", HandVal.FULL_HOUSE));
        assertEquals("H2 SJ C2 D2 CJ   FULL_HOUSE        OK", Hand.testHand("H2 SJ C2 D2 CJ", HandVal.FULL_HOUSE));
        assertEquals("D2 DJ D2 D2 DJ   FULL_HOUSE        NOT_OK", Hand.testHand("D2 DJ D2 D2 DJ", HandVal.FULL_HOUSE));
    }

    @Test
    public void testFlush() {
        assertEquals("HK HQ H2 H4 H5   FLUSH             OK", Hand.testHand("HK HQ H2 H4 H5", HandVal.FLUSH));
        assertEquals("HK HQ H2 H4 H5   FLUSH             OK", Hand.testHand("HK HQ H2 H4 H5", HandVal.FLUSH));
        assertEquals("D5 D4 D2 DQ DK   FLUSH             OK", Hand.testHand("D5 D4 D2 DQ DK", HandVal.FLUSH));
    }

    @Test
    public void testStraight() {
        assertEquals("H3 S7 H5 D6 H4   STRAIGHT          OK", Hand.testHand("H3 S7 H5 D6 H4", HandVal.STRAIGHT));
        assertEquals("C9 CT SJ D7 H8   STRAIGHT          OK", Hand.testHand("C9 CT SJ D7 H8", HandVal.STRAIGHT));
        assertEquals("H4 S5 HA D3 H2   STRAIGHT          OK", Hand.testHand("H4 S5 HA D3 H2", HandVal.STRAIGHT));
    }

    @Test
    public void testThreeOfAKind() {
        assertEquals("H2 SQ S2 D2 CK   THREE_OF_A_KIND   OK", Hand.testHand("H2 SQ S2 D2 CK", HandVal.THREE_OF_A_KIND));
        assertEquals("H2 S7 S2 D2 C9   THREE_OF_A_KIND   OK", Hand.testHand("H2 S7 S2 D2 C9", HandVal.THREE_OF_A_KIND));
        assertEquals("H2 S8 S2 D2 C9   THREE_OF_A_KIND   OK", Hand.testHand("H2 S8 S2 D2 C9", HandVal.THREE_OF_A_KIND));
    }

    @Test
    public void testTwoPairs() {
        assertEquals("H5 SQ C5 DT CT   TWO_PAIRS         OK", Hand.testHand("H5 SQ C5 DT CT", HandVal.TWO_PAIRS));
        assertEquals("D5 DK S5 DT DT   TWO_PAIRS         NOT_OK", Hand.testHand("D5 DK S5 DT DT", HandVal.TWO_PAIRS));
        assertEquals("H9 SQ C9 DT CT   TWO_PAIRS         OK", Hand.testHand("H9 SQ C9 DT CT", HandVal.TWO_PAIRS));
        assertEquals("D8 DK S8 DT DT   TWO_PAIRS         NOT_OK", Hand.testHand("D8 DK S8 DT DT", HandVal.TWO_PAIRS));
    }

    @Test
    public void testPair() {
        assertEquals("H3 S8 H5 D8 CA   PAIR              OK", Hand.testHand("H3 S8 H5 D8 CA", HandVal.PAIR));
        assertEquals("S4 DA H3 CA HT   PAIR              OK", Hand.testHand("S4 DA H3 CA HT", HandVal.PAIR));
    }

    @Test
    public void testHighCard() {
        assertEquals("H3 S8 H5 DK CA   HIGH_CARD         OK", Hand.testHand("H3 S8 H5 DK CA", HandVal.HIGH_CARD));
        assertEquals("H3 S8 H5 DK CT   HIGH_CARD         OK", Hand.testHand("H3 S8 H5 DK CT", HandVal.HIGH_CARD));
        assertEquals("H3 S8 H5 DK C2   HIGH_CARD         OK", Hand.testHand("H3 S8 H5 DK C2", HandVal.HIGH_CARD));
    }
}