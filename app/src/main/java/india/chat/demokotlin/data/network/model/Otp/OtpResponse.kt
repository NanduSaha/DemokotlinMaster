package india.chat.demokotlin.data.network.model.Otp

import com.google.gson.annotations.SerializedName

data class User_data (

    @SerializedName("userId") val userId : Int,
    @SerializedName("userEmail") val userEmail : String,
    @SerializedName("firstName") val firstName : String,
    @SerializedName("lastName") val lastName : String,
    @SerializedName("fullName") val fullName : String,
    @SerializedName("phoneNo") val phoneNo : Int,
    @SerializedName("agantId") val agantId : String,
    @SerializedName("gstNo") val gstNo : String
)


data class ResponseData (

    @SerializedName("otp") val otp : Int,
    @SerializedName("user_data") val user_data : User_data
)


data class OtpResponse (

    @SerializedName("responseCode") val responseCode : Int,
    @SerializedName("responseText") val responseText : String,
    @SerializedName("responseData") val responseData : ResponseData
)