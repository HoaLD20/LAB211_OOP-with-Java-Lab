package Long_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Le Duc Hoa
 */
public class Fileeeeee {
    public static void readFile(ArrayList<Fruit> fList) throws IOException{
        File dir = new File("File");
        if(!dir.mkdir()){
            dir.mkdir();
        }
        File file = new File("File/Fruit.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        Scanner readfile = new Scanner(file);
        while(readfile.hasNext()){
            Fruit fruit = new Fruit();
            String[] tmp = readfile.nextLine().split("/");
            fruit.setFruitId(tmp[0]);
            fruit.setFruitName(tmp[1]);
            fruit.setPrice(Double.parseDouble(tmp[2].trim()));
            fruit.setQuantity(Integer.parseInt(tmp[3].trim()));
            fruit.setOrigin(tmp[4]);
            fList.add(fruit);
        }
    }
    
    public static void writeFile(ArrayList<Fruit> fList) throws IOException{
        FileWriter fileWriter = new FileWriter("File/Fruit.txt");
        for(Fruit i: fList){
            fileWriter.write(i.getFruitId()+"/"+i.getFruitName()+"/"+i.getPrice()+"/"+i.getQuantity()+"/"+i.getOrigin()+System.lineSeparator());
        }
        fileWriter.close();
    }
}
