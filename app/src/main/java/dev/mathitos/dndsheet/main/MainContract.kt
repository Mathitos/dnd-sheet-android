package dev.mathitos.dndsheet.main

interface MainContract {
    interface View {
        fun openDrawer()

    }

    interface Presenter {
        fun bindView(view: View)
        fun onMenuButtonClick()
    }
}