package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainTest {
    @TestFactory
    Stream<DynamicTest> playerOneShouldWin() {
        byte playerCount = 2;
        byte handSize = 5;
        PokerGame poker = new PokerGame(playerCount, handSize);

        List<String> inputList = Arrays.asList(
                "QS 3C 5H QH 8S 7H AS JD 6S 7S",
                "QS QC QH QH 8S 7H AS JD 6S 7S",
                "TH 8H 7S QS 7D 5S 6C 9S 8D 2H",
                "QC 2C QS AS 8C 7C 6D 9D 3H 6C"
        );

        List<Integer> outputList = Arrays.asList(1, 2, 3, 4);

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating round: " + input,
                        () -> {
                            int id = inputList.indexOf(input);
                            poker.playRound(input);
                            Assertions.assertEquals((int)outputList.get(id), poker.players.get(0).victories);
                }));
    }
//
    @TestFactory
    Stream<DynamicTest> playerTwoShouldWin() {
        byte playerCount = 2;
        byte handSize = 5;
        PokerGame poker = new PokerGame(playerCount, handSize);

        List<String> inputList = Arrays.asList(
                "7H AS JD 6S 7S QS 3C 5H QH 8S",
                "7H AS JD 6S 7S QS QC QH QH 8S",
                "5S 6C 9S 8D 2H TH 8H 7S QS 7D",
                "7C 6D 9D 3H 6C QC 2C QS AS 8C"
        );

        List<Integer> outputList = Arrays.asList(1, 2, 3, 4);

        return inputList.stream()
                .map(input -> DynamicTest.dynamicTest("Evaluating round: " + input,
                        () -> {
                                int id = inputList.indexOf(input);
                                poker.playRound(input);
                                Assertions.assertEquals((int)outputList.get(id), poker.players.get(1).victories);
                        }));
    }
}
