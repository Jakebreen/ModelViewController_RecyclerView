package uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import uk.co.jakebreen.modelviewcontroller_recyclerview.R;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktail;
import uk.co.jakebreen.modelviewcontroller_recyclerview.data.model.Cocktails;
import uk.co.jakebreen.modelviewcontroller_recyclerview.ui.search.controller.SearchFragment;

/**
 * Created by Jake on 16/05/2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private static final String TAG = SearchAdapter.class.getName();
    private List<Cocktail> cocktails;

    public SearchAdapter(Cocktails cocktails) {
        this.cocktails = cocktails.getCocktail();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCocktail;
        public ImageView ivCocktail;

        public SearchViewHolder(View view) {
            super(view);
            tvCocktail = (TextView) view.findViewById(R.id.tv_cocktail);
            ivCocktail = (ImageView) view.findViewById(R.id.iv_cocktail);
        }
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View itemView = LayoutInflater.from(parent.getContext())
        //        .inflate(R.layout.list_item_cocktail, parent, false);
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_cocktail, parent, false);

        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SearchViewHolder holder, int position) {
        final Cocktail cocktail = cocktails.get(position);
        holder.tvCocktail.setText(cocktail.getStrDrink());
        Picasso.get().load(cocktail.getStrDrinkThumb()).into(holder.ivCocktail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment s = new SearchFragment();
                s.onSearch(cocktail.getIdDrink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cocktails.size();
    }

}
