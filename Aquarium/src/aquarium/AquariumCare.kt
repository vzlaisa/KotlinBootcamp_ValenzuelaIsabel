package aquarium

fun main(args: Array<String>) {
    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly uo")
    symptoms.add("white fungus")
    symptoms.remove("white fungus")

    symptoms.contains("red")
    println(symptoms.subList(4, symptoms.size))

    listOf(1, 3, 5).sum()

    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")
}
