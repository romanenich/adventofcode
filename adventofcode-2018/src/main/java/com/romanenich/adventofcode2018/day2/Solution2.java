package com.romanenich.adventofcode2018.day2;

import java.util.List;

public class Solution2 {

    private final static String FILE_PATH = "com/romanenich/adventofcode2018/day2/input2.txt";

    public static void main(String[] args) {
        List<Data2> inputData = new DataLoader2(FILE_PATH).loadData();
        System.out.println("checksum=" + countCheckSum(inputData));

        DataComparator2 comparator = new DataComparator2();
        inputData.sort(comparator);

        System.out.println("str1:  " + comparator.getStr1());
        System.out.println("str2:  " + comparator.getStr2());
        System.out.println("index: " + comparator.getPos());
        System.out.println("root:  " + comparator.getRoot());
    }

    private static int countCheckSum(List<Data2> inputData) {
        int twice = 0;
        int triple = 0;

        for (Data2 data2 : inputData) {
            int[] data = new int[128];
            int curTwice = 0;
            int curTriple = 0;

            for (int i = 0; i < data2.getValue().length(); i++) {
                int count = data[data2.getValue().charAt(i)] + 1;
                data[data2.getValue().charAt(i)] = count;
                if (count == 2) {
                    curTwice += 1;
                } else if (count == 3) {
                    curTwice -= 1;
                    curTriple += 1;
                } else if (count > 3){
                    curTriple -=1;
                }
            }

            if (curTwice > 0) {
                twice++;
            }

            if (curTriple > 0) {
                triple++;
            }
        }

        return twice * triple;
    }

}
