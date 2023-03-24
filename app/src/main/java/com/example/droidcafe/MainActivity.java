package com.example.droidcafe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static String API_KEY = "1023df71e14cdb4fd6b1af66d621ac84";
    public static int PAGE = 1;
    public static String CATEGORY = "popular";
    private final BroadcastReceiver networkChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (isNetworkConnected(MainActivity.this)) {
                // internet connection is available, show movie posters
                Log.d("MainActivity", "Internet connection is available");
            } else {
                // Internet connection is not available, show error message
                Log.d("MainActivity", "Internet connection is not available");

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Network Connection Error").setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // register the broadcast receiver to listen for changes in network connectivity
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeReceiver, filter);

        loadMovies();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister the broadcast receiver when the activity is destroyed
        unregisterReceiver(networkChangeReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // add items to the action bar if it is present.
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
                loadMovies();
                displayToast(getString(R.string.action_sort_popular_message));
                return true;
            case R.id.action_sort_top:
                CATEGORY = "top_rated";
                loadMovies();
                displayToast(getString(R.string.action_sort_top_message));
                return true;
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void loadMovies() {
        //convert Json to Gson
        MovieFetcher myInterface = RetrofitSingleton.getInstance().getMovieFetcher();

        Call<MovieResults> call = myInterface.listOfMovies(MainActivity.CATEGORY, API_KEY, PAGE);

        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(@NonNull Call<MovieResults> call, @NonNull Response<MovieResults> response) {
                MovieResults results = response.body();

                List<MovieResults.ResultsBean> listOfMovies = results.getResults();

                // find the RecyclerView from the layout
                RecyclerView recyclerView = findViewById(R.id.recycler_view);

                // create and set the layout manager for the RecyclerView
                GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
                recyclerView.setLayoutManager(layoutManager);

                // create the adapter and set it for the RecyclerView
                MovieAdapter adapter = new MovieAdapter(listOfMovies);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(@NonNull Call<MovieResults> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // get information about the currently active network
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }


}