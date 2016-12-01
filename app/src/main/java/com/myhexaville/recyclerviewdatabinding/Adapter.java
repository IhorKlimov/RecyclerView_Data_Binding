/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.myhexaville.recyclerviewdatabinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.myhexaville.recyclerviewdatabinding.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

class Adapter extends RecyclerView.Adapter<Holder> {
    private static final String LOG_TAG = "Adapter";
    List<Movie> list;
    private Context mContext;

    Adapter(Context context) {
        mContext = context;
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Movie("Movie " + i, "https://goo.gl/AaH3bP", i));
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.list_item, parent, false);

        return new Holder(mContext, binding.getRoot());
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Movie m = list.get(position);
        holder.mBinding.setMovie(m);
        holder.mBinding.setListener(new RequestListener() {
            @Override
            public boolean onException(Exception e, Object model, Target target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target, boolean isFromMemoryCache, boolean isFirstResource) {
                Log.d(LOG_TAG, "onResourceReady: IMAGE LOAD COMPLETE");
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}