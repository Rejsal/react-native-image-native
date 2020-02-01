package com.reactlibrary;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import javax.annotation.Nonnull;

public class GlideImageViewManager extends SimpleViewManager<ImageView> {

    private Context context;

    @Nonnull
    @Override
    public String getName() {
        return "GlideImageViewManager";
    }

    @ReactProp(name = "source")
    public void getSource(ImageView view,String image) {
        Glide.with(context).load(Uri.parse(image)).into(view);
    }

    @Nonnull
    @Override
    protected ImageView createViewInstance(@Nonnull ThemedReactContext reactContext) {
        context = reactContext;
        return new ImageView(reactContext);
    }
}
