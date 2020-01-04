package india.chat.demokotlin.features.Home

import india.chat.demokotlin.Shared.BasePresenter
import india.chat.demokotlin.data.DataManager
import india.chat.demokotlin.data.network.model.Banner.BannerResponse
import india.chat.demokotlin.data.network.model.Feature.FeatureResponse
import india.chat.demokotlin.data.network.model.Feature.featurerequest
import india.chat.demokotlin.data.network.model.MainCategory.MainCategoryRequest
import india.chat.demokotlin.data.network.model.MainCategory.MainCategoryResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class HomePresenter<V:HomeMvpView>@Inject constructor(mDataManager: DataManager):BasePresenter<V>(mDataManager),HomeMvpPresenter<V> {
    override fun onLoginClick() {
        getMvpView()?.setLogin()
    }

    override fun onBannerListFech() {
        getBanner()
    }


    override fun onFeatureListFetch(userId: String) {
        getFeatureList(userId)

    }

    override fun onCatListFetch(userId: String) {

        getCatList(userId)
    }


    internal fun getFeatureList(userId: String)
    {

        if(getMvpView()?.isNetworkConnected!!)
        {
            getMvpView()?.showLoading()
            val featureRequest= featurerequest(userId)

            dataManager.getFeatureData(featureRequest).enqueue(object :
                retrofit2.Callback<FeatureResponse> {
                override fun onResponse(
                    call: Call<FeatureResponse>,
                    response: Response<FeatureResponse>
                ) {
                    try {
                        if (response.isSuccessful()) {
                            getMvpView()?.hideLoading()
                            if (response.body()!!.responseCode === 1) {

                                getMvpView()!!.setFeatureListFetch(response.body()?.responseArray!!)

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

                override fun onFailure(call: Call<FeatureResponse>, t: Throwable) {
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

    internal fun getCatList(userId: String) {
        var userid:Int=userId.toInt()

        if (getMvpView()?.isNetworkConnected!!)
        {
            getMvpView()?.showLoading()
            val catRequest= MainCategoryRequest(userid)

            dataManager.getMainCategoryData(catRequest).enqueue(object :retrofit2.Callback<MainCategoryResponse>{
                override fun onFailure(call: Call<MainCategoryResponse>, t: Throwable) {
                    getMvpView()!!.hideLoading()
                    getMvpView()!!.showMessage("Server Failure")
                }

                override fun onResponse(call: Call<MainCategoryResponse>, response: Response<MainCategoryResponse>) {
                    try {
                        if (response.isSuccessful()) {
                            getMvpView()?.hideLoading()
                            if (response.body()!!.responseCode === 1) {

                                getMvpView()!!.setCatListFetch(response.body()?.categoryList!!)

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

            })
        }
        else
        {
            getMvpView()!!.onError("Check Internet")
        }
    }

    internal fun getBanner()
    {
        if (getMvpView()?.isNetworkConnected!!)
        {
            getMvpView()?.showLoading()
            dataManager.getBannerData().enqueue(object:retrofit2.Callback<BannerResponse>{
                override fun onFailure(call: Call<BannerResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<BannerResponse>, response: Response<BannerResponse>) {
                    try {
                        if (response.isSuccessful()) {
                            getMvpView()?.hideLoading()
                            if (response.body()!!.responseCode === 1) {

                                getMvpView()!!.setBannerFetch(response.body()?.responseData?.imageList!!)

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
            })

        }
        else
        {
            getMvpView()!!.onError("Check Internet")
        }
    }
}