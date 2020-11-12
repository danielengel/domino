package com.smartkyc.domino.application.longestchaincalculator.bruteforce;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FlipsGeneratorTest {

    @Test
    void testGeneratingThreeElementsArray() {
        List<Boolean[]> generatedFlips = FlipsGenerator.generateAllPossibleFlips(3);

        assertThat(generatedFlips.size()).isEqualTo(8);

        assertThat(generatedFlips.get(0)).isEqualTo(new Boolean[]{false, false, false});
        assertThat(generatedFlips.get(7)).isEqualTo(new Boolean[]{true, true, true});
    }

    @Test
    void testGeneratingOneElementsArray() {
        List<Boolean[]> generatedFlips = FlipsGenerator.generateAllPossibleFlips(1);

        assertThat(generatedFlips.size()).isEqualTo(2);

        assertThat(generatedFlips.get(0)).isEqualTo(new Boolean[]{false});
        assertThat(generatedFlips.get(1)).isEqualTo(new Boolean[]{true});
    }
}
