package uk.co.jakebreen.modelviewcontroller_recyclerview.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktails;

/**
 * Created by Jake on 14/05/2018.
 */

public interface ApiService {

    // Returns list of all cocktails
    @GET("filter.php?c=Cocktail")
    Call<Cocktails> getCocktailList();

    // Query API and return specific cocktail by ID
    @GET("lookup.php")
    Call<Cocktails> getCocktail(@Query("i") String idDrink);

}
