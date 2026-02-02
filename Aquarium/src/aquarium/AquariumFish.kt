package aquarium

abstract class AquariumFish {
    abstract var color : String
}

class Shark: AquariumFish(), FishAction {
    override var color = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction {
    override var color = "gold"

    override fun eat() {
        println("munch on algae")
    }
}

interface FishAction {
    fun eat()
}