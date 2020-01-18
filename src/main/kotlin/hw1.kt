fun main() {

//    val amount = 200 // стоимость текущей продажи
//    val total = 11_000 // сумма предыдущих продаж
//    val fee = calculateFee(200, 11_000)  // exclusive по умолчанию = false
//    println(fee) // 40
    println(calculateFee(100, 300_000))
    println(calculateFee(100, 300_000, true))
    println(calculateFee(100, 30_000))
    println(calculateFee(100, 30_000, true))
    println(calculateFee(100, 3_000))
    println(calculateFee(100, 3_000, true))
    println(calculateFee(100, 300))
    println(calculateFee(100, 300, true))

}

fun calculateFee(amount: Int, total: Int, exclusive: Boolean = false): Int {

    var percent: Int = when {
        total > 50000 -> 15
        total > 10000 -> 20
        total >  1000 -> 25
        else -> 30
    }

    when {
        exclusive -> percent-= 5
    }

    return percent * amount / 100
}