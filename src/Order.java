import java.util.ArrayList;

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

    public void orderDrinks() {
        System.out.println("Please select from the following Drinks:");
        restaurant.getMenu().displayDrinks();
    }


}
