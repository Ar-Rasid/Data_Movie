package com.example.datamovie.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.datamovie.R;
import com.example.datamovie.model.Result;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movir";
    String title, overview, image;
    ImageView imgDetail;
    TextView movieTitle, movieDetail;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        movieTitle = findViewById(R.id.titleDetailMovie);
        movieDetail = findViewById(R.id.descriptionDetailMovie);
        imgDetail = findViewById(R.id.imgDetailMovie);

        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = result.getOriginalTitle();
        overview = result.getOverview();
        image = result.getPosterPath();

        movieTitle.setText(title);
        movieDetail.setText(overview);

        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w185" + image)
                .into(imgDetail);
    }
}