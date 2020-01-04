package india.chat.demokotlin.Shared

import androidx.annotation.StringRes

interface MvpView {
    val isNetworkConnected: Boolean

    fun showLoading()

    fun hideLoading()

    fun onError(@StringRes resId: Int)

    fun onError(message: String)

    fun showMessage(message: String)

    fun showAlert(message: String)

    fun showInactiveUserAlert(message: String)

    fun showMessage(@StringRes resId: Int)

    fun hideKeyboard()

    fun logOut()
}