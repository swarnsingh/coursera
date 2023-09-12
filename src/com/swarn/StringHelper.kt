package com.swarn

import java.io.File
import java.net.URL

/**
 * @author Swarn Singh.
 */

private const val SIXT_BASE_URL = "https://www.sixt.de/"
private const val DOMAIN_NAME_DOT_INCLUSIVE = ".sixt."

fun CharSequence?.isNotNullOrBlank() = !isNullOrBlank()

fun getOfferImageUrl(urlString: String?): String? {
    return when {
        urlString.isNullOrBlank() -> null
        URL(urlString).host != null && File(URL(urlString).file).extension.isNotNullOrBlank() -> urlString
        urlString.contains(DOMAIN_NAME_DOT_INCLUSIVE) -> urlString
        else -> {
            SIXT_BASE_URL + urlString.replace("//", "")
        }
    }
}

fun isValid(url: String?): Boolean {
    return try {
        URL(url).toURI()
        true
    } catch (e: Exception) {
        false
    }
}

fun main(args: Array<String>) {
    /*val availableMileages = "You have %1$\\s %2$\\s left"
    val arr = availableMileages.split(" ")

    arr.forEach {
        if (it == "%1$\\s" || it == "%2$\\s") {
            println("Red : $it")
        } else {
            println("Black : $it")
        }
    }

    val processingFee = "$16.8"
    val str =
        "Processing     Fee of $processingFee    is charged    for non-reporting of mileage during the billing month."
    val title =
        StringBuilder(str)

    str.replace("\\s+".toRegex(), " ")
    println(str)

    println("Start Index : " + title.indexOf(processingFee))
    println("Last Index of : " + (title.indexOf(processingFee) + processingFee.length))*/

    val urlString = "//fileadmin/files/global/user_upload/fleet/png/630x360/mg-mg5-stw-silver-2022.png"

    println(getOfferImageUrl(urlString))
}