fun main(args:Array<String>) {
    var fortune = ""

    while (fortune != "Take it easy and enjoy life!") {
        fortune = getFortune(getBirthday())
        println("Your fortune is: $fortune")
    }
}

fun getFortune(birthday: Int): String {
    val list = listOf<String>(
        "You will have a great day",
        "Things will go well for you today",
        "Enjoy a wonderful day of success",
        "Be humble and all will turn out well",
        "Today is a good day for exercising restraint",
        "Take it easy and enjoy life!",
        "Treasure your friends!"
    )

    return list[birthday.mod(list.size)]
}

fun getBirthday(): Int {
    println("Enter your birthday: ")

   return readLine()?.toIntOrNull() ?: 1
}