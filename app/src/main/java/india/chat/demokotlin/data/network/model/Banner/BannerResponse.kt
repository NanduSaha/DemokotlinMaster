package india.chat.demokotlin.data.network.model.Banner

import com.google.gson.annotations.SerializedName


data class ImageList (

    @SerializedName("image_title") val image_title : String,
    @SerializedName("image_desc") val image_desc : String,
    @SerializedName("image") val image : String
)

data class ResponseData (

    @SerializedName("imageList") val imageList : List<ImageList>
)

    data class BannerResponse (

        @SerializedName("responseCode") val responseCode : Int,
        @SerializedName("responseText") val responseText : String,
        @SerializedName("responseData") val responseData : ResponseData
    )

