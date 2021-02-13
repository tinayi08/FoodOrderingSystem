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

    public void displayDrinks() {
        System.out.println("\nPlease select from the following beverages:");
        for (Drink d : drinks) {
            System.out.println(d.toString());
        }
    }

    public void displayFood() {
        System.out.println("\nPlease select from the following food items:");
        for (Food f : food) {
            System.out.println(f.toString());
        }
    }

    public void displayBooze() {
        System.out.println("\nPlease select from the following alcoholic beverages:");
        for (AlcoholicDrink b : booze) {
            System.out.println(b.toString());
        }
    }
}

