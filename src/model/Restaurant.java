package model;

import utility.MenuHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String cuisine;
    private int zipcode;
    private String phoneNumber;
    private int capacity;
    private int averageWaitTime;
    private Menu menu;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Restaurant(int id, String name, String cuisine, int zipcode, String phoneNumber, int capacity, int averageWaitTime) {
        this.name = name;
        this.cuisine = cuisine;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.capacity = capacity;
        this.averageWaitTime = averageWaitTime;
        this.id = id;
        this.menu = new Menu(MenuHelper.populateFood(this.name), MenuHelper.populateDrink(this.name), MenuHelper.populateBooze(this.name));

    }

    public static ArrayList displayAll() {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(File.RESTAURANTS.path));
            String str;
            while ((str = in.readLine()) != null) {
                String [] restaurantInfo = str.split(",");
                int id = Integer.parseInt(restaurantInfo[0]);
                String name = restaurantInfo[1];
                String cuisine = restaurantInfo[2];
                int zipcode = Integer.parseInt(restaurantInfo[3]);
                String phoneNumber = restaurantInfo[4];
                int capacity = Integer.parseInt(restaurantInfo[5]);
                int averageWaitTime = Integer.parseInt(restaurantInfo[6]);
                
                Restaurant restaurants = new Restaurant(id, name, cuisine, zipcode, phoneNumber, capacity, averageWaitTime);
                restaurantList.add(restaurants);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return restaurantList;
    }

    @Override
    public String toString() {
        return "Select " + id +
                " for " + name +
                ", Cuisine: " + cuisine +
                ", Average Wait Time: " + averageWaitTime;
    }
}