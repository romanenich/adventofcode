package com.romanenich.adventofcode2018.day7;

import java.util.List;
import java.util.stream.Collectors;

public class Solution7 {

    private final static String FILE_PATH = "com.romanenich/adventofcode2018/day7/input7.txt";

    public static void main(String[] args) {
        DataLoader7 dataLoader7 = new DataLoader7(FILE_PATH);
        List<Leg> legs = dataLoader7.loadData();
        TreeInfo treeInfo = new TreeInfo(legs);

        List<Node> steps = treeInfo.getSteps(treeInfo.getNodes());
        System.out.println("1. step order is " + steps.stream().map(node -> node.getName()).collect(Collectors.joining("")));
    }
}
