package dev.mathitos.dndsheet.entities

enum class Race {
    Human {
        override fun talent() = listOf<String>()
    },

    Elf {
        override fun talent() = listOf<String>()
    };

    abstract fun talent(): List<String>
}