package india.chat.demokotlin.data.network.model.updateCart

import com.google.gson.annotations.SerializedName



    data class UpdateCartRequest (

        @SerializedName("attribute") val attribute : String,
        @SerializedName("price") val price : String,
        @SerializedName("product_desc") val product_desc : String,
        @SerializedName("product_id") val product_id : String,
        @SerializedName("product_title") val product_title : String,
        @SerializedName("quantity") val quantity : String,
        @SerializedName("totalPrice") val totalPrice : String,
        @SerializedName("userId") val userId : String
    )
