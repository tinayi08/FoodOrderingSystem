import java.util.ArrayList;
import java.util.Scanner;

public class AppController {

    public static void main(String[] args) {
        AppController controller = new AppController();
        //controller.initUser();
        controller.orderingLogic(controller.initUser());
    }

    public User initUser() {
        User user = new User();
        user.create();
        return user;
    }

    public Restaurant selectRestaurant() {
        System.out.println("\nPlease select from the following restaurants: ");
        ArrayList<Restaurant> rest = Restaurant.displayAll();
        for(Restaurant r : rest) {
            System.out.println(r.toString());
        }
        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();
        selection = Validator.restaurantSelection(selection,rest);
        return rest.get(selection-1);
    }


    public void orderingLogic(User user){
        Restaurant selectedRestaurant = selectRestaurant();
        Order order = new Order(user, selectedRestaurant);
        int numOfDrinkItems = selectedRestaurant.getMenu().displayDrinks();
        if (numOfDrinkItems > 0) {
            order.orderDrinks();
        }
        int numOfFoodItems = selectedRestaurant.getMenu().displayFood();
        if(numOfFoodItems > 0) {
            order.orderFood();
        }
        int numOfBoozeItems = selectedRestaurant.getMenu().displayBooze();
        if (numOfBoozeItems > 0) {
            order.orderBooze();
        }


        //get totals from each section


        order.placeOrder();
    }
}
