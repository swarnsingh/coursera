package com.swarn.kotlin

class CornParser {

    private var index = 0
    private lateinit var input: String

    fun parse(corn: String): Map<String, Any> {
        input = corn
        index = 0
        return parseObject()
    }

    private fun parseObject(): Map<String, Any> {
        val result = mutableMapOf<String, Any>()

        while (index < input.length) {
            skipWhitespace()
            if (peek() == '}') {
                index++ // Skip the closing brace
                break
            }
            val key = parseKey()
            skipWhitespace()
            if (peek() == ':') {
                index++ // Skip the colon
                skipWhitespace()
                val value = parseValue()
                result[key] = value
            } else {
                throw Exception("Expected ':' after key at position $index")
            }
        }
        return result
    }

    private fun parseKey(): String {
        val start = index
        while (index < input.length && input[index] != ':' && input[index] != ' ' && input[index] != '\n') {
            index++
        }
        return input.substring(start, index).trim()
    }

    private fun parseValue(): Any {
        skipWhitespace()
        return when (val char = peek()) {
            '{' -> {
                index++ // Skip opening brace
                parseObject()
            }

            '[' -> {
                index++ // Skip opening bracket
                parseArray()
            }

            else -> parseLiteral()
        }
    }

    private fun parseArray(): List<Any> {
        val result = mutableListOf<Any>()
        while (index < input.length) {
            skipWhitespace()
            if (peek() == ']') {
                index++ // Skip the closing bracket
                break
            }
            val value = parseValue()
            result.add(value)
            skipWhitespace()
            if (peek() == ',') {
                index++ // Skip the comma
            }
        }
        return result
    }

    private fun parseLiteral(): String {
        val start = index
        while (index < input.length && input[index] != ',' && input[index] != '}' && input[index] != ']' && input[index] != '\n') {
            index++
        }
        return input.substring(start, index).trim()
    }

    private fun skipWhitespace() {
        while (index < input.length && input[index].isWhitespace()) {
            index++
        }
    }

    private fun peek(): Char {
        return if (index < input.length) input[index] else '\u0000'
    }
}

fun main() {
    val cornData = """
        field1: value1
        field2: value2
        field3: {
            nested1: value3
            nested2: value4
        }
        field4: [item1, item2, item3]
    """.trimIndent()

    val parser = CornParser()
    val result = parser.parse(cornData)

    println(result)
}
