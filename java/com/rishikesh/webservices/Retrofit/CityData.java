package com.rishikesh.webservices.Retrofit;

class CityData {

   private String CityName;
   private String ImageUrl;

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "CityData{" +
                "CityName='" + CityName + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                '}';
    }
}
