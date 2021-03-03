package model;

public class Drink extends MenuItems{

    public Drink(int id, String name, int calories, double price) {
        super(id, name, calories, price);
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Select " + id +
                " for " + name +
                ", Calories: " + calories +
                ", Price: $" + price;
    }

    public String drinkAdded() {
        return name;
    }
}


