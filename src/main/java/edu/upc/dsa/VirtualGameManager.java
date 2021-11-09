package edu.upc.dsa;

import edu.upc.dsa.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public interface VirtualGameManager {



    List<User> getUsersByName();
    User showUserInfo (String name);
    void placeSeenByUser(PassPlace passPlace);
    List<Place> allPlacesSeenByUser(String name);
    List<User> usersThatSeenThisPlace(String placeName);
    List<User> getUsersByPlacesSeen (String User);
    User getUser(String user);
    void addUser(String user, String id);
    void addPlace(String name);
    void clear();
}
