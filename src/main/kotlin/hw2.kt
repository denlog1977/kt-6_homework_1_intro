fun main() {
    val index = bodyMassIndex(96f, 1.76f)
    println(index)
    println(out(index))
}

fun bodyMassIndex(weight: Float, height: Float): Float {
    return weight / (height * height)
}

fun out(index: Float): String {
    val result: String = when {
        index < 16f -> "Выраженный дефицит массы тела"
        index < 18.5f -> "Недостаточная (дефицит) масса тела"
        index < 25f -> "Норма"
        index < 30f -> "Избыточная масса тела (предожирение)"
        index < 35f -> "Ожирение"
        index < 40f -> "Ожирение резкое"
        else -> "Очень резкое ожирение"
    }
    return result
}