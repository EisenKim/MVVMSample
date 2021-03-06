package org.nsa.app.mvvmsample.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import org.nsa.app.mvvmsample.R

class PhotoDetailFragment : Fragment() {

    companion object {
        fun newInstance() = PhotoDetailFragment()
    }

    private lateinit var viewModel: PhotoDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.photo_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PhotoDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
