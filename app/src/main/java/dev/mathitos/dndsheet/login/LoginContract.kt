package dev.mathitos.dndsheet.login

interface LoginContract {
    interface View {
        fun sendToMainScreen()
        fun showLoginScreen()
        fun showMessage(text:String)
    }

    interface Presenter {
        fun bindView(view: View)
        fun unbindView()
        fun onLoginSuccessful()
        fun onLoginFailed()
        fun userLogged()
        fun userNotLogged()
    }
}