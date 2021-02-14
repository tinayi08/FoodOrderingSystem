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
            BufferedReader in = new BufferedReader(new FileReader("src/Files/Drinks.txt"));
            String str;
            while((str = in.readLine()) != null) {
                String [] drinkInfo = str.split(",");
                id = Integer.parseInt(drinkInfo[0]);
                if(id == selectedDrinkID) {
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

}
