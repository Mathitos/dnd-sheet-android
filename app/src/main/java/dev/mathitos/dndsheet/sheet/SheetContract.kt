package dev.mathitos.dndsheet.sheet

interface SheetContract {
    interface View {

    }
    interface Presenter {
        fun bindView(view: View)
    }
}
