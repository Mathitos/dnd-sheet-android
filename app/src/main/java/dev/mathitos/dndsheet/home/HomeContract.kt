package dev.mathitos.dndsheet.home

import dev.mathitos.dndsheet.entities.Sheet

interface HomeContract {
    interface View {
        fun updateSheetsList(newList: MutableList<Sheet>)
    }
    interface Presenter{
        fun bindView(view: View)
        fun onViewCreated()
        fun onDestroy()
        fun handleOnCreateNewSheetClick()
        fun handleOnSheetClicked(index: Int)
    }
    interface Interactor{
        fun fetchUserData()
        fun bindPresenter(presenter: Presenter)
        fun unbindPresenter()
    }
}