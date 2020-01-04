package india.chat.demokotlin.features.Home

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import india.chat.demokotlin.R
import india.chat.demokotlin.Shared.BaseActivity
import india.chat.demokotlin.data.network.model.Banner.ImageList
import india.chat.demokotlin.data.network.model.Feature.ResponseArray
import india.chat.demokotlin.data.network.model.MainCategory.CategoryList
import india.chat.demokotlin.features.Dashboard.BannerImagePagerAdapter
import india.chat.demokotlin.features.Login.LoginActivity
import java.net.URLEncoder
import javax.inject.Inject

class HomeActivity : BaseActivity(),HomeMvpView,
    MainCategoryAdapter.MainCatListListner {
    override fun onItemClick(sCatId: String, mCatId: String) {

    }


    override fun setLogin() {
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }


    @Inject
    lateinit var homePresenter: HomePresenter<HomeMvpView>

    @BindView(R.id.ivHome)
    lateinit var ivHome:ImageView

    @BindView(R.id.drawerLayout)
    lateinit var drawerLayout:DrawerLayout

    @BindView(R.id.rvFeaturedProduct)
    lateinit var rvFeaturedProduct:RecyclerView

    @BindView(R.id.rvMainCategory)
    lateinit var rvMainCategory:RecyclerView

    @BindView(R.id.fabWhatsapp)
    lateinit var fabWhatsapp:FloatingActionButton

    @BindView(R.id.tvweatherData)
    lateinit var tvweatherData:TextView

    @BindView(R.id.viewpagerBanner)
    lateinit var viewpagerBanner:ViewPager

    lateinit var Login:Button



    @BindView(R.id.navView)
    lateinit var navView: NavigationView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        activityComponent?.inject(this)

        setUp()
        setAdapter()
        setClickListner()

    }
    protected fun setUp()
    {


        homePresenter.onAttach(this)
        Login = navView.getHeaderView(0).findViewById<Button>(R.id.btnNavLogin)




        homePresenter.getFeatureList("")
        homePresenter.getCatList("0")
        homePresenter.getBanner()




    }

    override fun onDestroy() {
        homePresenter.onDetach()
        super.onDestroy()
    }

    private fun setAdapter()
    {
        rvFeaturedProduct.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvMainCategory.layoutManager= LinearLayoutManager(this)
    }

    private fun setClickListner()
    {
        ivHome?.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        fabWhatsapp?.setOnClickListener(View.OnClickListener { navigateToWhatsapp() })

        Login.setOnClickListener{
            homePresenter.onLoginClick()
        }

    }




    private fun appInstalledOrNot(uri: String): Boolean {
        val pm = packageManager
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
        }

        return false
    }

    internal fun navigateToWhatsapp()
    {
        if (appInstalledOrNot("com.whatsapp")) {


            try {

                val packageManager = this.getPackageManager()
                val i = Intent(Intent.ACTION_VIEW)

                val url =
                    "https://api.whatsapp.com/send?phone=" + "+917073343172" + "&text=" + URLEncoder.encode("", "UTF-8")
                i.setPackage("com.whatsapp")
                i.data = Uri.parse(url)
                if (i.resolveActivity(packageManager) != null) {
                    this.startActivity(i)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {
            Toast.makeText(applicationContext, "Whatsapp not installed", Toast.LENGTH_SHORT).show()
        }
    }



    override fun setFeatureListFetch(list: List<ResponseArray>) {
      //  rvFeaturedProduct.adapter=FeaturedListAdapter(list,this@HomeActivity)
    }

    override fun setCatListFetch(list: List<CategoryList>) {
        rvMainCategory.adapter= MainCategoryAdapter(
            list,
            this@HomeActivity
        )
    }


    override fun setBannerFetch(list: List<ImageList>) {

        viewpagerBanner.adapter= BannerImagePagerAdapter(list)
    }

}
