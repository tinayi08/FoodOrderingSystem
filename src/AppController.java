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
        //adds drinks to order and get total
        //display booze, selects booze, adds booze to order and get total
        //display food, selects food, adds food to order and gets total
        //display order total and order number

    }
}



//once they have selected what they want, it will be added to the order object, then display order etc

//enter drink order based on ID number, then get the value and add it to their array list of drinks, foods, booze, etc


