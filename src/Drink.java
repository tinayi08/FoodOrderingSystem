public class Drink {
    int id;
    String name;
    int calories;
    double price;

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Drink(int id, String name, int calories, double price) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.price = price;

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


