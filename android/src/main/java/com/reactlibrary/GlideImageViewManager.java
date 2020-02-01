package com.reactlibrary;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import javax.annotation.Nonnull;

public class GlideImageViewManager extends SimpleViewManager<ImageView> {

    private String source;

    @Nonnull
    @Override
    public String getName() {
        return "ImageNative";
    }

    @ReactProp(name = "source")
    public void source(String image) {
       source = image;
    }

    @Nonnull
    @Override
    protected ImageView createViewInstance(@Nonnull ThemedReactContext reactContext) {
        ImageView imageView = new ImageView(reactContext);
        Glide.with(imageView).load(source);
        return imageView;
    }
}
