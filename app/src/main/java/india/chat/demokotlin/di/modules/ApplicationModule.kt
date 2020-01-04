package india.chat.demokotlin.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import india.chat.demokotlin.data.AppDataManager
import india.chat.demokotlin.data.DataManager
import india.chat.demokotlin.data.pref.AppPreferencesHelper
import india.chat.demokotlin.data.pref.PreferencesHelper
import india.chat.demokotlin.di.ApplicationContext
import javax.inject.Singleton

@Module
class ApplicationModule (private val mApplication: Application){

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }

    @Provides
    fun provideApplication(): Application {
        return mApplication
    }

    @Singleton
    @Provides
    fun providePrefHelper(mAppPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return mAppPreferencesHelper
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }



}