package com.example.gallery.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.adapter.PhotosAdapter
import com.example.gallery.databinding.FragmentPhotoListBinding
import com.example.gallery.ui.viewmodel.PhotoListViewModel

class PhotoListFragment  : Fragment() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: PhotoListViewModel
    private lateinit var binding: FragmentPhotoListBinding
    private lateinit var adapter: PhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoListBinding.inflate(inflater, container, false)
        val view = binding.root
        recyclerView = binding.photoListRv
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PhotoListViewModel::class.java)
        setRecyclerView()

    }


    private fun setRecyclerView() {
        setAdapter()
        setDataToAdapter()
    }


    private fun setAdapter() {
        adapter = PhotosAdapter(viewModel) {
            val action = PhotoListFragmentDirections
                .actionPhotoListFragmentToPhotoDetailFragment(it.urls.full)
            requireView().findNavController().navigate(action)
        }
        recyclerView.adapter = adapter
    }

    private fun setDataToAdapter() {
        viewModel.getPhotos(1)
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.listOfPhotos.addAll(it.body()!!)
            adapter.notifyDataSetChanged()
            Log.e("test", adapter.listOfPhotos.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.list.removeObservers(viewLifecycleOwner)
    }
}