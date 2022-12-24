package com.swarn.design.structural.adapter;

import com.swarn.design.structural.PilotPen;

/**
 * @author Swarn Singh.
 */

/**
 * Adapter class to write your assignment using
 * @see com.swarn.design.structural.PilotPen
 */
public class PenAdapter implements Pen {

    PilotPen pilotPen = new PilotPen();

    @Override
    public void write(String str) {
        pilotPen.mark(str);
    }
}
