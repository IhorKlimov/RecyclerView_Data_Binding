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
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.myhexaville.recyclerviewdatabinding.databinding.ListItemBinding;

class Holder extends RecyclerView.ViewHolder {
    private Context mContext;
    ListItemBinding mBinding;


    Holder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mBinding = DataBindingUtil.bind(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie m = mBinding.getMovie();
                m.setRating(5);
                String message = mContext.getString(
                        R.string.message_format, m.mName);

                Snackbar.make(v, message, Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
    }
}