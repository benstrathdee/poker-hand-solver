package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HandEvaluatorTest {
    int defaultRank = RankValue.DEFAULT.numValue;
    int rankInterval = RankValue.INTERVAL.numValue;

    @TestFactory
    Stream<DynamicTest> shouldHaveRoyalFlush () {
        int rankValue = RankValue.ROYAL_FLUSH.numValue;

        List<String> inputList = Arrays.asList(
                "TD QD JD KD AD",
                "AS TS QS JS KS",
                "QH AH KH JH TH",
                "TC KC QC JC AC",
                "AD JD QD KD TD"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            // Split the input string into a list of cards
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            // checks them against the function
                            Assertions.assertEquals(rankValue * rankInterval,
                                    HandEvaluator.hasRoyalFlush(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldNotHaveRoyalFlush () {

        List<String> inputList = Arrays.asList(
                "TD TD TD TD TD",
                "AD QD JD KD TH",
                "AD AD KD QD JD",
                "AD QH KS JD TC",
                "9D JD QD KD AD"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            Assertions.assertEquals(defaultRank, HandEvaluator.hasRoyalFlush(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldHaveStraightFlush () {
        int rankValue = RankValue.STRAIGHT_FLUSH.numValue;

        List<String> inputList = Arrays.asList(
                "2D 3D 4D 5D 6D",
                "4S 5S 6S 7S 8S",
                "7C 8C 9C TC JC",
                "9H TH JH QH KH",
                "5D 4D 2D 6D 3D"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            hand.sort(new CardComparator());
                            Assertions.assertEquals(rankValue * rankInterval + hand.get(hand.size() - 1).faceValue,
                                    HandEvaluator.hasStraightFlush(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldNotHaveStraightFlush () {

        List<String> inputList = Arrays.asList(
                "2D 2D 3D 4D 5D",
                "5D 2D TD 8D QD",
                "2D 3D 4H 5D 6D",
                "3D 5H 2D TC TD",
                "6D 7S 8D 9D TD"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            Assertions.assertEquals(defaultRank, HandEvaluator.hasStraightFlush(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldHaveFourOfAKind () {
        int rankValue = RankValue.FOUR_OF_A_KIND.numValue;
        int length = RankValue.FOUR_OF_A_KIND.length;

        List<String> inputList = Arrays.asList(
                "TC TH TD TS 2C",
                "3D TD 3H 3C 3S",
                "KD 5D KH KC KS",
                "8D 3H 8H 8C 8S",
                "2D 2S 2C 2H 3D"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            ArrayList<Integer> repeatedValues = HandEvaluator.getRepeatedValues(hand);
                            Assertions.assertEquals(rankValue * rankInterval + repeatedValues.get(length - 1),
                                    HandEvaluator.hasFourOfAKind(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldNotHaveFourOfAKind () {

        List<String> inputList = Arrays.asList(
                "2D 5S 3D 3H 3C",
                "3D 6D 3H TD 4D",
                "7D 7H 7C 6S 3D",
                "6D TS 6H 3D 6C",
                "2H 2D TD 2C 4D"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            Assertions.assertEquals(defaultRank, HandEvaluator.hasFourOfAKind(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldHaveFullHouse () {
        int rankValue = RankValue.FULL_HOUSE.numValue;
        int length = RankValue.FULL_HOUSE.length;

        List<String> inputList = Arrays.asList(
                "2D 3D 3H 2S 3C",
                "7H TD TS 7D 7S",
                "TD KS KD TC KC",
                "QS 3S QH 3C 3H",
                "4C 5D 4D 5C 5S"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            ArrayList<Integer> repeatedValues = HandEvaluator.getRepeatedValues(hand);
                            Assertions.assertEquals(rankValue * rankInterval + repeatedValues.get(length - 1),
                                    HandEvaluator.hasFullHouse(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldNotHaveFullHouse () {

        List<String> inputList = Arrays.asList(
                "2D 3C 3S 3D 5H",
                "3S TD 3H 2D 5C",
                "5D 2H TC 5H 2D",
                "4D 8S 4H TD 3C",
                "2D 3C 9S 7D 6C"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            Assertions.assertEquals(defaultRank, HandEvaluator.hasFullHouse(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldHaveFlush () {
        int rankValue = RankValue.FLUSH.numValue;

        List<String> inputList = Arrays.asList(
                "2D 7D 4D 8D TD",
                "2S 6S QS TS KS",
                "5D 9D JD 3D TD",
                "6C 4C 5C 3C 9C",
                "QH TH JH 4H 9H"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            hand.sort(new CardComparator());
                            Assertions.assertEquals(rankValue * rankInterval + hand.get(hand.size() - 1).faceValue,
                                    HandEvaluator.hasFlush(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldNotHaveFlush () {

        List<String> inputList = Arrays.asList(
                "2D 2H 5D TD 6D",
                "TD 3S 7D TS 9D",
                "2C 5C 6D 9C 6C",
                "2C 3C TH TS 5D",
                "7H 8H 5H 3D 4C"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            Assertions.assertEquals(defaultRank, HandEvaluator.hasFlush(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldHaveStraight () {
        int rankValue = RankValue.STRAIGHT.numValue;

        List<String> inputList = Arrays.asList(
                "2S 6H 3D 4C 5S",
                "TD 9C 6H 7S 8D",
                "TD JH QC KS 9D",
                "5C 9C 6D 8H 7S",
                "6S 5S 4D 7H 3C"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            hand.sort(new CardComparator());
                            Assertions.assertEquals(rankValue * rankInterval + hand.get(hand.size() - 1).faceValue,
                                    HandEvaluator.hasStraight(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldNotHaveStraight () {

        List<String> inputList = Arrays.asList(
                "5H 3C 6S 7S 8D",
                "JC 9H JS TD 8C",
                "7D 6C 5C 4D 2C",
                "9S TC 8D 4C 5H",
                "8D 8H TD 8C 8S"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            Assertions.assertEquals(defaultRank, HandEvaluator.hasStraight(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldHaveThreeOfAKind () {
        int rankValue = RankValue.THREE_OF_A_KIND.numValue;
        int length = RankValue.THREE_OF_A_KIND.length;

        List<String> inputList = Arrays.asList(
                "TD TH TS 3D 5D",
                "3D 5D 4D 3S 3C",
                "2D 2S TD 2C QC",
                "KD QS KS AD KH",
                "JC 6H JS 5S JH"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            ArrayList<Integer> repeatedValues = HandEvaluator.getRepeatedValues(hand);
                            Assertions.assertEquals(rankValue * rankInterval + repeatedValues.get(length - 1),
                                    HandEvaluator.hasThreeOfAKind(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldNotHaveThreeOfAKind () {

        List<String> inputList = Arrays.asList(
                "2C 3S 4H TD 5C",
                "3S 3H TC JD AC",
                "TD JD TC QD KD",
                "2D TC 2C 7H 8S",
                "8S 7C 5D 6H 5C"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            Assertions.assertEquals(defaultRank, HandEvaluator.hasThreeOfAKind(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldHaveTwoPairs () {
        int rankValue = RankValue.TWO_PAIR.numValue;
        int length = RankValue.TWO_PAIR.length;

        List<String> inputList = Arrays.asList(
                "2C TS 5D 5C 2D",
                "5S 7D 9S 7C 9C",
                "AH KS AD KC 5D",
                "6C 3D AD 6H 3S",
                "2C 2D 8C 5D 8S"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            ArrayList<Integer> repeatedValues = HandEvaluator.getRepeatedValues(hand);
                            Assertions.assertEquals(rankValue * rankInterval + repeatedValues.get(length - 1),
                                    HandEvaluator.hasTwoPairs(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldNotHaveTwoPairs () {

        List<String> inputList = Arrays.asList(
                "2D 4D 6H 8D TC",
                "3D 4C 5S 7D 9C",
                "3S 5C 7H 2H 4D",
                "TD AD QC 8D 9D",
                "6D 5C 6H TD 4C"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            Assertions.assertEquals(defaultRank, HandEvaluator.hasTwoPairs(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldHavePair () {
        int rankValue = RankValue.PAIR.numValue;
        int length = RankValue.PAIR.length;

        List<String> inputList = Arrays.asList(
                "2D TH AS 2H KC",
                "TD TH 3C 4D 5C",
                "5D 7C 3S 7D TH",
                "9S AD TS 9H KC",
                "2D 8H 3S AH 8C"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            ArrayList<Integer> repeatedValues = HandEvaluator.getRepeatedValues(hand);
                            Assertions.assertEquals(rankValue * rankInterval + repeatedValues.get(length - 1),
                                    HandEvaluator.hasPair(hand));
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldNotHavePair () {

        List<String> inputList = Arrays.asList(
                "3D 2H TS 6D 7C",
                "8D TH 4C KD AH",
                "4C 5D 6H TD 7C",
                "6D 7H 8C 2D 3S",
                "8S 9S 4C 3C 6C"
        );

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating hand: " + input,
                        () -> {
                            ArrayList<Card> hand = new ArrayList<>();
                            String[] splitInput = input.split(" ");
                            Arrays.stream(splitInput).forEach(c -> hand.add(new Card(c.charAt(0), c.charAt(1))));
                            Assertions.assertEquals(defaultRank, HandEvaluator.hasPair(hand));
                        }));
    }
}
