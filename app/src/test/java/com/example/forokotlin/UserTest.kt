package com.example.forokotlin

import com.example.forokotlin.dto.User
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserTest {

    private lateinit var user: User

    @Before
    fun setUp() {
        user = User()
    }

    @Test
    fun testGetUid() {
        val uid = "123456"
        user.setUid(uid)
        assertEquals(uid, user.getUid())
    }

    @Test
    fun testGetName() {
        val name = "John"
        user.setName(name)
        assertEquals(name, user.getName())
    }

    @Test
    fun testGetLastname() {
        val lastname = "Doe"
        user.setLastname(lastname)
        assertEquals(lastname, user.getLastname())
    }

    @Test
    fun testGetAge() {
        val age = 30
        user.setAge(age)
        assertEquals(age, user.getAge())
    }

    @Test
    fun testGetEmail() {
        val email = "john.doe@example.com"
        user.setEmail(email)
        assertEquals(email, user.getEmail())
    }

    @Test
    fun testGetPassword() {
        val password = "password123"
        user.setPassword(password)
        assertEquals(password, user.getPassword())
    }
}