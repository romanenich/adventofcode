package com.romanenich.adventofcode2018.day7;

import com.romanenich.AbstractDataLoader;

public class DataLoader7 extends AbstractDataLoader<Leg> {

    public DataLoader7(String filePath) {
        super(filePath);
    }

    @Override
    protected Leg convert(String line) {

        String[] s = line.split(" ");

        Node first = new Node(s[1]);
        Node second = new Node(s[7]);

        return new Leg(first, second);
    }
}
