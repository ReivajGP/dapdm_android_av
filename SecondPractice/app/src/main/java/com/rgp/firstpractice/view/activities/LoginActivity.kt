package com.rgp.firstpractice.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rgp.firstpractice.databinding.ActivityLoginBinding
import com.rgp.firstpractice.helpers.AuthenticationHelper
import com.rgp.firstpractice.utils.Constants
import com.rgp.firstpractice.helpers.LoaderHelper
import com.rgp.firstpractice.helpers.ToastHelper

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loaderHelper: LoaderHelper
    private lateinit var authenticationHelper: AuthenticationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instantiateProperties()
        setContentView(binding.root)
        setupView()
        setButtonClickListeners()
    }

    private fun setupView() {
        loaderHelper.hideLoader()
    }

    private fun instantiateProperties() {
        // ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)

        // Authentication helper
        authenticationHelper = AuthenticationHelper(this)

        // Loader helper
        val toShowViews: Array<View> = arrayOf(binding.background)
        val toHideViews: Array<View> = arrayOf(binding.btLogIn, binding.btSignIn, binding.btRecoverPass)
        loaderHelper = LoaderHelper(binding.laLoader, toShowViews, toHideViews)
    }

    private fun setButtonClickListeners() {
        // Inicio de sesión
        binding.btLogIn.setOnClickListener {
            if (areTextFieldsEntriesValid()) {
                loaderHelper.presentLoader()
                authenticationHelper.logIn(binding.etEmail.text.toString(), binding.etPassword.text.toString()) { isLoginSuccessful ->
                    loaderHelper.hideLoader()
                    if (isLoginSuccessful) {
                        // TODO: Pasar a la pantalla de catálogo
                        val intent = Intent(this, LyricsCatalogActivity::class.java).apply {
                            putExtra(Constants.INTENT_USER_ID, binding.etEmail.text.toString())
                        }
                        startActivity(intent)
                        finish()
                    } else {

                    }
                }
            }
        }

        // Registro
        binding.btSignIn.setOnClickListener {
            if (areTextFieldsEntriesValid()) {
                loaderHelper.presentLoader()
                authenticationHelper.signIn(binding.etEmail.text.toString(), binding.etPassword.text.toString()) { isSignUpSuccessful ->
                    loaderHelper.hideLoader()
                    if (isSignUpSuccessful) {
                        // TODO: Ver qué hacer aquí 🥲
                    } else {

                    }
                }
            }
        }

        // Recuperación de contraseña
        binding.btRecoverPass.setOnClickListener {
            authenticationHelper.recoverPassword(binding.etEmail.text.toString())
        }
    }

    private fun areTextFieldsEntriesValid(): Boolean {
        if (binding.etEmail.text.isEmpty() || binding.etPassword.text.isEmpty()) {
            ToastHelper(this).showToast(Constants.ON_EMPTY_FIELD_TOAST_MESSAGE)
            return false
        }
        return true
    }

    // TODO: Quitar esto: informaticorp80@gmail.com
}