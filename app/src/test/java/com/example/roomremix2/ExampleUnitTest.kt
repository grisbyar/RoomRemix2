package com.example.roomremix2

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class JsonUnitTest {
    @Test
    fun `Given a exercise name contained within the json then I should recieve a list of muscles that are worked out by thte exercise`() {
        givenJsonFileIsValid()
        whenExerciseDataIsReadAndParsed()
        thenExerciseCollectionShouldNotBeEmpty()
    } private fun thenExerciseCollectionShouldNotBeEmpty() {
        TODO("Not yet implemented")
    }

    private fun whenExerciseDataIsReadAndParsed() {
        TODO("Not yet implemented")
    }

    private fun givenJsonFileIsValid() {
        TODO("Not yet implemented")
    }

}