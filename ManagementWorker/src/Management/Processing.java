package Management;

import javafx.concurrent.Worker;
import java.util.ArrayList;

public class Processing {

    /**
     * Display menu for user
     *
     * @return
     */
    public static int menu() {
        System.out.println("======== WORKER MANAGEMENT ========");
        System.out.println("1. Add a Worker.");
        System.out.println("2. Increase salary for worker.");
        System.out.println("3. Decrease for worker.");
        System.out.println("4. Show adjusted salary worker information.");
        System.out.println("5. Exit.");
        System.out.print("   Please choose: ");
        int choice = Checking.checkInput(1, 5);
        return choice;
    }

    /**
     * Add worker to array list
     *
     * @param listWorker
     */
    public static void addWorker(ArrayList<Worker> listWorker) {
        System.out.print("Enter code: ");
        String id = Checking.checkInputString();
        while(true){
            if(Checking.checkIdExist(listWorker, id)){
                System.out.println("Id Exist!!!");
            }
            else{
                return;
            }
        }
        
        System.out.print("Enter worker's name: ");
        String name = Checking.checkInputString();

        System.out.print("Enter worker's age: ");
        int age = Checking.checkInput(18, 50);

        System.out.print("Enter salary: ");
        int salary = Checking.checksalary();

        System.out.print("Enter work location: ");
        String worklocation = Checking.checkInputString();

        if(!Checking.checkWorkerExist(listWorker, id, name, age, salary, worklocation)){
            System.out.println("Some thing went wrong!");
        }
        else{
            listWorker.add(new Worker(id, name, age, salary, worklocation));
            System.out.println("Add worker success!!!");
        }
    }

}
