package com.romanenich.adventofcode2018.day2;

import com.romanenich.AdventOfCodeException;
import com.romanenich.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    private final static String FILE_PATH = "com/romanenich/adventofcode2018/day2/input2.txt";


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(countCheckSum(solution2.readData()));
    }

    private List<String> readData() {
        List<String> retVal = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Utils.getFileByName(getClass(), FILE_PATH)))) {
            String line = fileReader.readLine();
            while (line != null) {
                retVal.add(line);
                line = fileReader.readLine();
            }
        } catch (IOException | NumberFormatException e) {
            throw new AdventOfCodeException("Something went wrong", e);
        }

        return retVal;
    }

    private static int countCheckSum(List<String> inputData) {
        int twice = 0;
        int triple = 0;

        for (String line : inputData) {
            int[] data = new int[128];
            int curTwice = 0;
            int curTriple = 0;

            for (int i = 0; i < line.length(); i++) {
                int count = data[line.charAt(i)] + 1;
                data[line.charAt(i)] = count;
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
