package dev.mathitos.dndsheet.entities

enum class RPGClass {
    Warrior {
        override fun talent() = listOf<String>()
    },

    Barbarian {
        override fun talent() = listOf<String>()
    };

    abstract fun talent(): List<String>
}