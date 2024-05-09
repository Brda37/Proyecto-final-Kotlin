package com.example.forokotlin.dto

class Group : BaseDto() {

    private var userUid: String? = null
    private var description: String? = null
    private var status: String? = null
    private var members: HashMap<String, Boolean>? = null

    fun getUserUid(): String? {
        return userUid
    }

    fun setUserUid(userUid: String?) {
        this.userUid = userUid
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getMembers(): HashMap<String, Boolean>? {
        return members
    }

}