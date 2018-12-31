package com.romanenich.adventofcode2018.day5;

import java.util.List;

public class Solution5 {

    private final static String FILE_PATH = "com.romanenich/adventofcode2018/day5/input5.txt";

    public static void main(String[] args) {
        DataLoader5 dataLoader5 = new DataLoader5(FILE_PATH);
        List<Data5> data5s = dataLoader5.loadData();

        PolymerInfo polymerInfo = new PolymerInfo(data5s.get(0).getValue());
        String remainedPolymer = polymerInfo.getRemainedPolymer();
        System.out.println("1. Remained units = " + remainedPolymer.length());
        System.out.println("2. Min length     = " + polymerInfo.getRemainAdjustedPolymer(remainedPolymer).length());

    }
}
