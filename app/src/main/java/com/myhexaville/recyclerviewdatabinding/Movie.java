package com.myhexaville.recyclerviewdatabinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Movie extends BaseObservable {
    String mPosterUrl;
    String mName;
    int mRating;

    public Movie(String name, String posterUrl, int rating) {
        this.mName = name;
        this.mRating = rating;
        this.mPosterUrl = posterUrl;
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    @Bindable
    public int getRating() {
        return mRating;
    }

    public void setRating(int newRating) {
        mRating = newRating;
        notifyPropertyChanged(BR.rating);
    }
}
