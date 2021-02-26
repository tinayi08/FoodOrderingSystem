import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    User customer;
    Restaurant restaurant;
    ArrayList<Drink> drinksOrdered;
    ArrayList <Food> foodOrdered;
    ArrayList <AlcoholicDrink> boozeOrdered;
    int totalPrice; //total price for food & total price for drinks and then create an order total - cant do it in one step because its coming from drinks array and food array
    static int orderNumber;

    public static void populateOrderNum() {
        orderNumber = 1000;
        orderNumber++;
        System.out.println("Your order number is: " + orderNumber);
    }

    public Order(User customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
    }



    public ArrayList orderDrinks() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section.");
        int selectedDrink = scan.nextInt();
        ArrayList<Drink> drinksOrdered = new ArrayList<>();
        while (selectedDrink != 0) {
            selectedDrink = Validator.drinkSelection(selectedDrink, MenuHelper.populateDrink(this.restaurant.getName()));
            if(selectedDrink != 0) {
                Drink addDrink = OrderHelper.getDrink(selectedDrink);
                drinksOrdered.add(addDrink);
                System.out.println("Item has been added. Please add another item or enter 0 to move to the next section.");
                selectedDrink = scan.nextInt();
            }
        }
        if (drinksOrdered.size() > 0) {
            System.out.println("Drinks added:");
            for (Drink d : drinksOrdered) {
                System.out.println(d.drinkAdded());
            }
        }
        return drinksOrdered;
    }


    public ArrayList orderFood() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section.");
        int selectedFood = scan.nextInt();
        ArrayList<Food> foodOrdered = new ArrayList<>();
        while (selectedFood != 0) {
            selectedFood = Validator.foodSelection(selectedFood, MenuHelper.populateFood(this.restaurant.getName()));
            if(selectedFood != 0) {
                Food addFood = OrderHelper.getFood(selectedFood);
                foodOrdered.add(addFood);
                System.out.println("Item has been added. Please add another item or enter 0 to move to the next section.");
                selectedFood = scan.nextInt();
            }
        }
        if(foodOrdered.size() > 0) {
            System.out.println("Food added:");
            for (Food f : foodOrdered) {
                System.out.println(f.foodAdded());
            }
        }
        return foodOrdered;
    }

    public ArrayList orderBooze() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section.");
        int selectedBooze = scan.nextInt();
        ArrayList<AlcoholicDrink> boozeOrdered = new ArrayList<>();
        while (selectedBooze != 0) {
            selectedBooze = Validator.boozeSelected(selectedBooze, MenuHelper.populateBooze(this.restaurant.getName()));
            if(selectedBooze != 0) {
                AlcoholicDrink addBooze = OrderHelper.getBooze(selectedBooze);
                boozeOrdered.add(addBooze);
                System.out.println("Item has been added. Please add another item or enter 0 to move to the next section.");
                selectedBooze = scan.nextInt();
            }

        }
        if(boozeOrdered.size() > 0) {
            System.out.println("Alcoholic drink added:");
            for (AlcoholicDrink a : boozeOrdered) {
                System.out.println(a.boozeAdded());
            }
        }
        return boozeOrdered;

    }

    public double boozeTotal(ArrayList<AlcoholicDrink> boozeOrdered) {
        double boozeTotal = 0;
        for(AlcoholicDrink b : boozeOrdered) {
            boozeTotal += b.getPrice();
        }
        //System.out.println("Alcohol total: " + boozeTotal);
        return boozeTotal;
    }

    public double foodTotal(ArrayList<Food> foodOrdered) {
        double foodTotal = 0;
        for(Food f : foodOrdered) {
            foodTotal += f.getPrice();
        }
        //System.out.println("Food total: " + foodTotal);
        return foodTotal;
    }

    public double drinkTotal(ArrayList<Drink> drinkOrdered) {
        double drinkTotal = 0;
        for(Drink d : drinkOrdered) {
            drinkTotal += d.getPrice();
        }
        //System.out.println("Food total: " + foodTotal);
        return drinkTotal;
    }


    public void placeOrder() {
        System.out.println("\nThank you for your order.");
        populateOrderNum();

    }



}
