package india.chat.demokotlin.di.modules

import android.util.Log
import dagger.Module
import dagger.Provides
import india.chat.demokotlin.Shared.BasicAuthInterceptor
import india.chat.demokotlin.Utils.AppData
import india.chat.demokotlin.data.network.ApiHelper
import india.chat.demokotlin.di.WithAuth
import india.chat.demokotlin.di.WithOutAuth
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule(private val baseUrl: String) {
    @Singleton
    @Provides
    internal fun provideRetrofit(@WithOutAuth httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }


    @Singleton
    @Provides
    @WithAuth
    internal fun provideHttpClient(logging: HttpLoggingInterceptor, interceptor: BasicAuthInterceptor): OkHttpClient {

        Log.d("Nandita", "Calling")
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.addInterceptor(interceptor)
        httpClient.connectTimeout(10000, TimeUnit.SECONDS)
        httpClient.readTimeout(10000, TimeUnit.SECONDS)
        return httpClient.build()

    }

    @Singleton
    @Provides
    @WithOutAuth
    internal fun provideHttpClientWithoutAuth(logging: HttpLoggingInterceptor): OkHttpClient {
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.connectTimeout(200, TimeUnit.SECONDS)
        httpClient.readTimeout(200, TimeUnit.SECONDS)
        return httpClient.build()

    }

    @Singleton
    @Provides
    internal fun provideLogInterceptor(): HttpLoggingInterceptor {

        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d("OkHttp", message) })
    }


    @Singleton
    @Provides
    internal fun provideAuthInterceptor(): BasicAuthInterceptor {
        return BasicAuthInterceptor(AppData.USERNAME, AppData.APP_SECRET)
    }

    @Singleton
    @Provides
    internal fun provideApiHelper(retrofit: Retrofit): ApiHelper {
        return retrofit.create(ApiHelper::class.java)
    }

}