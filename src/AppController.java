import java.util.ArrayList;
import java.util.Scanner;

public class AppController {

    public static void main(String[] args) {
        AppController controller = new AppController();
        controller.orderingLogic(controller.initUser());
        //controller.finalizeOrder(controller.initUser());
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
        double foodTotal = 0;
        double boozeTotal = 0;
        double drinkTotal = 0;
        int numOfDrinkItems = selectedRestaurant.getMenu().displayDrinks();
        if (numOfDrinkItems > 0) {
            drinkTotal = order.drinkTotal(order.orderDrinks());
        }
        int numOfFoodItems = selectedRestaurant.getMenu().displayFood();
        if(numOfFoodItems > 0) {
            foodTotal = order.foodTotal(order.orderFood());
            //order.orderFood();
        }
        int numOfBoozeItems = selectedRestaurant.getMenu().displayBooze();
        if (numOfBoozeItems > 0) {
            boozeTotal = order.boozeTotal(order.orderBooze());
            //order.orderBooze();
        }
        double total = foodTotal + boozeTotal + drinkTotal;
        System.out.println("\nOrder total is: " + total);
        order.placeOrder();
        //return order;

    }
//MenuHelper.populateBooze(order.restaurant.getName())
//    public void finalizeOrder(User user) {
//        Order order = orderingLogic(user);
//
//        order.placeOrder();
//
//    }

}
