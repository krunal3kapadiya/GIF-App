package app.krunal3kapadiya.giphyapp.util

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager


/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

object Common {

    @JvmStatic
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun hideKeyboard(context: Context, view: View) {
        val v = view.findFocus() ?: return
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE)
                as InputMethodManager
        inputManager.hideSoftInputFromWindow(v.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}