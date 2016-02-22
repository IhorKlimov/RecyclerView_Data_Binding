package com.iklimov.recyclerviewdatabinding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.iklimov.recyclerviewdatabinding.databinding.ActivityMainBinding;
import com.iklimov.recyclerviewdatabinding.databinding.ListItemBinding;

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
        List<User> list;

        public Adapter() {
            list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new User("User " + i, 20 + i));
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
            User user = list.get(position);
            holder.binding.setUser(user);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class Holder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

        public Holder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = binding.getUser();
                    String message = context.getString(
                            R.string.message_format, user.name, user.age);

                    Snackbar.make(v, message, Snackbar.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }

}
