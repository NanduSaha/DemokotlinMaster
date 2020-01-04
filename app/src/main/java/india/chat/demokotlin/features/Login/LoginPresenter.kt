package india.chat.demokotlin.features.Login

import india.chat.demokotlin.Shared.BasePresenter
import india.chat.demokotlin.data.DataManager
import india.chat.demokotlin.data.network.model.Otp.OtpRequest
import india.chat.demokotlin.data.network.model.Otp.OtpResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class LoginPresenter<V:LoginMvpView>@Inject constructor(mDataManager: DataManager):BasePresenter<V>(mDataManager),LoginMvpPresenter<V> {
    override fun decidenaviagetionToOtp(phonNumber:String,deviceType:String,deviceToken:String) {
        getLogin(phonNumber,deviceType,deviceToken)

    }

    internal fun getLogin(phonNumber:String,deviceType:String,deviceToken:String)
    {
        if(getMvpView()?.isNetworkConnected!!) {
            getMvpView()?.showLoading()


        }
        else
        {
            getMvpView()!!.onError("Check Internet")
            val otpRequest= OtpRequest(phonNumber.toInt(),deviceType,deviceToken)
            dataManager.getLogin(otpRequest).enqueue(object:retrofit2.Callback<OtpResponse>{
                override fun onFailure(call: Call<OtpResponse>, t: Throwable) {
                    getMvpView()!!.hideLoading()
                    getMvpView()!!.showMessage("Server Failure")
                }

                override fun onResponse(call: Call<OtpResponse>, response: Response<OtpResponse>) {
                    try {
                        if (response.isSuccessful()) {
                            getMvpView()?.hideLoading()
                            if (response.body()!!.responseCode === 1) {

                              //  getMvpView()!!.navigateToOtp(response.body().responseData)

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
    }
}