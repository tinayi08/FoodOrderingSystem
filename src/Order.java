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
        orderNumber++;
        System.out.println("Your order number is: " + orderNumber);
    }

    public Order(User customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
    }

    public void orderDrinks() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section. ");
        int selectedDrink = scan.nextInt();
        ArrayList<Drink> drinksOrdered = new ArrayList<>();
        while(selectedDrink != 0) {
            Drink addDrink = OrderHelper.getDrink(selectedDrink);
            drinksOrdered.add(addDrink);
            System.out.println("Order has been added. Please add another selection or enter 0 to move to the next section.");
            selectedDrink = scan.nextInt();
        }

        System.out.println("Drinks added:");
        for (Drink d : drinksOrdered) {
            System.out.println(d.drinkAdded());
        }

    }

}
