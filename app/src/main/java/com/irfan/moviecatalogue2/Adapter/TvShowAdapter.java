package com.irfan.moviecatalogue2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.irfan.moviecatalogue2.DetailActivity;
import com.irfan.moviecatalogue2.R;
import com.irfan.moviecatalogue2.pojo.Movie;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Movie> listMovies;

    public TvShowAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movie> listMovies) {
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public TvShowAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvShowAdapter.CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvName.setText(getListMovies().get(i).getName());
        categoryViewHolder.tvRelease.setText(getListMovies().get(i).getRelease());
        categoryViewHolder.tvDesc.setText(getListMovies().get(i).getDescription());
        Glide.with(context)
                .load(getListMovies().get(i).getPhoto())
                .apply(new RequestOptions())
                .into(categoryViewHolder.imgPhoto);

        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Movie movie = new Movie();
                movie.setName(listMovies.get(categoryViewHolder.getAdapterPosition()).getName());
                movie.setGenre(listMovies.get(categoryViewHolder.getAdapterPosition()).getGenre());
                movie.setScore(listMovies.get(categoryViewHolder.getAdapterPosition()).getScore());
                movie.setRuntime(listMovies.get(categoryViewHolder.getAdapterPosition()).getRuntime());
                movie.setDescription(listMovies.get(categoryViewHolder.getAdapterPosition()).getDescription());
                movie.setRelease(listMovies.get(categoryViewHolder.getAdapterPosition()).getRelease());
                movie.setPhoto(listMovies.get(categoryViewHolder.getAdapterPosition()).getPhoto());


                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MOVIE, movie);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDesc, tvRelease;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvRelease = itemView.findViewById(R.id.tv_release);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
