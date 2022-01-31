package org.example;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandEvaluatorTest {

    @Test
    public void shouldHaveRoyalFlush () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('Q','D'));
                add(new Card('J','D'));
                add(new Card('K','D'));
                add(new Card('A','D'));
            }
        };
        assertEquals(200, HandEvaluator.hasRoyalFlush(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('A','S'));
                add(new Card('T','S'));
                add(new Card('Q','S'));
                add(new Card('J','S'));
                add(new Card('K','S'));
            }
        };
        assertEquals(200, HandEvaluator.hasRoyalFlush(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('Q','H'));
                add(new Card('A','H'));
                add(new Card('K','H'));
                add(new Card('J','H'));
                add(new Card('T','H'));
            }
        };
        assertEquals(200, HandEvaluator.hasRoyalFlush(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('T','C'));
                add(new Card('K','C'));
                add(new Card('Q','C'));
                add(new Card('J','C'));
                add(new Card('A','C'));
            }
        };
        assertEquals(200, HandEvaluator.hasRoyalFlush(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('A','D'));
                add(new Card('K','D'));
                add(new Card('Q','D'));
                add(new Card('J','D'));
                add(new Card('T','D'));
            }
        };
        assertEquals(200, HandEvaluator.hasRoyalFlush(hand5));
    }

    @Test
    public void shouldNotHaveRoyalFlush () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('T','D'));
                add(new Card('T','D'));
                add(new Card('T','D'));
                add(new Card('T','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasRoyalFlush(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('A','D'));
                add(new Card('Q','D'));
                add(new Card('J','D'));
                add(new Card('K','D'));
                add(new Card('T','H'));
            }
        };
        assertEquals(1, HandEvaluator.hasRoyalFlush(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('A','D'));
                add(new Card('A','D'));
                add(new Card('K','D'));
                add(new Card('Q','D'));
                add(new Card('J','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasRoyalFlush(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('A','D'));
                add(new Card('Q','H'));
                add(new Card('K','S'));
                add(new Card('J','D'));
                add(new Card('T','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasRoyalFlush(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('9','D'));
                add(new Card('J','D'));
                add(new Card('Q','D'));
                add(new Card('K','D'));
                add(new Card('A','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasRoyalFlush(hand5));
    }

    @Test
    public void shouldHaveStraightFlush () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('3','D'));
                add(new Card('4','D'));
                add(new Card('5','D'));
                add(new Card('6','D'));
            }
        };
        assertEquals(186, HandEvaluator.hasStraightFlush(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('4','S'));
                add(new Card('5','S'));
                add(new Card('6','S'));
                add(new Card('7','S'));
                add(new Card('8','S'));
            }
        };
        assertEquals(188, HandEvaluator.hasStraightFlush(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('7','C'));
                add(new Card('8','C'));
                add(new Card('9','C'));
                add(new Card('T','C'));
                add(new Card('J','C'));
            }
        };
        assertEquals(191, HandEvaluator.hasStraightFlush(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('9','H'));
                add(new Card('T','H'));
                add(new Card('J','H'));
                add(new Card('Q','H'));
                add(new Card('K','H'));
            }
        };
        assertEquals(193, HandEvaluator.hasStraightFlush(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('5','D'));
                add(new Card('4','D'));
                add(new Card('2','D'));
                add(new Card('6','D'));
                add(new Card('3','D'));
            }
        };
        assertEquals(186, HandEvaluator.hasStraightFlush(hand5));
    }

    @Test
    public void shouldNotHaveStraightFlush () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('2','D'));
                add(new Card('3','D'));
                add(new Card('4','D'));
                add(new Card('5','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraightFlush(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('5','D'));
                add(new Card('2','D'));
                add(new Card('T','D'));
                add(new Card('8','D'));
                add(new Card('Q','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraightFlush(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('3','D'));
                add(new Card('4','H'));
                add(new Card('5','D'));
                add(new Card('6','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraightFlush(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('3','D'));
                add(new Card('5','H'));
                add(new Card('2','D'));
                add(new Card('T','C'));
                add(new Card('T','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraightFlush(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('6','D'));
                add(new Card('7','S'));
                add(new Card('8','D'));
                add(new Card('9','D'));
                add(new Card('T','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraightFlush(hand5));
    }

    @Test
    public void shouldHaveFourOfAKind () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('T','C'));
                add(new Card('T','H'));
                add(new Card('T','D'));
                add(new Card('T','S'));
                add(new Card('2','C'));
            }
        };
        assertEquals(170, HandEvaluator.hasFourOfAKind(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('3','D'));
                add(new Card('T','D'));
                add(new Card('3','H'));
                add(new Card('3','C'));
                add(new Card('3','S'));
            }
        };
        assertEquals(163, HandEvaluator.hasFourOfAKind(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('K','D'));
                add(new Card('5','D'));
                add(new Card('K','H'));
                add(new Card('K','C'));
                add(new Card('K','S'));
            }
        };
        assertEquals(173, HandEvaluator.hasFourOfAKind(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('8','D'));
                add(new Card('3','H'));
                add(new Card('8','H'));
                add(new Card('8','C'));
                add(new Card('8','S'));
            }
        };
        assertEquals(168, HandEvaluator.hasFourOfAKind(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('2','S'));
                add(new Card('2','C'));
                add(new Card('2','H'));
                add(new Card('3','D'));
            }
        };
        assertEquals(162, HandEvaluator.hasFourOfAKind(hand5));
    }

    @Test
    public void shouldNotHaveFourOfAKind () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('5','S'));
                add(new Card('3','D'));
                add(new Card('3','H'));
                add(new Card('3','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasFourOfAKind(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('3','D'));
                add(new Card('6','D'));
                add(new Card('3','H'));
                add(new Card('T','D'));
                add(new Card('4','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasFourOfAKind(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('7','D'));
                add(new Card('7','H'));
                add(new Card('7','C'));
                add(new Card('6','S'));
                add(new Card('3','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasFourOfAKind(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('6','D'));
                add(new Card('T','S'));
                add(new Card('6','H'));
                add(new Card('3','D'));
                add(new Card('6','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasFourOfAKind(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('2','H'));
                add(new Card('2','D'));
                add(new Card('T','D'));
                add(new Card('2','C'));
                add(new Card('4','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasFourOfAKind(hand5));
    }

    @Test
    public void shouldHaveFullHouse () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('3','D'));
                add(new Card('3','H'));
                add(new Card('2','S'));
                add(new Card('3','C'));
            }
        };
        assertEquals(143, HandEvaluator.hasFullHouse(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('7','H'));
                add(new Card('T','D'));
                add(new Card('T','S'));
                add(new Card('7','D'));
                add(new Card('7','S'));
            }
        };
        assertEquals(150, HandEvaluator.hasFullHouse(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('K','S'));
                add(new Card('K','D'));
                add(new Card('T','C'));
                add(new Card('K','C'));
            }
        };
        assertEquals(153, HandEvaluator.hasFullHouse(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('Q','S'));
                add(new Card('3','S'));
                add(new Card('Q','H'));
                add(new Card('3','C'));
                add(new Card('3','H'));
            }
        };
        assertEquals(152, HandEvaluator.hasFullHouse(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('4','C'));
                add(new Card('5','D'));
                add(new Card('4','D'));
                add(new Card('5','C'));
                add(new Card('5','S'));
            }
        };
        assertEquals(145, HandEvaluator.hasFullHouse(hand5));
    }

    @Test
    public void shouldNotHaveFullHouse () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('3','C'));
                add(new Card('3','S'));
                add(new Card('3','D'));
                add(new Card('5','H'));
            }
        };
        assertEquals(1, HandEvaluator.hasFullHouse(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('3','S'));
                add(new Card('T','D'));
                add(new Card('3','H'));
                add(new Card('2','D'));
                add(new Card('5','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasFullHouse(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('5','D'));
                add(new Card('2','H'));
                add(new Card('T','C'));
                add(new Card('5','H'));
                add(new Card('2','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasFullHouse(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('4','D'));
                add(new Card('8','S'));
                add(new Card('4','H'));
                add(new Card('T','D'));
                add(new Card('3','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasFullHouse(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('3','C'));
                add(new Card('9','S'));
                add(new Card('7','D'));
                add(new Card('6','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasFullHouse(hand5));
    }

    @Test
    public void shouldHaveFlush () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('7','D'));
                add(new Card('4','D'));
                add(new Card('8','D'));
                add(new Card('T','D'));
            }
        };
        assertEquals(130, HandEvaluator.hasFlush(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('2','S'));
                add(new Card('6','S'));
                add(new Card('Q','S'));
                add(new Card('T','S'));
                add(new Card('K','S'));
            }
        };
        assertEquals(133, HandEvaluator.hasFlush(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('5','D'));
                add(new Card('9','D'));
                add(new Card('J','D'));
                add(new Card('3','D'));
                add(new Card('T','D'));
            }
        };
        assertEquals(131, HandEvaluator.hasFlush(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('6','C'));
                add(new Card('4','C'));
                add(new Card('5','C'));
                add(new Card('3','C'));
                add(new Card('9','C'));
            }
        };
        assertEquals(129, HandEvaluator.hasFlush(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('Q','H'));
                add(new Card('T','H'));
                add(new Card('J','H'));
                add(new Card('5','H'));
                add(new Card('9','H'));
            }
        };
        assertEquals(132, HandEvaluator.hasFlush(hand5));
    }

    @Test
    public void shouldNotHaveFlush () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('2','H'));
                add(new Card('5','D'));
                add(new Card('T','D'));
                add(new Card('6','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasFlush(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('3','S'));
                add(new Card('7','D'));
                add(new Card('T','S'));
                add(new Card('9','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasFlush(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('2','C'));
                add(new Card('5','C'));
                add(new Card('6','D'));
                add(new Card('9','C'));
                add(new Card('6','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasFlush(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('2','C'));
                add(new Card('3','C'));
                add(new Card('T','H'));
                add(new Card('T','S'));
                add(new Card('5','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasFlush(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('7','H'));
                add(new Card('8','H'));
                add(new Card('5','H'));
                add(new Card('3','D'));
                add(new Card('4','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasFlush(hand5));
    }

    @Test
    public void shouldHaveStraight () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','S'));
                add(new Card('6','H'));
                add(new Card('3','D'));
                add(new Card('4','C'));
                add(new Card('5','S'));
            }
        };
        assertEquals(106, HandEvaluator.hasStraight(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('9','C'));
                add(new Card('6','H'));
                add(new Card('7','S'));
                add(new Card('8','D'));
            }
        };
        assertEquals(110, HandEvaluator.hasStraight(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('J','H'));
                add(new Card('Q','C'));
                add(new Card('K','S'));
                add(new Card('9','D'));
            }
        };
        assertEquals(113, HandEvaluator.hasStraight(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('5','C'));
                add(new Card('9','C'));
                add(new Card('6','D'));
                add(new Card('8','H'));
                add(new Card('7','S'));
            }
        };
        assertEquals(109, HandEvaluator.hasStraight(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('6','S'));
                add(new Card('5','S'));
                add(new Card('4','D'));
                add(new Card('7','H'));
                add(new Card('3','C'));
            }
        };
        assertEquals(107, HandEvaluator.hasStraight(hand5));
    }

    @Test
    public void shouldNotHaveStraight () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('5','H'));
                add(new Card('3','C'));
                add(new Card('6','S'));
                add(new Card('7','S'));
                add(new Card('8','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraight(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('J','C'));
                add(new Card('9','H'));
                add(new Card('J','C'));
                add(new Card('T','D'));
                add(new Card('8','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraight(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('7','D'));
                add(new Card('6','C'));
                add(new Card('5','C'));
                add(new Card('4','D'));
                add(new Card('2','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraight(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('9','S'));
                add(new Card('T','C'));
                add(new Card('8','D'));
                add(new Card('4','C'));
                add(new Card('5','H'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraight(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('8','D'));
                add(new Card('8','H'));
                add(new Card('T','D'));
                add(new Card('8','C'));
                add(new Card('8','S'));
            }
        };
        assertEquals(1, HandEvaluator.hasStraight(hand5));
    }

    @Test
    public void shouldHaveThreeOfAKind () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('T','H'));
                add(new Card('T','S'));
                add(new Card('3','D'));
                add(new Card('5','D'));
            }
        };
        assertEquals(90, HandEvaluator.hasThreeOfAKind(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('3','D'));
                add(new Card('5','D'));
                add(new Card('4','D'));
                add(new Card('3','S'));
                add(new Card('3','C'));
            }
        };
        assertEquals(83, HandEvaluator.hasThreeOfAKind(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('2','S'));
                add(new Card('T','D'));
                add(new Card('2','C'));
                add(new Card('Q','C'));
            }
        };
        assertEquals(82, HandEvaluator.hasThreeOfAKind(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('K','D'));
                add(new Card('Q','S'));
                add(new Card('K','S'));
                add(new Card('A','D'));
                add(new Card('K','H'));
            }
        };
        assertEquals(93, HandEvaluator.hasThreeOfAKind(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('J','C'));
                add(new Card('6','H'));
                add(new Card('J','S'));
                add(new Card('5','S'));
                add(new Card('J','H'));
            }
        };
        assertEquals(91, HandEvaluator.hasThreeOfAKind(hand5));
    }

    @Test
    public void shouldNotHaveThreeOfAKind () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','C'));
                add(new Card('3','S'));
                add(new Card('4','H'));
                add(new Card('T','D'));
                add(new Card('5','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasThreeOfAKind(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('3','S'));
                add(new Card('3','H'));
                add(new Card('T','C'));
                add(new Card('J','D'));
                add(new Card('A','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasThreeOfAKind(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('J','D'));
                add(new Card('T','C'));
                add(new Card('Q','D'));
                add(new Card('K','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasThreeOfAKind(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('T','C'));
                add(new Card('2','C'));
                add(new Card('7','H'));
                add(new Card('8','S'));
            }
        };
        assertEquals(1, HandEvaluator.hasThreeOfAKind(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('8','S'));
                add(new Card('7','C'));
                add(new Card('5','D'));
                add(new Card('6','H'));
                add(new Card('5','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasThreeOfAKind(hand5));
    }

    @Test
    public void shouldHaveTwoPairs () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','C'));
                add(new Card('T','S'));
                add(new Card('5','D'));
                add(new Card('5','C'));
                add(new Card('2','D'));
            }
        };
        assertEquals(65, HandEvaluator.hasTwoPairs(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('5','S'));
                add(new Card('7','D'));
                add(new Card('9','S'));
                add(new Card('7','C'));
                add(new Card('9','C'));
            }
        };
        assertEquals(69, HandEvaluator.hasTwoPairs(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('A','H'));
                add(new Card('K','S'));
                add(new Card('A','D'));
                add(new Card('K','C'));
                add(new Card('5','D'));
            }
        };
        assertEquals(74, HandEvaluator.hasTwoPairs(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('6','C'));
                add(new Card('3','D'));
                add(new Card('A','D'));
                add(new Card('6','H'));
                add(new Card('3','S'));
            }
        };
        assertEquals(66, HandEvaluator.hasTwoPairs(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('2','C'));
                add(new Card('2','D'));
                add(new Card('8','C'));
                add(new Card('5','D'));
                add(new Card('8','S'));
            }
        };
        assertEquals(68, HandEvaluator.hasTwoPairs(hand5));
    }

    @Test
    public void shouldNotHaveTwoPairs () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('4','D'));
                add(new Card('6','H'));
                add(new Card('8','D'));
                add(new Card('T','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasTwoPairs(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('3','D'));
                add(new Card('4','C'));
                add(new Card('5','S'));
                add(new Card('7','D'));
                add(new Card('9','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasTwoPairs(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('3','S'));
                add(new Card('5','C'));
                add(new Card('7','H'));
                add(new Card('2','H'));
                add(new Card('4','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasTwoPairs(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('A','D'));
                add(new Card('Q','C'));
                add(new Card('8','D'));
                add(new Card('9','D'));
            }
        };
        assertEquals(1, HandEvaluator.hasTwoPairs(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('6','D'));
                add(new Card('5','C'));
                add(new Card('6','H'));
                add(new Card('T','D'));
                add(new Card('4','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasTwoPairs(hand5));
    }

    @Test
    public void shouldHavePair () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('T','H'));
                add(new Card('A','S'));
                add(new Card('2','H'));
                add(new Card('K','C'));
            }
        };
        assertEquals(42, HandEvaluator.hasPair(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('T','D'));
                add(new Card('T','H'));
                add(new Card('3','C'));
                add(new Card('4','D'));
                add(new Card('5','C'));
            }
        };
        assertEquals(50, HandEvaluator.hasPair(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('5','D'));
                add(new Card('7','C'));
                add(new Card('3','S'));
                add(new Card('7','D'));
                add(new Card('T','H'));
            }
        };
        assertEquals(47, HandEvaluator.hasPair(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('9','S'));
                add(new Card('A','D'));
                add(new Card('T','S'));
                add(new Card('9','H'));
                add(new Card('K','C'));
            }
        };
        assertEquals(49, HandEvaluator.hasPair(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('2','D'));
                add(new Card('8','H'));
                add(new Card('3','S'));
                add(new Card('A','H'));
                add(new Card('8','C'));
            }
        };
        assertEquals(48, HandEvaluator.hasPair(hand5));
    }

    @Test
    public void shouldNotHavePair () {

        ArrayList<Card> hand1 = new ArrayList<>() {
            {
                add(new Card('3','D'));
                add(new Card('2','H'));
                add(new Card('T','S'));
                add(new Card('6','D'));
                add(new Card('7','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasPair(hand1));

        ArrayList<Card> hand2 = new ArrayList<>() {
            {
                add(new Card('8','D'));
                add(new Card('T','H'));
                add(new Card('4','C'));
                add(new Card('K','D'));
                add(new Card('A','H'));
            }
        };
        assertEquals(1, HandEvaluator.hasPair(hand2));

        ArrayList<Card> hand3 = new ArrayList<>() {
            {
                add(new Card('4','C'));
                add(new Card('5','D'));
                add(new Card('6','H'));
                add(new Card('T','D'));
                add(new Card('7','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasPair(hand3));

        ArrayList<Card> hand4 = new ArrayList<>() {
            {
                add(new Card('6','D'));
                add(new Card('7','H'));
                add(new Card('8','C'));
                add(new Card('2','D'));
                add(new Card('3','S'));
            }
        };
        assertEquals(1, HandEvaluator.hasPair(hand4));

        ArrayList<Card> hand5 = new ArrayList<>() {
            {
                add(new Card('8','S'));
                add(new Card('9','S'));
                add(new Card('4','C'));
                add(new Card('3','C'));
                add(new Card('6','C'));
            }
        };
        assertEquals(1, HandEvaluator.hasPair(hand5));
    }
}
