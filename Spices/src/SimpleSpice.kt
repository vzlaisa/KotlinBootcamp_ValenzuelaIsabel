class SimpleSpice {
    var name: String = "curry"
    var spiciness: String = "mild"

    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }
}