package edu.upc.dsa;

import edu.upc.dsa.models.PassPlace;
import edu.upc.dsa.models.Place;
import edu.upc.dsa.models.User;


import java.util.*;
import java.util.logging.Logger;

public class VirtualGameManagerImpl implements VirtualGameManager {
    /*
    public List<Product> productsList = new ArrayList<>();
    public Queue<Order> ordersList = new LinkedList<>();

    private int sellCount;

     */
    private static VirtualGameManagerImpl instance;
    HashMap<String,User> users = new HashMap<String,User>();
    HashMap<String,Place> places = new HashMap<String,Place>();
    List<User> usersList = new ArrayList<>();
    List<Place> placesList = new ArrayList<>();
    Queue<PassPlace> passPlaceList = new LinkedList<>();
    private int numPlaces;

    final static Logger logger = Logger.getLogger(String.valueOf(VirtualGameManagerImpl.class));


    public static VirtualGameManagerImpl getInstance() {
        if(instance == null)
            instance = new VirtualGameManagerImpl();

        return instance;
    }
    public void addUser(String user, String id) {
        this.usersList.add(new User(user, id));
    }
    public void addPlace(String name)
    {
        this.placesList.add(new Place(name,""));
    }

    @Override
    public List<User> getUsersByName() {
        logger.info("Users list before: " + usersList.toString());
        Collections.sort(usersList, new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {

                return o1.getName().compareTo(o2.getName());
            }
        });
        logger.info("Products after: " + usersList.toString());
        return usersList;
    }
    public User getUser(String user)
    {
        return this.users.get(user);
    }
    @Override
    public User showUserInfo(String name) {

        return this.users.get(name);

    }

    @Override
    public void placeSeenByUser(PassPlace passPlace) {
        passPlaceList.add(passPlace);
        users.get(passPlace.getUserName()).setNumPlaces(numPlaces++);

    }

    @Override
    public List<Place> allPlacesSeenByUser(String name) {
        return users.get(name).getPlaceList();

    }

    @Override
    public List<User> usersThatSeenThisPlace(String placeName) {
        List<User> userListForPlace = new ArrayList<>();
        User user = new User();
        user.setName(places.get(placeName).getUserName());
        userListForPlace.add(user);
        return userListForPlace;
    }

    @Override
    public List<User> getUsersByPlacesSeen(String User) {
        logger.info("Users list before: " + usersList.toString());
        Collections.sort(usersList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getNumPlaces() - o2.getNumPlaces();
            }
        });
        logger.info("Users list after: " + usersList.toString());
        return usersList;
    }
    public void clear() {
        users.clear();
        placesList.clear();
        passPlaceList.clear();
        usersList.clear();
        places.clear();
        users.clear();
    }

    /*
    @Override
    public List<Product> getProductsByPrice() {
        logger.info("Products before: " + productsList.toString());
        Collections.sort(productsList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int)o1.getPrice() - (int)o2.getPrice();
            }
        });
        logger.info("Products after: " + productsList.toString());
        return productsList;
    }
    @Override
    public void doOrder(Order order) {
        ordersList.add(order);
        User client = order.getUser();
        client.getOrderList().add(order);

    }

     */

    /*
    public User getUser(String user)
    {
        return this.users.get(user);
    }

    public List<Product> getProductsList(){
        return productsList;
    }
    public Queue<Order> getOrdersList() {
        return this.ordersList;
    }

    @Override
    public void serveOrder() {

        Order served = ordersList.poll();
        for(int i=0; i <served.getProductList().size(); i++ ) {
            int j = 0;
            Boolean found = false;
            while(!found && j < productsList.size()) {
                if(productsList.get(j).getName() == served.getProductList().get(i).getName()) {
                    found = true;
                    productsList.get(j).setAmount(productsList.get(j).getAmount() - served.getProductList().get(i).getAmount());
                    sellCount += served.getProductList().get(i).getAmount();
                }
                j++;
            }
        }
    }
    public int getSellsnum(){
        return sellCount;
    }

    @Override
    public List<Order> getOrdersByUser(String user) {


            return users.get(user).getOrderList();
    }

    @Override
    public List<Product> getProductsBySales() {
        List<Product> list = this.productsList;
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                logger.info(String.valueOf(o1.getSells() - o2.getSells()));
                return o1.getSells() - o2.getSells();
            }
        });
        return list;
    }

    public void addProduct(Product product) {
        this.productsList.add(product);
    }

    public int getOrderAmount(){ return this.ordersList.size(); }

    @Override
    public int getNumProducts() {
        return this.productsList.size();
    }

     */

}

