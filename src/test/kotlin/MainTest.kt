package ru.netology

import org.junit.Assert.*
import org.junit.Test

class MainTest {
    @Test
    fun calculateTransfer_Mastercard1() {
        val cardName = "Mastercard"
        val monthAmount = 75_000
        val amount = 70_000

        val result = calculateTransfer(cardName = cardName, monthAmount = monthAmount, amount = amount)
        assertEquals(440, result)
    }

    @Test
    fun calculateTransfer_Mastercard2() {
        val cardName = "Mastercard"
        val monthAmount = 0
        val amount = 60_000

        val result = calculateTransfer(cardName = cardName, monthAmount = monthAmount, amount = amount)
        assertEquals(0, result)
    }

    @Test
    fun calculateTransfer_Mastercard3() {
        val cardName = "Mastercard"
        val monthAmount = 40_000
        val amount = 50_000

        val result = calculateTransfer(cardName = cardName, monthAmount = monthAmount, amount = amount)
        assertEquals(110, result)
    }

    @Test
    fun calculateTransfer_Visa() {
        val cardName = "Visa"
        val monthAmount = 150_000
        val amount = 30_000

        val result = calculateTransfer(cardName = cardName, monthAmount = monthAmount, amount = amount)
        assertEquals(225, result)
    }

    @Test
    fun calculateTransfer_Default() {
        val cardName = ""
        val monthAmount = 0
        val amount = 70_000

        val result = calculateTransfer(cardName = cardName, monthAmount = monthAmount, amount = amount)
        assertEquals(0, result)
    }

}