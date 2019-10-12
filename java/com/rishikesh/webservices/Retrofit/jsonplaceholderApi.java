package com.rishikesh.webservices.Retrofit;

import com.rishikesh.webservices.Retrofit.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface jsonplaceholderApi
{
    @GET("posts")
    Call<List<Post>> getPost();

    @GET("http://japware.com/api/selectfolder/")
    Call<PostObject> getDataArray(@QueryMap Map<String,String> mp);

    @FormUrlEncoded
    @POST("posts")
    Call<List<PostBike>> getPostData(@FieldMap Map<String,String> mp);

    @GET("posts")
    Call<List<CityData>> getCitydata();
}


