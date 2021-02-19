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
        selectedRestaurant.getMenu().displayDrinks();
        order.orderDrinks();
        selectedRestaurant.getMenu().displayFood();
        order.orderFood();
        selectedRestaurant.getMenu().displayBooze();
        order.orderBooze();
        //get totals from each section
        //how to get the validator to work
        //need to add a validator to only allow order placing for items listed not for other restaurants
        //skip sections if there is no items for that restaurant
        order.placeOrder();
    }
}
