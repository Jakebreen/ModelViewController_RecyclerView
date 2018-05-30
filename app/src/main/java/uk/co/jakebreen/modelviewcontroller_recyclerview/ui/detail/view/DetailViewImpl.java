package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.detail.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import uk.co.jakebreen.modelviewcontroller_recyclerview.R;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktail;

/**
 * Created by Jake on 16/05/2018.
 */

public class DetailViewImpl implements DetailView {

    private View mRootView;
    private ImageView ivCocktail;
    private TextView tvTitle, tvGlass, tvIngredient1, tvMeasure1, tvInstructions, tvAlcohol;
    private ArrayList<String> ingredientArray, measureArray;

    public DetailViewImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ivCocktail = mRootView.findViewById(R.id.iv_cocktail);
        tvTitle = mRootView.findViewById(R.id.tv_title);
        tvGlass = mRootView.findViewById(R.id.tv_glass);
        tvIngredient1 = mRootView.findViewById(R.id.tv_ingredient1);
        tvMeasure1 = mRootView.findViewById(R.id.tv_measure1);
        tvInstructions = mRootView.findViewById(R.id.tv_instructions);
        tvAlcohol = mRootView.findViewById(R.id.tv_alcohol);

        //Hide unused textviews
        tvIngredient1.setVisibility(View.GONE);
        tvMeasure1.setVisibility(View.GONE);

    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }

    //Method to populate interface
    @Override
    public void setupInterface(Cocktail cocktail, ArrayList<String> ingredients, ArrayList<String> measurements) {
        Picasso.get().load(cocktail.getStrDrinkThumb()).into(ivCocktail);
        tvTitle.setText(cocktail.getStrDrink());
        tvGlass.setText("Best served in, " + cocktail.getStrGlass());
        tvInstructions.setText(cocktail.getStrInstructions());
        tvAlcohol.setText(cocktail.getStrAlcoholic());

        this.ingredientArray = ingredients;
        this.measureArray = measurements;

        //Create new textview for each ingredient in array
        LinearLayout llIngredient = (LinearLayout) mRootView.findViewById(R.id.ll_ingredient);
        for (String ingredient : ingredientArray) {
            tvIngredient1 = new TextView(mRootView.getContext());
            tvIngredient1.setText(ingredient); // <-- does it really compile without the + sign?
            tvIngredient1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            tvIngredient1.setTextAppearance(mRootView.getContext(), R.style.TextAppearance_AppCompat_Medium);
            llIngredient.addView(tvIngredient1);

        }

        //Create new textview for each measure in array
        LinearLayout llMeasurement = (LinearLayout) mRootView.findViewById(R.id.ll_measurement);
        for (String measure : measureArray) {
            tvMeasure1 = new TextView(mRootView.getContext());
            tvMeasure1.setText(measure); // <-- does it really compile without the + sign?
            tvMeasure1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            tvMeasure1.setTextAppearance(mRootView.getContext(), R.style.TextAppearance_AppCompat_Medium);
            llMeasurement.addView(tvMeasure1);

        }
    }
}
