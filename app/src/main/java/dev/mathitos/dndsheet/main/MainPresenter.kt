package dev.mathitos.dndsheet.main

class MainPresenter : MainContract.Presenter {
    var view: MainContract.View? = null

    override fun bindView(view: MainContract.View) {
        this.view = view
    }

    override fun unbindView() {
        this.view = null
    }

    override fun onMenuButtonClick() {
        view?.openDrawer()
    }
}