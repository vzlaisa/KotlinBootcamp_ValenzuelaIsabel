fun main(args: Array<String>) {
    print("How are you feeling today?: ")
    val mood = readLine()!!
    print(whatShouldIDoToday(mood))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature : Int = 24): String {
    return when {
        isHappySunny(mood, weather) -> "go for a walk"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isVeryHot(temperature) -> "take a shower"
        isBoringDay(mood, weather) -> "watch a movie"
        else -> "stay home and read"
    }
}

fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun isSadRainyCold(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0

fun isVeryHot(temperature: Int) = temperature > 35

fun isBoringDay(mood: String, weather: String) = mood == "bored" && weather == "cloudy"