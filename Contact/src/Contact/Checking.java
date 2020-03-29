package Contact;

import java.util.Scanner;

/**
 *
 * @author Le Duc Hoa
 */
public class Checking {

    private final static Scanner in = new Scanner(System.in);
    private static final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    /**
     * check input menu
     * @param min
     * @param max
     * @return 
     */
    public static int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int num = Integer.parseInt(in.nextLine().trim());
                if (num < min || num > max) {
                    throw new Exception();
                }
                return num;
            } catch (Exception e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    /**
     * check string empty
     * @return 
     */
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    /**
     * check id delete
     * @return 
     */
    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * check phone number
     * @return 
     */
    public static String checkPhone() {
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_PHONE)) {
                System.out.println("Successful");
                return result;
            } else {
                System.out.println("Please input Phone flow");
                System.out.println(". 1234567890");
                System.out.println(". 123-456-7890");
                System.out.println(". 123-456-7890 x1234");
                System.out.println(". 123-456-7890 ext1234");
                System.out.println(". (123)-456-7890");
                System.out.println(". 123.456.7890");
                System.out.println(". 123 456 7890");
                System.out.print("Enter again: ");
            }
        }
    }
}
