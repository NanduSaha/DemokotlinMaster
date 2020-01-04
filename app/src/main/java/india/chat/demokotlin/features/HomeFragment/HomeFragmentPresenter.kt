package india.chat.demokotlin.features.HomeFragment

import india.chat.demokotlin.Shared.BasePresenter
import india.chat.demokotlin.data.DataManager
import india.chat.demokotlin.data.network.model.CategoryProduct.CategoryProductResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class HomeFragmentPresenter<V: HomeFragmentMvpView>@Inject constructor(mDataManager: DataManager): BasePresenter<V>(mDataManager),
    HomeFragmentMvpPresenter<V> {
    override fun onCategoryListFetch() {
        getCategoryList()
    }

    internal fun getCategoryList()
    {
        getMvpView()?.showMessage("presenter")
        if(getMvpView()?.isNetworkConnected!!)
        {
            getMvpView()?.showLoading()


            dataManager.getCategoryProductList().enqueue(object :
                retrofit2.Callback<CategoryProductResponse> {
                override fun onResponse(
                    call: Call<CategoryProductResponse>,
                    response: Response<CategoryProductResponse>
                ) {
                    try {
                        if (response.isSuccessful()) {
                            getMvpView()?.hideLoading()
                            if (response.body()!!.responseCode === 1) {

                             //   response.body()?.let { getMvpView()!!.setCategoryListFetch(it) }

                            } else {
                                getMvpView()!!.onError(response.body()!!.responseText)
                            }
                        } else {
                            getMvpView()!!.hideLoading()
                            getMvpView()!!.onError("Server Error")
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }

                override fun onFailure(call: Call<CategoryProductResponse>, t: Throwable) {
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
