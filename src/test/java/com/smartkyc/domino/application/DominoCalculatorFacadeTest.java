package com.smartkyc.domino.application;

import com.smartkyc.domino.domain.CalculatedDominoSet;
import com.smartkyc.domino.domain.DominoSet;
import com.smartkyc.domino.domain.Tile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DominoCalculatorFacadeTest {

    @Autowired
    private DominoCalculatorFacade calculator;

    @Test
    void test() {
        DominoSet dominoSet = new DominoSet(new Tile[]{new Tile(1, 2), new Tile(2, 1), new Tile(3, 2)});
        CalculatedDominoSet calculatedDominoSet = calculator.calculateDominoSet(dominoSet);

        assertThat(calculatedDominoSet.getChainValue()).isEqualTo(4);
    }
}
