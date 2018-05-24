package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.ExecutionException;

import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktail;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.controller.BaseFragment;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.detail.controller.DetailFragment;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.async.SearchAsyncTask;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.view.SearchView;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.view.SearchViewImpl;

/**
 * Created by Jake on 16/05/2018.
 */

public class SearchFragment extends BaseFragment implements SearchView.SearchViewListener {

    private static final String TAG = SearchFragment.class.getName();
    private SearchView mView;
    public static final String BUNDLE_RECYCLER_LAYOUT = "classname.recycler.layout";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Instantiate view and set the listener to this fragment
        mView = new SearchViewImpl(inflater, container);
        mView.setListener(this);
        mView.getCocktails();

        // Return the root view
        return mView.getRootView();
    }

    @Override
    public void onSearch(String id) {
        // Async response returning cocktail object
        try {
            Cocktail c = new SearchAsyncTask(id).execute().get();
            onEventCompleted(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEventCompleted(Cocktail cocktail) {
        // Create a bundle that contains the ID of the selected cocktail
        Bundle args = new Bundle(1);
        args.putSerializable(DetailFragment.ARG_COCKTAIL, cocktail);
        // Replace with new fragment passing bundle
        replaceFragment(DetailFragment.class, true, args);
    }

    @Override
    public void onEventFailed(String message) {
        // TODO
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //if (savedInstanceState != null) {
        //    mView.setScrollPosition(savedInstanceState);
        //}
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, mView.getScrollPosition());
    }
}
