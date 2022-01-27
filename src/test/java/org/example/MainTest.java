package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void playerOneShouldWin() throws InvalidGameString {
        byte playerCount = 2;
        byte handSize = 5;
        PokerGame poker = new PokerGame(playerCount, handSize);
        poker.playRound("QS 3C 5H QH 8S 7H AS JD 6S 7S");
        assertEquals(1, poker.players.get(0).victories);
        poker.playRound("QS QC QH QH 8S 7H AS JD 6S 7S");
        assertEquals(2, poker.players.get(0).victories);
        poker.playRound("TH 8H 7S QS 7D 5S 6C 9S 8D 2H");
        assertEquals(3, poker.players.get(0).victories);
        poker.playRound("QC 2C QS AS 8C 7C 6D 9D 3H 6C");
        assertEquals(4, poker.players.get(0).victories);
    }
//
    @Test
    public void playerTwoShouldWin() throws InvalidGameString {
        byte playerCount = 2;
        byte handSize = 5;
        PokerGame poker = new PokerGame(playerCount, handSize);
        poker.playRound("7H AS JD 6S 7S QS 3C 5H QH 8S");
        assertEquals(1, poker.players.get(1).victories);
        poker.playRound("7H AS JD 6S 7S QS QC QH QH 8S");
        assertEquals(2, poker.players.get(1).victories);
        poker.playRound("5S 6C 9S 8D 2H TH 8H 7S QS 7D");
        assertEquals(3, poker.players.get(1).victories);
        poker.playRound("7C 6D 9D 3H 6C QC 2C QS AS 8C");
        assertEquals(4, poker.players.get(1).victories);
    }

//    @Test
//    public void shouldThrowError() {
//        byte playerCount = 2;
//        byte handSize = 5;
//        PokerGame poker = new PokerGame(playerCount, handSize);
//        InvalidGameString thrown = Assert.assertThrows(InvalidGameString.class, poker.playRound("assdfsdfsdf"));
//        Assert.ass(poker.playRound("assdfsdfsdf"));
//
//    }
}
