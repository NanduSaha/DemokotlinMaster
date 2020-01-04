package india.chat.demokotlin.data.network.model.MainCategory

import com.google.gson.annotations.SerializedName




data class MainCategoryResponse (

    @SerializedName("responseCode") val responseCode : Int,
    @SerializedName("responseText") val responseText : String,
    @SerializedName("CategoryList") val categoryList : List<CategoryList>
)

data class CategoryList (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("image") val image : String,
    @SerializedName("subcategory") val subcategory : Boolean
)