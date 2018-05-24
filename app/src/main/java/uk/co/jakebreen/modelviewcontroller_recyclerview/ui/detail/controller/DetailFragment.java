package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.detail.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktail;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.controller.BaseFragment;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.detail.view.DetailView;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.detail.view.DetailViewImpl;

/**
 * Created by Jake on 16/05/2018.
 */

public class DetailFragment extends BaseFragment {

    private static final String TAG = DetailFragment.class.getName();
    public static final String ARG_COCKTAIL = "arg_cocktail_object";
    private DetailView mView;
    private Cocktail cocktail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Instantiate view and set the listener to this fragment
        mView = new DetailViewImpl(inflater, container);

        Bundle args = getArguments();
        if (args.containsKey(ARG_COCKTAIL)) {
            cocktail = (Cocktail) args.getSerializable(ARG_COCKTAIL);
            mView.setupInterface(cocktail);
        }

        return mView.getRootView();
    }



}