package india.chat.demokotlin.data.network.model.Otp

import com.google.gson.annotations.SerializedName

data class OtpRequest (

    @SerializedName("phone_no") val phone_no : Int,
    @SerializedName("deviceType") val deviceType : String,
    @SerializedName("deviceToken") val deviceToken : String
)