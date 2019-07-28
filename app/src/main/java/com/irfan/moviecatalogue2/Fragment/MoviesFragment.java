package com.irfan.moviecatalogue2.Fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfan.moviecatalogue2.Adapter.MovieAdapter;
import com.irfan.moviecatalogue2.R;
import com.irfan.moviecatalogue2.pojo.Movie;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private String[] dataName;
    private String[] dataRelease;
    private String[] dataDescription;
    private String[] dataGenre;
    private String[] dataRuntime;
    private String[] dataScore;
    private TypedArray dataPhoto;

    private RecyclerView recyclerView;
    private ArrayList<Movie> listMovies = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = view.findViewById(R.id.rv_movie);
        recyclerView.setHasFixedSize(true);

        prepare();
        addItem();
        showRecyclerList();

        return view;
    }


    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(getActivity());
        movieAdapter.setListMovies(listMovies);
        recyclerView.setAdapter(movieAdapter);

    }


    private void addItem() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i=0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setName(dataName[i]);
            movie.setRelease(dataRelease[i]);
            movie.setDescription(dataDescription[i]);
            movie.setScore(dataScore[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setGenre(dataGenre[i]);
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movies.add(movie);
        }
        listMovies.addAll(movies);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_movie_name);
        dataDescription = getResources().getStringArray(R.array.data_movie_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_movie_photo);
        dataRelease = getResources().getStringArray(R.array.data_movie_release);
        dataRuntime = getResources().getStringArray(R.array.data_movie_runtime);
        dataGenre = getResources().getStringArray(R.array.data_movie_genre);
        dataScore = getResources().getStringArray(R.array.data_movie_score);
    }

}
