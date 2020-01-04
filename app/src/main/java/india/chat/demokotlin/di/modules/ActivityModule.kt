package india.chat.demokotlin.di.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.india.deveshsarees.feature.Home.FeaturedListAdapter
import dagger.Module
import dagger.Provides
import india.chat.demokotlin.data.network.model.CategoryProduct.Featured
import india.chat.demokotlin.di.ActivityContext
import india.chat.demokotlin.di.PerActivity
import india.chat.demokotlin.features.Dashboard.DashboardMvpPresenter
import india.chat.demokotlin.features.Dashboard.DashboardMvpView
import india.chat.demokotlin.features.Dashboard.DashboardPresenter
import india.chat.demokotlin.features.Home.HomeMvpPresenter
import india.chat.demokotlin.features.Home.HomeMvpView
import india.chat.demokotlin.features.Home.HomePresenter
import india.chat.demokotlin.features.ProductDetails.ProductDetailsMvpPresenter
import india.chat.demokotlin.features.ProductDetails.ProductDetailsMvpView
import india.chat.demokotlin.features.ProductDetails.ProductDetailsPresenter
import india.chat.demokotlin.features.Splash.SplashMvpPresenter
import india.chat.demokotlin.features.Splash.SplashMvpView
import india.chat.demokotlin.features.Splash.SplashPresenter

@Module
class ActivityModule(private val mActivity: AppCompatActivity) : FeaturedListAdapter.FeaturedListListner {
    override fun onItemClickFeature(sCatId: String, pId: String) {

    }

    @Provides
    @ActivityContext
    internal fun provideContext(): Context {
        return mActivity
    }

    @Provides
    internal fun provideActivity(): AppCompatActivity {
        return mActivity
    }


    @Provides
    @PerActivity
    internal fun provideSplashMvpPresenter(presenter: SplashPresenter<SplashMvpView>): SplashMvpPresenter<SplashMvpView> {
        return presenter
    }
    @Provides
    @PerActivity
    internal fun provideHomeMvpPresenter(presenter: HomePresenter<HomeMvpView>): HomeMvpPresenter<HomeMvpView> {
        return presenter
    }

    @Provides
    @PerActivity
    internal fun provideDashboardMvpPresenter(presenter: DashboardPresenter<DashboardMvpView>): DashboardMvpPresenter<DashboardMvpView> {
        return presenter
    }

    @Provides
    @PerActivity
    internal fun provideProductDetailsPresenter(presenter: ProductDetailsPresenter<ProductDetailsMvpView>): ProductDetailsMvpPresenter<ProductDetailsMvpView> {
        return presenter
    }


//    @Provides
//    internal fun provideShipping_Fragment(): HomeFragment {
//        return HomeFragment()
//    }




    @Provides
    internal fun provideFeatureListAdapter(): FeaturedListAdapter {
        return FeaturedListAdapter(ArrayList<Featured>(),this)
    }
//
//    @Provides
//    internal fun provideCateListAdapter(): MainCategoryAdapter {
//        return MainCategoryAdapter(ArrayList<CategoryList>(),this)
//    }


}