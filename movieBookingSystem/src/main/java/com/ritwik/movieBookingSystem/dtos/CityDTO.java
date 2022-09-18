package com.ritwik.movieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityDTO {

    @JsonProperty(value = "city_id")
    private int cityId;

    @JsonProperty(value = "city_name")
    private String cityName;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
