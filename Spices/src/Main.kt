fun main(args: Array<String>) {
    val spice = SimpleSpice()
    println("Name is ${spice.name}, heat is ${spice.heat}")

    /*val spices = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("chili", "spicy"),
        Spice("ginger", "mild"),
        Spice("paprika", "very spicy"),
        makeSalt()
    )

    val list = spices.filter { it.heat <= 10 }
    for (spice in list) {
        println("${spice.name} - heat ${spice.heat}")
    }*/

    val curry = Curry("spicy")
    println("Name: ${curry.name}")
    println("Spiciness: ${curry.spiciness}")
    println("Heat: ${curry.heat}")

    curry.prepareSpice()

    val curry2 = Curry("spicy")
    println("Color: ${curry2.color}")
}

