package com.swarn

import java.time.LocalTime

data class TimeSlotState(
        val enabled: Boolean,
        val selected: Boolean,
        val time: LocalTime
)

private fun createTimePickerOptions(openTimes: List<Pair<LocalTime, LocalTime>>? = null, localSelectedTime: LocalTime?): List<TimeSlotState> {
    val items = mutableListOf<TimeSlotState>()
    openTimes?.forEach { openTime ->
        val start = openTime.first
        val end = openTime.second

        // Handle the special case of 00:00 to 00:00 (midnight to midnight)
        if (start == LocalTime.MIDNIGHT && end == LocalTime.MIDNIGHT) {
            for (hour in 0 until 24) {
                val fullHour = LocalTime.of(hour, 0)
                val halfHour = LocalTime.of(hour, 30)
                items.add(createTimePickerListItem(fullHour, localSelectedTime))
                items.add(createTimePickerListItem(halfHour, localSelectedTime))
            }
        } else {
            for (hourOfDay in start.hour..end.hour) {
                val fullHour = LocalTime.of(hourOfDay, 0)
                val halfHour = LocalTime.of(hourOfDay, 30)
                if (fullHour.isWithinRange(openTime)) items.add(createTimePickerListItem(fullHour, localSelectedTime))
                if (halfHour.isWithinRange(openTime)) items.add(createTimePickerListItem(halfHour, localSelectedTime))
            }
        }
    }
    return items
}

private fun createTimePickerListItem(localTime: LocalTime, localSelectedTime: LocalTime?): TimeSlotState {
    return TimeSlotState(
            enabled = true,
            selected = localTime == localSelectedTime,
            time = localTime,
    )
}

private fun LocalTime.isWithinRange(openTime: Pair<LocalTime, LocalTime>) = (
        (this.isAfter(openTime.first) || this == openTime.first) &&
                (this.isBefore(openTime.second) || this == openTime.second)
        )

fun main() {
    // Example list of opening and closing hours
    val openingClosingHours = listOf(
            Pair(LocalTime.of(0, 0), LocalTime.of(0, 0)),
    )

    val timeSlots = createTimePickerOptions(openingClosingHours, LocalTime.of(13, 0, 0))
    timeSlots.forEach { println(it) }
}