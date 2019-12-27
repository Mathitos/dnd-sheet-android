package dev.mathitos.dndsheet.setting

interface SettingContract {
    interface View{
        fun logOut()
        fun sendToLoginScreen()
        fun showText(text: String)
    }

    interface Presenter {
        fun bindView(view: View)
        fun unbindView()
        fun handleLogOutSucess()
        fun handleLogoutButtonClicked()
    }
}