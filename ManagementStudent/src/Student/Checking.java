package Student;

public class Checking {

    //check empty input
    public static String checkInputString() {

        while (true) {
            String result = Main.scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Empty!!!!");
            } else {
                return result;
            }
        }
    }

    //check mark >= 0 and <= 10
    public static int checkInputMark(String name) {
        while (true) {
            try {
                int mark = Integer.parseInt(Main.scanner.nextLine());
                if (mark < 0) {
                    System.out.println(name + " is greater than equal zero");
                    System.out.print(name + ":");

                } else if (mark > 10) {
                    System.out.println(name + " is less than equal ten");
                    System.out.print(name + ":");

                }
                return mark;
            } 
            //in case input character
            catch (Exception e) {
                System.out.println(name + " is digit");
                System.out.print(name + ":");
            }
        }
    }

    //get Y or N from user
    public static boolean checkYN() {
        while (true) {
            String YN = checkInputString();
        
            if ("Y".equalsIgnoreCase(YN) || "y".equalsIgnoreCase(YN)) {
                return true;
            }
            else if ("N".equalsIgnoreCase(YN) || "n".equalsIgnoreCase(YN)) {
                return false;
            }
            System.out.print("Enter again: ");
        }
        
    }

}
