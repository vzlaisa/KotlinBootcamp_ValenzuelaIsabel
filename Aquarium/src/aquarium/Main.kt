package aquarium

import javax.swing.Spring.height

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println("length is ${myAquarium.length}, width is ${myAquarium.width}, height is ${myAquarium.height}")

    myAquarium.height = 80
    println("height is ${myAquarium.height} cm")

    println("volume is ${myAquarium.volume} liters")

    val smallAquarium = Aquarium(20, 15, 30)
    println("smallAquarium is ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 9)
    println("myAquarium2 is ${myAquarium2.volume} liters with length ${myAquarium2.length}, width is ${myAquarium2.width}, height is ${myAquarium2.height}")
}

fun feedFish(fish: FishAction) {
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("shark is ${shark.color}, pleco is ${pleco.color}")

    shark.eat()
    pleco.eat()
}