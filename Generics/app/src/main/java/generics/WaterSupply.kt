package generics

fun genericsExample(){
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium(TapWater())
    aquarium.addWater(cleaner)
}

class Aquarium<out T: WaterSupply> (val waterSupply: T){ //out=just used as return value
    fun addWater(cleaner: Cleaner<T>){
        check(!waterSupply.needsProcessing){"water supply needs processing before adding"}
        //if needsProcessing=true, it throws exception
        if (waterSupply.needsProcessing){
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }
}

open class WaterSupply(var needsProcessing: Boolean) {

}
class TapWater : WaterSupply(true){
    fun addChemicalCleaners(){
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(true){

}
class LakeWater : WaterSupply(false){
    fun filter(){
        needsProcessing = false
    }
}
