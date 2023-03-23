package com.example.droidcafe;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final List<MovieResults.ResultsBean> movies;

    public MovieAdapter(List<MovieResults.ResultsBean> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_view, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieResults.ResultsBean movie = movies.get(position);

        // load the movie poster using Picasso
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movie.getPoster_path()).into(holder.posterImageView);

        // set the click listener for the movie poster
        holder.itemView.setOnClickListener(view -> {
            // new intent to start the MovieDetailsActivity
            Intent intent = new Intent(view.getContext(), MovieDetailsActivity.class);
            // pass the movie ID to the MovieDetailsActivity
            intent.putExtra("movie", movie);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public ImageView posterImageView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImageView = itemView.findViewById(R.id.poster_image);
        }
    }
}
