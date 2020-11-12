package com.smartkyc.domino.infrastruture.rest.validation;

import com.smartkyc.domino.domain.Tile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.stream.Stream;

class ProperDominoTilesValidator implements ConstraintValidator<ProperDominoTiles, Tile[]> {


    public void initialize(ProperDominoTiles constraint) {
    }

    public boolean isValid(Tile[] tiles, ConstraintValidatorContext context) {
        return Objects.nonNull(tiles)
                && Stream.of(tiles)
                .noneMatch(tile -> tile.getLeft() == tile.getRight());
    }

}