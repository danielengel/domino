package com.smartkyc.domino.application.longestchaincalculator.bruteforce;

import com.smartkyc.domino.domain.Tile;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DominoPermutationGenerator {

    static List<Tile[]> generateAllPermutations(Tile[] input) {
        Tile frozenStartingPoint = input[0];
        Tile[] tailToPermute = Arrays.copyOfRange(input, 1, input.length);
        return generateAllPossibleCombinationsOfIndexes(tailToPermute.length)
                .stream()
                .map(permutation -> permuteDomino(permutation, tailToPermute))
                .map(DominoPermutationGenerator::flipEveryPossibleTile)
                .flatMap(Collection::stream)
                .map(permuted -> addFirstElementWithFlip(frozenStartingPoint, permuted))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<Tile[]> flipEveryPossibleTile(Tile[] permutation) {
        return FlipsGenerator.generateAllPossibleFlips(permutation.length)
                .stream()
                .map(flipper -> flipDomino(flipper, permutation))
                .collect(Collectors.toList());
    }

    static Tile[] flipDomino(Boolean[] flippers, Tile[] domino) {
        Tile[] result = new Tile[domino.length];
        for (int i = 0; i < flippers.length; i++) {
            if (flippers[i]) {
                result[i] = domino[i].flipped();
            } else {
                result[i] = domino[i];
            }
        }
        return result;
    }

    private static List<int[]> generateAllPossibleCombinationsOfIndexes(int length) {
        List<int[]> allCombinations = new ArrayList<>();

        int[] elements = IntStream.range(0, length).toArray();
        int[] indexes = new int[elements.length];

        allCombinations.add(Arrays.copyOf(elements, elements.length));

        int i = 0;
        while (i < elements.length) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
                allCombinations.add(Arrays.copyOf(elements, elements.length));
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }
        return allCombinations;
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static List<Tile[]> addFirstElementWithFlip(Tile first, Tile[] tail) {
        Tile[] newArr = new Tile[tail.length + 1];
        newArr[0] = first;
        Tile[] newArrFlipped = new Tile[tail.length + 1];
        newArrFlipped[0] = first.flipped();

        for (int i = 0; i < tail.length; i++) {
            newArr[i + 1] = tail[i];
            newArrFlipped[i + 1] = tail[i];
        }
        return List.of(newArr, newArrFlipped);
    }

    private static Tile[] permuteDomino(int[] permutation, Tile[] input) {
        List<Tile> output = new LinkedList<>();
        for (int j : permutation) {
            output.add(input[j]);
        }
        return output.toArray(new Tile[0]);
    }
}
