package com.swarn.kotlin.coroutines

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val job = launch {
            var i = 0
            while (true) { // Check for cancellation
                println("I'm sleeping $i ...")
                i++
                yield()
            }
        }
        delay(100)
        job.cancelAndJoin()

        val result = async {
            delay(3000)
            "Return result"
        }
        // println(result.getCompleted()) // this will through an error because job is not completed yet
        result.invokeOnCompletion {
            if (it == null) {
                println(result.getCompleted())
            }
        }
    }
}

suspend fun getData(): String = coroutineScope {
    val data1 = async(Dispatchers.IO) { loadApi1() }
    val data2 = async(Dispatchers.IO) { loadApi2() }
    "${data1.await()} ${data2.await()}"
}

suspend fun loadApi1(): String {
    delay(1000)
    return "Data 1"
}

suspend fun loadApi2(): String {
    delay(1000)
    return "Data 2"
}