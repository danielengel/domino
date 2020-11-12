package com.smartkyc.domino.application.longestchaincalculator.bruteforce;

import com.smartkyc.domino.application.longestchaincalculator.HighestValueChainCounter;
import com.smartkyc.domino.domain.CalculatedDominoSet;
import com.smartkyc.domino.domain.DominoSet;
import com.smartkyc.domino.domain.Tile;

import java.util.TreeMap;

public class BruteForceCalculator {

    public CalculatedDominoSet calculateHighestValueChain(DominoSet inputSet) {
        if (inputSet.getTiles().length == 1) {
            return new CalculatedDominoSet(inputSet, 0);
        }

        TreeMap<Integer, Tile[]> results = new TreeMap<>();
        DominoPermutationGenerator.generateAllPermutations(inputSet.getTiles())
                .forEach(permutation -> {
                    int permutationHighestValueChain = HighestValueChainCounter.calculateHighestValueChain(permutation);
                    results.put(permutationHighestValueChain, permutation);
                });

        return new CalculatedDominoSet(new DominoSet(results.lastEntry().getValue()), results.lastKey());
    }
}
