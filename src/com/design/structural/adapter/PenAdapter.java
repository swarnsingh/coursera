package com.design.structural.adapter;

import com.design.structural.PilotPen;

/**
 * @author Swarn Singh.
 */

/**
 * Adapter class to write your assignment using
 * @see com.design.structural.PilotPen
 */
public class PenAdapter implements Pen {

    PilotPen pilotPen = new PilotPen();

    @Override
    public void write(String str) {
        pilotPen.mark(str);
    }
}
