package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Place {

    String placeName;
    String userName;


    public Place(){}

    public Place(String placeName, String userName) {
        this.placeName = placeName;
        this.userName = userName;
    }
    public Place(User user)
    {
        this.userName = user.getName();

    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeName='" + placeName + '\'' +
                '}';
    }
}
