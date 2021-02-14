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
        System.out.println("\nPlease select from the items above to add to your order:");
        int selectedDrink = scan.nextInt();
        Drink addDrink = OrderHelper.getDrink(selectedDrink);
        ArrayList<Drink> drinksOrdered = new ArrayList<>();
        drinksOrdered.add(addDrink);
        for (Drink d : drinksOrdered) {
            System.out.println(d.toString());
        }
    }

}
