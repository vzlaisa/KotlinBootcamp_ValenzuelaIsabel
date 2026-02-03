open class BaseBuildingMaterial(open val numberNeeded: Int = 1)

class Wood: BaseBuildingMaterial(4)

class Brick: BaseBuildingMaterial(8)

class Building<out T : BaseBuildingMaterial>(val material: T) {
    val baseMaterialsNeeded : Int = 100

    val actualMaterialsNeeded : Int
        get() = baseMaterialsNeeded * material.numberNeeded

    fun build() = println("type is ${material::class.simpleName}, number needed is $actualMaterialsNeeded")
}

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) {
        println("small building")
    } else {
        println("large building")
    }
}

fun main(args: Array<String>) {
    val building : Building<BaseBuildingMaterial> = Building(Wood())
    building.build()

    isSmallBuilding(Building(Brick()))
}