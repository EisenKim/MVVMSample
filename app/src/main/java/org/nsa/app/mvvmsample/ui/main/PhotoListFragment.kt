package org.nsa.app.mvvmsample.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import org.nsa.app.mvvmsample.R

class PhotoListFragment : Fragment() {

    companion object {
        fun newInstance() = PhotoListFragment()
    }

    private lateinit var viewModel: PhotoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.photo_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PhotoListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
