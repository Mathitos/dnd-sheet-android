package dev.mathitos.dndsheet.entities

import java.io.Serializable

class Sheet(var name: String, var race: Race,
            private var classes: MutableMap<RPGClass, Int>, var str: Int, var dec: Int, var con: Int, var int: Int, var wis: Int, var cha: Int): Serializable {
    val level: String
        get() {
            var totalLevel = 0
            classes.forEach { (_, classLevel) ->
                totalLevel += classLevel
            }
            return totalLevel.toString()
        }

    fun levelUp(rpgClass : RPGClass){
        classes[rpgClass] = classes[rpgClass]?.let{it + 1} ?: run {1}
    }
}