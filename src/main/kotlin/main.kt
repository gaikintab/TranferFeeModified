package ru.netology

fun main() {
    val amount = 500000        // сумма перевода в копейках
    val minFee = 3500          // минимальная сумма комиссии
    val tax = 0.0075           // процент комиссии

    val fee = if ((amount * tax) > minFee) (amount * tax) else minFee
    val result = fee.toInt() / 100

    println("Комиссия за перевод суммы " + amount / 100 + "р.: $result" + "р.")
}