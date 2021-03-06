package model;

import utility.MenuHelper;
import utility.OrderHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Order {
    private User customer;
    private Restaurant restaurant;
    private ArrayList<Drink> drinksOrdered;
    private ArrayList<Food> foodOrdered;
    private ArrayList<AlcoholicDrink> boozeOrdered;
    private double totalPrice;
    private static int orderNumber;

    private static void populateOrderNum() {
        orderNumber = 1000;
        orderNumber++;
        System.out.println("Your order number is: " + orderNumber);
    }

    public Order(User customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
    }

    /**
     * This method will allow the user to add drinks to their order.
     * User can select 0 to move to the next menu section.
     * Try/Catch has been added to catch any incorrect entries.
     * Selected drinks will be added to an Array List.
     *
     */
    public void orderDrinks() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section.");
        this.drinksOrdered = new ArrayList<>();
        boolean isValid = false;
        while (!isValid) {
            try {
                int selectedDrink = scan.nextInt();
                while (selectedDrink != 0) {
                    selectedDrink = Validator.drinkSelection(selectedDrink, MenuHelper.populateDrink(this.restaurant.getName()));
                    if (selectedDrink != 0) {
                        Drink addDrink = OrderHelper.getDrink(selectedDrink);
                        this.drinksOrdered.add(addDrink);
                        System.out.println("Item has been added. Please add another item or enter 0 to move to the next section.");
                        selectedDrink = scan.nextInt();
                    }
                }
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid entry");
                scan.next();
            }
        }

    }

    public void printOrderedDrinks() {
        if (this.drinksOrdered.size() > 0) {
            System.out.println("Drinks added:");
            for (Drink d : this.drinksOrdered) {
                System.out.println(d.drinkAdded());
            }
        }
    }

    /**
     * This method will allow the user to add food to their order.
     * User can select 0 to move to the next menu section.
     * Try/Catch has been added to catch any incorrect entries.
     * Selected food will be added to an Array List.
     *
     */
    public void orderFood() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section.");
        this.foodOrdered = new ArrayList<>();
        boolean isValid = false;
        while (!isValid) {
            try {
                int selectedFood = scan.nextInt();
                while (selectedFood != 0) {
                    selectedFood = Validator.foodSelection(selectedFood, MenuHelper.populateFood(this.restaurant.getName()));
                    if (selectedFood != 0) {
                        Food addFood = OrderHelper.getFood(selectedFood);
                        this.foodOrdered.add(addFood);
                        System.out.println("Item has been added. Please add another item or enter 0 to move to the next section.");
                        selectedFood = scan.nextInt();
                    }
                }
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid entry");
                scan.next();
            }
        }
    }

    public void printOrderedFood() {
        if (this.foodOrdered.size() > 0) {
            System.out.println("Food added:");
            for (Food f : this.foodOrdered) {
                System.out.println(f.foodAdded());
            }
        }
    }

    /**
     * This method will allow the user to add alcohol to their order.
     * User can select 0 to move to the next menu section.
     * Try/Catch has been added to catch any incorrect entries.
     * Selected alcohol will be added to an Array List.
     *
     */
    public void orderBooze() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease select from the items above to add to your order or enter 0 to move to the next section.");
        this.boozeOrdered = new ArrayList<>();
        boolean isValid = false;
        while (!isValid) {
            try {
                int selectedBooze = scan.nextInt();
                while (selectedBooze != 0) {
                    selectedBooze = Validator.boozeSelected(selectedBooze, MenuHelper.populateBooze(this.restaurant.getName()));
                    if (selectedBooze != 0) {
                        AlcoholicDrink addBooze = OrderHelper.getBooze(selectedBooze);
                        this.boozeOrdered.add(addBooze);
                        System.out.println("Item has been added. Please add another item or enter 0 to move to the next section.");
                        selectedBooze = scan.nextInt();
                    }
                }
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid entry");
                scan.next();
            }
        }
    }

    public void printOrderedBooze() {
        if (this.boozeOrdered.size() > 0) {
            System.out.println("Alcoholic drink added:");
            for (AlcoholicDrink a : this.boozeOrdered) {
                System.out.println(a.boozeAdded());
            }
        }
    }

    /**
     * This method will calculate the order total and provide an order number.
     *
     */
    public void placeOrder() {
        System.out.println("\nThank you for your order.");
        double foodTotal = 0;
        double boozeTotal = 0;
        double drinkTotal = 0;

        for (Food f : this.foodOrdered) {
            foodTotal += f.getPrice();
        }

        for (Drink d : this.drinksOrdered) {
            drinkTotal += d.getPrice();
        }

        if(this.boozeOrdered != null) {
            for (AlcoholicDrink b : this.boozeOrdered) {
                boozeTotal += b.getPrice();
            }
        }

        this.totalPrice = foodTotal + boozeTotal + drinkTotal;
        DecimalFormat t = new DecimalFormat("#.##");

        System.out.println("\nOrder total is: $" +t.format(this.totalPrice));
        populateOrderNum();
    }

}
