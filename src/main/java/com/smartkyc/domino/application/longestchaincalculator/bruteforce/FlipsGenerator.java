package com.smartkyc.domino.application.longestchaincalculator.bruteforce;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class FlipsGenerator {


    static List<Boolean[]> generateAllPossibleFlips(int n) {
        return IntStream.rangeClosed(0, (int) (Math.pow(2, n) - 1))
                .boxed()
                .map(Integer::toBinaryString)
                .map(binaryInt -> StringUtils.leftPad(binaryInt, n, '0'))
                .map(binaryInt -> binaryInt.split(""))
                .map(binaryArr -> Stream.of(binaryArr)
                        .map(binaryEl -> binaryEl.equals("1"))
                        .toArray(Boolean[]::new))
                .collect(Collectors.toList());
    }
}
