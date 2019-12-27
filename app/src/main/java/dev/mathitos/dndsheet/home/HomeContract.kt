package dev.mathitos.dndsheet.home

interface HomeContract {
    interface View {

    }
    interface Presenter{
        fun bindView(view: View)
        fun onViewCreated()
        fun onDestroy()
        fun handleOnCreateNewSheetClick()
        fun handleOnLoadSheetClick()
    }
    interface Interactor{
        fun fetchUserData()
        fun bindPresenter(presenter: Presenter)
        fun unbindPresenter()
    }
}