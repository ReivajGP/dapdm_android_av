package com.rgp.firstpractice.helpers

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthException
import com.rgp.firstpractice.utils.Constants

class AuthErrorHandler {

    fun handleError(result: Task<AuthResult>) : String {
        var errorCause: String = String()

        try{
            errorCause = (result.exception as FirebaseAuthException).errorCode
        } catch(e: Exception) {
            errorCause = Constants.AUTH_MESSAGE_NO_NETWORK
        }

        when(errorCause) {
            Constants.AUTH_ERROR_INVALID_EMAIL -> {
                return Constants.AUTH_MESSAGE_INVALID_EMAIL
            }

            Constants.AUTH_ERROR_WRONG_PASSWORD -> {
                return Constants.AUTH_MESSAGE_WRONG_PASSWORD
            }

            Constants.AUTH_ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_PROVIDER -> {
                return Constants.AUTH_MESSAGE_ACCOUNT_EXISTS_WITH_DIFFERENT_PROVIDER
            }

            Constants.AUTH_ERROR_EMAIL_IN_USE -> {
                return Constants.AUTH_MESSAGE_EMAIL_IN_USE
            }

            Constants.AUTH_ERROR_TOKEN_EXPIRED -> {
                return Constants.AUTH_MESSAGE_TOKEN_EXPIRED
            }

            Constants.AUTH_ERROR_USER_NOT_FOUND -> {
                return Constants.AUTH_MESSAGE_USER_NOT_FOUND
            }

            Constants.AUTH_ERROR_WEAK_PASSWORD -> {
                return Constants.AUTH_MESSAGE_WEAK_PASSWORD
            }

            Constants.NO_NETWORK -> {
                return Constants.AUTH_MESSAGE_NO_NETWORK
            }
        }

        return String()
    }
}