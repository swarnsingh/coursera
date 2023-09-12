package com.swarn;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Swarn Singh.
 */
public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("You have %1$s %2$s left");
        System.out.println(sb.lastIndexOf("%1$s"));
        String str = "You have %1$s %2$s left";
        String[] arr = str.split("%1$s");
        for(String s : arr) {
            System.out.println(s);
        }
        //System.out.println("Hello World");
        //createScanDefaultFileName("Scan_");
    }

    public static String createScanDefaultFileName(String s) {
        StringBuilder name = new StringBuilder();
        Date now = new Date();

        System.out.println(System.getenv());

        System.out.println(System.getenv());

        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("MMdd_HHmmss");
        String date = dateFormat.format(now);

        if (s.isEmpty())
            name.append("RP_");
        else
            name.append(s).append("_");

        name.append(date);

        return name.toString();
    }
}
