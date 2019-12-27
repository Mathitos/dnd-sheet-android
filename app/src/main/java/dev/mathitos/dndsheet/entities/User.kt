package dev.mathitos.dndsheet.entities

class User(var name: String) {
    var sheets: MutableList<Sheet> = mutableListOf()

    fun addSheet(newSheet: Sheet) {
        this.sheets.add(newSheet)
    }

    fun deleteSheet(sheetIndex: Int){
        this.sheets.removeAt(sheetIndex)
    }
}