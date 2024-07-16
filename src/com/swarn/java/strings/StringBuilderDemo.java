package com.swarn.java.strings;

/**
 *  Hello Hello World
 * Hello Hello World
 * Hello World
 * 9
 * 2
 * dlroW olleH
 * Hello World
 *
 * @author Swarn Singh
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(" Hello Hello ");
        sb.append("World");

        System.out.println(sb);
        System.out.println(sb.deleteCharAt(0));
        System.out.println(sb.delete(0, 6));
        System.out.println(sb.lastIndexOf("l")); // Char not supported
        System.out.println(sb.indexOf("l"));
        System.out.println(sb.reverse());
        System.out.println(sb.reverse());
    }
}
