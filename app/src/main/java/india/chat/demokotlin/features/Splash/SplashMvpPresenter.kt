package india.chat.demokotlin.features.Splash

import india.chat.demokotlin.Shared.MvpPresenter

interface SplashMvpPresenter<V:SplashMvpView>:MvpPresenter<V> {

    fun decideNavigation()
}