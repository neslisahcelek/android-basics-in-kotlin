package generics

interface Cleaner< in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}