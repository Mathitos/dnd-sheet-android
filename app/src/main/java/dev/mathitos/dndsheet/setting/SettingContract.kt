package dev.mathitos.dndsheet.setting

interface SettingContract {
    interface View{
        fun logOut()
        fun sendToLoginScreen()
        fun showText(text: String)
    }

    interface Presenter {
        fun bindView(view: View)
        fun onDestroy()
        fun handleLogOutSucess()
        fun handleLogoutButtonClicked()
    }
}