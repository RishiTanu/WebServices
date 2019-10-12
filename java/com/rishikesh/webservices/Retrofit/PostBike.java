package com.rishikesh.webservices.Retrofit;

public class PostBike {  //calling match

    private String BikeType;
    private String BikeImage;

    public String getBikeType() {
        return BikeType;
    }

    public String getBikeImage() {
        return BikeImage;
    }

    @Override
    public String toString() {
        return "PostBike{" +
                "BikeType='" + BikeType + '\'' +
                ", BikeImage='" + BikeImage + '\'' +
                '}';
    }
}


