package dev.mathitos.dndsheet.login

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import dev.mathitos.dndsheet.R
import dev.mathitos.dndsheet.main.MainActivity

class LoginActivity: AppCompatActivity(), LoginContract.View {
    private lateinit var presenter: LoginPresenter

    private lateinit var firebaseAuth: FirebaseAuth
    private var authStateListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        firebaseAuth = FirebaseAuth.getInstance()
        createAuthStateListener()

        presenter = LoginPresenter()
        presenter.bindView(this)
    }

    override fun onResume() {
        super.onResume()
        authStateListener?.let { firebaseAuth.addAuthStateListener(it) }
    }

    override fun onPause() {
        super.onPause()
        authStateListener?.let { firebaseAuth.removeAuthStateListener(it) }
    }

    override fun sendToMainScreen() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
    }

    override fun showLoginScreen() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build())

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == Activity.RESULT_OK) {
                presenter.onLoginSuccessful()
            } else {
                presenter.onLoginFailed()
            }
        }
    }

    private fun createAuthStateListener(){
        authStateListener = FirebaseAuth.AuthStateListener {
                firebaseAuth ->
            if(firebaseAuth.currentUser != null) {
                presenter.userLogged()
            } else {
                presenter.userNotLogged()
            }
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showMessage (text: String){
        Toast.makeText(this@LoginActivity, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val RC_SIGN_IN: Int = 1111
    }
}