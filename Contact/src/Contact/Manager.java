package Contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Le Duc Hoa
 */
public class Manager {

    public static int contactId = 1;//default id increasing
    /**
     * Display menu
     * @return 
     */
    public static int menu() {
        System.out.println("\n========= Contact Manager ========");
        System.out.println("1. Add a contact.");
        System.out.println("2. Display all contact.");
        System.out.println("3. Delete a contact.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Checking.checkInputLimit(1, 4);
        return choice;
    }
    /**
     * Add contacts to listContact
     * @param listContact
     * @throws IOException 
     */
    public static void addContact(ArrayList<Contact> listContact) throws IOException {
        //get full name
        System.out.print("Enter full name: ");
        String fullname = Checking.checkInputString();
        String firstname = "";
        String latsname = "";
        
        /**
         * Slip first name and last name from full name
         */
        StringTokenizer st = new StringTokenizer(fullname);
        int iTokenCount = st.countTokens();
        for (int i = 0; i < iTokenCount; i++) {
            if (i == 0 && iTokenCount > 1) {
                latsname = st.nextToken();
            } else {
                firstname = st.nextToken();
            }
        }
        //get group
        System.out.print("Enter group: ");
        String group = Checking.checkInputString();
        //get address
        System.out.print("Enter address: ");
        String address = Checking.checkInputString();
        //get phone
        System.out.print("Enter phone: ");
        String phone = Checking.checkPhone();
        listContact.add(new Contact(contactId++, fullname, group, address, phone, firstname, latsname));
        
        System.out.println("Add successful.");
        
    }

//+---+----------------------+---------------+--------------+-----------+-------------+------------+
//| ID|Name |First Name |Last Name |Group |Address |Phone |
//+---+----------------------+---------------+--------------+-----------+-------------+------------+
//| 1|Iker Casillas |Iker |Casillas |Star |Spain |1234567890 |
//| 2|John Terry |John |Terry |Star |England |1234567890 |
//| 3|Raul Gonzalez |Raul |Gonzalez |Star |Spain |1234567890 |
//+---+----------------------+---------------+--------------+-----------+-------------+------------+
    
    
    
    /**
     * Display listContact
     * @param listContact 
     */
    public static void printContact(ArrayList<Contact> listContact) {
        if (listContact.isEmpty()) {
            System.out.println("List is Empty!!!");
        } else {
            System.out.println("+---+----------------------+---------------+--------------+-----------+-------------+------------+");
            System.out.printf("|%3s|%-22s|%-15s|%-14s|%-11s|%-13s|%-12s|\n", 
                                "Id", "Name", "First name", "Last name", "Group", "Address", "Phone");
            System.out.println("+---+----------------------+---------------+--------------+-----------+-------------+------------+");
            for (Contact contact : listContact) {
                System.out.printf("|%3s|%-22s|%-15s|%-14s|%-11s|%-13s|%-12s|\n", contact.getContactId(), contact.getFullName(), contact.getFirstName(), contact.getLastName(), contact.getGroup(), contact.getAddress(), contact.getPhone());
            }
            System.out.println("+---+----------------------+---------------+--------------+-----------+-------------+------------+");
        }
    }

    /**
     * Delete contact from id
     * @param listContact 
     */
    public static void delete(ArrayList<Contact> listContact) {
        while(true){
            System.out.print("Enter id: ");
            int idDelete = Checking.checkInputInt();
            Contact contactDelete = getContactById(listContact, idDelete);
            if (contactDelete == null) {
                System.out.println("Contact not found.");
                
            } else {
                listContact.remove(contactDelete);
                System.out.println("Delete successful.");
                break;
            }
            
        }
    }

    /**
     * get all of infor of contact from id
     * @param listContact
     * @param idDelete
     * @return 
     */
    public static Contact getContactById(ArrayList<Contact> listContact, int idDelete) {
        for (Contact contact : listContact) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
}
