package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktail;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktails;

import static uk.co.jakebreen.modelviewcontroller_recyclerview.ui.common.controller.MainActivity.mApiService;

/**
 * Created by Jake on 18/05/2018.
 */

public class SearchAsyncTask extends AsyncTask<Cocktail, Void, Cocktail> {

    private static final String TAG = SearchAsyncTask.class.getName();
    private String id;
    private Cocktails cocktails;
    private Cocktail cocktail;

    public SearchAsyncTask(String id) {
        this.id = id;
    }

    @Override
    protected Cocktail doInBackground(Cocktail... cocktails) {

        Call<Cocktails> call = mApiService.getCocktail(id);
        try {
            Response<Cocktails> response = call.execute();
            this.cocktails = response.body();
            this.cocktail = this.cocktails.getCocktails().get(0);

            Log.i(TAG, "Success: " + response.body().toString());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e);
            e.printStackTrace();
        } catch (IllegalStateException e) {
            Log.e(TAG, "IllegalStateException: " + e);
            e.printStackTrace();
        }

        return cocktail;
    }
}