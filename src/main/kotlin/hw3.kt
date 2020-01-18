fun main() {

    println(timeInWords(30)) // 30 секунд
    println(timeInWords(90)) // 1,5 минуты
    println(timeInWords(360)) // 6 минут
    println(timeInWords(390)) // 6,5 минут
    println(timeInWords(600)) // 10 минут
    println(timeInWords(3_600)) // час
    println(timeInWords(7_200)) // 2 часа
    println(timeInWords(17_200)) // 4,78 часа
    println(timeInWords(657_200)) // 182,56 часов = 7,6 дней
    println(timeInWords(3600*24*200)) // 200 дней
    println(timeInWords(3600*24*365)) // 1 год
    println(timeInWords(3600*24*365*8)) // 8 лет
    println(timeInWords(3600*24*365*100*3)) // 300 лет


    println(def_sec(1))
    println(def_sec(2))
    println(def_sec(3))
    println(def_sec(4))
    println(def_sec(5))
    println(def_sec(9))
    println(def_sec(10))
    println(def_sec(11))
    println(def_sec(12))
    println(def_sec(19))
    println(def_sec(20))
    println(def_sec(21))
    println(def_sec(22))
    println(def_sec(23))
    println(def_sec(24))
    println(def_sec(25))
    println(def_sec(26))

}

fun timeInWords(sec: Int): String {

    val seconds = def_sec(sec)
    val minutes = sec / 60
    
    val hours = sec / 3600
    val days = sec / (3600*24)
    val years = sec / (3600*24*365)
    val result: String = when {
        sec < 60                -> "$seconds  - это менее минуты назад"
        sec < 3600              -> "$seconds  - это $minutes минут назад"
        sec < 3600*24           -> "$seconds  - это $hours часов назад"
        sec < 3600*24*365       -> "$seconds  - это $days дней назад"
        sec < 3600*24*365*100   -> "$seconds  - это $years лет назад"
        else                    -> "$years лет - это более века назад"
    }
    return result
}

fun def_sec(i: Int): String {

    val lastSymbol = i.toString().get(i.toString().length-1).toString()
    val last2Symbols: String
    val intLast2Symbol: Int

    if (i.toString().length > 1) {
        last2Symbols = i.toString().get(i.toString().length-2).toString() + lastSymbol
        intLast2Symbol = last2Symbols.toInt()
        val result: String = when {
            intLast2Symbol > 10 && i < 21 -> "секунд"
            lastSymbol.equals("1") -> "секундА"
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "секундЫ"
            else -> "секунд"
        }
        return "$i $result"
    } else {
        val result: String = when {
            i > 10 && i < 21 -> "секунд"
            lastSymbol.equals("1") -> "секундА"
            lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") -> "секундЫ"
            else -> "секунд"
        }
        return "$i $result"
    }


}
