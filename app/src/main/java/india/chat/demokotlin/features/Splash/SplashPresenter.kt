package india.chat.demokotlin.features.Splash

import android.os.Handler
import india.chat.demokotlin.Shared.BasePresenter
import india.chat.demokotlin.data.DataManager
import javax.inject.Inject

class SplashPresenter<V:SplashMvpView> @Inject
constructor(mdataManager: DataManager) : BasePresenter<V>(mdataManager), SplashMvpPresenter<V> {
    override fun decideNavigation() {
      Navigate()
    }


    private fun Navigate() {
        Handler().postDelayed({ getMvpView()?.goToDeshboard() }, 2000)
    }
}