package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        // Find the views for the movie details
        TextView titleTextView = findViewById(R.id.movie_title);
        TextView releaseDateTextView = findViewById(R.id.movie_release_date);
        TextView overviewTextView = findViewById(R.id.movie_overview);
        ImageView posterImageView = findViewById(R.id.movie_poster);
        TextView voteAverageTextView = findViewById(R.id.movie_vote_average);

        // Get the movie data from the intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("movie")) {
            MovieResults.ResultsBean movie = (MovieResults.ResultsBean) intent.getSerializableExtra("movie");

            // Set the movie details
            titleTextView.setText(movie.getTitle());
            releaseDateTextView.setText(movie.getRelease_date());
            overviewTextView.setText(movie.getOverview());
            voteAverageTextView.setText(String.format("%s/10", movie.getVote_average()));

            // Load the movie poster using Picasso
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movie.getPoster_path()).into(posterImageView);
        }
    }
}