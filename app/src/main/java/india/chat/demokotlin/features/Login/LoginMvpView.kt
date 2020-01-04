package india.chat.demokotlin.features.Login

import india.chat.demokotlin.Shared.MvpView
import india.chat.demokotlin.data.network.model.Otp.OtpResponse

interface LoginMvpView:MvpView {
    fun navigateToOtp(otpResponse: OtpResponse)
}