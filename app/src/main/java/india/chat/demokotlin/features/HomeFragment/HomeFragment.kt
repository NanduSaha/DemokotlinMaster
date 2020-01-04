package india.chat.demokotlin.features.HomeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import india.chat.demokotlin.R
import india.chat.demokotlin.Shared.BaseFragment
import javax.inject.Inject

class HomeFragment:BaseFragment(),HomeFragmentMvpView {


    override fun onError(resId: Int) {

    }

    override fun onError(message: String) {

    }

    override fun showAlert(message: String) {

    }

    override fun showInactiveUserAlert(message: String) {

    }

    override fun logOut() {

    }

    override fun setUp(view: View) {

    }

    override val isNetworkConnected: Boolean
        get() = true


    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }

    }



    @BindView(R.id.rvFeaturedProduct)
    lateinit var rvFeaturedProduct: RecyclerView



    @Inject
    internal lateinit var presenter: HomeFragmentPresenter<HomeFragmentMvpView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)
//        val component = getActivityComponent()
//        if (component != null) {
//            component!!.inject(this)
//             setUnBinder(ButterKnife.bind(this, v))
//           presenter.onAttach(this)
//
//        }


        setAdapter()
        return  v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  presenter.onAttach(this)
        presenter.onCategoryListFetch()
    }






    private fun setAdapter()
    {
        rvFeaturedProduct.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

    }
}