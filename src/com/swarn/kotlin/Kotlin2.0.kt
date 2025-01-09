package com.swarn.kotlin

/**
 * <h1>Inline functions</h1>
 * <p>
 * In Kotlin 2.0.0, the K2 compiler treats inline functions differently, allowing it to determine in combination with
 * other compiler analyses whether it's safe to smart-cast.
 *
 * Specifically, inline functions are now treated as having an implicit callsInPlace contract. This means that any lambda
 * functions passed to an inline function are called in place. Since lambda functions are called in place, the compiler
 * knows that a lambda function can't leak references to any variables contained within its function body.
 *
 * The compiler uses this knowledge along with other compiler analyses to decide whether it's safe to smart-cast any of
 * the captured variables. For example:
 * </p>
 */
interface Processor {
    fun process()
}

inline fun inlineAction(f: () -> Unit) = f()

fun nextProcessor(): Processor? = null

fun runProcessor(): Processor? {
    var processor: Processor? = null
    inlineAction {
        // In Kotlin 2.0.0, the compiler knows that processor
        // is a local variable and inlineAction() is an inline function, so
        // references to processor can't be leaked. Therefore, it's safe
        // to smart-cast processor.

        // If processor isn't null, processor is smart-cast
        if (processor != null) {
            // The compiler knows that processor isn't null, so no safe call
            // is needed
            processor.process()

            // In Kotlin 1.9.20, you have to perform a safe call:
            // processor?.process()
        }

        processor = nextProcessor()
    }

    return processor
}

/**
 * Type checks with the logical or operator﻿
 * In Kotlin 2.0.0, if you combine type checks for objects with an or operator (||), a smart cast is made to their closest
 * common supertype. Before this change, a smart cast was always made to the Any type.
 *
 * In this case, you still had to manually check the object type afterward before you could access any of its properties
 * or call its functions. For example:
 *
 */

interface Status {
    fun signal() {}
}

interface Ok : Status
interface Postponed : Status
interface Declined : Status

fun signalCheck(signalStatus: Any) {
    if (signalStatus is Postponed || signalStatus is Declined) {
        // signalStatus is smart-cast to a common supertype Status
        signalStatus.signal()
        // Prior to Kotlin 2.0.0, signalStatus is smart cast
        // to type Any, so calling the signal() function triggered an
        // Unresolved reference error. The signal() function can only
        // be called successfully after another type check:

        // check(signalStatus is Status)
        // signalStatus.signal()
    }
}

interface Provider {
    operator fun invoke()
}

class Holder(val provider: Provider?, val processor: Processor?) {
    fun process() {
        if (provider != null) {
            provider()
            // In 1.9.20, the compiler triggers an error:
            // Reference has a nullable type 'Provider?', use explicit '?.invoke()' to make a function-like call instead
        }
    }
}