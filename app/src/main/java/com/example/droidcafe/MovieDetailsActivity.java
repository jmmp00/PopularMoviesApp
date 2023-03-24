package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // find the views for the movie details
        TextView titleTextView = findViewById(R.id.movie_title);
        TextView releaseDateTextView = findViewById(R.id.movie_release_date);
        TextView overviewTextView = findViewById(R.id.movie_overview);
        ImageView posterImageView = findViewById(R.id.movie_poster);
        TextView voteAverageTextView = findViewById(R.id.movie_vote_average);

        // get movie data from the intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("movie")) {
            MovieResults.ResultsBean movie = (MovieResults.ResultsBean) intent.getSerializableExtra("movie");

            // set movie details
            titleTextView.setText(movie.getTitle());
            releaseDateTextView.setText(movie.getRelease_date());
            overviewTextView.setText(movie.getOverview());
            voteAverageTextView.setText(String.format("%s/10", movie.getVote_average()));

            // load the movie poster
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movie.getPoster_path()).into(posterImageView);

            MovieFetcher myInterface = RetrofitSingleton.getInstance().getMovieFetcher();

            // show trailers

            Call<TrailerResults> call = myInterface.movieTrailers(movie.getId(), MainActivity.API_KEY);

            call.enqueue(new Callback<TrailerResults>() {
                @Override
                public void onResponse(@NonNull Call<TrailerResults> call, @NonNull Response<TrailerResults> response) {
                    // Get the trailer data from the response
                    TrailerResults trailerResults = response.body();
                    if (trailerResults != null && trailerResults.getResults().size() > 0) {
                        List<TrailerResults.ResultsBean> trailers = trailerResults.getResults();
                        LinearLayout trailerLayout = findViewById(R.id.trailer_layout);

                        for (TrailerResults.ResultsBean trailer : trailers) {
                            Button trailerButton = new Button(MovieDetailsActivity.this);
                            trailerButton.setText(R.string.trailer_button_text);

                            trailerButton.setOnClickListener(view -> {
                                String youtubeUrl = "https://www.youtube.com/watch?v=" + trailer.getKey();
                                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));
                                startActivity(intent1);
                            });

                            trailerLayout.addView(trailerButton);
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<TrailerResults> call, @NonNull Throwable t) {
                    t.printStackTrace();
                }
            });


            // show reviews

            Call<ReviewsResults> call2 = myInterface.movieReviews(movie.getId(), MainActivity.API_KEY);

            call2.enqueue(new Callback<ReviewsResults>() {
                @Override
                public void onResponse(Call<ReviewsResults> call, Response<ReviewsResults> response) {
                    ReviewsResults reviewsResults = response.body();
                    if (reviewsResults != null && reviewsResults.getResults().size() > 0) {
                        List<ReviewsResults.ResultsBean> reviews = reviewsResults.getResults();
                        LinearLayout reviewsLayout = findViewById(R.id.reviews_layout);

                        for (ReviewsResults.ResultsBean review : reviews) {
                            Button reviewsButton = new Button(MovieDetailsActivity.this);
                            reviewsButton.setText(R.string.reviews_button_text);

                            reviewsButton.setOnClickListener(view -> {
                                String reviewUrl = review.getUrl();
                                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(reviewUrl));
                                startActivity(intent2);
                            });

                            reviewsLayout.addView(reviewsButton);
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ReviewsResults> call, @NonNull Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }
}