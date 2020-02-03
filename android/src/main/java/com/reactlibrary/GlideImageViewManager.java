package com.reactlibrary;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
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

    @ReactProp(name = "resizeMode")
    public void setResize(ImageView view,String mode) {
        view.setCropToPadding(true);
        if(mode != null && !TextUtils.isEmpty(mode)) {
            if(TextUtils.equals(mode,"cover"))
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if(TextUtils.equals(mode,"stretch"))
                view.setScaleType(ImageView.ScaleType.FIT_XY);
            if(TextUtils.equals(mode,"contain"))
                view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
    }

    @Nonnull
    @Override
    protected ImageView createViewInstance(@Nonnull ThemedReactContext reactContext) {
        context = reactContext;
        return new ImageView(reactContext);
    }
}
