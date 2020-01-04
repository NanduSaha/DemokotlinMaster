package india.chat.demokotlin.features.Dashboard

import india.chat.demokotlin.Shared.MvpView
import india.chat.demokotlin.data.network.model.Banner.BannerResponse
import india.chat.demokotlin.data.network.model.CategoryProduct.CategoryProductResponse

interface DashboardMvpView: MvpView {
    fun setCategoryListFetch(response: CategoryProductResponse)
    fun setBannerFetch(response: BannerResponse)
}