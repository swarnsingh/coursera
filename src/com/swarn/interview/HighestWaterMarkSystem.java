package com.swarn.interview;

import java.util.*;

/**
 * we have a system class which has three methods
 *
 * public void start(in jobId)
 * public void ack(int jobId)
 * public int getHWM()
 *
 *
 * start(1) // start the system
 * ack(1)
 * ack(2)
 * getHWM() // return 2
 * ack(3)
 * getHWM() // return 3
 * ack(6) // return 3 because id 4 & 5 are missing
 * ack(5)
 * getHWM() // return 3
 * ack(4)
 * getWM() // return 6
 */
public class HighestWaterMarkSystem {

    Set<Integer> set = new HashSet<>();
    Integer hwm = 0;

    public void start(int jobId) {
        set.clear();
        hwm = 0;
    }

    public void ack(int jobId) {
        set.add(jobId);
        while (set.contains(hwm + 1)) {
            hwm++;
        }
    }

    public Integer getHWM() {
        return hwm;
    }

    public static void main(String[] args) {
        HighestWaterMarkSystem system = new HighestWaterMarkSystem();

        system.start(1);
        system.ack(6);
        System.out.println(system.getHWM());
        system.ack(1);
        system.ack(2);
        System.out.println(system.getHWM()); // should return 2
        system.ack(3);
        System.out.println(system.getHWM()); // should return 3
        System.out.println(system.getHWM()); // should return 3
        system.ack(5);
        System.out.println(system.getHWM()); // should return 3
        system.ack(4);
        System.out.println(system.getHWM()); // should return 6
    }
}
