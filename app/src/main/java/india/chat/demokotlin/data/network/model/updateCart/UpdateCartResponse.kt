package india.chat.demokotlin.data.network.model.updateCart

import com.google.gson.annotations.SerializedName

data class ResponseData (

    @SerializedName("id") val id : Int,
    @SerializedName("user_id") val user_id : Int,
    @SerializedName("product_id") val product_id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("description") val description : String,
    @SerializedName("image") val image : List<String>,
    @SerializedName("quatity") val quatity : Int,
    @SerializedName("price") val price : Double,
    @SerializedName("totalPrice") val totalPrice : Double,
    @SerializedName("attribute") val attribute : String
)

data class UpdateCartResponse (

    @SerializedName("responseCode") val responseCode : Int,
    @SerializedName("responseText") val responseText : String,
    @SerializedName("cartitems") val cartitems : Int,
    @SerializedName("responseData") val responseData : List<ResponseData>
)