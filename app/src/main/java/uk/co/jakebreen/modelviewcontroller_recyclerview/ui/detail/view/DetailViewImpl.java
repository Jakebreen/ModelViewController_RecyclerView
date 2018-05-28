package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.detail.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import uk.co.jakebreen.modelviewcontroller_recyclerview.R;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktail;

/**
 * Created by Jake on 16/05/2018.
 */

public class DetailViewImpl implements DetailView {

    private View mRootView;
    private ImageView ivCocktail;
    private TextView tvTitle, tvGlass, tvIngredient1, tvMeasure1, tvInstructions;
    private ArrayList<String> ingredientArray, measureArray;

    public DetailViewImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ivCocktail = mRootView.findViewById(R.id.iv_cocktail);
        tvTitle = mRootView.findViewById(R.id.tv_title);
        tvGlass = mRootView.findViewById(R.id.tv_glass);
        tvIngredient1 = mRootView.findViewById(R.id.tv_ingredient1);
        tvMeasure1 = mRootView.findViewById(R.id.tv_measure1);
        tvInstructions = mRootView.findViewById(R.id.tv_instructions);

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
    public void setupInterface(Cocktail cocktail, ArrayList<String> ingredients, ArrayList<String> measurements) {
        Picasso.get().load(cocktail.getStrDrinkThumb()).into(ivCocktail);
        tvTitle.setText(cocktail.getStrDrink());
        tvGlass.setText(cocktail.getStrGlass());

        tvIngredient1.setText(String.valueOf(ingredients));
        tvMeasure1.setText(String.valueOf(measurements));

        //LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
        //        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //TextView tv=new TextView(this);
        //tv.setLayoutParams(lparams);
        //tv.setText("test");
        //this.m_vwJokeLayout.addView(tv);

        //for (int count = 1; count < 4; count++) {
//
        //    String methodName = "getName";
        //}
//
        //LinearLayout llIngredient = (LinearLayout) mRootView.findViewById(R.id.ll_ingredient);
        //for (int i = 0; i < 2; i++) {
        //    int count = 2;
        //    String rec = "getIngredient" + count;
        //    tvIngredient1 = new TextView(mRootView.getContext());
        //    tvIngredient1.setText(rec); // <-- does it really compile without the + sign?
        //    tvIngredient1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        //    llIngredient.addView(tvIngredient1);
        //    tvInstructions.setText(cocktail.getStrInstructions());
        //    count ++;
        //}
    }
}
