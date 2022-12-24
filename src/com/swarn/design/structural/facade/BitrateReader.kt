package com.swarn.design.structural.facade

/**
 * @author Swarn Singh.
 */
class BitrateReader {

    companion object {
        fun read(file: VideoFile?, codec: Codec?): VideoFile? {
            println("BitrateReader: reading file...")
            return file
        }

        fun convert(buffer: VideoFile?, codec: Codec?): VideoFile? {
            println("BitrateReader: writing file...")
            return buffer
        }
    }
}