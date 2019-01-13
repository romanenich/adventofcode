package com.romanenich.adventofcode2018.day7;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Leg {
    private final Node first;
    private final Node second;
}
