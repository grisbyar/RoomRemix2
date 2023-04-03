package com.example.roomremix2.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.example.roomremix2.data.LoginRepository
import com.example.roomremix2.data.Result

import com.example.roomremix2.R

sealed class LoginViewState {
    object Loading : LoginViewState()
    data class Error(val message: Int) : LoginViewState()
    data class Success(val displayName: String) : LoginViewState()
}

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginViewState>()
    val loginResult: LiveData<LoginViewState> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value = LoginViewState.Success(result.data.displayName)
        } else {
            _loginResult.value = LoginViewState.Error(R.string.login_failed)
        }
    }

    fun loginDataChanged(username: String, password: String) {
        val isValidEmail = username.isValidEmail()
        val isPasswordValid = password.length > 5

        _loginForm.value = when {
            !isValidEmail -> LoginFormState(usernameError = R.string.invalid_username)
            !isPasswordValid -> LoginFormState(passwordError = R.string.invalid_password)
            else -> LoginFormState(isDataValid = true)
        }
    }

    private fun String.isValidEmail(): Boolean {
        return if (this.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(this).matches()
        } else {
            this.isNotBlank()
        }
    }
}
