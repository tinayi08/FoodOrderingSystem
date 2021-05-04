package utility;

import model.AlcoholicDrink;
import model.Drink;
import model.Food;

import java.io.IOException;
import java.sql.*;

public class OrderHelper {
    /**
     * This method will read a list of drinks from a file and will list them
     * for the user to chose from
     *
     * @param selectedDrinkID
     * @return user selected Drink
     */
    public static Drink getDrink(int selectedDrinkID) {
        int id = 0;
        String drinkName = "";
        int calories = 0;
        double price = 0;
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


            while (resultSet.next()) {

                id = resultSet.getInt("id");
                if (id == selectedDrinkID) {
                    drinkName = resultSet.getString("drink");
                    calories = resultSet.getInt("calories");
                    price = resultSet.getDouble("price");
                    break;
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

        Drink drink = new Drink(id, drinkName, calories, price);
        return drink;
    }

    /**
     * This method will read a list of Food from a file and will list them
     * for the user to chose from
     *
     * @param selectedFoodID
     * @return user selected Food
     */
    public static Food getFood(int selectedFoodID) {
        int id = 0;
        String name = "";
        int calories = 0;
        double price = 0;

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

            String query = "SELECT * FROM FoodOrderingSystem.food;";

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                id = resultSet.getInt("id");
                if (id == selectedFoodID) {
                    name = resultSet.getString("item");
                    calories = resultSet.getInt("calories");
                    price = resultSet.getDouble("price");
                    break;
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

        Food food = new Food(id, name, calories, price);
        return food;
    }

    /**
     * This method will read a list of Alcoholic Drinks available from a file
     * and will display them for the user to chose from
     *
     * @param selectedBoozeID
     * @return user selected AlcoholicDrink
     */
    public static AlcoholicDrink getBooze(int selectedBoozeID) {
        int id = 0;
        String name = "";
        int calories = 0;
        double price = 0;
        String alcohol = "";
        double percentage = 0;

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

            resultSet = statement.executeQuery(query);



            while (resultSet.next()) {

                id = resultSet.getInt("id");
                if (id == selectedBoozeID) {
                    name = resultSet.getString("drink");
                    calories = resultSet.getInt("calories");
                    price = resultSet.getDouble("price");
                    alcohol = resultSet.getString("type");
                    percentage = resultSet.getDouble("percent");
                    break;
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

        AlcoholicDrink booze = new AlcoholicDrink(id, name, calories, price, alcohol, percentage);
        return booze;
    }
}
