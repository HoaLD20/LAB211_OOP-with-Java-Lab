package Contact;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Le Duc Hoa
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ///Store list contact
        ArrayList<Contact> listContact = new ArrayList<>();
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1: {
                    Manager.addContact(listContact);
                    break;
                }
                case 2: {
                    Manager.printContact(listContact);
                    break;
                }
                case 3: {
                    Manager.delete(listContact);
                    break;
                }
                case 4: {
                    System.out.println("Thank you <3 !");
                    System.exit(0);
                }
            }
        }
    }
}