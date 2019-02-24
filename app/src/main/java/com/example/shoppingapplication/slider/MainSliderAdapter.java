package com.example.shoppingapplication.slider;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainSliderAdapter extends SliderAdapter {
    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {

        switch (position) {
            case 0:
//                imageSlideViewHolder.bindImageSlide("https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg");
                imageSlideViewHolder.bindImageSlide("https://img.bamilo.com/bnp/hp/slider/hnb.jpg");

                break;
            case 1:
                imageSlideViewHolder.bindImageSlide("https://img.bamilo.com/bnp/hp/slider/fmcg.jpg");
                break;
            case 2:
                imageSlideViewHolder.bindImageSlide("https://img.bamilo.com/bnp/hp/slider/mobile.jpg");
                break;

        }
    }


}
