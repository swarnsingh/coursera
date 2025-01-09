package com.swarn.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestKNumber {

    public static void main(String[] args) {
        String str = "999888777";
        int k = 2;
        System.out.println(getLargestKNumber(str, k));
    }

    static String getLargestKNumber(String str, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        Collections.sort(list, Collections.reverseOrder());

        int count = 0;
        int last = list.get(0);
        for (int i = 0; i < str.length(); i++) {
            int value = list.get(i);

            if (value == last && count < k) {
                sb.append(value);
                count++;
            } else if (value == last && count >= k) {
                for (int j = i + 1; j < str.length(); j++) {
                    int data = list.get(j);
                    if (data != value) {
                        int temp = data;
                        list.add(i, temp);
                        list.add(j, value);
                        sb.append(temp);
                        last = temp;
                        count = 1;
                        break;
                    }
                }
            } else {
                sb.append(value);
                count = 1;
                last = value;
            }
        }
        return sb.toString();
    }
}
