package india.chat.demokotlin.Shared

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import butterknife.Unbinder
import com.app.kotlindemo.utils.CommonUtils
import com.app.kotlindemo.utils.NetworkUtils
import com.google.android.material.snackbar.Snackbar
import india.chat.demokotlin.DemoKotlin
import india.chat.demokotlin.R
import india.chat.demokotlin.Utils.ConnectivityReceiver
import india.chat.demokotlin.di.components.ActivityComponent
import india.chat.demokotlin.di.components.DaggerActivityComponent
import india.chat.demokotlin.di.modules.ActivityModule

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener,MvpView {

    private var mProgressDialog: ProgressDialog? = null


    var activityComponent: ActivityComponent? = null
        private set

    private var mUnBinder: Unbinder? = null

    override val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(applicationContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as DemoKotlin).getApplicationComponent())
            .build()

    }



    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(
            findViewById(android.R.id.content),
            message, Snackbar.LENGTH_SHORT
        )
      //  val sbView = snackbar.view
       // val textView = sbView.findViewById(android.support.design.R.id.snackbar_text) as TextView
       // textView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        snackbar.show()
    }

    override fun onError(message: String) {
        hideKeyboard()
        if (message != null) {
            showErrorToast(message)
        } else {
            showErrorToast("Error Message is null")
        }
    }

    override fun onError(@StringRes resId: Int) {
        onError(getString(resId))
    }

    override fun showMessage(message: String) {
        hideKeyboard()
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Some error", Toast.LENGTH_LONG).show()
        }
    }

    fun showErrorToast(message: String?) {
        hideKeyboard()
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Some error", Toast.LENGTH_LONG).show()
        }
    }

    override fun showMessage(@StringRes resId: Int) {
        showMessage(getString(resId))
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun logOut() {
        /*  Intent i = new Intent(this, SignInActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);*/

        /*LockManager<CustomPinActivity> lockManager = LockManager.getInstance();
        lockManager.getAppLock().setLogoId(R.mipmap.ic_launcher);
        lockManager.getAppLock().setShouldShowForgot(true);
        lockManager.getAppLock().setTimeout(Constants.TIMEOUT_MILLIES);
        lockManager.getAppLock().addIgnoredActivity(SplashActivity.class);
        lockManager.getAppLock().addIgnoredActivity(SignInActivity.class);
        lockManager.getAppLock().addIgnoredActivity(LoginEmailActivity.class);*/
    }


    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

//    override fun onDestroy() {
//
//        if (mUnBinder != null) {
//            mUnBinder!!.unbind()
//        }
//        super.onDestroy()
//    }

    override fun showAlert(message: String) {
        try {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.app_name)
            builder.setIcon(R.mipmap.ic_launcher)
            builder.setMessage(message)
            builder.setCancelable(false)
            builder.setPositiveButton("Ok") { dialog, which -> dialog.dismiss() }
            val alert = builder.create()
            alert.show()
        } catch (e: Exception) {
           // Timber.tag(TAG).e(e)
        }

    }


    override fun showInactiveUserAlert(message: String) {
        try {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.app_name)
            builder.setIcon(R.mipmap.ic_launcher)
            builder.setMessage(message)
            builder.setCancelable(false)
            builder.setPositiveButton("Ok") { dialog, which ->
                dialog.dismiss()
                logOut()
            }
            val alert = builder.create()
            alert.show()
        } catch (e: Exception) {
          //  Timber.e(e)
        }

    }

    companion object {


        val TAG = BaseActivity::class.java.simpleName
    }

    private var mSnackBar: Snackbar? = null

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showMessage(isConnected)
    }

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }

    private fun showMessage(isConnected: Boolean) {

        if (!isConnected) {

            val messageToUser = "You are offline now." //TODO
//            mSnackBar = Snackbar.make(Context, messageToUser, Snackbar.LENGTH_LONG) //Assume "rootLayout" as the root layout of every activity.
//            mSnackBar?.duration = Snackbar.LENGTH_INDEFINITE
//            mSnackBar?.show()
            Toast.makeText(applicationContext,"You are offline now.",Toast.LENGTH_SHORT).show()
        } else {
          //  mSnackBar?.dismiss()
        }

    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        registerReceiver(ConnectivityReceiver(),
//            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
//        )
//    }
    public override fun onDestroy() {

        try {
            if (ConnectivityReceiver() != null)
                unregisterReceiver(ConnectivityReceiver())

        } catch (e: Exception) {
        }
        if (mUnBinder != null) {
            mUnBinder!!.unbind()
        }
        super.onDestroy()
    }
}