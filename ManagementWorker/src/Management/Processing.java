package Management;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Processing {

    /**
     * Display menu for user
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
     * @param listWorker
     */
    public static void addWorker(ArrayList<Worker> listWorker) {
        String id;
        while (true) {
            System.out.print("Enter code: ");
            id = Checking.checkInputString();
            if (!Checking.checkIdExist(listWorker, id)) {
                System.out.println("Id Exist!!!");
            }
            break;
        }
        //get name
        System.out.print("Enter worker's name: ");
        String name = Checking.checkInputString();
        //get age
        System.out.print("Enter worker's age: ");
        int age = Checking.checkInput(18, 50);
        //get salary
        System.out.print("Enter salary: ");
        int salary = Checking.checksalary();
        //get location
        System.out.print("Enter work location: ");
        String worklocation = Checking.checkInputString();
        //check worker exist
        if (!Checking.checkWorkerExist(listWorker, id, name, age, salary, worklocation)) {
            System.out.println("Some thing went wrong!");
        } else {
            listWorker.add(new Worker(id, name, age, salary, worklocation));
            System.out.println("Add worker success!!!");
        }
    }

    //update salary

    public static void changeSalary(ArrayList<Worker> listWorker, ArrayList<History> listHistory, int status) {
        //in case list empty
        if (listWorker.isEmpty()) {
            System.out.println("List is Empty!!!");
            return;
        }
        //get id
        System.out.print("Enter id: ");
        String id = null;
        try{
            id = Checking.checkInputString();
            //in case id not found
            if (takeWorkerAway(listWorker, id) == null) {
                
                throw new Exception();
            }
            
        }catch(Exception e){
            System.out.println("Id not found!!!");
            return;
        }
        //update infor of worker match id
        Worker infor = takeWorkerAway(listWorker, id);
        int salary = infor.getSalary();//get old salary
        int newsalary;//get new salary
        //status same with case
        if (status == 2) {
            while (true) {
                //increase salary
                System.out.print("Enter salary: ");
                newsalary = Checking.checksalary();
                if (newsalary <= salary) {
                    System.out.println("Hmm! Something went wrong!");
                    return;
                }
                break;
            }
            listHistory.add(new History("UP", getDate(), infor.getId(), infor.getName(), infor.getAge(), newsalary, infor.getWorklocation()));
            System.out.println("Increse salary success!");
        } else {
            //decrease salary
            System.out.print("Enter salary: ");
            while (true) {
                newsalary = Checking.checksalary();
                if (newsalary >= salary) {
                    System.out.println("Hmm! Something went wrong!");
                    return;
                }
                break;
            }
            //update status
            listHistory.add(new History("DOWN", getDate(), infor.getId(), infor.getName(), infor.getAge(), newsalary, infor.getWorklocation()));
            System.out.println("Decrease salary success!");
        }

    }
    //get worker and infor
    public static Worker takeWorkerAway(ArrayList<Worker> listWorker, String id) {
        for (Worker worker : listWorker) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }
    //get date
    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    //display list
    public static void display(ArrayList<History> listHistory) {
        //in case not update
        if (listHistory.isEmpty()) {
            System.out.println("List is Empty!!!");
//            System.exit(0);
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");

        //print history from first to last list
        for (History history : listHistory) {
            System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(), history.getName(), history.getAge(), history.getSalary(), history.getStatus(), history.getDate());
        }
    }

}
