package india.chat.demokotlin.features.Dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import india.chat.demokotlin.R
import india.chat.demokotlin.data.network.model.Banner.ImageList

class BannerImagePagerAdapter(private val mValue: List<ImageList>) : PagerAdapter() {


    @BindView(R.id.ivBanner)
    internal lateinit var ivBanner: ImageView
    @BindView(R.id.tvimageId)
    internal lateinit var tvimageId: TextView



    internal lateinit var ctx: Context

    private var layoutInflater: LayoutInflater? = null
    // private BannerImagePagerAdapter.ImagePagerListner imagePagerListner;

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View)
    }
    //    public void setAdapterListner(BannerImagePagerAdapter.ImagePagerListner imagePagerListner)
    //    {
    //        this.imagePagerListner=imagePagerListner;
    //    }



    override fun getCount(): Int {
        return mValue.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        ctx = container.context


        layoutInflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = layoutInflater!!.inflate(R.layout.layout_image_banner, container, false)
        ButterKnife.bind(this, itemView)
        val mDataBean = mValue[position]
        Glide.with(ctx)
            .load(mDataBean.image)
            .placeholder(R.drawable.ic_picture)
            .into(ivBanner!!)



        container.addView(itemView)



        return itemView
    }
}
