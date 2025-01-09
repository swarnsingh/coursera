package com.swarn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given on-call rotation schedule for multiple people by: their name, start time and end time of the rotation
 * Abby 1 10
 * Ben 5 7
 * Carla 6 12
 * David 15 17
 * Your goal is to return rotation table without overlapping periods representing who is on call during that time. Return "Start time", "End time" and list of on-call people
 * Sarvare Alam
 * 5:04 PM
 * 1	5	Abby
 * 5	6	Abby, Ben
 * 6	7	Abby, Ben, Carla
 * 7	10	Abby, Carla
 * 10	12	Carla
 * 12	15	(None)
 * 15	17	David
 * <p>
 * 1 5 6 7 10 12 15 17
 */

public class RotationTest {

    public static List<Rotation> callRotationInterval(List<Rotation> rotations) {
        List<Rotation> list = new ArrayList<>();
        List<Integer> intervals = new ArrayList<>();

        for (Rotation rotation : rotations) {
            intervals.add(rotation.getStartInterval());
            intervals.add(rotation.getEndInterval());
        }
        Collections.sort(intervals);

        for (int i = 0; i < intervals.size() - 1; i++) {
            int start = intervals.get(i);
            int end = intervals.get(i + 1);

            Rotation r1 = new Rotation(start, end, "");
            for (Rotation rotation : rotations) {
                if (rotation.getStartInterval() < end && end <= rotation.getEndInterval()) {
                    r1.setName(r1.getName() + " " + rotation.getName());
                }
            }
            list.add(r1);
        }

        return list;
    }

    public static void main(String[] args) {
        List<Rotation> list = new ArrayList<>();
        list.add(new Rotation(1, 10, "Abby"));
        list.add(new Rotation(5, 7, "Ben"));
        list.add(new Rotation(6, 12, "Carla"));
        list.add(new Rotation(15, 17, "David"));

        list = callRotationInterval(list);

        for (Rotation r1 : list) {
            System.out.println(r1);
        }
    }
}
