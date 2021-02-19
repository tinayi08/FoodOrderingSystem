public class Food {
    double price;
    int calories;
    String name;
    int id;

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

    public Food(int id, String name, int calories,double price) {
        this.price = price;
        this.calories = calories;
        this.name = name;
        this.id = id;
    }

    public String foodAdded() {
        return name;
    }

}


