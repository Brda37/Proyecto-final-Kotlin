package com.example.forokotlin.dto

import android.annotation.SuppressLint

class Group {

    private var userUid: String? = null
    private var name: String? = null
    private var description: String? = null
    private var status: String? = null

    @SuppressLint("NotConstructor")
    fun Group(name: String?, description: String?, status: String?) {
        this.name = name
        this.description = description
        this.status = status
    }

    fun Group() {}

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getUserUid(): String? {
        return userUid
    }

    fun setUserUid(uid: String?) {
        userUid = uid
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

}