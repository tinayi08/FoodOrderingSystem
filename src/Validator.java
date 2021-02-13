import java.util.Scanner;

public class Validator {
    //this class will handle incorrect answers from user
    public static int payment(int paymentEntry) {
        Scanner scan = new Scanner(System.in);
        while (paymentEntry != 1 && paymentEntry != 2) {
            System.out.println("Please enter a valid entry.");
            paymentEntry = scan.nextInt();
        }
        return paymentEntry;
    }

}
