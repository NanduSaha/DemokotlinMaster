package india.chat.demokotlin.features.Splash

import android.os.Bundle
import butterknife.ButterKnife
import india.chat.demokotlin.R
import india.chat.demokotlin.Shared.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(),SplashMvpView {


    @Inject
    lateinit var splashPresenter: SplashPresenter<SplashMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_same_category)

        setUnBinder(ButterKnife.bind(this))
        activityComponent?.inject(this)
        setUp()


    }
    protected fun setUp()
    {
        splashPresenter.onAttach(this)
        splashPresenter.decideNavigation()
    }
     override fun onDestroy() {

         splashPresenter!!.onDetach()

        super.onDestroy()
    }

    override fun goToDeshboard() {
     //   val intent = Intent(applicationContext, HomeActivity::class.java)
     //   startActivity(intent)
     //   finish()
    }

}
