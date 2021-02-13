import java.lang.reflect.Array;
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
        Restaurant chipotle = new Restaurant(1,"Chipotle", "Mexican Fast Food", 92780,
                "949-555-5555", 25, 45);
        //Restaurant.display();
        System.out.println("Select 1 for " + chipotle.name + " - " + chipotle.cuisine + ", current wait time is " + chipotle.averageWaitTime + " minutes.");
        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();
        //add a validator - while selection is less than arrayList length
//        if(selection == 1) { // display the restaurant menu according to the ID
//            chipotle.getMenu().display();
//        }

        return chipotle;
    }

    public void orderingLogic(){
        selectRestaurant().getMenu().displayDrinks();
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


