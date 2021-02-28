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

    public User initUser() {
        User user = new User();
        user.create();
        return user;
    }

    public Restaurant selectRestaurant() {
        System.out.println("\nPlease select from the following restaurants: ");
        System.out.println("1");
        ArrayList<Restaurant> rest = Restaurant.displayAll();
        for (Restaurant r : rest) {
            System.out.println(r.toString());
        }
        System.out.println("2");
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        int selection = 0;
        while (!isValid) {
            try {
                selection = scan.nextInt();
                System.out.println("3");
                selection = Validator.restaurantSelection(selection,rest);
                System.out.println("4");
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid entry");
                scan.next();
            }
        }
        return rest.get(selection-1);
    }


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
