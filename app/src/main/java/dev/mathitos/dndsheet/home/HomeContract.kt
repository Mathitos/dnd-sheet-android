package dev.mathitos.dndsheet.home

import dev.mathitos.dndsheet.entities.Sheet

interface HomeContract {
    interface View {
        fun updateSheetsList(newList: MutableList<Sheet>)
        fun showText(text: String)
        fun showSheetPage(sheet: Sheet)
    }
    interface Presenter{
        fun bindView(view: View)
        fun onViewCreated()
        fun onDestroy()
        fun handleOnCreateNewSheetClick()
        fun handleOnSheetClicked(sheet: Sheet)
    }
    interface Interactor{
        fun fetchUserData()
        fun bindPresenter(presenter: Presenter)
        fun unbindPresenter()
    }
}