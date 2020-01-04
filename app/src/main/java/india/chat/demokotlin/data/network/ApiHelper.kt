package india.chat.demokotlin.data.network

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
import retrofit2.Call
import retrofit2.http.*

interface ApiHelper {

    @POST("category/products")
     fun getCategoryProductList(): Call<CategoryProductResponse>

    @POST("bannerimage")
    fun getBannerList(): Call<BannerResponse>


    @Headers("Authorization: Basic Y2tfODgzOTBlNTI0ZmJiYTMzNDZlZTU0MzBiNjRjMzVlN2RjMTZhOWU2ODpjc18xNjQ3ZDY0ODkwMTg1NWRjODRjNGFjODM3MThmMjdkYWE0NTI2ZmMw")
    @GET
    fun getProductDetails(@Url url: String): Call<ProductDetailsResponse>

    @POST("cart/update")
     fun getUpdateCart(@Body updateCartRequest: UpdateCartRequest): Call<UpdateCartResponse>


    @POST("feature/products")
    fun getFeatureData(@Body request: featurerequest): Call<FeatureResponse>

    @POST("categories")
    fun getMainCategoryData(@Body request: MainCategoryRequest): Call<MainCategoryResponse>

    @POST("bannerimage")
    fun getBannerData():Call<BannerResponse>

    @POST("otp/verify")
    fun getLogin(@Body request:OtpRequest):Call<OtpResponse>

}

