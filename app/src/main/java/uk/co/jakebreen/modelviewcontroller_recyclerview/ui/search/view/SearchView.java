package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.view;

import android.os.Parcelable;

import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktail;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktails;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.view.RootView;

/**
 * Created by Jake on 16/05/2018.
 */

public interface SearchView extends RootView {

    interface SearchViewListener {
        /**
         * This callback will be invoked when the user selects a cocktail
         * @param id selected cocktail
         */
        void onSearch(String id);
        void onEventCompleted(Cocktail cocktail);
        void onEventFailed(String message);
    }

    void showToast(String message);
    void setListener(SearchViewListener listener);
    void getCocktails(Parcelable p);
    void populateRecyclerView(Cocktails cocktails);
    Parcelable getScrollPosition();
    void setScrollPosition(Parcelable parcelable);

}
