package analyzestring;

/**
 *
 * @author Le Duc Hoa
 */

public class MainClass {

    public static void main(String[] args) {

        System.out.println("===== Analysis String program ==== ");
        System.out.print("Input String: ");
        new Stringg().setString(Analyze.checkInputString());
        new Stringg().setNumber(Analyze.getNumber(new Stringg().getString()));
        new Stringg().setCharacter(Analyze.getCharacter(new Stringg().getString()));
        Analyze.display(new Stringg().getNumber(), new Stringg().getCharacter());
    }
}
