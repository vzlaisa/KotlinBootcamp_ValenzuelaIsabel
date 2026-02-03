package aquarium

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(needsProcessed = true) {
    fun addChemicalCleaners() = apply {needsProcessed = false}
}

class FishStoreWater: WaterSupply(needsProcessed = false)

class LakeWater : WaterSupply(needsProcessed = true) {
    fun filter() = apply {needsProcessed = false}
}

class Aquarium2<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        check(waterSupply.needsProcessed) { "water supply needs processed" }
        println("adding water for $waterSupply")
    }
}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun addItemTo(aquarium: Aquarium2<WaterSupply>) = println("item added")

fun genericExample() {
    val cleaner = TapWaterCleaner()
    val aquarium: Aquarium2<TapWater> = Aquarium2(TapWater())
    aquarium.addWater(cleaner)
}