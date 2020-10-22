package com.design.structural.facade

import java.io.File




/**
 * @author Swarn Singh.
 */
class AudioMixer {
    fun fix(result: VideoFile?): File? {
        println("AudioMixer: fixing audio...")
        return File("tmp")
    }
}