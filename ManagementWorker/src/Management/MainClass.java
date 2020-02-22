package Management;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    /**
     * listWorker: contain list of worker listHistory: contain list of history
     */

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Store list of worker and list of istory
        ArrayList<Worker> listWorker = new ArrayList<>();
        ArrayList<History> listHistory = new ArrayList<>();

        while (true) {
            int choice = Processing.menu();
            switch (choice) {
                case 1: {
                    System.out.println("--------- Add Worker ---------");
                    Processing.addWorker(listWorker);
                    break;
                }
                case 2: {
                    System.out.println("------ Increase salary for worker ------");
                    Processing.changeSalary(listWorker, listHistory, 2);
                    break;

                }
                case 3: {
                    System.out.println("------- Decrease salary for worker ------");
                    Processing.changeSalary(listWorker, listHistory, 0);
                    break;

                }
                case 4: {
                    System.out.println("------ Show adjusted salary worker information. --------");
                    Processing.display(listHistory);
                    break;
                }
                case 5: {
                    System.out.println("Thank you <3 !!!");
                    return;
                }
            }
        }
    }
}
