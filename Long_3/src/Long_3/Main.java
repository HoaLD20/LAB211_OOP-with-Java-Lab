package Long_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Le Duc Hoa
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<Fruit> lf = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        Fileeeeee.readFile(lf);
//        try {
//            Scanner s = new Scanner(new File("src/Long_3/Fruit.txt"));
////            ArrayList<String> list = new ArrayList<String>();
//            
//            while (s.hasNextLine()) {
//                lf.add(s.next());
//            }
//            s.close();
//        }catch(Exception e){
//            System.out.println("File not found!!!");
//        }

        //loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createFruit(lf);
                    break;
                case 2:
                    Manager.viewOrder(ht);
                    break;
                case 3:
                    Manager.shopping(lf, ht);
                    break;
                case 4:
                    Fileeeeee.writeFile(lf);
                    return;
            }
        }
    }

}
