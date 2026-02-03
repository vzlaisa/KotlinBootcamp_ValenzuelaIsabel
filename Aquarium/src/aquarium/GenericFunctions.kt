package aquarium

open class WaterSupply2(var needsProcessed: Boolean)

class TapWater2 : WaterSupply2(needsProcessed = true) {
    fun addChemicalCleaners() = apply {needsProcessed = false}
}

class FishStoreWater2: WaterSupply2(needsProcessed = false)

class LakeWater2 : WaterSupply2(needsProcessed = true) {
    fun filter() = apply {needsProcessed = false}
}

class Aquarium3<out T: WaterSupply2>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessed) { "water supply needs processed" }
        println("adding water for $waterSupply")
    }
}


fun <T: WaterSupply2> isWaterClean(aquarium: Aquarium3<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

inline fun <reified T: WaterSupply2> WaterSupply2.isOfType() = this is T

fun genericExample2() {
    val aquarium: Aquarium3<TapWater2> = Aquarium3(TapWater2())
    isWaterClean(aquarium)

    aquarium.waterSupply.isOfType<LakeWater2>()
}