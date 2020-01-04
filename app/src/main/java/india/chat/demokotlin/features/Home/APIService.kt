package india.chat.demokotlin.features.Home

import india.chat.demokotlin.data.network.model.CategoryProduct.CategoryProductResponse
import india.chat.demokotlin.data.network.model.Feature.FeatureResponse
import india.chat.demokotlin.data.network.model.Feature.featurerequest
import india.chat.demokotlin.data.network.model.MainCategory.MainCategoryRequest
import india.chat.demokotlin.data.network.model.MainCategory.MainCategoryResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {


    @POST("category/products")
    fun getCategoryProductList():Call<CategoryProductResponse>

    @POST("feature/products")
    fun getFeatureData(@Body request: featurerequest):Call<FeatureResponse>

    @POST("categories")
    fun getMainCategoryData(@Body request: MainCategoryRequest):Call<MainCategoryResponse>

}