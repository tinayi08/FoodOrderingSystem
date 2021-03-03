package model;

import model.AlcoholicDrink;
import model.Drink;
import model.Food;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Drink> drinks;
    private ArrayList<Food> food;
    private ArrayList<AlcoholicDrink> booze;

    public Menu(ArrayList<Food> food, ArrayList<Drink> drinks, ArrayList<AlcoholicDrink> booze) {
        this.drinks = drinks;
        this.food = food;
        this.booze = booze;
    }


    public int displayDrinks() {
        if (drinks.size() > 0) {
            System.out.println("\nPlease select from the following beverages:");
            for (Drink d : drinks) {
                System.out.println(d.toString());
            }
            return drinks.size();
        }
        return 0;
    }

    public int displayFood() {
        if (food.size() > 0) {
            System.out.println("\nPlease select from the following food items:");
            for (Food f : food) {
                System.out.println(f.toString());
            }
            return food.size();
        }
        return 0;
    }

    public int displayBooze() {
        if (booze.size() > 0) {
            System.out.println("\nPlease select from the following alcoholic beverages:");
            for (AlcoholicDrink b : booze) {
                System.out.println(b.toString());
            }
            return booze.size();
        }
        return 0;
    }
}

