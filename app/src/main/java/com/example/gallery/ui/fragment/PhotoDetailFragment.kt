package com.example.gallery.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.R
import com.example.gallery.adapter.PhotosAdapter
import com.example.gallery.databinding.FragmentPhotoDetailBinding
import com.example.gallery.databinding.FragmentPhotoListBinding
import com.example.gallery.ui.viewmodel.PhotoListViewModel
import com.squareup.picasso.Picasso

class PhotoDetailFragment : Fragment() {
    companion object {
        const val photoUrlArg = "photoUrl"
    }

    private lateinit var imageView: ImageView

    private lateinit var binding: FragmentPhotoDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = binding.photoImageView

        arguments?.let {
            Picasso.with(context)
                .load(it.getString(photoUrlArg).toString())
                .into(imageView)
        }
    }


}