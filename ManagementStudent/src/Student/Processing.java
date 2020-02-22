
package Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Processing {
    //Display information of each student
    public static void displayInformationStudent(List<Student> listStudent) {
        int i = 0;
        for (Student student : listStudent) {
            System.out.println("------ Student " + (i++) + " info ------");
            System.out.println("Name: " + student.getStudentName());
            System.out.println("Classes: " + student.getClassName());
            System.out.println("AVG: " + student.getAverage());
            System.out.println("Type: " + student.getType());
        }
    }
    
    //
    public static HashMap<String, Double> getPercentTypeStudent(List<Student> listStudent) {
        
        HashMap<String, Double> getPercentTypeStudent = new HashMap<>();
        //get total type of student
        int totalStudent = listStudent.size();
        
        //default each type equal 0
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        
        //get number of each type
        for (int i = 0; i < totalStudent; i++) {
            if (listStudent.get(i).getType() == 'A') {
                typeA++;
            }
            if (listStudent.get(i).getType() == 'B') {
                typeB++;
            }
            if (listStudent.get(i).getType() == 'C') {
                typeC++;
            }
            if (listStudent.get(i).getType() == 'D') {
                typeD++;
            }
        }
        //get percent of each type
        getPercentTypeStudent.put("A", typeA / totalStudent * 100);
        getPercentTypeStudent.put("B", typeB / totalStudent * 100);
        getPercentTypeStudent.put("C", typeC / totalStudent * 100);
        getPercentTypeStudent.put("D", typeD / totalStudent * 100);
        
        return getPercentTypeStudent;
    }
    
    //add student to list
    public static void createStudent(List<Student> listStudent) {
        while (true) {
            //get name of student
            System.out.print("Name: ");
            String name = Checking.checkInputString();
            //get class of student
            System.out.print("Classes: ");
            String className = Checking.checkInputString();
            //get mark of  math
            System.out.print("Maths: ");
            double math = Checking.checkInputMark("Maths");
            //get mark of chemistry
            System.out.print("Chemistry: ");
            double chemistry = Checking.checkInputMark("Chemistry");
            //get mark of physics
            System.out.print("Physics: ");
            double physics = Checking.checkInputMark("Physics");
            //get agv mark of each student
            double average = (math + chemistry + physics) / 3;
            
            char type;
            //get type for each student with their mark
            if (average > 7.5) {
                type = 'A';
            } else if (average >= 6 && average <= 7.5) {
                type = 'B';
            } else if (average >= 4 && average < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
            //add student ti list
            listStudent.add(new Student(name, className, math, physics, chemistry, average, type));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            //check continue condition
            if (!Checking.checkYN()) {
                return;
            }
        }
    }
    //
    public static void display() {
        //store list of student
        List<Student> listStudent = new ArrayList<>();
        
        //get student inputed
        createStudent(listStudent);
        //display each infor of student
        displayInformationStudent(listStudent);
        
        System.out.println("--------Classification Info ----- ");
        //display value and type from hashMap below
        //store type with value of this type
        HashMap<String, Double> getPercentTypeStudent = getPercentTypeStudent(listStudent);
        for(Map.Entry student : getPercentTypeStudent.entrySet()){
            System.out.println(student.getKey() + " :" + student.getValue() + "%");
        }
    }
}
