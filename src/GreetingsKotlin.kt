fun main(args: Array<String>) {
    val time = args[0].toInt()
    if (time < 12)  {
        println("Good morning, Kotlin")
    } else {
        println("Good night, Kotlin")
    }
}