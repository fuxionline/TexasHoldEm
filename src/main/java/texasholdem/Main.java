package texasholdem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        deleteOutputFile();

        appendTestResultToFile(Hand.testHand("CT CJ CQ CK CA", HandVal.ROYAL_FLUSH));

        appendTestResultToFile(Hand.testHand("D8 DQ DJ DT D9", HandVal.STRAIGHT_FLUSH));
        appendTestResultToFile(Hand.testHand("H8 HT HJ H7 H9", HandVal.STRAIGHT_FLUSH));

        appendTestResultToFile(Hand.testHand("HT SQ ST DT CT", HandVal.POKER));
        appendTestResultToFile(Hand.testHand("HT SK ST DT CT", HandVal.POKER));
        appendTestResultToFile(Hand.testHand("H8 SQ S8 D8 C8", HandVal.POKER));
        appendTestResultToFile(Hand.testHand("H7 SK S7 D7 C7", HandVal.POKER));

        appendTestResultToFile(Hand.testHand("H2 SQ C2 D2 CQ", HandVal.FULL_HOUSE));
        appendTestResultToFile(Hand.testHand("D2 DJ D2 D2 DJ", HandVal.FULL_HOUSE));
        appendTestResultToFile(Hand.testHand("H2 SJ C2 D2 CJ", HandVal.FULL_HOUSE));
        appendTestResultToFile(Hand.testHand("D2 DJ D2 D2 DJ", HandVal.FULL_HOUSE));

        appendTestResultToFile(Hand.testHand("HK HQ H2 H4 H5", HandVal.FLUSH));
        appendTestResultToFile(Hand.testHand("HK HQ H2 H4 H5", HandVal.FLUSH));
        appendTestResultToFile(Hand.testHand("D5 D4 D2 DQ DK", HandVal.FLUSH));

        appendTestResultToFile(Hand.testHand("H3 S7 H5 D6 H4", HandVal.STRAIGHT));
        appendTestResultToFile(Hand.testHand("C9 CT SJ D7 H8", HandVal.STRAIGHT));
        appendTestResultToFile(Hand.testHand("H4 S5 HA D3 H2", HandVal.STRAIGHT));

        appendTestResultToFile(Hand.testHand("H2 SQ S2 D2 CK", HandVal.THREE_OF_A_KIND));
        appendTestResultToFile(Hand.testHand("H2 S7 S2 D2 C9", HandVal.THREE_OF_A_KIND));
        appendTestResultToFile(Hand.testHand("H2 S8 S2 D2 C9", HandVal.THREE_OF_A_KIND));

        appendTestResultToFile(Hand.testHand("H5 SQ C5 DT CT", HandVal.TWO_PAIRS));
        appendTestResultToFile(Hand.testHand("D5 DK S5 DT DT", HandVal.TWO_PAIRS));
        appendTestResultToFile(Hand.testHand("H9 SQ C9 DT CT", HandVal.TWO_PAIRS));
        appendTestResultToFile(Hand.testHand("D8 DK S8 DT DT", HandVal.TWO_PAIRS));

        appendTestResultToFile(Hand.testHand("H3 S8 H5 D8 CA", HandVal.PAIR));
        appendTestResultToFile(Hand.testHand("S4 DA H3 CA HT", HandVal.PAIR));

        appendTestResultToFile(Hand.testHand("H3 S8 H5 DK CA", HandVal.HIGH_CARD));
        appendTestResultToFile(Hand.testHand("H3 S8 H5 DK CT", HandVal.HIGH_CARD));
        appendTestResultToFile(Hand.testHand("H3 S8 H5 DK C2", HandVal.HIGH_CARD));

    }

    private static void appendTestResultToFile(String result) {
        try (FileWriter fw = new FileWriter("output.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOutputFile() {
        try {
            Files.deleteIfExists(Paths.get("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




        // Ausgabe
        // "ST SQ SJ SK SA" ROYAL_FLUSH OK
        // "ST SQ SJ SK SA" POKER NOT OK
        //
        // Aufgabe 1
        // Main.java
        // Hand.java
        // in output.txt
        // Aufgabe 2
        // als jUnit Test
        // Testverzeichnis als zip


}