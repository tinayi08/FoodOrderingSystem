import model.Order;
import model.Restaurant;
import model.User;
import model.Validator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppController {

    public static void main(String[] args) {
        AppController controller = new AppController();
        controller.orderingLogic(controller.initUser());
    }

    /**
     * This method will initiate a user.
     *
     * @return a user
     */
    public User initUser() {
        User user = new User();
        user.create();
        return user;
    }

    /**
     * This method will display a list of restaurants for the user
     * to select from.
     *
     * @return returns the selected restaurant
     */
    public Restaurant selectRestaurant() {
        System.out.println("\nPlease select from the following restaurants: ");
        ArrayList<Restaurant> rest = Restaurant.displayAll();
        for (Restaurant r : rest) {
            System.out.println(r.toString());
        }
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        int selection = 0;
        while (!isValid) {
            try {
                selection = scan.nextInt();
                selection = Validator.restaurantSelection(selection,rest);
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid entry");
                scan.next();
            }
        }
        return rest.get(selection-1);
    }

    /**
     * This method will go through the menu items. It will display the list of
     * drinks and allow the user to select what drinks to order. Then go through
     * the list of food and then the list of alcoholic drinks. Once the user has
     * selected the items to order. A order total will display with an order number.
     *
     * @param user
     */
    public void orderingLogic(User user){
        Restaurant selectedRestaurant = selectRestaurant();
        Order order = new Order(user, selectedRestaurant);
        int numOfDrinkItems = selectedRestaurant.getMenu().displayDrinks();
        if (numOfDrinkItems > 0) {
            order.orderDrinks();
            order.printOrderedDrinks();
        }
        int numOfFoodItems = selectedRestaurant.getMenu().displayFood();
        if (numOfFoodItems > 0) {
            order.orderFood();
            order.printOrderedFood();
        }
        int numOfBoozeItems = selectedRestaurant.getMenu().displayBooze();
        if (numOfBoozeItems > 0) {
            order.orderBooze();
            order.printOrderedBooze();
        }
        order.placeOrder();
    }
}
