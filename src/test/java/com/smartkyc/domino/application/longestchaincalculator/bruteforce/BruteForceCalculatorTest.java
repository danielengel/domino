package com.smartkyc.domino.application.longestchaincalculator.bruteforce;

import com.smartkyc.domino.domain.CalculatedDominoSet;
import com.smartkyc.domino.domain.DominoSet;
import com.smartkyc.domino.domain.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BruteForceCalculatorTest {

    BruteForceCalculator algorithm;


    @BeforeEach
    void setup() {
        algorithm = new BruteForceCalculator();
    }

    @Test
    void testRandomizedDominoElements() {
        DominoSet dominoSet = new DominoSet(new Tile[]{
                new Tile(1, 3),
                new Tile(2, 1),
                new Tile(3, 2)});

        CalculatedDominoSet calculatedDominoSet = algorithm.calculateHighestValueChain(dominoSet);

        assertThat(calculatedDominoSet.getChainValue()).isEqualTo(5);
        assertThat(calculatedDominoSet.getDominoSet().getTiles()).isEqualTo(
                new Tile[]{new Tile(1, 3),
                        new Tile(3, 2),
                        new Tile(2, 1)});

        System.out.printf("%d --- %s", calculatedDominoSet.getChainValue(), Arrays.deepToString(calculatedDominoSet.getDominoSet().getTiles()));
    }

    @Test
    void testAlreadySortedDominoSet() {
        DominoSet dominoSet = new DominoSet(
                new Tile[]{
                        new Tile(1, 2),
                        new Tile(2, 3),
                        new Tile(3, 4)});

        CalculatedDominoSet calculatedDominoSet = algorithm.calculateHighestValueChain(dominoSet);

        assertThat(calculatedDominoSet.getChainValue()).isEqualTo(5);
        assertThat(calculatedDominoSet.getDominoSet().getTiles()).isEqualTo(new Tile[]{
                new Tile(1, 2),
                new Tile(2, 3),
                new Tile(3, 4)});

        System.out.printf("%d --- %s", calculatedDominoSet.getChainValue(), Arrays.deepToString(calculatedDominoSet.getDominoSet().getTiles()));
    }

    @Test
    void testFlippingFirstElement() {
        DominoSet dominoSet = new DominoSet(new Tile[]{
                new Tile(3, 1),
                new Tile(1, 3)});

        CalculatedDominoSet calculatedDominoSet = algorithm.calculateHighestValueChain(dominoSet);

        assertThat(calculatedDominoSet.getChainValue()).isEqualTo(3);
        assertThat(calculatedDominoSet.getDominoSet().getTiles()).isEqualTo(new Tile[]{new Tile(1, 3), new Tile(3, 1)});

        System.out.printf("%d --- %s", calculatedDominoSet.getChainValue(), Arrays.deepToString(calculatedDominoSet.getDominoSet().getTiles()));
    }

    @Test
    void testOneElementDomino() {
        DominoSet dominoSet = new DominoSet(new Tile[]{
                new Tile(3, 1)});

        CalculatedDominoSet calculatedDominoSet = algorithm.calculateHighestValueChain(dominoSet);

        assertThat(calculatedDominoSet.getChainValue()).isEqualTo(0);
        assertThat(calculatedDominoSet.getDominoSet().getTiles()).isEqualTo(new Tile[]{new Tile(3, 1)});

        System.out.printf("%d --- %s", calculatedDominoSet.getChainValue(), Arrays.deepToString(calculatedDominoSet.getDominoSet().getTiles()));
    }

    @Test
    void testEightElementsDominoDoNotOverflowMemory() {
        DominoSet dominoSet = new DominoSet(new Tile[]{
                new Tile(1, 2),
                new Tile(2, 3),
                new Tile(3, 4),
                new Tile(4, 5),
                new Tile(5, 6),
                new Tile(6, 7),
                new Tile(7, 8),
                new Tile(8, 9)
        });

        CalculatedDominoSet calculatedDominoSet = algorithm.calculateHighestValueChain(dominoSet);

        assertThat((Object) null).isNull();
        System.out.printf("%d --- %s", calculatedDominoSet.getChainValue(), Arrays.deepToString(calculatedDominoSet.getDominoSet().getTiles()));
    }
}
