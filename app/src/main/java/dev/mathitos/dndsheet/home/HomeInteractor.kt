package dev.mathitos.dndsheet.home

class HomeInteractor: HomeContract.Interactor {
    private var presenter: HomeContract.Presenter? = null

    override fun fetchUserData() {

    }

    override fun bindPresenter(presenter: HomeContract.Presenter) {
        this.presenter = presenter
    }

    override fun unbindPresenter() {
        this.presenter = null
    }
}