package com.fta.testdatabinding.custom;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.fta.testdatabinding.glide.GlideApp;

public class DemoBindingAdapter {


    @BindingAdapter({"app:imageUrl", "app:placeholder"})
    public static void loadImgFromUrl(ImageView view, String url, Drawable drawable) {
        GlideApp.with(view).load(url).placeholder(drawable).into(view);
    }
}
