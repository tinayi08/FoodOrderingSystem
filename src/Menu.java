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

    public void display() {

        for (Drink d : drinks) {
            System.out.println(d.toString());
        }

        for (Food f : food) {
            System.out.println(f.toString());
        }

        for (AlcoholicDrink a : booze) {
            System.out.println(a.toString());
        }
    }

    public void displayDrinks() {
        System.out.println("\nPlease select from the following items:");
        for (Drink d : drinks) {
            System.out.println(d.toStringForOrdering());
        }
    }

    public void displayFood() {
        System.out.println("\nPlease select from the following items:");
        for (Food f : food) {
            System.out.println(f.toStringForOrdering());
        }
    }
}

