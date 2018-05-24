package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.controller;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Jake on 16/05/2018.
 */

public class BaseFragment extends Fragment {

    private FragmentCallback mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (FragmentCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement " + FragmentCallback.class.getCanonicalName());
        }
    }

    /**
     * Replaces current fragment.
     *
     * @param c                 the class of the fragment to show
     * @param addToBackStack    whether the replacement should be added to back-stack
     * @param args              arguments for the newly created fragment (can be null)
     */
    public void replaceFragment(Class<? extends Fragment> c, boolean addToBackStack,
                                Bundle args) {
        mCallback.replaceFragment(c, addToBackStack, args);
    }

    public interface FragmentCallback {

        /**
         * Replace current fragment
         *
         * @param c                 the class of the new fragment
         * @param addToBackStack    whether the old fragment should be added to the back stack
         * @param args              arguments to be set for the new fragment
         */

        void replaceFragment(Class<? extends Fragment> c, boolean addToBackStack,
                             Bundle args);
    }



}
