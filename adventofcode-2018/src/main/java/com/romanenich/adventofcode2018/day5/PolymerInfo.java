package com.romanenich.adventofcode2018.day5;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class PolymerInfo implements Info {

    private String value;

    public PolymerInfo(String value) {
        this.value = value;
    }

    @Override
    public String getRemainedPolymer() {
        return simplify(value);
    }

    @Override
    public String getRemainAdjustedPolymer(String input) {
        int minLength = Integer.MAX_VALUE;
        String curString  = StringUtils.EMPTY;
        for (int i = 0; i < 26; i++) {
            String adjInput = getAdjustedString(input, i);

            String simplify = simplify(adjInput);
            if (simplify.length() < minLength) {
                minLength = simplify.length();
                curString = simplify;
            }
        }
        return curString;
    }

    String getAdjustedString(String input, int i) {
        char character = (char) ('a' + i);
        char bigCharacter = (char) ('a' + i - 32);
        return input.replaceAll("" + character + "|" + bigCharacter, "");
    }

    private String simplify(String polymer) {

        Stack<Character> stack = new Stack<>();
        polymer.chars().forEachOrdered(character -> {
                    if (stack.empty()) {
                        stack.push((char) character);
                        return;
                    }

                    Character peek = stack.peek();
                    if (!(character == peek) && (Character.toUpperCase(peek) == Character.toUpperCase(character))) {
                        stack.pop();
                    } else {
                        stack.push((char) character);
                    }
                }
        );


        if (stack.empty()) {
            return StringUtils.EMPTY;
        } else {

            StringBuilder stringBuilder = new StringBuilder(stack.size());
            while (!stack.empty()) {
                stringBuilder.append(stack.pop());
            }
            return stringBuilder.reverse().toString();
        }
    }

}
