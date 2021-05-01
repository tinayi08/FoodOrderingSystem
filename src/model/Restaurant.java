package model;

import utility.MenuHelper;


import java.sql.*;
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

    /**
     * This method read a list of restaurants from a file and
     * will display all restaurants available to order from.
     *
     * @return ArrayList of restaurants
     */
    public static ArrayList displayAll() {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection with the DB

            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/FoodOrderingSystem?"
                            + "user=root&password=&useSSL=false");

            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();

            String query = "SELECT * FROM FoodOrderingSystem.restaurants;";

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(query);


            // loop through the result set while there are more records
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String cuisine = resultSet.getString("type");
                int zipcode = resultSet.getInt("zipcode");
                String phoneNumber = resultSet.getString("phone");
                int capacity = resultSet.getInt("capacity");
                int averageWaitTime = resultSet.getInt("wait_time");

                Restaurant restaurants = new Restaurant(id, name, cuisine, zipcode, phoneNumber, capacity, averageWaitTime);
                restaurantList.add(restaurants);

            }


        } catch (SQLException exc) {
            System.out.println("Exception occurred");
            exc.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Exception occurred - driver not found on classpath");
            e.printStackTrace();
        } finally {
            try {
                // close all JDBC elements
                statement.close();
                resultSet.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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