package com.smartkyc.domino.application.longestchaincalculator;

import com.smartkyc.domino.domain.Tile;

import java.util.Arrays;
import java.util.Iterator;

public class HighestValueChainCounter {

    public static int calculateHighestValueChain(Tile[] domino) {
        Iterator<Tile> dominoIterator = Arrays.asList(domino).iterator();
        Tile current = dominoIterator.next();
        int totalMax = 0;
        int max = 0;

        while (dominoIterator.hasNext()) {
            Tile next = dominoIterator.next();

            if (current.getRight() == next.getLeft()) {
                max += current.getRight();
            } else {
                if (max > totalMax) {
                    totalMax = max;
                    max = 0;
                }
            }
            current = next;
        }
        return Math.max(totalMax, max);
    }
}
