data class SpiceContainer(val spice: Spice) {
    val label: String
        get() = spice.name
}

fun main() {
    val curry = Curry("mild")
    val hotCurry = Curry("very spicy")

    val containers = listOf(
        SpiceContainer(curry),
        SpiceContainer(hotCurry),
    )

    containers.forEach {
        println("Label is ${it.label}")
    }
}