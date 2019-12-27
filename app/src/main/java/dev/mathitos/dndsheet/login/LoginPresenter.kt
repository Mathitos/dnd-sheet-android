package dev.mathitos.dndsheet.login

class LoginPresenter: LoginContract.Presenter {
    private var view: LoginContract.View? = null

    override fun bindView(view: LoginContract.View) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun onLoginSuccessful() {
        this.view?.sendToMainScreen()
    }

    override fun onLoginFailed() {
        this.view?.showMessage("login failed")
    }

    override fun userLogged() {
        this.view?.sendToMainScreen()
    }

    override fun userNotLogged() {
        this.view?.showLoginScreen()
    }

}