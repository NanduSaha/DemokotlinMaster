package india.chat.demokotlin.data.network.model.Feature

import com.google.gson.annotations.SerializedName


data class FeatureResponse (

    @SerializedName("responseCode") val responseCode : Int,
    @SerializedName("responseText") val responseText : String,
    @SerializedName("responseArray") val responseArray : List<ResponseArray>,
    @SerializedName("cartitems") val cartitems : Int,
    @SerializedName("unread_notification_count") val unread_notification_count : Int,
    @SerializedName("enquiry") val enquiry : String,
    @SerializedName("whatsapp") val whatsapp : String
)

data class ResponseArray (

    @SerializedName("p_id") val p_id : Int,
    @SerializedName("p_name") val p_name : String,
    @SerializedName("p_desc") val p_desc : String,
    @SerializedName("p_img") val p_img : String,
    @SerializedName("p_price") val p_price : Double,
    @SerializedName("sale_price") val sale_price : String
)