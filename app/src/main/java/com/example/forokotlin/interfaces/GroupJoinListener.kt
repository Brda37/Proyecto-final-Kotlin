package com.example.forokotlin.interfaces

import com.example.forokotlin.dto.Group

interface GroupJoinListener {
    fun onJoinGroupClicked(group: Group)
}