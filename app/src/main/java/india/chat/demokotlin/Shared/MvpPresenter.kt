package india.chat.demokotlin.Shared

interface MvpPresenter<V : MvpView> {
    fun onAttach(mvpView: V)

    fun onDetach()
}