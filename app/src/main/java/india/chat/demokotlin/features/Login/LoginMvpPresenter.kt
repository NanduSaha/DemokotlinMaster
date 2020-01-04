package india.chat.demokotlin.features.Login

import india.chat.demokotlin.Shared.MvpPresenter

interface LoginMvpPresenter<V:LoginMvpView>:MvpPresenter<V> {
    fun decidenaviagetionToOtp(phonNumber:String,deviceType:String,deviceToken:String)
}