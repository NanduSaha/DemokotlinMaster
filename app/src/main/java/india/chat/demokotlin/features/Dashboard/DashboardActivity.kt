package india.chat.demokotlin.features.Dashboard

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.india.deveshsarees.feature.Home.FeaturedListAdapter
import com.india.deveshsarees.feature.Home.HotSealingAdapter
import com.india.deveshsarees.feature.Home.NewArrivalAdapter
import com.india.deveshsarees.feature.Home.OtherAdapter
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import india.chat.demokotlin.R
import india.chat.demokotlin.Shared.BaseActivity
import india.chat.demokotlin.data.network.model.Banner.BannerResponse
import india.chat.demokotlin.data.network.model.CategoryProduct.CategoryProductResponse
import india.chat.demokotlin.features.ProductDetails.ProductDetailsActivity
import javax.inject.Inject


@Suppress("DEPRECATION")
class DashboardActivity : BaseActivity(), DashboardMvpView, FeaturedListAdapter.FeaturedListListner,NewArrivalAdapter.FeaturedListListner,HotSealingAdapter.FeaturedListListner,OtherAdapter.FeaturedListListner {
    override fun onItemClickNewarrival(sCatId: String, pId: String) {
        intent = Intent(applicationContext, ProductDetailsActivity::class.java)
        intent.putExtra("ProductId",pId)
        startActivity(intent)
    }

    override fun onItemClickHotsealing(sCatId: String, pId: String) {
        intent = Intent(applicationContext, ProductDetailsActivity::class.java)
        intent.putExtra("ProductId",pId)
        startActivity(intent)
    }

    override fun onItemClickOtherAdapter(sCatId: String, pId: String) {
        intent = Intent(applicationContext, ProductDetailsActivity::class.java)
        intent.putExtra("ProductId",pId)
        startActivity(intent)
    }

    override fun onItemClickFeature(sCatId: String, pId: String) {
       // Toast.makeText(applicationContext,"Feature",Toast.LENGTH_SHORT).show(

        intent = Intent(applicationContext, ProductDetailsActivity::class.java)
        intent.putExtra("ProductId",pId)
        startActivity(intent)
    }

    override fun setBannerFetch(response: BannerResponse) {
        viewpagerBanner.adapter= BannerImagePagerAdapter(
            response.responseData.imageList

        )
        dots_indicator.setViewPager(viewpagerBanner)
    }


    override fun setCategoryListFetch(response: CategoryProductResponse) {
        rvFeaturedProduct.adapter= FeaturedListAdapter(
            response.responseData.featured,
            this
        )
        rvNewArrivalProduct.adapter= NewArrivalAdapter(
            response.responseData.newarrival,
            this
        )

        rvHotSealingProduct.adapter= HotSealingAdapter(
            response.responseData.hotsellingproducts,
            this
        )
        rvOtherProduct.adapter= OtherAdapter(
            response.responseData.otherproducts,
            this
        )
    }


    @BindView(R.id.rvFeaturedProduct)
    lateinit var rvFeaturedProduct: RecyclerView
    @BindView(R.id.rvNewArrivalProduct)
    lateinit var rvNewArrivalProduct:RecyclerView
    @BindView(R.id.rvHotSealingProduct)
    lateinit var rvHotSealingProduct:RecyclerView
    @BindView(R.id.rvOtherProduct)
    lateinit var rvOtherProduct:RecyclerView
    @BindView(R.id.viewpagerBanner)
    lateinit var  viewpagerBanner: ViewPager
    @BindView(R.id.dots_indicator)
    lateinit var dots_indicator: SpringDotsIndicator




    @Inject
    internal lateinit var featuredListAdapter: FeaturedListAdapter
    @BindView(india.chat.demokotlin.R.id.bottom_navigation)
    lateinit var navigationView: AHBottomNavigation

    @Inject
    lateinit var dasboardPresenter: DashboardPresenter<DashboardMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(india.chat.demokotlin.R.layout.activity_dashboard)
        activityComponent?.inject(this)
        ButterKnife.bind(this)
        setBottom()
        setUp()
        setAdapter()

    }

    protected fun setUp()
    {
        dasboardPresenter.onAttach(this)

        dasboardPresenter.getCategoryList()
        dasboardPresenter.getBannerList()


    }

    private fun setAdapter()
    {
        rvFeaturedProduct.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvNewArrivalProduct.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvHotSealingProduct.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvOtherProduct.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }

  @SuppressLint("ResourceAsColor")
  private  fun setBottom(){
      val item1 = AHBottomNavigationItem("Home", india.chat.demokotlin.R.drawable.ic_home, india.chat.demokotlin.R.color.colorPrimaryDark)
      val item2 = AHBottomNavigationItem("Category", india.chat.demokotlin.R.drawable.ic_list, india.chat.demokotlin.R.color.colorPrimaryDark)
      val item3 = AHBottomNavigationItem("Order", india.chat.demokotlin.R.drawable.ic_my_order, india.chat.demokotlin.R.color.colorPrimaryDark)
      val item4 = AHBottomNavigationItem("More", india.chat.demokotlin.R.drawable.ic_my_order, india.chat.demokotlin.R.color.colorPrimaryDark)
      navigationView.addItem(item1)
      navigationView.addItem(item2)
      navigationView.addItem(item3)
      navigationView.addItem(item4)
      navigationView.accentColor=R.color.colorYellow
     // navigationView.inactiveColor=R.color.colorPrimaryDark
      navigationView.setColoredModeColors(R.color.colorPrimaryDark,R.color.colorYellow)

      navigationView.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener { position, wasSelected ->


          when (position) {
              0 -> {
                //  Toast.makeText(applicationContext,"Home", Toast.LENGTH_SHORT).show()
//                  val fragment = HomeFragment()
//                  supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
//                      .commit()

                  intent = Intent(applicationContext, DashboardActivity::class.java)
                  startActivity(intent)


              }
              1 -> {


              }
              2 -> {

              }
              3 -> {


              }
          }
          true
      })

  }


}
