package utility;

import model.AlcoholicDrink;
import model.Drink;
import model.Food;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuHelper {

    /**
     *
     * Method will read alcoholic items from the file and will populate
     * and return as an ArrayList model.AlcoholicDrink
     *
     * @return ArrayList model.AlcoholicDrink
     */
    public static ArrayList populateBooze(String restaurantName) {
        ArrayList<AlcoholicDrink> boozeList = new ArrayList<>();

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

            String query = "SELECT * FROM FoodOrderingSystem.booze;";

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(query);


            // loop through the result set while there are more records
            while (resultSet.next()) {

                String restaurant = resultSet.getString("rest");
                if (restaurantName.equalsIgnoreCase(restaurant)) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("drink");
                    int calories = resultSet.getInt("calories");
                    double price = resultSet.getDouble("price");
                    String alcohol = resultSet.getString("type");
                    double percentage = resultSet.getDouble("percent");

                    AlcoholicDrink booze = new AlcoholicDrink(id, name, calories, price, alcohol, percentage);
                    boozeList.add(booze);
                }
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
        return boozeList;
    }

    /**
     * Method will read drink items from the file and will populate and
     * return as an ArrayList model.Drink
     *
     * @return ArrayList model.Drink
     */
    public static ArrayList populateDrink(String restaurantName) {

        ArrayList<Drink> drinkItems = new ArrayList<>();

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

            String query = "SELECT * FROM FoodOrderingSystem.drinks;";

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(query);

            // loop through the result set while there are more records
            while (resultSet.next()) {

                String restaurant = resultSet.getString("rest");
                if (restaurantName.equalsIgnoreCase(restaurant)) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("drink");
                    int calories = resultSet.getInt("calories");
                    double price = resultSet.getDouble("price");

                    Drink drinks = new Drink(id, name, calories, price);
                    drinkItems.add(drinks);
                }
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
        return drinkItems;
    }

    /**
     *
     * Method will read food items from the file and will populate
     * and return as an ArrayList model.Food
     *
     * @return ArrayList model.Food
     */
    public static ArrayList populateFood(String restaurantName) {

        ArrayList<Food> foodItems = new ArrayList<>();

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

            String query = "SELECT * FROM FoodOrderingSystem.drinks;";

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(query);

            // loop through the result set while there are more records
            while (resultSet.next()) {

                String restaurant = resultSet.getString("rest");
                if (restaurantName.equalsIgnoreCase(restaurant)) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("drink");
                    int calories = resultSet.getInt("calories");
                    double price = resultSet.getDouble("price");

                    Food food = new Food(id, name, calories, price);
                    foodItems.add(food);
                }
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
        return foodItems;
    }
}
