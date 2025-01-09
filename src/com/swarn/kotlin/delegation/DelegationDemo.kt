package com.swarn.kotlin.delegation

interface Engine {
    fun runsOn()
    fun transmissionType()
}

class ElectricEngine : Engine {
    override fun runsOn() {
        println("Runs on Electric Battery")
    }

    override fun transmissionType() {
        println("Automatic Transmission only")
    }
}

class TeslaEngine(val engine: Engine) : Engine by engine {
    override fun transmissionType() {
        println("Tesla Automatic Transmission only")
    }
}

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    var totalPairs = 0;
    val map = HashMap<Int, Int>()
    for (number in ar) {
        if (map.containsKey(number)) {
            val count = map.get(number) ?: 1
            map.put(number, count + 1)
        } else {
            map.put(number, 1)
        }
    }
    map.forEach { (key, value) ->
        val count: Int = value / 2
        if (count >= 1) {
            totalPairs += count
        }

    }
    return totalPairs;
}

fun main() {
    val engine = TeslaEngine(ElectricEngine())
    engine.runsOn()
    engine.transmissionType()

    val ar = arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)
    println(sockMerchant(ar.size, ar))
}