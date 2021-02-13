import java.util.ArrayList;
import java.util.Scanner;

public class AppController {

    public static void main(String[] args) {
        AppController controller = new AppController();
        controller.initUser();
        controller.orderingLogic();
    }

    public void initUser() {
        User user = new User();
        user.create();
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

    public void orderingLogic(){
        Restaurant selectedRestaurant = selectRestaurant();
        selectedRestaurant.getMenu().displayDrinks();
        selectedRestaurant.getMenu().displayFood();
        selectedRestaurant.getMenu().displayBooze();
        //user selects drinks
        //adds drinks to order and get total
        //display booze, selects booze, adds booze to order and get total
        //display food, selects food, adds food to order and gets total
        //display order total and order number

    }
}


//for the user to select from. be able to select item

//once they have selected what they want, it will be added to the order object, then display order etc

//display menu
//enter drink order based on ID number, then get the value and add it to their array list of drinks, foods, booze, etc


