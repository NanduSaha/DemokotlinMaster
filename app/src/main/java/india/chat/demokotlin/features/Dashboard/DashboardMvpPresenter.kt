package india.chat.demokotlin.features.Dashboard

import india.chat.demokotlin.Shared.MvpPresenter

interface DashboardMvpPresenter <V: DashboardMvpView>: MvpPresenter<V> {
    fun onCategoryListFetch()
    fun bannerListFetch()
}