package india.chat.demokotlin.Shared

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import butterknife.Unbinder
import com.app.kotlindemo.utils.CommonUtils

abstract class BaseFragment : Fragment(),MvpView {

    private var mActivity: BaseActivity? = null
    private var mUnBinder: Unbinder? = null
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
       // performDependencyInjection()
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

   // private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.mActivity = context

        }
    }



    override fun showLoading() {
        hideLoading()
        mProgressDialog = this.context?.let { CommonUtils.showLoadingDialog(it) }
    }


    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun showMessage(message: String) {
        if (mActivity != null) {
            mActivity!!.showMessage(message)
        }
    }


    override fun showMessage(@StringRes resId: Int) {
        if (mActivity != null) {
            mActivity!!.showMessage(resId)
        }
    }



    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }


    override  fun hideKeyboard() {
        if (mActivity != null) {
            mActivity!!.hideKeyboard()
        }
    }


    fun getBaseActivity(): BaseActivity? {
        return mActivity
    }

    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    protected abstract fun setUp(view: View)

    override fun onDestroy() {
        if (mUnBinder != null) {
            mUnBinder!!.unbind()
        }
        super.onDestroy()
    }

}