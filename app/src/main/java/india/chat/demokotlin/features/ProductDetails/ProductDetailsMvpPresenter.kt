package india.chat.demokotlin.features.ProductDetails

import india.chat.demokotlin.Shared.MvpPresenter

interface ProductDetailsMvpPresenter<V:ProductDetailsMvpView>:MvpPresenter<V> {

    fun onDeatilsFetch(productId:String)
    fun onUpdateCartClick(attribute:String,price:String,description:String,productId:String,productTitle:String,productQuantity:String,totalPrice:String,userId:String)

}