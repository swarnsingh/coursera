package com.cp.string;

/**
 * @author Swarn Singh.
 */
public class LastCharacter {

    public static String getLastCharacter(String str, int count) {
        StringBuilder sb = new StringBuilder(str);
        if (sb.length() > 0) {
            int position = 0;
            int deletePosition = position + (count - 1);
            while (sb.length() > 1) {
                if (sb.length() > deletePosition) {
                    sb.deleteCharAt(deletePosition);
                    position = count - 1;
                } else {
                    position = deletePosition % sb.length();
                    sb.deleteCharAt(position);
                }
                deletePosition = position + (count - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Swarn";

        System.out.println("Last Remaining Character is : " + getLastCharacter(str, 4));
    }
}
