package model;

public class Food extends MenuItems {

    public Food(int id, String name, int calories, double price) {
        super(id, name, calories, price);
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Select " + id +
                " for " + name +
                ", Calories: " + calories +
                ", Price: $" + price;
    }

    public String foodAdded() {
        return name;
    }

}


