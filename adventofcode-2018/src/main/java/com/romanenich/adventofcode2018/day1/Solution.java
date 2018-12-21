package com.romanenich.adventofcode2018.day1;

import com.romanenich.AdventOfCodeException;
import com.romanenich.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

    private final static String FILE_PATH = "com/romanenich/adventofcode2018/day1/input.txt";

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getResult());
    }

    private int getResult() {
        int result = 0;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Utils.getFileByName(getClass(), FILE_PATH)))) {
            String readLine = fileReader.readLine();
            while (readLine != null) {
                result += Integer.valueOf(readLine);
                readLine = fileReader.readLine();
            }
        } catch (IOException | NumberFormatException e) {
            throw new AdventOfCodeException("Something went wrong", e);
        }
        return result;
    }


}
