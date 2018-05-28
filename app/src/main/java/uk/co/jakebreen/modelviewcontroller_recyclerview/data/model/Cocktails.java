package uk.co.jakebreen.modelviewcontroller_recyclerview.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jake on 16/05/2018.
 */

public class Cocktails implements Serializable {

    @SerializedName("drinks")
    @Expose
    private List<Cocktail> cocktail;

    public List<Cocktail> getCocktail() {
        return cocktail;
    }

    public void setCocktail(List<Cocktail> cocktails) {
        this.cocktail = cocktails;
    }

}
