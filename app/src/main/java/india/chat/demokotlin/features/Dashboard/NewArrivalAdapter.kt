package com.india.deveshsarees.feature.Home


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import india.chat.demokotlin.R
import india.chat.demokotlin.data.network.model.CategoryProduct.Newarrival
import org.jetbrains.annotations.Nullable

class NewArrivalAdapter(private val mValues: List<Newarrival>, val listener: FeaturedListListner) :
    RecyclerView.Adapter<NewArrivalAdapter.ViewHolder>() {


    private var listListner: NewArrivalAdapter.FeaturedListListner? = null
    internal lateinit var ctx: Context



    interface FeaturedListListner {
        fun onItemClickNewarrival(sCatId: String, pId: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewArrivalAdapter.ViewHolder {
        ctx = parent.context
        val view = LayoutInflater.from(ctx)
            .inflate(R.layout.featured_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val mDataBean = mValues[position]

        holder.tvItemTitle!!.setText(mDataBean.p_name)

        if (mDataBean.sale_price.equals("")) {
            holder.tvItemPrice!!.setText(mDataBean.p_price.toString())
        } else {
            holder.tvItemPrice!!.setText(mDataBean.sale_price.toString())
        }
        holder.tvCartId!!.setText(mDataBean.cat_id.toString())
        holder.tvProductId!!.setText(mDataBean.p_id.toString())

        Glide.with(ctx)
            .load(mDataBean.p_img[0])
            .placeholder(R.drawable.ic_picture)
            .into(holder?.ivItemImage!!)

        holder.bindView(ctx,listener)
    }


    override fun getItemCount(): Int {
        return mValues.size
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @Nullable
        @BindView(R.id.ivItemImage)
        internal lateinit var ivItemImage: ImageView

        @BindView(R.id.tvItemTitle)
        internal lateinit var tvItemTitle: TextView
        @BindView(R.id.tvCartId)
        internal lateinit var tvCartId: TextView
        @BindView(R.id.tvItemPrice)
        internal lateinit var tvItemPrice: TextView
        @BindView(R.id.tvProductId)
        internal lateinit var tvProductId: TextView
        @BindView(R.id.llMain)
        internal  lateinit var llMain: RelativeLayout



        init {
            ButterKnife.bind(this, view)

        }
        open fun bindView(context: Context, listener: FeaturedListListner)
        {

            /* Set the listener on the button */
            llMain!!.setOnClickListener(View.OnClickListener { listener.onItemClickNewarrival(tvCartId!!.text.toString(), tvProductId!!.text.toString())})
        }

    }
}
