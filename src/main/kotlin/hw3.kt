fun main() {

    println(timeInWords(31)) // 30 секунд
    println(timeInWords(92)) // 1,5 минуты
    println(timeInWords(363)) // 6 минут
    println(timeInWords(394)) // 6,5 минут
    println(timeInWords(605)) // 10 минут
    println(timeInWords(3_606)) // час
    println(timeInWords(7_211)) // 2 часа
    println(timeInWords(17_200)) // 4,78 часа
    println(timeInWords(3600*8)) // 8 часов
    println(timeInWords(657_200)) // 182,56 часов = 7,6 дней
    println(timeInWords(3600*24*202)) // 200 дней
    println(timeInWords(3600*24*365)) // 1 год
    println(timeInWords(3600*24*365*8L)) // 8 лет
    println(timeInWords(3600*24*365*224L)) // 300 лет

//    ---  проверка окончаний ---
//    println(endOfWordSecMin(1))
//    println(endOfWordSecMin(2))
//    println(endOfWordSecMin(3))
//    println(endOfWordSecMin(4))
//    println(endOfWordSecMin(5))
//    println(endOfWordSecMin(9))
//    println(endOfWordSecMin(10))
//    println(endOfWordSecMin(11))
//    println(endOfWordSecMin(12))
//    println(endOfWordSecMin(19))
//    println(endOfWordSecMin(20))
//    println(endOfWordSecMin(21))
//    println(endOfWordSecMin(22))
//    println(endOfWordSecMin(23))
//    println(endOfWordSecMin(24))
//    println(endOfWordSecMin(25))
//    println(endOfWordSecMin(26))

}

fun timeInWords(sec: Long): String {

    val seconds: String =  "$sec секунд" + endOfWordSecMin(sec)
    val minutes: String = (sec/60).toString() + " минут" + endOfWordSecMin(sec/60)
    val hours: String = (sec/3600).toString() + " час" + endOfWordHours(sec/3600)
    val days: String = (sec/(3600*24)).toString() + " " +  endOfWordDays(sec/(3600*24))
    val years: String = (sec/(3600*24*365)).toString() + " " + endOfWordYears(sec/(3600*24*365))

    val result: String = when {
        sec < 60                -> "$seconds  - это менее минуты назад"
        sec < 3600              -> "$seconds  - это $minutes назад"
        sec < 3600*24           -> "$seconds  - это $hours назад"
        sec < 3600*24*365       -> "$seconds  - это $days назад"
        sec < 3600*24*365*100   -> "$seconds  - это $years назад"
        else                    -> "$years - это более века назад"
    }
    return result
}

fun endOfWordSecMin(i: Long): String {

    val lastSymbol = i.toString().get(i.toString().length-1).toString()
    val last2Symbols: String
    val intLast2Symbol: Int

    if (i.toString().length > 1) {
        last2Symbols = i.toString().get(i.toString().length-2).toString() + lastSymbol
        intLast2Symbol = last2Symbols.toInt()
        val result: String = when {
            intLast2Symbol > 10 && i < 21 -> "" // секунд
            lastSymbol.equals("1") -> "а" // секундА минутА
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "ы" // секундЫ минутЫ
            else -> "" // секунд
        }
        return result
    } else {
        val result: String = when {
            i > 10 && i < 21 -> "" // секунд
            lastSymbol.equals("1") -> "а" // секундА минутА
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "ы" // секундЫ минутЫ
            else -> "" // секунд
        }
        return result
    }


}

fun endOfWordHours(i: Long): String {

    val lastSymbol = i.toString().get(i.toString().length-1).toString()
    val last2Symbols: String
    val intLast2Symbol: Int

    if (i.toString().length > 1) {
        last2Symbols = i.toString().get(i.toString().length-2).toString() + lastSymbol
        intLast2Symbol = last2Symbols.toInt()
        val result: String = when {
            intLast2Symbol > 10 && i < 21 -> "ов" // часОВ
            lastSymbol.equals("1") -> ""  // час
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "а" // часА
            else -> "ов" // часОВ
        }
        return result
    } else {
        val result: String = when {
            i > 10 && i < 21 -> "секунд"
            lastSymbol.equals("1") -> ""  // час
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "а" // часА
            else -> "ов" // часОВ
        }
        return result
    }


}

fun endOfWordDays(i: Long): String {

    val lastSymbol = i.toString().get(i.toString().length-1).toString()
    val last2Symbols: String
    val intLast2Symbol: Int

    if (i.toString().length > 1) {
        last2Symbols = i.toString().get(i.toString().length-2).toString() + lastSymbol
        intLast2Symbol = last2Symbols.toInt()
        val result: String = when {
            intLast2Symbol > 10 && i < 21 -> "дней"
            lastSymbol.equals("1") -> "день"
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "дня"
            else -> "дней"
        }
        return result
    } else {
        val result: String = when {
            i > 10 && i < 21 -> "дней"
            lastSymbol.equals("1") -> "день"  // час
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "дня"
            else -> "дней"
        }
        return result
    }


}

fun endOfWordYears(i: Long): String {

    val lastSymbol = i.toString().get(i.toString().length-1).toString()
    val last2Symbols: String
    val intLast2Symbol: Int

    if (i.toString().length > 1) {
        last2Symbols = i.toString().get(i.toString().length-2).toString() + lastSymbol
        intLast2Symbol = last2Symbols.toInt()
        val result: String = when {
            intLast2Symbol > 10 && i < 21 -> "лет"
            lastSymbol.equals("1") -> "год"
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "года"
            else -> "лет"
        }
        return result
    } else {
        val result: String = when {
            i > 10 && i < 21 -> "лет"
            lastSymbol.equals("1") -> "год"
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "года"
            else -> "лет"
        }
        return result
    }


}
