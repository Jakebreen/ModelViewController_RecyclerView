package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.jakebreen.modelviewcontroller_recyclerview.R;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktail;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktails;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.adapter.RecyclerTouchListener;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.adapter.SearchAdapter;

import static uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.controller.MainActivity.mApiService;

/**
 * Created by Jake on 16/05/2018.
 */

public class SearchViewImpl implements SearchView {

    private static final String TAG = SearchViewImpl.class.getName();
    private View mRootView;
    private SearchViewListener mListener;
    private RecyclerView recyclerView;
    private GridLayoutManager mGridLayoutManager;
    private SearchAdapter searchAdapter;
    private Cocktails mCocktails;

    public SearchViewImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerview);
    }

    @Override
    public void setListener(SearchViewListener listener) {
        mListener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }

    @Override
    public void getCocktails(final Parcelable p) {
        // Retrofit call to API, returns list of cocktails
        mApiService.getCocktailList().enqueue(new Callback<Cocktails>() {
            @Override
            public void onResponse(Call<Cocktails> call, Response<Cocktails> response) {
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    mCocktails = response.body();
                    populateRecyclerView(mCocktails);
                    if (p != null)
                        setScrollPosition(p);
                }
            }

            @Override
            public void onFailure(Call<Cocktails> call, Throwable t) {
                showResponse(t.toString());
            }
        });
    }

    public void showResponse(String response) {
        Log.e(TAG, "Response: " + response);
    }

    @Override
    public void populateRecyclerView(final Cocktails cocktails) {
        // Setup recyclerview adapter
        searchAdapter = new SearchAdapter(cocktails);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mRootView.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(searchAdapter);

        // Handle orientation change, increasing grid-size to 4 in landscape and vice versa
        OrientationEventListener mOrientationListener = new OrientationEventListener(
                mRootView.getContext()) {
            @Override
            public void onOrientationChanged(int orientation) {
                if (orientation == 0) {
                    mGridLayoutManager = new GridLayoutManager(mRootView.getContext(), 2);
                    recyclerView.setLayoutManager(mGridLayoutManager);
                } else {
                    mGridLayoutManager = new GridLayoutManager(mRootView.getContext(), 4);
                    recyclerView.setLayoutManager(mGridLayoutManager);
                }
            }
        };

        if (mOrientationListener.canDetectOrientation()) {
            mOrientationListener.enable();
        }

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(mRootView.getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                // Select cocktail and begin fragment change
                Cocktail cocktail = cocktails.getCocktail().get(position);
                mListener.onSearch(cocktail.getIdDrink());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public Parcelable getScrollPosition() {
        // Return position of recyclerview
        Parcelable recyclerViewState = recyclerView.getLayoutManager().onSaveInstanceState();
        return recyclerViewState;
    }

    @Override
    public void setScrollPosition(Parcelable parcelable) {
        // TODO
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mRootView.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}