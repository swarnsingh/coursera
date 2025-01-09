package com.swarn

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
 *
 * 1 5 6 7 10 12 15 17
 */

data class Rotation(
    val startInterval : Int,
    val endInterval: Int,
    var name: String,
)

fun main() {

}
