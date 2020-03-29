package Analyze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Le Duc Hoa
 */

public class Analyze {

    public static Scanner scanner = new Scanner(System.in);
    /**
     * get all number of string
     * @param text
     * @return 
     */
    public HashMap<String, ArrayList<Integer>> getNumber(String text) {
        //
        HashMap<String, ArrayList<Integer>> number = new HashMap<>();

        String numbers = text.replaceAll("\\D+", " ").trim();
        //slipt each element in string by blank
        String[] listNumber = numbers.split(" ");
        //get square number
        ArrayList<Integer> squareNumber = new ArrayList<>();
        //get odd number
        ArrayList<Integer> oddNumber = new ArrayList<>();
        //get even number
        ArrayList<Integer> evenNumber = new ArrayList<>();
        //get string
        ArrayList<Integer> allNumber = new ArrayList<>();

        for (int i = 0; i < listNumber.length; i++) {
            try{
            int n = Integer.parseInt(listNumber[i]);
            if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
                squareNumber.add(n);
            }
            if (n % 2 == 0) {
                evenNumber.add(n);
            } else {
                oddNumber.add(n);
            }
            allNumber.add(n);
            }catch(Exception e){
                
            }
        }
        //store data to hashmap
        number.put("Square Numbers", squareNumber);
        number.put("Odd Numbers", oddNumber);
        number.put("Even Numbers", evenNumber);
        number.put("All Numbers", allNumber);
        return number;
    }
    /**
     *get character in string 
     * @param text
     * @return 
     */
    public HashMap<String, String> getCharacter(String text) {
        //
        HashMap<String, String> character = new HashMap<>();
        String AllCharacter = text.replaceAll("\\d", "");
        String UpperCharacter = text.replaceAll("[\\Wa-z0-9]", "");
        String LowerCharacter = text.replaceAll("[\\WA-Z0-9]", "");
        String SpecialCharacter = text.replaceAll("\\w", "");
        character.put("Uppercase Characters", UpperCharacter);
        character.put("Lowercase Characters", LowerCharacter);
        character.put("Special Characters", SpecialCharacter);
        character.put("All Characters", AllCharacter);
        return character;
    }
    //display result use for each, value from key
    public void display(HashMap<String, ArrayList<Integer>> number, HashMap<String, String> character) {
        System.out.println("-----Result Analysis------");
        number.forEach((key, value) -> System.out.println(key + ": " + value));
        character.forEach((key, value) -> System.out.println(key + ": " + value));
    }
    /**
     * check empty input string
     * @return 
     */
    private static String checkInputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.length() == 0) {
                System.out.println("String mustn't empty!!!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * input string and set variable
     */
    public void run() {
        Stringggggg text = new Stringggggg();
        System.out.println("===== Analysis String program ==== ");
        System.out.print("Input String: ");
        text.setString(checkInputString());
        text.setNumber(getNumber(text.getString()));
        text.setCharacter(getCharacter(text.getString()));
        display(text.getNumber(), text.getCharacter());
    }
}
