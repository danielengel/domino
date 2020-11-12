package com.smartkyc.domino.application;

import com.smartkyc.domino.application.longestchaincalculator.bruteforce.BruteForceCalculator;
import com.smartkyc.domino.domain.CalculatedDominoSet;
import com.smartkyc.domino.domain.DominoSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DominoCalculatorFacade {

    public CalculatedDominoSet calculateDominoSet(DominoSet inputSet) {

        BruteForceCalculator bruteForceAlgorithm = new BruteForceCalculator();
        return bruteForceAlgorithm.calculateHighestValueChain(inputSet);
    }


}
