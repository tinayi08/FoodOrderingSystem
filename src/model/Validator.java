package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Validator {

    /**
     * This method will check to ensure a valid entry has entered by the user
     *
     * @param paymentEntry
     * @return valid entry
     */
    public static int payment(int paymentEntry) {
        Scanner scan = new Scanner(System.in);
        while (paymentEntry != 1 && paymentEntry != 2) {
            System.out.println("Please enter a valid entry");
            paymentEntry = scan.nextInt();
        }
        return paymentEntry;
    }

    /**
     * This method will check to ensure a valid entry has entered by the user
     *
     * @param restSelection
     * @param rest
     * @return valid entry
     */
    public static int restaurantSelection(int restSelection, ArrayList<Restaurant> rest) {
        Scanner scan = new Scanner(System.in);
        while (restSelection > (rest.size()) || restSelection == 0) {
            System.out.println("Please enter a valid entry");
            restSelection = scan.nextInt();
        }
        return restSelection;
    }

    /**
     * This method will check to ensure a valid entry has entered by the user
     * @param selectedItem
     * @param drink
     * @return valid entry
     */
    public static int drinkSelection(int selectedItem, ArrayList<Drink> drink) {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid){
            for (Drink d : drink) {
                if (selectedItem == d.getId()) {
                    isValid = true;
                    return selectedItem;
                } else if (selectedItem == 0) {
                    return selectedItem;
                }
            }
            System.out.println("Please enter a valid entry");
            selectedItem = scan.nextInt();
        }
        return selectedItem;
    }

    /**
     * This method will check to ensure a valid entry has entered by the user
     *
     * @param selectedItem
     * @param food
     * @return valid entry
     */
    public static int foodSelection(int selectedItem, ArrayList<Food> food) {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid) {
            for (Food f : food) {
                if (selectedItem == f.getId()){
                    isValid = true;
                    return selectedItem;
                } else if (selectedItem == 0) {
                    return selectedItem;
                }
            }
            System.out.println("Please enter a valid entry");
            selectedItem = scan.nextInt();
        }
        return selectedItem;
    }

    /**
     * This method will check to ensure a valid entry has entered by the user
     *
     * @param selectedBooze
     * @param booze
     * @return valid entry
     */
    public static int boozeSelected(int selectedBooze, ArrayList<AlcoholicDrink> booze) {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid) {
            for (AlcoholicDrink b : booze) {
                if (selectedBooze == b.getId()) {
                    isValid = true;
                    return selectedBooze;
                } else if (selectedBooze == 0) {
                    return selectedBooze;
                }
            }
            System.out.println("Please enter a valid entry");
            selectedBooze = scan.nextInt();
        }
        return selectedBooze;
    }
}
