package india.chat.demokotlin.di.components

import android.app.Application
import android.content.Context
import dagger.Component
import india.chat.demokotlin.DemoKotlin
import india.chat.demokotlin.data.DataManager
import india.chat.demokotlin.di.ApplicationContext
import india.chat.demokotlin.di.modules.ApplicationModule
import india.chat.demokotlin.di.modules.NetworkModule
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class,NetworkModule::class])
interface ApplicationComponent {

    val dataManager:DataManager

    fun inject(app: DemoKotlin)

    @ApplicationContext
    fun context(): Context

    fun application(): Application
}