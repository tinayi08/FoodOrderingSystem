import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu {
    ArrayList<Drink> drinks;
    ArrayList<Food> food;
    ArrayList<AlcoholicDrink> booze;

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public void setFood(ArrayList<Food> food) {
        this.food = food;
    }

    public Menu(ArrayList<Food> food, ArrayList<Drink> drinks, ArrayList<AlcoholicDrink> booze) {
        this.drinks = drinks;
        this.food = food;
        this.booze = booze;
    }

    public int displayDrinks() {
        if(drinks.size() > 0) {
            System.out.println("\nPlease select from the following beverages:");
            for (Drink d : drinks) {
                System.out.println(d.toString());
            }
            return drinks.size();
        }
        return 0;

    }

    public int displayFood() {
        if(food.size() > 0) {
            System.out.println("\nPlease select from the following food items:");
            for (Food f : food) {
                System.out.println(f.toString());
            }
            return food.size();
        }
        return 0;

    }

    public int displayBooze() {
        if(booze.size() > 0) {
            System.out.println("\nPlease select from the following alcoholic beverages:");
            for (AlcoholicDrink b : booze) {
                System.out.println(b.toString());
            }
            return booze.size();
        }
        return 0;

    }
}

