package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.detail.view;

import java.util.ArrayList;

import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktail;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.view.RootView;

/**
 * Created by Jake on 16/05/2018.
 */

public interface DetailView extends RootView {

    void setupInterface(Cocktail cocktail, ArrayList<String> ingredients, ArrayList<String> measurements);

}
