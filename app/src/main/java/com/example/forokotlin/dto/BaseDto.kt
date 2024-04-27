package com.example.forokotlin.dto

abstract class BaseDto {

    private var uid: String? = null
    private var name: String? = null

    fun getUid(): String? {
        return uid
    }

    fun setUid(uid: String?) {
        this.uid = uid
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

}