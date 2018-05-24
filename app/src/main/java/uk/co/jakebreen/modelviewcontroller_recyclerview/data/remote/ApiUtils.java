package uk.co.jakebreen.modelviewcontroller_recyclerview.data.remote;

/**
 * Created by Jake on 14/05/2018.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";

    public static ApiService getApiService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }

}
