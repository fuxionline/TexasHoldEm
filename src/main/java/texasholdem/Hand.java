package texasholdem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Hand {
    private Card[] cards;
    private HandVal handValue;

    public Hand(Card[] cards) {
        this.cards = cards;
        this.handValue = calcHandValue();
    }

    // constructor that takes a string describing 5 cards,
    // each with two characters, separated by at least one space
    // eg, "D2 HA ST CK S2"
    public Hand(String handDesc) {
        String[] cardDescs = handDesc.split("\\s+");
        if (cardDescs.length != 5) {
            throw new IllegalArgumentException("Invalid hand description: " + handDesc);
        }
        cards = new Card[5];
        for (int i = 0; i < 5; i++) {
            cards[i] = new Card(cardDescs[i]);
        }
        this.handValue = calcHandValue();
    }

    private boolean hasDuplicates() {
        Set<String> cardCombinations = new HashSet<>();
        for (Card card : cards) {
            String combination = card.getSuit().ordinal() + "-" + card.getRank().ordinal();
            if (!cardCombinations.add(combination)) {
                return true; // Duplicate suit-rank combination found
            }
        }
        return false; // No duplicates
    }

    private HandVal calcHandValue() {
        // This method is used to calculate the actual hand value and return the highest possible value
        // This involves checking the current hand against all possible hand values
        // The hand value is then set to the highest possible value
        // The hand value is then returned

        // Check for duplicates
        if (hasDuplicates()) return HandVal.NOT_VALID;

        Arrays.sort(cards, Comparator.comparingInt(card -> card.getRank().ordinal()));

        boolean isFlush = Arrays.stream(cards)
                .allMatch(card -> card.getSuit() == cards[0].getSuit());

        // Check for Ace-low straight (A-2-3-4-5)
        boolean isLowAceStraight = cards[0].getRank() == Rank.TWO &&
                cards[1].getRank() == Rank.THREE &&
                cards[2].getRank() == Rank.FOUR &&
                cards[3].getRank() == Rank.FIVE &&
                cards[4].getRank() == Rank.ACE;

        boolean isStraight = true;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].getRank().ordinal() != cards[i - 1].getRank().ordinal() + 1) {
                isStraight = false;
                break;
            }
        }
        isStraight = isStraight || isLowAceStraight;

        if (isFlush && isStraight) {
            if (cards[0].getRank() == Rank.TEN && cards[4].getRank() == Rank.ACE) {
                return HandVal.ROYAL_FLUSH;
            }
            return HandVal.STRAIGHT_FLUSH;
        }

        int[] rankCounts = new int[Rank.values().length];
        for (Card card : cards) {
            rankCounts[card.getRank().ordinal()]++;
        }

        boolean hasFour = false, hasThree = false, hasPair = false, hasTwoPairs = false;
        for (int count : rankCounts) {
            if (count == 4) hasFour = true;
            if (count == 3) hasThree = true;
            if (count == 2) {
                if (hasPair) hasTwoPairs = true;
                hasPair = true;
            }
        }

        if (hasFour) return HandVal.POKER;
        if (hasThree && hasPair) return HandVal.FULL_HOUSE;
        if (isFlush) return HandVal.FLUSH;
        if (isStraight) return HandVal.STRAIGHT;
        if (hasThree) return HandVal.THREE_OF_A_KIND;
        if (hasTwoPairs) return HandVal.TWO_PAIRS;
        if (hasPair) return HandVal.PAIR;

        return HandVal.HIGH_CARD;
    }

    public Card[] getCards() {
        return cards;
    }

    public HandVal getHandValue() {
        return handValue;
    }


    public static String testHand(String handString, HandVal expectedValue){
        Hand hand = new Hand(handString);
        String status = "NOT_OK";
        if (hand.getHandValue() == expectedValue) {
            status = "OK";
        }

        System.out.printf("%s   %-17s %s%n", handString, expectedValue, status);
        return String.format("%s   %-17s %s", handString, expectedValue, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card).append("\n");  // new line after each card
        }
        return sb.toString().trim();
    }
}
