package india.chat.demokotlin.features.ProductDetails

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import india.chat.demokotlin.R
import india.chat.demokotlin.Shared.BaseActivity
import india.chat.demokotlin.Shared.weights.CountDrawable
import india.chat.demokotlin.data.network.model.ProductDetails.ProductDetailsResponse
import india.chat.demokotlin.data.network.model.updateCart.UpdateCartResponse
import javax.inject.Inject







class ProductDetailsActivity : BaseActivity(),ProductDetailsMvpView {



    @BindView(india.chat.demokotlin.R.id.toolbar)
    lateinit var toolbar:Toolbar

    @BindView(india.chat.demokotlin.R.id.tvProductDetailsTitle)
    lateinit var tvProductDetailsTitle: TextView

    @BindView(india.chat.demokotlin.R.id.tvId)
    lateinit var tvId:TextView
    @BindView(india.chat.demokotlin.R.id.tvProductDetailsDescription)
    lateinit var tvProductDetailsDescription:TextView
    @BindView(india.chat.demokotlin.R.id.ivProductDetailsImage)
    lateinit var ivProductDetailsImage:ImageView
    @BindView(india.chat.demokotlin.R.id.tvProductDetailsPrice)
    lateinit var tvProductDetailsPrice:TextView
    @BindView(india.chat.demokotlin.R.id.tvDescriptionQuantity)
    lateinit var tvDescriptionQuantity:TextView
    @BindView(india.chat.demokotlin.R.id.btnDetailsPlus)
    lateinit var btnDetailsPlus:Button
    @BindView(india.chat.demokotlin.R.id.btnDetailsMinus)
    lateinit var btnDetailsMinus:Button
    @BindView(india.chat.demokotlin.R.id.tvAddtoCart)
    lateinit var tvAddtoCart:TextView
    @BindView(india.chat.demokotlin.R.id.tvBuyNow)
    lateinit var tvBuyNow:TextView
    @BindView(india.chat.demokotlin.R.id.tvInStock)
    lateinit var tvInStock:TextView

    lateinit var context: Context

    @BindView(R.id.rvSameCategory)
    lateinit var rvSameCategory:RecyclerView




    @Inject
    lateinit var productDetailsPresenter: ProductDetailsPresenter<ProductDetailsMvpView>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(india.chat.demokotlin.R.layout.activity_product_details)
        activityComponent?.inject(this)
        ButterKnife.bind(this)
        context=this
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setTitle("")
        setUp()
        getIntentData()
        setClickListner()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(india.chat.demokotlin.R.menu.toolbar_header, menu)
        return true
    }

    private fun setClickListner()
    {

        tvAddtoCart.setOnClickListener {
           productDetailsPresenter.getUpdateCart(tvProductDetailsDescription.text.toString(),tvProductDetailsPrice.text.toString(),tvProductDetailsDescription.text.toString(),tvId.text.toString(),tvProductDetailsTitle.text.toString(),tvDescriptionQuantity.text.toString(),tvProductDetailsPrice.text.toString(),"67")
        }
    }

    protected fun setUp()
    {
        productDetailsPresenter.onAttach(this)

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    internal fun getIntentData()
    {
        val bundle: Bundle? = intent.extras
        val id: String? = bundle?.getString("ProductId")
        Toast.makeText(applicationContext, id.toString(), Toast.LENGTH_SHORT).show()
        if (id != null) {
            productDetailsPresenter.getProductDetails(id)
        }
    }

    override fun setProductDetails(response: ProductDetailsResponse) {

        tvProductDetailsTitle.setText(response.name)
        tvProductDetailsDescription.setText(Html.fromHtml(response.description))
        tvProductDetailsPrice.setText(response.regular_price.toString())
        tvId.setText(response.id.toString())
        if(response.in_stock)
        {
            tvInStock.setBackgroundResource(india.chat.demokotlin.R.drawable.green_dot)
        }
        else
        {
            tvInStock.setBackgroundResource(india.chat.demokotlin.R.drawable.red_dot)
        }

        Glide.with(applicationContext)
            .load(response.images[0].src)
            .placeholder(india.chat.demokotlin.R.drawable.ic_picture)
            .into(ivProductDetailsImage)


    }

    override fun setUpdateClickResult(response: UpdateCartResponse) {

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            india.chat.demokotlin.R.id.ic_group -> {
                Toast.makeText(applicationContext, "click on setting", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        setCount(this, "9",menu)
        return true
    }


    fun setCount(context: Context, count: String,menu:Menu) {
        val menuItem = menu.findItem(india.chat.demokotlin.R.id.ic_group)
        val icon = menuItem.getIcon() as LayerDrawable

        val badge: CountDrawable

        // Reuse drawable if possible
        val reuse = icon.findDrawableByLayerId(india.chat.demokotlin.R.id.ic_group_count)
        if (reuse != null && reuse is CountDrawable) {
            badge = reuse
        } else {
            badge = CountDrawable(context)
        }

        badge.setCount(count)
        icon.mutate()
        icon.setDrawableByLayerId(india.chat.demokotlin.R.id.ic_group_count, badge)
    }

}
