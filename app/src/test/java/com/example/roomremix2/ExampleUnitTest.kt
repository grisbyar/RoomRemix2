package com.example.roomremix2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.roomremix2.data.LoginRepository
import com.example.roomremix2.ui.login.LoginViewModel
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import com.example.roomremix2.ui.login.LoginFormState
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations.openMocks

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
class LoginViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var loginRepository: LoginRepository
    private lateinit var loginViewModel: LoginViewModel
    private val username = "testuser"
    private val password = "testpassword"
    @Before
    fun setup(){
        openMocks(this)
        loginViewModel = LoginViewModel(loginRepository)
    }
    @Test
    fun usernameInvalid(){
        loginViewModel.loginDataChanged("","testpassword")
        assertEquals(LoginFormState(usernameError = R.string.invalid_username),
        loginViewModel.loginFormState.value)
    }
    @Test
    fun passwordInvalid(){
        loginViewModel.loginDataChanged("testuser","")
        assertEquals(LoginFormState(passwordError = R.string.invalid_password),
        loginViewModel.loginFormState.value)
    }
    @Test
    fun loginDataChangeValid(){
        val observer = mock(Observer::class.java) as Observer<LoginFormState>
        loginViewModel.loginFormState.observeForever(observer)
        loginViewModel.loginDataChanged("testuser", "testpassword")
        verify(observer, times(1)).onChanged(any(LoginFormState::class.java))
    }
    @Test
    fun invalidusernameerrorgeneration(){
        loginViewModel.loginDataChanged("", password)
        val loginFormState = loginViewModel.loginFormState.value

        assertEquals(loginFormState?.isDataValid, false)
        assertEquals(loginFormState?.usernameError, R.string.invalid_username)
        assertEquals(loginFormState?.passwordError, null)
    }
}