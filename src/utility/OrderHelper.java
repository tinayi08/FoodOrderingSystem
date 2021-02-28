package utility;

import model.AlcoholicDrink;
import model.Drink;
import model.File;
import model.Food;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OrderHelper {

    public static Drink getDrink(int selectedDrinkID) {
        int id = 0;
        String drinkName = "";
        int calories = 0;
        double price = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader(File.DRINKS.path));
            String str;
            while ((str = in.readLine()) != null) {
                String [] drinkInfo = str.split(",");
                id = Integer.parseInt(drinkInfo[0]);
                if (id == selectedDrinkID) {
                    drinkName = drinkInfo[1];
                    calories = Integer.parseInt(drinkInfo[2]);
                    price = Double.parseDouble(drinkInfo[3]);
                    break;
                }

            }
            in.close();
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        Drink drink = new Drink(id, drinkName, calories, price);
        return drink;
    }

    public static Food getFood(int selectedFoodID) {
        int id = 0;
        String name = "";
        int calories = 0;
        double price = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader(File.FOOD.path));
            String str;
            while ((str = in.readLine()) != null) {
                String [] foodInfo = str.split(",");
                id = Integer.parseInt(foodInfo[0]);
                if (id == selectedFoodID) {
                    name = foodInfo[1];
                    calories = Integer.parseInt(foodInfo[2]);
                    price = Double.parseDouble(foodInfo[3]);
                    break;
                }

            }
            in.close();
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        Food food = new Food(id, name, calories, price);
        return food;
    }

    public static AlcoholicDrink getBooze(int selectedBoozeID) {
        int id = 0;
        String name = "";
        int calories = 0;
        double price = 0;
        String alcohol = "";
        double percentage = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader(File.BOOZE.path));
            String str;
            while ((str = in.readLine()) != null) {
                String [] boozeInfo = str.split(",");
                id = Integer.parseInt(boozeInfo[0]);
                if (id == selectedBoozeID) {
                    name = boozeInfo[1];
                    calories = Integer.parseInt(boozeInfo[2]);
                    price = Double.parseDouble(boozeInfo[3]);
                    alcohol = boozeInfo[4];
                    percentage = Double.parseDouble(boozeInfo[5]);
                    break;
                }
            }
            in.close();
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        AlcoholicDrink booze = new AlcoholicDrink(id, name, calories, price, alcohol, percentage);
        return booze;
    }
}
