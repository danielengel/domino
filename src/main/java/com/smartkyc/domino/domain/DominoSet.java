package com.smartkyc.domino.domain;

import com.smartkyc.domino.infrastruture.rest.validation.ProperDominoTiles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DominoSet {

    @Valid
    @NotEmpty
    @ProperDominoTiles
    Tile[] tiles;
}
