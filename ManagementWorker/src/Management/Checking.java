package Management;

import java.util.ArrayList;

public class Checking {
    /**
     * Check
     * Input
     * Menu
     *
     * @param from
     * @param to
     * @return
     */
    public static int checkInput(int from, int to) {
        while (true) {
            try {
                int input = Integer.parseInt(MainClass.scanner.nextLine().trim());

                if (input > to || input < from) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                System.out.println("Input from [" + from + " to " + to + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Check
     * ID
     * Exist
     * :)))
     * @param listWorker
     * @param id
     * @return 
     */

    /**
     * Check
 ID
 Exist
 :)))
     * @param listWorker
     * @param id
     * @param name
     * @param age
     * @param salary
     * @param worklocation
     * @return
     */
    public static boolean checkWorkerExist(ArrayList<Worker> listWorker, String id, String name, int age, int salary, String worklocation){
        for(Worker i : listWorker){
            if(id.equalsIgnoreCase(i.getId()) && name.equalsIgnoreCase(i.getName()) && age == i.getAge() && salary == i.getSalary() && worklocation.equalsIgnoreCase(i.getWorklocation())){
                return false;
                        
            }
           
        }
         return true;
    }

    /**
     * Check input when user enter empty string
     *
     * @return string
     */
    public static String checkInputString() {
        while (true) {
            String string = MainClass.scanner.nextLine().trim();
            try {
                if (string.isEmpty()) {
                    throw new Exception();
                }
                return string;
            }catch (Exception e){
                System.out.println("Empty input");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Check salary <= 0
     * @return salary
     */
    public static int checksalary(){
        while(true){
            try{
                int salary = Integer.parseInt(MainClass.scanner.nextLine().trim());
                if(salary > 0){
                    return salary;
                }
                else{
                    throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Something went wrong !!!");
                System.out.print("Enter again: ");
            }
        }
    }
    /**
     * Check id exist
     */
       public static boolean checkIdExist(ArrayList<Worker> listWorker, String id) {
        //check from first to last list id worker exist or not
        for (Worker worker : listWorker) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return false;
            }
        }
        return true;
    }
}
