package com.example.forokotlin

import com.example.forokotlin.dto.Group
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GroupTest {

    private lateinit var group: Group

    @Before
    fun setUp() {
        group = Group()
    }

    @Test
    fun testGetName() {
        val name = "Test Group"
        group.setName(name)
        assertEquals(name, group.getName())
    }

    @Test
    fun testGetDescription() {
        val description = "This is a test group"
        group.setDescription(description)
        assertEquals(description, group.getDescription())
    }

    @Test
    fun testGetUserUid() {
        val uid = "123456"
        group.setUid(uid)
        assertEquals(uid, group.getUid())
    }

    @Test
    fun testGetStatus() {
        val status = "Active"
        group.setStatus(status)
        assertEquals(status, group.getStatus())
    }
}