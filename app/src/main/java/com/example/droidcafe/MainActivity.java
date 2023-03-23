package com.example.droidcafe;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";

    public static String BASE_URL = "https://api.themoviedb.org";
    public static String API_KEY = "YOUR_API_KEY_HERE";
    public static int PAGE = 1;
    public static String CATEGORY = "popular";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadMovies("popular");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
                case R.id.action_sort_popular:
                    CATEGORY = "popular";
                    loadMovies(CATEGORY);
                displayToast(getString(R.string.action_sort_popular_message));
                return true;
            case R.id.action_sort_top:
                CATEGORY = "top_rated";
                loadMovies(CATEGORY);
                displayToast(getString(R.string.action_sort_top_message));
                return true;
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this,
                        SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void loadMovies(String CATEGORY) {
        //convert Json to Gson
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieFetcher myInterface = retrofit.create(MovieFetcher.class);

        Call<MovieResults> call = myInterface.listOfMovies(MainActivity.CATEGORY, API_KEY, PAGE);

        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();

                List<MovieResults.ResultsBean> listOfMovies = results.getResults();

                // adding movie posters to the grid layout - parent view
                GridLayout parentView = findViewById(R.id.parent_view);
                parentView.removeAllViews();

                for (MovieResults.ResultsBean movie : listOfMovies) {
                    // create a new ImageView for each movie poster
                    ImageView moviePoster = new ImageView(MainActivity.this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    layoutParams.setMargins(25, 15, 0, 5); // Add some margin between posters
                    moviePoster.setLayoutParams(layoutParams);

                    // load each movie poster and add it to the parent view
                    Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movie.getPoster_path()).into(moviePoster);
                    moviePoster.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // new intent to start the MovieDetailsActivity
                            Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
                            // pass the movie ID to the MovieDetailsActivity
                            intent.putExtra("movie", movie);
                            startActivity(intent);
                        }
                    });

                    parentView.addView(moviePoster);
                }
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}