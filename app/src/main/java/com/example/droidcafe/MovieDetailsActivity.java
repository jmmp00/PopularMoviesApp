package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView releaseDateTextView;
    private TextView overviewTextView;
    private ImageView posterImageView;
    private TextView voteAverageTextView;

    private MovieResults.ResultsBean movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
// Find the views for the movie details
        titleTextView = findViewById(R.id.movie_title);
        releaseDateTextView = findViewById(R.id.movie_release_date);
        overviewTextView = findViewById(R.id.movie_overview);
        posterImageView = findViewById(R.id.movie_poster);
        voteAverageTextView = findViewById(R.id.movie_vote_average);

// Get the movie data from the intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("movie")) {
            movie = (MovieResults.ResultsBean) intent.getSerializableExtra("movie");

            // Set the movie details
            titleTextView.setText(movie.getTitle());
            releaseDateTextView.setText(movie.getRelease_date());
            overviewTextView.setText(movie.getOverview());
            voteAverageTextView.setText(movie.getVote_average() + "/10");

            // Load the movie poster using Picasso
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movie.getPoster_path()).into(posterImageView);
        }
    }
}