fun main() {

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