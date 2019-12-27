package dev.mathitos.dndsheet.home

class HomePresenter: HomeContract.Presenter {
    private var view: HomeContract.View? = null
    private var interactor: HomeContract.Interactor? = null

    override fun bindView(view: HomeContract.View) {
        this.view = view
    }

    override fun unbindView() {
        this.view = null
    }

    override fun onViewCreated() {
        this.interactor = HomeInteractor()
        interactor?.bindPresenter(this)
    }

    override fun onDestroy() {
        this.view = null
        this.interactor = null
    }
}