package com.rishikesh.webservices.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostObject {

    @SerializedName("data")
    private List<ImagePost> sponsors;

    public List<ImagePost> getSponsors() {
        return sponsors;
    }

}
