package com.irfan.moviecatalogue2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRatingBar;
import android.widget.ImageView;
import android.widget.TextView;

import com.irfan.moviecatalogue2.pojo.Movie;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView itemJudulFilm, itemTglRilis, itemDurasi, itemKarakter, itemDeskripsi;
    AppCompatRatingBar itemRatingBar;
    private ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        itemJudulFilm = findViewById(R.id.item_judul_film);
        itemTglRilis = findViewById(R.id.item_tgl_rilis);
        itemRatingBar = findViewById(R.id.rt_bar);
        itemDurasi = findViewById(R.id.item_durasi);
        itemKarakter = findViewById(R.id.item_genre);
        itemDeskripsi = findViewById(R.id.item_desc);
        imgFoto = findViewById(R.id.img_foto);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String name = movie.getName();
        String release = movie.getRelease();
        String runtime = movie.getRuntime();
        String genre = movie.getGenre();
        String desc = movie.getDescription();
        String score = movie.getScore();
        float rating = Float.valueOf(score)/2;

        itemJudulFilm.setText(name);
        itemTglRilis.setText(release);
        itemDurasi.setText(runtime);
        itemKarakter.setText(genre);
        itemDeskripsi.setText(desc);
        imgFoto.setImageResource(movie.getPhoto());
        itemRatingBar.setRating(rating);
    }
}
