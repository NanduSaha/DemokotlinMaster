package india.chat.demokotlin.features.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import india.chat.demokotlin.R
import india.chat.demokotlin.data.network.model.MainCategory.CategoryList

class MainCategoryAdapter(private val mValues: List<CategoryList>,
                          val listener: HomeActivity
) : RecyclerView.Adapter<MainCategoryAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
       return mValues.size
    }


    internal lateinit var ctx: Context

    interface MainCatListListner {
        fun onItemClick( sCatId: String, mCatId: String)
    }


    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        ctx = parent.context
        val view = LayoutInflater.from(ctx)
            .inflate(R.layout.layout_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {


        val mDataBean = mValues[position]

       // holder?.tvhasSubCat?.text=mDataBean.subcategory
        holder?.tvCategoryName?.text=mDataBean.name






//        Glide.with(ctx)
//            .load(mDataBean.image)
//            .placeholder(R.drawable.placeholder)
//            .into(holder.ivCatImage)

        holder.bindView(ctx,listener)

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        @Nullable
        @BindView(R.id.ivCatImage)
        internal lateinit var ivCatImage: ImageView

        @BindView(R.id.tvCategoryName)
        internal lateinit  var tvCategoryName: TextView
        @BindView(R.id.tvhasSubCat)
        internal lateinit var tvhasSubCat: TextView


        @BindView(R.id.llCat)
        internal lateinit var llCat: FrameLayout

        init {
            ButterKnife.bind(this, view)

        }


        open fun bindView(context: Context,  listener: MainCatListListner)
        {
            /* Set the listener on the button */

        }

    }
}


