package com.example.forokotlin

import com.example.forokotlin.utils.Status
import org.junit.Assert.assertEquals
import org.junit.Test

class StatusTest {

    @Test
    fun testStatusValues() {
        assertEquals("Activo", Status.ACTIVE.value)
        assertEquals("Inactivo", Status.INACTIVE.value)
    }
}