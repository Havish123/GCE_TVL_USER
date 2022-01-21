package com.havish.gce_tvl.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.slider.Slider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.havish.gce_tvl.R
import com.smarteist.autoimageslider.DefaultSliderView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderLayout
import java.lang.ref.Reference

class HomeFragment : Fragment() {
//    private lateinit var storageReference:StorageReference
    private lateinit var sliderLayout:SliderLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=inflater.inflate(R.layout.fragment_home, container, false)

        sliderLayout=view.findViewById(R.id.slider)
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL)
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        sliderLayout.scrollTimeInSec=1

        setSliderView()

        return view;
    }

    private fun setSliderView() {
//        storageReference=FirebaseStorage.getInstance().reference.child("slider")

        for (i in 0..5){
            var sliderView:DefaultSliderView=DefaultSliderView(context)
            when(i){
                0->{
                    sliderView.imageUrl="https://firebasestorage.googleapis.com/v0/b/gcetvl-75110.appspot.com/o/slider%2FGCE.jpg?alt=media&token=d10873fc-647a-49ea-bdf8-dd400aaff168"
                }
                1->{
                    sliderView.imageUrl="https://firebasestorage.googleapis.com/v0/b/gcetvl-75110.appspot.com/o/slider%2FHeader.jpg?alt=media&token=6b4a8b60-955b-4fc0-a750-5d776192aa37"
                }
                2->{
                    sliderView.imageUrl="https://firebasestorage.googleapis.com/v0/b/gcetvl-75110.appspot.com/o/slider%2Fslide1.jpg?alt=media&token=03466c2f-e677-4255-8398-a9aa2bde5515"
                }
                3->{
                    sliderView.imageUrl="https://firebasestorage.googleapis.com/v0/b/gcetvl-75110.appspot.com/o/slider%2Fslide2.jpg?alt=media&token=df4ae6b4-6ed6-4a47-b28a-1f9ba6977c60"
                }
                4->{
                    sliderView.imageUrl="https://firebasestorage.googleapis.com/v0/b/gcetvl-75110.appspot.com/o/slider%2Fslide3.jpg?alt=media&token=40eec06b-5008-4419-9f6e-2794b47fa78d"
                }
                5->{
                    sliderView.imageUrl="https://firebasestorage.googleapis.com/v0/b/gcetvl-75110.appspot.com/o/slider%2Fslide4.jpeg?alt=media&token=8cd6b80c-07b1-40a7-a581-2b0f95d8a615"
                }

            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP)
            sliderLayout.addSliderView(sliderView)
        }
    }
}