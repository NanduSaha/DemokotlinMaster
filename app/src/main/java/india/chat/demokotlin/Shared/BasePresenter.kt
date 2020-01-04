package india.chat.demokotlin.Shared

import india.chat.demokotlin.data.DataManager
import javax.inject.Inject

open class BasePresenter<V : MvpView> @Inject
constructor(val dataManager: DataManager) : MvpPresenter<V> {
    private var mvpView: V? = null
    val isViewAttached: Boolean
        get() = mvpView != null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    fun getMvpView(): V? = mvpView

    override fun onDetach() {
        mvpView = null
    }



    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }





    class MvpViewNotAttachedException :
        RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")

    companion object {

        private val TAG = "BasePresenter"
    }

}

