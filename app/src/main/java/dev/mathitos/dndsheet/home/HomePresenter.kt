package dev.mathitos.dndsheet.home

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

    override fun handleOnSheetClicked(index: Int) {
        this.view?.showSheetPage()
    }
}