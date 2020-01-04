package india.chat.demokotlin.features.ProductDetails

import india.chat.demokotlin.Shared.MvpView
import india.chat.demokotlin.data.network.model.ProductDetails.ProductDetailsResponse
import india.chat.demokotlin.data.network.model.updateCart.UpdateCartResponse

interface ProductDetailsMvpView:MvpView {
    fun setProductDetails(response: ProductDetailsResponse)
    fun setUpdateClickResult(response: UpdateCartResponse)

}