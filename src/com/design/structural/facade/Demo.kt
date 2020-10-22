package com.design.structural.facade


/**
 * @author Swarn Singh.
 */

fun main(args: Array<String>) {
    val converter = VideoConversionFacade()
    val mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4")
    println(mp4Video?.absolutePath)
}