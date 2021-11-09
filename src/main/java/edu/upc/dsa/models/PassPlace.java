package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class PassPlace {
    String userName;
    public List<Place> placeList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    public PassPlace(String userName) {
        this.userName = userName;

    }
    public PassPlace (User user)
    {
        this.userName = user.getName();
        this.placeList = new ArrayList<Place>();
    }
    public void addP(Place place) {

        placeList.add(place);
    }
}
