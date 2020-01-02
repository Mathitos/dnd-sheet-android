package dev.mathitos.dndsheet.home

import dev.mathitos.dndsheet.entities.Sheet

class HomePresenter: HomeContract.Presenter {
    private var view: HomeContract.View? = null
    private var interactor: HomeContract.Interactor? = null

    override fun bindView(view: HomeContract.View) {
        this.view = view
    }

    override fun onViewCreated() {
        this.interactor = HomeInteractor()
        interactor?.bindPresenter(this)
    }

    override fun onDestroy() {
        this.interactor?.unbindPresenter()
        this.view = null
        this.interactor = null
    }

    override fun handleOnCreateNewSheetClick() {
        this.view?.showText("TODO: create new clicked")
    }

    override fun handleOnSheetClicked(sheet: Sheet) {
        this.view?.showSheetPage(sheet)
    }
}