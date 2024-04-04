package com.DailyDash.AccountManagement.entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.util.Objects;


@Entity
public class City {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(column = "city")
    private String cityName;

    @CsvBindByName(column = "lat")
    private double latitude;

    @CsvBindByName(column = "lng")
    private double longitude;

    public City(){

    }

    public City(String cityName, double latitude, double longitude){
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCityName(){
        return this.cityName;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(latitude, city.latitude) == 0 && Double.compare(longitude, city.longitude) == 0 && Objects.equals(id, city.id) && Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, latitude, longitude);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
