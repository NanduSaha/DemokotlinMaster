package india.chat.demokotlin.data.network.model.CategoryProduct

import com.google.gson.annotations.SerializedName

data class Featured (

    @SerializedName("cat_id") val cat_id : Int,
    @SerializedName("p_id") val p_id : Int,
    @SerializedName("p_name") val p_name : String,
    @SerializedName("p_img") val p_img : List<String>,
    @SerializedName("p_price") val p_price : Double,
    @SerializedName("sale_price") val sale_price : String
)

data class Hotsellingproducts (

    @SerializedName("cat_id") val cat_id : Int,
    @SerializedName("p_id") val p_id : Int,
    @SerializedName("p_name") val p_name : String,
    @SerializedName("p_img") val p_img : List<String>,
    @SerializedName("p_price") val p_price : Double,
    @SerializedName("sale_price") val sale_price : String
)

data class CategoryProductResponse (

    @SerializedName("responseCode") val responseCode : Int,
    @SerializedName("responseText") val responseText : String,
    @SerializedName("responseData") val responseData : ResponseData
)

data class Newarrival (

    @SerializedName("cat_id") val cat_id : Int,
    @SerializedName("p_id") val p_id : Int,
    @SerializedName("p_name") val p_name : String,
    @SerializedName("p_img") val p_img : List<String>,
    @SerializedName("p_price") val p_price : Double,
    @SerializedName("sale_price") val sale_price : String
)

data class Otherproducts (

    @SerializedName("cat_id") val cat_id : Int,
    @SerializedName("p_id") val p_id : Int,
    @SerializedName("p_name") val p_name : String,
    @SerializedName("p_img") val p_img : List<String>,
    @SerializedName("p_price") val p_price : Double,
    @SerializedName("sale_price") val sale_price : String
)

data class ResponseData (

    @SerializedName("featured") val featured : List<Featured>,
    @SerializedName("newarrival") val newarrival : List<Newarrival>,
    @SerializedName("otherproducts") val otherproducts : List<Otherproducts>,
    @SerializedName("hotsellingproducts") val hotsellingproducts : List<Hotsellingproducts>
)