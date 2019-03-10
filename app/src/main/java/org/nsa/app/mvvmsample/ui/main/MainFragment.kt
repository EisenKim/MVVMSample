package org.nsa.app.mvvmsample.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidquery.AQuery
import com.androidquery.callback.AjaxStatus
import org.nsa.app.mvvmsample.BuildConfig
import org.nsa.app.mvvmsample.R
import org.nsa.app.mvvmsample.common.util.AQueryReq
import java.util.HashMap



class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        requestHome()
    }

    private fun requestHome() {

        val url = BuildConfig.serverUrl + "/home"
        val params = HashMap<String, Any>()

        AQueryReq(context, url, object : AQueryReq.Callback {
            override fun onSuccess(data: String, status: AjaxStatus) {
                Log.d("Test", "Success!!!")
                print(data)
            }

            override fun onError(message: String) {
            }

            override fun onAjaxError(code: Int) {
            }
        })
    }

}
