package com.example.datamovie.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.datamovie.R;
import com.example.datamovie.model.Result;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    String title, overview, image;
    Double rating;
    ImageView imgDetail;
    TextView movieTitle, movieDetail,rilis;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        movieTitle = findViewById(R.id.titleDetailMovie);
        movieDetail = findViewById(R.id.descriptionDetailMovie);
        imgDetail = findViewById(R.id.imgDetailMovie);
        TextView ratingTextView = findViewById(R.id.ratingMovie);
        rilis = findViewById(R.id.rilisMovie);

        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = result.getOriginalTitle();
        overview = result.getOverview();
        image = result.getPosterPath();
        rating = result.getVoteAverage();
        String releaseDate = result.getReleaseDate(); // Ambil releaseDate dari Result dan simpan dalam variabel String

        movieTitle.setText(title);
        movieDetail.setText(overview);
        ratingTextView.setText(rating.toString());
        rilis.setText(releaseDate); // Menggunakan releaseDate yang telah diambil tadi


        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w185" + image)
                .into(imgDetail);
    }
}