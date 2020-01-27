package Ptb1;

import java.util.Scanner;

public class Main {
    public static Scanner in  = new Scanner(System.in);
            

    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.superlativeEquation();
                    break;
                case 2:
                    Manager.quadraticEquation();
                    break;
                case 3:
                    return;
            }
        }
    }

   
    static class Manager {

       

        //dispaly menu
        private static int menu() {
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = checkInputIntLimit(1, 3);
            return choice;
        }

        //check user input number limit
        private static int checkInputIntLimit(int min, int max) {
            //loop until user input correct
            while (true) {
                try {
                    int result = Integer.parseInt(in.nextLine().trim());
                    if (result < min || result > max) {
                        throw new NumberFormatException();
                    }
                    return result;
                } catch (NumberFormatException e) {
                    System.err.println("Please input number in rage [" + min + ", " + max + "]");
                    System.out.print("Enter again: ");
                }
            }
        }

        //check user input double
        private static double checkInputDouble() {
            //loop until user input correct
            while (true) {
                try {
                    double result = Double.parseDouble(in.nextLine());
                    return result;
                } catch (NumberFormatException e) {
                    System.err.println("Must be input double");
                    System.out.print("Enter again: ");
                }

            }
        }

        //check number is odd or not
        private static boolean checkOdd(double n) {
            if (n % 2 == 1) {
                return true;
            } else {
                System.out.println("None");
                return false;
            }
        }

        //check number is even or not
        private static boolean checkEven(double n) {
            if (n % 2 == 0) {
                return true;
            } else {
                System.out.println("None");
                return false;
            }
        }

        //check number is squarenumber or not
        private static boolean checkSquareNumber(double n) {
            if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
                return true;
            } else {
                return false;
            }
        }

        //allow user calculate Superlative Equation
        private static void superlativeEquation() {
            System.out.print("Enter A: ");
            double a = checkInputDouble();
            System.out.print("Enter B: ");
            double b = checkInputDouble();
            double x = -b / a;
            
            System.out.println();
            System.out.print("Solution: x = " + x);
            System.out.println();
            System.out.print("Number is odd: ");
            
            if (checkOdd(a)) {
                System.out.print(a + " ");
            }
            if (checkOdd(b)) {
                System.out.print(b + " ");
            }
            if (checkOdd(x)) {
                System.out.print(x + "\n");
            }
            System.out.println();
            System.out.print("Number is even: ");
            if (checkEven(a)) {
                System.out.print(a + " ");
            }
            if (checkEven(b)) {
                System.out.print(b + " ");
            }
            if (checkEven(x)) {
                System.out.print(x + "\n");
            }
            System.out.println();
            System.out.print("Number is perfect square: ");
            if (checkSquareNumber(a)) {
                System.out.print(a + " ");
            }
            if (checkSquareNumber(b)) {
                System.out.print(b + " ");
            }
            if (checkSquareNumber(x)) {
                System.out.print(x);
            }
            System.out.println("\n");
        }

        //allow user calculate Quadratic Equation
        private static void quadraticEquation() {
            System.out.print("Enter A: ");
            double a = checkInputDouble();
            System.out.print("Enter B: ");
            double b = checkInputDouble();
            System.out.print("Enter C: ");
            double c = checkInputDouble();
            double delta = b * b - 4 * a * c;
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            
            System.out.println();
            
            System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
            System.out.print("Odd Number(s): ");
            if (checkOdd(a)) {
                System.out.print(a + " ");
            }
            if (checkOdd(b)) {
                System.out.print(b + " ");
            }
            if (checkOdd(c)) {
                System.out.print(c + " ");
            }
            if (checkOdd(x1)) {
                System.out.print(x1 + " ");
            }
            if (checkOdd(x2)) {
                System.out.print(x2 + " ");
            }
            
            
            System.out.println();
            
            
            System.out.print("Number is even: ");
            if (checkEven(a)) {
                System.out.print(a + " ");
            }
            if (checkEven(b)) {
                System.out.print(b + " ");
            }
            if (checkEven(c)) {
                System.out.print(b + " ");
            }
            if (checkEven(x1)) {
                System.out.print(x1 + " ");
            }
            if (checkEven(x2)) {
                System.out.print(x1 + " ");
            }
            
            System.out.println();
            
            
            System.out.print("Number is perfect square: ");
            if (checkSquareNumber(a)) {
                System.out.print(a + " ");
            }
            if (checkSquareNumber(b)) {
                System.out.print(b + " ");
            }
            if (checkSquareNumber(c)) {
                System.out.print(c + " ");
            }
            if (checkSquareNumber(x1)) {
                System.out.print(x1 + " ");
            }
            if (checkSquareNumber(x2)) {
                System.out.print(x2);
            }
            
            
            System.out.println("\n");
        }
    }

}
