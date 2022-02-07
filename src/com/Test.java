package com;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Swarn Singh.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World");
        createScanDefaultFileName("Scan_");
    }

    public static String createScanDefaultFileName(String s) {
        StringBuilder name = new StringBuilder();
        Date now = new Date();

        System.out.println(System.getenv());

        System.out.println(System.getenv());

        SimpleDateFormat dateFormat;
//        if (getLocalTimeFormat()) {
////            dateFormat = new SimpleDateFormat("MMDD_HHmmss");
////        } else {
////            dateFormat = new SimpleDateFormat("MMDD_hhmmss");
////        }
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
