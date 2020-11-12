package com.smartkyc.domino.application.longestchaincalculator;

import com.smartkyc.domino.domain.Tile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HighestValueChainCounterTest {

    @Test
    void testCalculationEightElements() {
        Tile[] dominoTiles = {
                new Tile(1, 2),
                new Tile(2, 3),
                new Tile(3, 4),
                new Tile(4, 5),
                new Tile(5, 6),
                new Tile(6, 7),
                new Tile(7, 8),
                new Tile(8, 9)
        };

        int valueChain = HighestValueChainCounter.calculateHighestValueChain(dominoTiles);

        assertThat(valueChain).isEqualTo(35);
    }


    @Test
    void testCalculationOneElement() {
        Tile[] dominoTiles = {
                new Tile(1, 2)
        };

        int valueChain = HighestValueChainCounter.calculateHighestValueChain(dominoTiles);

        assertThat(valueChain).isEqualTo(0);
    }

}
