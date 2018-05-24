package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.co.jakebreen.modelviewcontroller_recyclerview.R;

/**
 * Created by Jake on 16/05/2018.
 */

public class RootViewImpl implements RootView {

    private View mView;

    public RootViewImpl(Context context, ViewGroup container) {
        mView = LayoutInflater.from(context).inflate(R.layout.frame_layout, container);
    }

    @Override
    public View getRootView() {
        return mView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }

}
