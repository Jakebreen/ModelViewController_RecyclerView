package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.detail.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

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
    private ArrayList<String> ingredientArray, measureArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Instantiate view and set the listener to this fragment
        mView = new DetailViewImpl(inflater, container);

        savedInstanceState = getArguments();
        if (savedInstanceState.containsKey(ARG_COCKTAIL)) {
            cocktail = (Cocktail) savedInstanceState.getSerializable(ARG_COCKTAIL);
            mView.setupInterface(cocktail, getIngredientArray(), getMeasureArray());
        }

        return mView.getRootView();
    }

    // Create arraylist from ingredient variables
    public ArrayList<String> getIngredientArray() {

        ArrayList<String> ingredientArray = new ArrayList<>();
        String fields = "";
        int i;

        // Loop through cocktail methods adding response to array
        for(i=1; i<=15; i++) {

            Method m = null;
            try {
                m = cocktail.getClass().getMethod("getStrIngredient" + String.valueOf(i), new Class[]{});
                fields = (String) m.invoke(cocktail);
                // Remove whitespace from response
                fields = fields.trim();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            if (!fields.isEmpty()) {
                ingredientArray.add(fields);
            } else {
                break;
            }
        }

        return ingredientArray;
    }

    // Create arraylist from measure variables
    public ArrayList<String> getMeasureArray() {

        ArrayList<String> measureArray = new ArrayList<>();
        String fields = null;
        int i;

        // Loop through cocktail methods adding response to array
        for(i=1; i<=15; i++) {

            Method m = null;
            try {
                m = cocktail.getClass().getMethod("getStrMeasure" + String.valueOf(i), new Class[]{});
                fields = (String) m.invoke(cocktail);
                // Remove whitespace from response
                fields = fields.trim();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            if (!fields.isEmpty()) {
                measureArray.add(fields);
            } else {
                break;
            }
        }

        return measureArray;
    }

}