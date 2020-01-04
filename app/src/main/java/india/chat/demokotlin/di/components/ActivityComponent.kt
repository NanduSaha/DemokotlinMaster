package india.chat.demokotlin.di.components

import dagger.Component
import india.chat.demokotlin.di.PerActivity
import india.chat.demokotlin.di.modules.ActivityModule
import india.chat.demokotlin.features.Dashboard.DashboardActivity
import india.chat.demokotlin.features.Home.HomeActivity
import india.chat.demokotlin.features.HomeFragment.HomeFragment
import india.chat.demokotlin.features.ProductDetails.ProductDetailsActivity
import india.chat.demokotlin.features.Splash.SplashActivity


@PerActivity
@Component(dependencies = [ApplicationComponent::class],modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity : SplashActivity)
    fun inject(activity: HomeActivity)
    fun inject(activity:DashboardActivity)
    fun inject(fragment: HomeFragment)
    fun inject(activity:ProductDetailsActivity)
}