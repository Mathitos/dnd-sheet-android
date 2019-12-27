package dev.mathitos.dndsheet.entities

class Sheet(var name: String, var race: Race,var classes: MutableMap<RPGClass, Int>, var str: Int, var dec: Int,var con: Int,var int: Int,var wis: Int,var cha: Int) {
    val level: Int
        get() {
            var totalLevel = 0
            classes.forEach { (_, classLevel) ->
                totalLevel += classLevel
            }
            return totalLevel
        }

    fun levelUp(rpgClass : RPGClass){
        classes[rpgClass] = classes[rpgClass]?.let{it + 1} ?: run {1}
    }
}