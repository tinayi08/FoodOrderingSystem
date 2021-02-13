import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MenuHelper {

    public static ArrayList populateBooze() {
        ArrayList <AlcoholicDrink> boozeList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/Files/Booze.txt"));
            String str;
            //TODO - add a condition where readLine is not null and not an empty line
            while ((str = in.readLine()) != null){
                String [] boozeInfo = str.split(",");
                int number = Integer.parseInt(boozeInfo[0]);
                String name = boozeInfo[1];
                int calories = Integer.parseInt(boozeInfo[2]);
                double price = Double.parseDouble(boozeInfo[3]);
                String alcohol = boozeInfo[4];
                double percentage = Double.parseDouble(boozeInfo[5]);
                AlcoholicDrink booze = new AlcoholicDrink(number, name, calories, price, alcohol, percentage);
                boozeList.add(booze);
            }
            in.close();
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }catch (IOException exc) {
            exc.printStackTrace();
        }
        return boozeList;
    }

    /**
     * Method will read drink items from the file and will populate and
     * return as an ArrayList Drink
     *
     * @return ArrayList Drink
     */
    public static ArrayList populateDrink(String restaurantName) {

        ArrayList <Drink> drinkItems = new ArrayList<>();
         try {
             BufferedReader in = new BufferedReader(new FileReader("src/Files/Drinks.txt"));
             String str;
             while((str = in.readLine()) != null) {
                 String [] drinkInfo = str.split(",");
                 if(restaurantName.equalsIgnoreCase(drinkInfo[4])){
                     int id = Integer.parseInt(drinkInfo[0]);
                     String drinkName = drinkInfo[1];
                     int calories = Integer.parseInt(drinkInfo[2]);
                     double price = Double.parseDouble(drinkInfo[3]);
                     Drink drinks = new Drink(id, drinkName, calories, price);
                     drinkItems.add(drinks);
                 }

             }
             in.close();
         } catch (FileNotFoundException exc) {
             exc.printStackTrace();
         } catch (IOException exc) {
             exc.printStackTrace();
         }
         return drinkItems;


    }

    /**
     *
     * Method will read food items from the file and will populate
     * and return as an ArrayList Food
     *
     * @return ArrayList Food
     */
    public static ArrayList populateFood() {

        ArrayList <Food> foodItems = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/Files/Food.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                String [] foodInfo = str.split(",");
                int id = Integer.parseInt(foodInfo[0]);
                String name = foodInfo[1];
                int calories = Integer.parseInt(foodInfo[2]);
                double price = Double.parseDouble(foodInfo[3]);
                Food food = new Food(id, name, calories, price);
                foodItems.add(food);

            }
            in.close();
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }catch (IOException exc) {
            exc.printStackTrace();
        }
        return foodItems;


    }
}
