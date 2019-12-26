package dev.mathitos.dndsheet.setting

class SettingPresenter : SettingContract.Presenter {
    private var view: SettingContract.View? = null

    override fun bindView(view: SettingContract.View) {
        this.view = view
    }

    override fun unbindView() {
        this.view = null
    }

    override fun handleLogOutSucess() {
        this.view?.showText("Logged Out")
        this.view?.sendToLoginScreen()
    }

    override fun handleLogoutButtonClicked() {
        this.view?.logOut()
    }

}