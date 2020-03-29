package analyzestring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Analyze {

    public static Scanner scanner = new Scanner(System.in);

    public static String checkInputString() {
        while (true) {
            try {
                String result = scanner.nextLine().trim();
//                if (result.length() == 0) {
//                    throw new Exception();
//                }
                return result;

            } catch (Exception e) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            }
        }
    }

    public static HashMap<String, ArrayList<Integer>> getNumber(String input) {

        HashMap<String, ArrayList<Integer>> number = new HashMap<>();

        String numbers = input.replaceAll("\\D+", " ").trim();
        String[] listNumber = numbers.split(" ");

        ArrayList<Integer> squareNumber = new ArrayList<>();
        ArrayList<Integer> oddNumber = new ArrayList<>();
        ArrayList<Integer> evenNumber = new ArrayList<>();
        ArrayList<Integer> allNumber = new ArrayList<>();

        for (int i = 0; i < listNumber.length; i++) {
            int n = Integer.parseInt(listNumber[i]);
            if (Math.sqrt(n) * Math.sqrt(n) == n) {
                squareNumber.add(n);
            }
            if (n % 2 == 0) {
                evenNumber.add(n);
            } else {
                oddNumber.add(n);
            }
            allNumber.add(n);
        }

        number.put("Square Numbers", squareNumber);
        number.put("Odd Numbers", oddNumber);
        number.put("Even Numbers", evenNumber);
        number.put("All Numbers", allNumber);
        return number;
    }

    public static HashMap<String, String> getCharacter(String input) {

        HashMap<String, String> character = new HashMap<>();
        String AllCharacter = input.replaceAll("\\d", "");
        String UpperCharacter = input.replaceAll("[\\Wa-z0-9]", "");
        String LowerCharacter = input.replaceAll("[\\WA-Z0-9]", "");
        String SpecialCharacter = input.replaceAll("\\w", "");
        character.put("Uppercase Characters", UpperCharacter);
        character.put("Lowercase Characters", LowerCharacter);
        character.put("Special Characters", SpecialCharacter);
        character.put("All Characters", AllCharacter);
        return character;
    }

    public static void display(HashMap<String, ArrayList<Integer>> number, HashMap<String, String> character) {
        System.out.println("-----Result Analysis------");
        number.forEach((key, value) -> System.out.println(key + ": " + value));
        character.forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
