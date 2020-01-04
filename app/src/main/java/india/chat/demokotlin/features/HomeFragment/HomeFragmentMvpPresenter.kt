package india.chat.demokotlin.features.HomeFragment

import india.chat.demokotlin.Shared.MvpPresenter

interface HomeFragmentMvpPresenter<V: HomeFragmentMvpView>: MvpPresenter<V> {
    fun onCategoryListFetch()
}