package ru.netology

fun main() {
    val amount = 40_000          // сумма перевода
    val cardType = 0             // тип карты. 1-Mastercard, 2-Visa, 3-Мир
    var dayAmount = 0           // переведенная сумма за день
    var monthAmount = 0         // переведенная сумма за месяц
    val dayLimit = 150_000       // дневной лимит переводов
    val monthLimit = 600_000     // месячный лимит переводов

    var cardName = ""
    when (cardType) {
        1 -> {
            cardName = "Mastercard"
            dayAmount = 70_000
            monthAmount = 350_000
        }
        2 -> {
            cardName = "Visa"
            dayAmount = 40_000
            monthAmount = 250_000
        }
        else -> {
            cardName = "Мир"
            dayAmount = 24_000
            monthAmount = 100_000
        }
    }
    if ((dayAmount + amount > dayLimit) || (monthAmount + amount > monthLimit)) {
        println("Превышение лимита на перевод! Операция прервана.")
        return
    }
    when (val fee = calculateTransfer(cardName, monthAmount, amount)) {
        0 -> println("Карта $cardName\nКомиссия за перевод суммы " + amount + "р. не взимается")
        else -> println("Карта $cardName\nКомиссия за перевод суммы " + amount + "р. составит $fee" + "р.")
    }
}

fun calculateTransfer(cardName: String, monthAmount: Int, amount: Int): Int {
    return when (cardName) {
        "Mastercard" -> if (monthAmount > 75_000) {
            (amount * 0.006 + 20).toInt()
        } else {
            if ((monthAmount + amount) > 75_000) {
                ((monthAmount + amount - 75_000) * 0.006 + 20).toInt()
            } else 0
        }
        "Visa" -> if ((amount * 0.0075) > 35) (amount * 0.0075).toInt() else 35
        else -> 0
    }
}