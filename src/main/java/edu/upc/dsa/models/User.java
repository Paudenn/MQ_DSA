package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String id;
    int numPlaces = 0;
    List<Place> placeList;


    public User(String name, List<Place> placeList,String id) {
        this.name = name;
        this.placeList = placeList;
        this.id = id;
    }
    public User(String name, String id) {
        this.name = name;
        this.id = id;
        placeList = new ArrayList<>();
    }
    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", numPlaces=" + numPlaces +
                ", placeList=" + placeList +
                '}';
    }
}
