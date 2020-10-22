package com.design.structural.facade

/**
 * @author Swarn Singh.
 */
class VideoFile  {
    private var name: String
    private var codecType: String

    constructor(name: String) {
        this.name = name
        this.codecType = name.subSequence(name.indexOf("."), name.length).toString()
    }

    fun getCodecType(): String {
        return codecType
    }

    fun getName(): String? {
        return name
    }
}