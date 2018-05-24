package uk.co.jakebreen.modelviewcontroller_recyclerview.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktails;

/**
 * Created by Jake on 14/05/2018.
 */

public interface ApiService {

    //@GET("filter.php?c=Cocktail")
    //Call<List<Cocktail>> getCocktails();

    @GET("filter.php?c=Cocktail")
    Call<Cocktails> getCocktailList();

    @GET("lookup.php")
    Call<Cocktails> getCocktail(@Query("i") String idDrink);

}
