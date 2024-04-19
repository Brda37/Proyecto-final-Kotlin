package com.example.forokotlin.utils

enum class Status {
    ACTIVE,
    INACTIVE;

    private var status: String? = null

    fun setName(name: String) {
        this.status = name
    }
    fun getName(): String? {
        return status
    }
}
