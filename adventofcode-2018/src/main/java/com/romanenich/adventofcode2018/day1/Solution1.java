package com.romanenich.adventofcode2018.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 {

    private final static String FILE_PATH = "com/romanenich/adventofcode2018/day1/input1.txt";

    public static void main(String[] args) {
        List<Data1> data = new DataLoader1(FILE_PATH).loadData();
        System.out.println("Resulting frequency is " + getResult(data).sum);
        System.out.println("The first frequency reached twice is " + findFirstFrequencyReachedTwice(getResult(data).numbers));
    }

    private static int findFirstFrequencyReachedTwice(List<Integer> numbers) {
        Set<Integer> checks = new TreeSet<>();
        int size = numbers.size();
        int curFreq = 0;
        while (true) {
            for (Integer number : numbers) {
                curFreq += number;
                if (checks.contains(curFreq) || curFreq == 0) {
                    return curFreq;
                }
                checks.add(curFreq);
            }
        }
    }

    private static DataAggregator getResult(List<Data1> data) {
        DataAggregator retVal = new DataAggregator();
        for (Data1 data1 : data) {
            retVal.add(data1.getValue());
        }

        return retVal;
    }

    private static class DataAggregator {
        private List<Integer> numbers = new ArrayList<>();
        private Integer sum = 0;

        private void add(Integer number) {
            sum += number;
            numbers.add(number);
        }

        @Override
        public String toString() {
            return "DataAggregator{" +
                    "numbers=" + numbers +
                    ", sum=" + sum +
                    '}';
        }
    }

}
