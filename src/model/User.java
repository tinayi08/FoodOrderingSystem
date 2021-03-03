package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    private String name;
    private String address;
    private String phoneNumber;
    private int paymentMethod; //1 for cash, 2 for credit card

    /**
     * This method will take user input to create a user profile.
     *
     */
    public void create() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        this.name = scan.nextLine();
        System.out.println("Please provide your address");
        this.address = scan.nextLine();
        System.out.println("Please provide your phone number");
        this.phoneNumber = scan.nextLine();
        System.out.println("What will be your method of payment? Enter 1 for Cash or 2 for Credit Card?");
        boolean isValid = false;
        while (!isValid) {
            try {
                int paymentEntry = scan.nextInt();
                paymentEntry = Validator.payment(paymentEntry);
                this.paymentMethod = paymentEntry;
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid entry");
                scan.next();
            }
        }
    }
}