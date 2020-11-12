package com.smartkyc.domino.infrastruture.rest;

import com.smartkyc.domino.application.DominoCalculatorFacade;
import com.smartkyc.domino.domain.CalculatedDominoSet;
import com.smartkyc.domino.domain.DominoSet;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/api")
@RequiredArgsConstructor
@Validated
public class DominoResource {

    private final DominoCalculatorFacade facade;

    @PostMapping("/highest-value-chain")
    CalculatedDominoSet calculateMaxChainFor(@Valid @RequestBody DominoSet dominoSet) {
        return facade.calculateDominoSet(dominoSet);
    }
}
