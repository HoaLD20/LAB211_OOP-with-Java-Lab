/**
 *
 * @author Le Duc Hoa
 */
package Matrix;

import java.util.Scanner;

public class MainClass {

    public static Scanner scanner = new Scanner(System.in);

    //Display menu for user
    public static void menu() {
        System.out.println("==========Caculator program==========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtration Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
    }

    public static void main(String[] args) {
        while (true) {
            menu();
            int choice = Checking.checkInput(1, 4);
            switch (choice) {
                case 1: {
                    System.out.println("\n------ Addition ------");
                    new Processing().addMatrix();
                    break;
                }
                case 2: {
                    System.out.println("\n------- Subtration ------");
                    new Processing().subMatrix();
                    break;

                }
                case 3: {
                    System.out.println("\n------- Multiplication --------");
                    new Processing().mulMatrix();
                    break;

                }
                case 4:{
                    return;
                }
            }

        }
    }
}
