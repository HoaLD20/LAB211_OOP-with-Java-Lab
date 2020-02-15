/**
 *
 * @author Le Duc Hoa
 */
package Matrix;

import static Matrix.MainClass.scanner;

public class Checking {

    //check inpit limmit for menu
    public static int checkInput(int from, int to) {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number < from || number > to) {
                    throw new NumberFormatException();
                }
                return number;
            }catch(Exception e){
                System.out.println("Input limited in [" + from + " to " + to + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    //check character for element
    public static int checkInputElement(){
        while(true){
            try{
                int element = Integer.parseInt(scanner.nextLine().trim());
                return element;
            }catch(Exception e){
                System.out.println("Do not input character!!!");
                System.out.print("Enter again: ");
            }
        }
    }
    //check chracter and < 0 for row and column
    public static int checkInputRL(){
        while(true){
            try{
                int value = Integer.parseInt(scanner.nextLine().trim());
               
                if(value <= 0){
                    throw new Exception();
                }
                 return value;
            }catch(Exception e){
                System.out.println("Do not input character or negative number!");
                System.out.print("Enter again: ");
            }
        }
    }
}
