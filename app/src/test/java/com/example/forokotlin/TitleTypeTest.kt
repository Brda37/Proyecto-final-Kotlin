package com.example.forokotlin

import com.example.forokotlin.utils.TitleType
import org.junit.Assert.assertEquals
import org.junit.Test

class TitleTypeTest {

    @Test
    fun testTitleTypeValues() {
        assertEquals("Error", TitleType.ERROR.value)
        assertEquals("Éxito", TitleType.SUCCESS.value)
        assertEquals("Advertencia", TitleType.WARNING.value)
    }
}