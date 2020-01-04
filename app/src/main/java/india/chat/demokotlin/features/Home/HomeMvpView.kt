package india.chat.demokotlin.features.Home

import india.chat.demokotlin.Shared.MvpView
import india.chat.demokotlin.data.network.model.Banner.ImageList
import india.chat.demokotlin.data.network.model.Feature.ResponseArray
import india.chat.demokotlin.data.network.model.MainCategory.CategoryList

interface HomeMvpView:MvpView {


     fun setFeatureListFetch(list: List<ResponseArray>)
     fun setCatListFetch(list: List<CategoryList>)
     fun setBannerFetch(list: List<ImageList>)
     fun setLogin()

}