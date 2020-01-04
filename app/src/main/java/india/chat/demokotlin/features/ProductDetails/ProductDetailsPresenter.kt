package india.chat.demokotlin.features.ProductDetails

import india.chat.demokotlin.Shared.BasePresenter
import india.chat.demokotlin.Utils.Constants
import india.chat.demokotlin.data.DataManager
import india.chat.demokotlin.data.network.model.ProductDetails.ProductDetailsResponse
import india.chat.demokotlin.data.network.model.updateCart.UpdateCartRequest
import india.chat.demokotlin.data.network.model.updateCart.UpdateCartResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ProductDetailsPresenter<V:ProductDetailsMvpView>@Inject constructor(mDataManager: DataManager): BasePresenter<V>(mDataManager),
    ProductDetailsMvpPresenter<V> {


    override fun onUpdateCartClick(attribute: String, price: String, description: String, productId: String, productTitle: String, productQuantity: String, totalPrice: String, userId: String) {
        getUpdateCart(attribute,price,description,productId,productTitle,productQuantity,totalPrice,userId)
    }


    override fun onDeatilsFetch(productId: String) {
        getProductDetails(productId)
    }

    internal fun getProductDetails(productId: String)
    {
        if(getMvpView()?.isNetworkConnected!!)
        {
            getMvpView()?.showLoading()
            val url = Constants.baseUrlLive + "products/" + Integer.valueOf(productId)

            dataManager.getProductDetails(url).enqueue(object :
                retrofit2.Callback<ProductDetailsResponse> {
                override fun onResponse(
                    call: Call<ProductDetailsResponse>,
                    response: Response<ProductDetailsResponse>
                ) {
                    try {
                        if (response.isSuccessful()) {
                            getMvpView()?.hideLoading()


                                response.body()?.let { getMvpView()!!.setProductDetails(it) }


                        } else {
                            getMvpView()!!.hideLoading()
                            getMvpView()!!.onError("Server Error")
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }

                override fun onFailure(call: Call<ProductDetailsResponse>, t: Throwable) {
                    getMvpView()!!.hideLoading()
                    getMvpView()!!.showMessage("Server Failure")
                }
            })
        }
        else
        {
            getMvpView()!!.onError("Check Internet")
        }
    }


    internal fun getUpdateCart(attribute: String, price: String, description: String, productId: String, productTitle: String, productQuantity: String, totalPrice: String, userId: String)
    {
        if(getMvpView()?.isNetworkConnected!!)
        {
            getMvpView()?.showLoading()

            val updateCartRequest=UpdateCartRequest(attribute,price,description,productId,productTitle,productQuantity,totalPrice,userId)

            dataManager.getUpdateCart(updateCartRequest).enqueue(object :
                retrofit2.Callback<UpdateCartResponse> {
                override fun onResponse(
                    call: Call<UpdateCartResponse>,
                    response: Response<UpdateCartResponse>
                ) {
                    try {
                        if (response.isSuccessful()) {
                            getMvpView()?.hideLoading()


                            response.body()?.let { getMvpView()!!.setUpdateClickResult(it) }


                        } else {
                            getMvpView()!!.hideLoading()
                            getMvpView()!!.onError("Server Error")
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }

                override fun onFailure(call: Call<UpdateCartResponse>, t: Throwable) {
                    getMvpView()!!.hideLoading()
                    getMvpView()!!.showMessage("Server Failure")
                }
            })
        }
        else
        {
            getMvpView()!!.onError("Check Internet")
        }
    }



}