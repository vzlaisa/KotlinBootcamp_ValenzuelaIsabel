import YellowSpiceColor

abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color {

    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            "medium" -> 7
            "spicy" -> 10
            "very spicy" -> 15
            else -> 0
        }

    init {
        println("Spice: name is $name, spiciness is $spiciness, heat is $heat")
    }

    abstract fun prepareSpice()
}

// fun makeSalt() = Spice("salt", "not spicy")

interface Grinder {
    fun grind()
}

class Curry(
    spiciness: String, color: SpiceColor = YellowSpiceColor,
) : Spice("Curry", spiciness, color), Grinder {

    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
        println("Grinding the curry")
    }
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}

