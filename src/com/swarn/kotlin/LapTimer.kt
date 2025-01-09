package com.swarn.kotlin

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay

var msCounter: Int = 0
var secondsCounter: Int = 0
var minuteCounter: Int = 0

var flag = true

fun main() {
    runBlocking {
        startTimer()
    }
}

suspend fun startTimer() {
    while (flag) {
        delay(10)
        if (msCounter <= 99) {
            msCounter++
        }
        if (msCounter == 100) {
            msCounter = 0
            secondsCounter++
        }
        if (secondsCounter == 60) {
            secondsCounter = 0
            minuteCounter++
        }
        println("${minuteCounter}:${secondsCounter}.${msCounter}")
    }
}