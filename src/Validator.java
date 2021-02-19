import java.util.ArrayList;
import java.util.Scanner;

public class Validator {


    public static int payment(int paymentEntry) {
        Scanner scan = new Scanner(System.in);
        while (paymentEntry != 1 && paymentEntry != 2) {
            System.out.println("Please enter a valid entry.");
            paymentEntry = scan.nextInt();
        }
        return paymentEntry;
    }

    public static int restaurantSelection(int restSelection, ArrayList<Restaurant> rest) {
        Scanner scan = new Scanner(System.in);
        while(restSelection > (rest.size())|| restSelection == 0) {
            System.out.println("Please enter a valid entry.");
            restSelection = scan.nextInt();
        }
        return restSelection;
    }

    public static int drinkSelection(int selectedItem, ArrayList<Drink> drink) {
        Scanner scan = new Scanner(System.in);
        while(selectedItem > drink.size()){
            System.out.println("Please enter a valid entry.");
            selectedItem = scan.nextInt();
        }
        return selectedItem;
    }

}
