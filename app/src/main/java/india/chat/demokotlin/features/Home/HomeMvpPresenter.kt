package india.chat.demokotlin.features.Home

import india.chat.demokotlin.Shared.MvpPresenter

interface HomeMvpPresenter<V:HomeMvpView>:MvpPresenter<V> {

    fun onFeatureListFetch(userId:String)
    fun onCatListFetch(userId: String)
    fun onBannerListFech()
    fun onLoginClick()

}