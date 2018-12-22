package com.romanenich.adventofcode2018.day1;

import com.romanenich.AdventOfCodeException;
import com.romanenich.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 {

    private final static String FILE_PATH = "com/romanenich/adventofcode2018/day1/input.txt";

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println("Resulting frequency is " + solution.getResult().sum);
        System.out.println("The first frequency reached twice is " + findFirstFrequencyReachedTwice(solution.getResult().numbers));
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

    private DataAggregator getResult() {
        DataAggregator retVal = new DataAggregator();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Utils.getFileByName(getClass(), FILE_PATH)))) {
            String readLine = fileReader.readLine();
            while (readLine != null) {
                retVal.add(Integer.valueOf(readLine));
                readLine = fileReader.readLine();
            }
        } catch (IOException | NumberFormatException e) {
            throw new AdventOfCodeException("Something went wrong", e);
        }
        return retVal;
    }

    private class DataAggregator {
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
