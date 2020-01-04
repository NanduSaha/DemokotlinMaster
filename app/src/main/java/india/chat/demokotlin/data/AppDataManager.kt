package india.chat.demokotlin.data

import android.content.Context
import india.chat.demokotlin.data.network.ApiHelper
import india.chat.demokotlin.data.network.model.Banner.BannerResponse
import india.chat.demokotlin.data.network.model.CategoryProduct.CategoryProductResponse
import india.chat.demokotlin.data.network.model.Feature.FeatureResponse
import india.chat.demokotlin.data.network.model.Feature.featurerequest
import india.chat.demokotlin.data.network.model.MainCategory.MainCategoryRequest
import india.chat.demokotlin.data.network.model.MainCategory.MainCategoryResponse
import india.chat.demokotlin.data.network.model.Otp.OtpRequest
import india.chat.demokotlin.data.network.model.Otp.OtpResponse
import india.chat.demokotlin.data.network.model.ProductDetails.ProductDetailsResponse
import india.chat.demokotlin.data.network.model.updateCart.UpdateCartRequest
import india.chat.demokotlin.data.network.model.updateCart.UpdateCartResponse
import india.chat.demokotlin.data.pref.PreferencesHelper
import india.chat.demokotlin.di.ApplicationContext
import retrofit2.Call
import javax.inject.Inject

class AppDataManager:DataManager {


    override fun getProductDetails(url: String): Call<ProductDetailsResponse> {
        return mApiHelper.getProductDetails(url)
    }


    var mApiHelper: ApiHelper
    var mPreferencerHelper: PreferencesHelper
    var mContext: Context


    @Inject
    constructor(mApiHelper: ApiHelper, mPreferencerHelper: PreferencesHelper, @ApplicationContext mContext: Context) {
        this.mApiHelper = mApiHelper
        this.mPreferencerHelper = mPreferencerHelper
        this.mContext = mContext
    }


    override fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserId(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserId(userId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentFirstName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentFirstName(firstName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentLastName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentLastName(lastName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentMobileNumber(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentMobileNumber(lastName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserEmail(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserEmail(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserProfilePicUrl(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserProfilePicUrl(profilePicUrl: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserGender(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserGender(gender: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLastIntaractionTimestamp(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLastIntaractionTimestamp(timeStamp: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroyPref() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRegistrationType(registrationType: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRegistrationType(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFeatureData(request: featurerequest): Call<FeatureResponse> {
        return mApiHelper.getFeatureData(request)
    }

    override fun getMainCategoryData(request: MainCategoryRequest): Call<MainCategoryResponse> {
        return mApiHelper.getMainCategoryData(request)
    }

    override fun getBannerData(): Call<BannerResponse> {
        return mApiHelper.getBannerData()
    }

    override fun getLogin(request: OtpRequest): Call<OtpResponse> {
       return mApiHelper.getLogin(request)
    }
    override fun getCategoryProductList(): Call<CategoryProductResponse> {
        return  mApiHelper.getCategoryProductList()
    }

    override fun getBannerList(): Call<BannerResponse> {
        return mApiHelper.getBannerList()
    }

    override fun getUpdateCart(updateCartRequest: UpdateCartRequest): Call<UpdateCartResponse> {
       return  mApiHelper.getUpdateCart(updateCartRequest)
    }
}