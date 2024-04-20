package com.example.forokotlin.dto

class Group {

    private var userUid: String? = null
    private var name: String? = null
    private var description: String? = null
    private var status: String? = null

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