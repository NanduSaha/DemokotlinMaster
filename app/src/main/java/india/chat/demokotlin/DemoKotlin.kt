package india.chat.demokotlin

import android.app.Application
import android.content.Context
import india.chat.demokotlin.Utils.Constants
import india.chat.demokotlin.data.DataManager
import india.chat.demokotlin.di.components.ApplicationComponent
import india.chat.demokotlin.di.components.DaggerApplicationComponent
import india.chat.demokotlin.di.modules.ApplicationModule
import india.chat.demokotlin.di.modules.NetworkModule
import javax.inject.Inject

class DemoKotlin:Application() {



    internal var applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .networkModule(NetworkModule(Constants.baseUrlLive)).build()

    @Inject lateinit var mDataManager: DataManager


    override fun onCreate() {
        super.onCreate()

        applicationComponent.inject(this)


    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)

    }

    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }

    fun getDataManager(): DataManager? {
        return mDataManager
    }




}