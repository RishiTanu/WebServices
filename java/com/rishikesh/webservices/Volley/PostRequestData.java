package com.rishikesh.webservices.Volley;

public class PostRequestData
{
    private String BikeType;
    private String BikeImage;

    public void setBikeType(String bikeType) {
        BikeType = bikeType;
    }

    public void setBikeImage(String bikeImage) {
        BikeImage = bikeImage;
    }

    public String getBikeType()
    {
        return BikeType;
    }

    public String getBikeImage()
    {
        return BikeImage;
    }


    @Override
    public String toString() {
        return "PostRequestData{" +
                "BikeType='" + BikeType + '\'' +
                ", BikeImage='" + BikeImage + '\'' +
                '}';
    }
}

