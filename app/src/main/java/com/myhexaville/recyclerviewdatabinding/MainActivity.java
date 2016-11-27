package com.myhexaville.recyclerviewdatabinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myhexaville.recyclerviewdatabinding.databinding.ActivityMainBinding;
import com.myhexaville.recyclerviewdatabinding.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        context = this;

        binding.recycler.setAdapter(new Adapter());
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private class Adapter extends RecyclerView.Adapter<Holder> {
        List<Movie> list;

        public Adapter() {
            list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new Movie("Movie " + i, i));
            }
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            ListItemBinding binding = DataBindingUtil.inflate(
                    LayoutInflater.from(context), R.layout.list_item, parent, false);

            return new Holder(binding.getRoot());
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            Movie m = list.get(position);
            holder.binding.setMovie(m);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class Holder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

        Holder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Movie m = binding.getMovie();
                    m.setRating(5);
                    String message = context.getString(
                            R.string.message_format, m.name);

                    Snackbar.make(v, message, Snackbar.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }

}
