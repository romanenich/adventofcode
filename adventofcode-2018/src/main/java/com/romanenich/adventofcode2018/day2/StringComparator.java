package com.romanenich.adventofcode2018.day2;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    private String str1;
    private String str2;
    private String root;
    private int pos;

    public String getStr1() {
        return str1;
    }

    public String getStr2() {
        return str2;
    }

    public String getRoot() {
        return root;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) {
            return o1.compareTo(o2);
        }

        int len = o1.length();

        char v1[] = o1.toCharArray();
        char v2[] = o2.toCharArray();

        int index = 0;
        int count = 0;
        int diff = 0;
        while (index < len) {
            char c1 = v1[index];
            char c2 = v2[index];
            if (c1 != c2) {
                pos = index;
                if (count++ == 0) {
                    diff = c1 - c2;
                } else {
                    return diff;
                }
            }
            index++;
        }

        str1 = o1;
        str2 = o2;

        findAndSetRoot();
        return 0;
    }

    private void findAndSetRoot() {
        root = str1.substring(0, pos).concat(str1.substring(pos + 1));
    }
}
