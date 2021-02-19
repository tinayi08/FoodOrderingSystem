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



    public void orderDrinks() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section.");
        int selectedDrink = scan.nextInt();
        ArrayList<Drink> drinksOrdered = new ArrayList<>();
        while (selectedDrink != 0) {
            //selectedDrink = Validator.drinkSelection(selectedDrink, );
            Drink addDrink = OrderHelper.getDrink(selectedDrink);
            drinksOrdered.add(addDrink);
            System.out.println("Item has been added. Please add another item or enter 0 to move to the next section.");
            selectedDrink = scan.nextInt();
        }
        System.out.println("Drinks added:");
        for (Drink d : drinksOrdered) {
            System.out.println(d.drinkAdded());
        }
    }

    public void orderFood() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section.");
        int selectedFood = scan.nextInt();
        ArrayList<Food> foodOrdered = new ArrayList<>();
        while (selectedFood != 0) {
            //selectedFood = Validator.drinkSelection(selectedDrink, )
            Food addFood = OrderHelper.getFood(selectedFood);
            foodOrdered.add(addFood);
            System.out.println("Item has been added. Please add another item or enter 0 to move to the next section.");
            selectedFood = scan.nextInt();
        }
        System.out.println("Food added:");
        for (Food f : foodOrdered) {
            System.out.println(f.foodAdded());
        }
    }

    public void orderBooze() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section.");
        int selectedbooze = scan.nextInt();
        ArrayList<AlcoholicDrink> boozeOrdered = new ArrayList<>();
        while (selectedbooze != 0) {
            //selectedFood = Validator.drinkSelection(selectedDrink, )
            AlcoholicDrink addBooze = OrderHelper.getBooze(selectedbooze);
            boozeOrdered.add(addBooze);
            System.out.println("Item has been added. Please add another item or enter 0 to move to the next section.");
            selectedbooze = scan.nextInt();
        }
        System.out.println("Alcoholic drink added:");
        for (AlcoholicDrink a : boozeOrdered) {
            System.out.println(a.boozeAdded());
        }
    }

    public void placeOrder() {
        System.out.println("\nThank you for your order.");
        populateOrderNum();

    }

}
