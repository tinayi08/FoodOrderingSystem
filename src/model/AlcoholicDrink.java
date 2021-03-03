package model;

public class AlcoholicDrink extends Drink {
    private String liquorType;
    private double percentage;

    public AlcoholicDrink(int id, String name, int calories, double price, String liquorType, double percentage) {
        super(id, name, calories, price);
        this.liquorType = liquorType;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Select " + id +
                " for " + name +
                ", Liquor Type: " + liquorType +
                ", Calories: " + calories +
                ", Alcohol Percentage: " + percentage +
                "%, Price: $" + price;
    }

    public String boozeAdded() {
        return name;
    }
}
