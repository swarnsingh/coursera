package com.swarn.kotlin.inline

/**
 * <p>
 * Inline
 * Attempts to replace a function call with its body at the call site, potentially improving performance.
 * However, it can impact code size and readability.
 * Often used with lambdas, but not exclusively.
 * Compiler's decision to inline depends on various factors, including function size, complexity, and overall code
 * structure.
 * </p>
 * <p>
 * Noinline
 * Prevents the compiler from inlining a lambda, giving more control over the lambda's execution.
 * Useful when the lambda needs to be captured or passed to non-inline functions.
 * Can be applied to any lambda parameter, not just those passed to inline functions.
 * </p>
 * <p>
 * Crossinline
 * Allows a lambda to return from the outer function, enabling more flexible control flow.
 * Primarily used in conjunction with suspend functions and coroutines.
 * Should be used judiciously, as it's a specific use case.
 * </p>
 * <p>
 * Additional Points
 * Performance Impact: Inlining can improve performance but can also increase code size. Overusing inlining might lead to
 * larger compiled code.
 * Readability: Excessive use of inline can sometimes make code less readable.
 * Compiler Optimization: The Kotlin compiler has optimizations beyond inline, noinline, and crossinline. Understanding
 * these optimizations can help in making informed decisions about when to use these keywords.
 *</p>
 * @author Swarn Singh
 */
import com.swarn.kotlin.UseCaseResourceStatus
import com.swarn.kotlin.handleNetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

const val ITEM = "ITEM"
val ITEM1 = "ITEM1"

fun main() {
    runBlocking {
        println(ITEM)
        println(ITEM1)
        handleNetworkResponse(
            getData(),
            onSuccess = {
                println(it.data)
            },
            onError = {
                println(it.throwable)
            }
        )
    }
    bar()
    processRecords("Swarn", "Aman", "Rohan", "Anjali")
}

suspend inline fun <reified T> getUseCaseResourceStatusFlow(crossinline function: suspend () -> T): Flow<UseCaseResourceStatus<T>> {
    return flow {
        emit(UseCaseResourceStatus.Loading())
        val response = function()
        emit(UseCaseResourceStatus.Success(response))
    }.catch { throwable ->
        emit(UseCaseResourceStatus.Error(null, throwable))
    }.flowOn(Dispatchers.IO)
}

suspend fun getData(): Flow<UseCaseResourceStatus<String>> {
    return getUseCaseResourceStatusFlow {
        "Test"
    }
}

fun processRecords(vararg records: String) {
    for (record in records) {
        executeAndMeasure(
            label = record,
            block = {
                println(record)
            },
            onError = { ex ->
                println("Trouble saving $record - ${ex.message} - ${records.size}")
            }
        )
    }
}

inline fun executeAndMeasure(label: String, crossinline block: () -> Unit, noinline onError: (Exception) -> Unit) {
    Thread {
        try {
            val start = System.nanoTime()
            block()
            val end = System.nanoTime()
            println("Duration for $label: ${(end - start) / 1_000_00} ms")
        } catch (e: Exception) {
            println(label + onError.invoke(e))
        }
    }.start()
}

/**
 * Non-local returns
 * In Kotlin, you can only use a normal, unqualified return to exit a named function or an anonymous function.
 * To exit a lambda, use a label. A bare return is forbidden inside a lambda because a lambda cannot make the
 * enclosing function return:
 *
 * fun foo() {
 *     ordinaryFunction {
 *         return // ERROR: cannot make `foo` return here
 *     }
 * }
 *
 */
fun foo() {
    ordinaryFunction {
        // return // ERROR: cannot make `foo` return here
    }
}

fun ordinaryFunction(block: () -> Unit) {
    block.invoke()
}

fun bar() {
    inlined {
        println("inlined function")
        return // OK: the lambda is inlined
    }
    foo()
}

inline fun inlined(block: () -> Unit) {
    block.invoke()
}




