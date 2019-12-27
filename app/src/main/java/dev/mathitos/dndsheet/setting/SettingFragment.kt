package dev.mathitos.dndsheet.setting

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.firebase.ui.auth.AuthUI
import dev.mathitos.dndsheet.R
import dev.mathitos.dndsheet.login.LoginActivity
import dev.mathitos.dndsheet.main.MainActivity

class SettingFragment : Fragment(), SettingContract.View {

    private lateinit var presenter: SettingContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = SettingPresenter()
        presenter.bindView(this)

        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButtonListeners()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()

    }

    override fun logOut() {
        activity?.let {
            AuthUI.getInstance()
                .signOut(it)
                .addOnCompleteListener {
                    presenter.handleLogOutSucess()
                }
        }
    }

    override fun sendToLoginScreen() {
        activity?.let { startActivity(Intent(it, LoginActivity::class.java)) }
    }

    private fun addButtonListeners() {
        val logoutButton = activity?.findViewById<Button>(R.id.logout_button)
        logoutButton?.setOnClickListener {
            presenter.handleLogoutButtonClicked()
        }
    }

    override fun showText(text: String) {
        (activity as? MainActivity)?.showText(text)
    }
}