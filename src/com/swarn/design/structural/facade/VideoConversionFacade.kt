package com.swarn.design.structural.facade

import java.io.File

/**
 *
  Intent
  Facade is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.


    Problem

    Imagine that you must make your code work with a broad set of objects that belong to a sophisticated library or framework.
    Ordinarily, you’d need to initialize all of those objects, keep track of dependencies, execute methods in the correct order, and so on.

    As a result, the business logic of your classes would become tightly coupled to the implementation details of 3rd-party classes, making it hard to
    comprehend and maintain.

    Solution

    A facade is a class that provides a simple interface to a complex subsystem which contains lots of moving parts. A facade might provide limited
    functionality in comparison to working with the subsystem directly. However, it includes only those features that clients really care about.

    Having a facade is handy when you need to integrate your app with a sophisticated library that has dozens of features, but you just need a tiny bit
    of its functionality.

    For instance, an app that uploads short funny videos with cats to social media could potentially use a professional video conversion library.
    However, all that it really needs is a class with the single method encode(filename, format). After creating such a class and connecting it with
    the video conversion library, you’ll have your first facade.

    Real-World Analogy

    When you call a shop to place a phone order, an operator is your facade to all services and departments of the shop. The operator provides you with
    a simple voice interface to the ordering system, payment gateways, and various delivery services.
 */

/**
 * @author Swarn Singh.
 */
class VideoConversionFacade {

    fun convertVideo(fileName: String?, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName!!)
        val sourceCodec = CodecFactory.extract(file)
        val destinationCodec: Codec = if (format == "mp4") {
            OggCompressionCodec()
        } else {
            MPEG4CompressionCodec()
        }
        val buffer = BitrateReader.read(file, sourceCodec)
        val intermediateResult = BitrateReader.convert(buffer, destinationCodec)
        val result = AudioMixer().fix(intermediateResult)
        println("VideoConversionFacade: conversion completed.")
        return result
    }
}