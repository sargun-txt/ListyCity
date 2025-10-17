package com.example.listycity;

/**
* This is a class that defines a City.
*/
public class City implements Comparable {
    /**
     * This is the name of the city.
     */
    private String city;
    /**
     * This is the name of the province.
     */
    private String province;

    /**
     * This is the constructor for the City class.
     * @param city The name of the city.
     * @param province The name of the province.
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This returns the name of the city.
     * @return The name of the city.
     */
    String getCityName(){
        return this.city;
    }

    /**
     * This returns the name of the province.
     * @return The name of the province.
     */
    String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}
