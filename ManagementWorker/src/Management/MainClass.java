package Management;

import javafx.concurrent.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    /**
     * listWorker: contain list of worker
     * listHistory: contain list of history
     */
    private static final ArrayList<Worker> listWorker = new ArrayList<>();
    private static final ArrayList<History> listHistory = new ArrayList<>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            int choice = Processing.menu();
            switch (choice){
                case 1:{
                    System.out.println("--------- Add Worker ---------");
                    Processing.addWorker(listWorker);
                    break;
                }
                case 2:{
                    System.out.println("------ Increase salary for worker ------");
                    break;

                }
                case 3:{
                    System.out.println("------- Decrease salary for worker ------");
                    break;

                }
                case 4:{
                    System.out.println("------ Show adjusted salary worker information. --------");
                    break;
                }
                case 5:{
                    System.out.println("Thank you <3 !!!");
                    return;
                }
            }
        }
    }
}
