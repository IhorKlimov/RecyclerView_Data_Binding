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

package com.iklimov.recyclerviewdatabinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Movie extends BaseObservable {
    String name;
    int rating;

    public Movie(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public int getRating() {
        return rating;
    }

    public void setRating(int newRating) {
        rating = newRating;
        notifyPropertyChanged(BR.rating);
    }
}
