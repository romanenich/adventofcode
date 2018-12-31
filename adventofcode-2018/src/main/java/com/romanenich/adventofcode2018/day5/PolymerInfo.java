package com.romanenich.adventofcode2018.day5;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class PolymerInfo implements Info {

    private String value;

    public PolymerInfo(String value) {
        this.value = value;
    }

    @Override
    public int getRemainUnits() {
        return simplify(value).length();
    }

    @Override
    public int getRemainUnitsAdjustedInput() {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            String adjInput = getAdjustedString(i);

            int length = simplify(adjInput).length();
            if (length < minLength) {
                minLength = length;
            }
        }

        return minLength;
    }

    String getAdjustedString(int i) {
        Character character = (char) ('a' + i);
        char newChar = Character.toUpperCase(character);
        String replacedInput = value.replace(character, newChar);
        return replacedInput.replace(new StringBuilder().append(newChar),StringUtils.EMPTY);
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
