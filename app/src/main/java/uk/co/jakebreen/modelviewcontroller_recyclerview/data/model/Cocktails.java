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
    private List<Cocktail> cocktails;

    public List<Cocktail> getCocktails() {
        return cocktails;
    }

    public void setCocktails(List<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

}
