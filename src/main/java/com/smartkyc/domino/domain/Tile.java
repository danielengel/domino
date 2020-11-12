package com.smartkyc.domino.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
public class Tile {

    @Range(min = 0, max = 10)
    Integer left;
    @Range(min = 0, max = 10)
    int right;

    public static Tile of(int left, int right) {
        return new Tile(left, right);
    }

    public Tile flipped() {
        return new Tile(right, left);
    }
}
