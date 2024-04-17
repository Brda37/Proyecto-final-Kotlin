package com.example.forokotlin.utils

enum class TitleType {
    ERROR,
    SUCCESS,
    WARNING;

    private var title: String? = null
    fun setTitle(title: String) {
        this.title = title
    }
    fun getTitle(): String? {
        return title
    }
}
