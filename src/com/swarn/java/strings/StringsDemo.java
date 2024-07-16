package com.swarn.java.strings;

/**
 * <p>
 * O/p
 * true
 * 9
 * H
 * World
 * Hello
 * Hello World
 * HeLLo WorLd
 * HeLLo WorLd
 * true
 * true
 * 2
 *</p>
 * @author Swarn Singh
 */
public class StringsDemo {

    public static void main(String[] args) {
        String str = "Hello World";

        System.out.println(str.contains("Hello"));
        System.out.println(str.lastIndexOf('l'));
        System.out.println(str.charAt(0));
        System.out.println(str.substring(6));
        System.out.println(str.substring(0, 5));
        System.out.println(str.toCharArray());
        System.out.println(str.replace('l', 'L'));
        System.out.println(str.replaceAll("l", "L"));
        System.out.println(str.startsWith("Hello"));
        System.out.println(str.endsWith("World"));

        String[] arr = str.split("\\s+");
        System.out.println(arr.length);
    }
}
