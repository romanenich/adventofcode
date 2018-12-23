package com.romanenich.adventofcode2018.day3;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Roman on 23.12.2018.
 */
@Data
@Builder
class Data3 {
    private Integer id;
    private Integer shiftLeft;
    private Integer shiftTop;
    private Integer width;
    private Integer tall;
}
