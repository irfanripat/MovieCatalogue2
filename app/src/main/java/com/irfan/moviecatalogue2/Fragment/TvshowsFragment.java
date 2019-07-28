package com.irfan.moviecatalogue2.Fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfan.moviecatalogue2.Adapter.TvShowAdapter;
import com.irfan.moviecatalogue2.R;
import com.irfan.moviecatalogue2.pojo.Movie;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvshowsFragment extends Fragment {

    private String[] dataName;
    private String[] dataRelease;
    private String[] dataDescription;
    private String[] dataGenre;
    private String[] dataRuntime;
    private String[] dataScore;
    private TypedArray dataPhoto;

    private RecyclerView recyclerView;
    private ArrayList<Movie> listMovies = new ArrayList<>();

    public TvshowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tvshows, container, false);
        recyclerView = view.findViewById(R.id.rv_tvshow);
        recyclerView.setHasFixedSize(true);

        prepare();
        addItem();
        showRecyclerList();

        return  view;
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvShowAdapter movieAdapter = new TvShowAdapter(getActivity());
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
        dataName = getResources().getStringArray(R.array.data_tv_show_name);
        dataDescription = getResources().getStringArray(R.array.data_tv_show_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_tv_show_photo);
        dataRelease = getResources().getStringArray(R.array.data_tv_show_release);
        dataRuntime = getResources().getStringArray(R.array.data_tv_show_runtime);
        dataGenre = getResources().getStringArray(R.array.data_tv_show_genre);
        dataScore = getResources().getStringArray(R.array.data_tv_show_score);
    }


}
