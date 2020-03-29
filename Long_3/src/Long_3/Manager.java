package Long_3;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Le Duc Hoa
 */
public class Manager {

    //display menu
    static int menu() {
        //loop until user want to exit
        System.out.println("   FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("   Please choose: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    //allow user create fruit
    static void createFruit(ArrayList<Fruit> lf) {
        //loop until user don't want to create fruit
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString();
            //check id exist
            if (!Validation.checkIdExist(lf, fruitId)) {
                System.err.println("Id exist");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            lf.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            //check user want to continue or not
            if (!Validation.checkInputYN()) {
                displayListFruit(lf);
                return;
            }

        }
    }

    //allow user show view order
    static void viewOrder(Hashtable<String, ArrayList<Order>> ht) {
        if (ht.isEmpty()) {
            System.out.println("Have no customer!!!");
            return;
        }
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> lo = ht.get(name);
            displayListOrder(lo);
        }
    }

    //allow user buy items
    public static void shopping(ArrayList<Fruit> lf, Hashtable<String, ArrayList<Order>> ht) {
        //check list empty user can't buy
        if (lf.isEmpty()) {
            System.err.println("Sold out!!!\n");
            return;
        }
        //loop until user don't want to buy continue
        ArrayList<Order> lo = new ArrayList<>();

        while (true) {

            displayListFruit(lf);

            System.out.print("Choose an item: ");
            int item = Validation.checkInputIntLimit(1, lf.size());
            System.out.println("You selected: " + getFruitByItem(lf, item).getFruitName());
            Fruit fruit = getFruitByItem(lf, item);
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());

            fruit.setQuantity(fruit.getQuantity() - quantity);

            if (!Validation.checkItemExist(lo, fruit.getFruitId())) {
                updateOrder(lo, fruit.getFruitId(), quantity);
            } else {
                lo.add(new Order(fruit.getFruitId(), fruit.getFruitName(), quantity, fruit.getPrice()));
            }
            delete(lf, fruit);
            if (lf.isEmpty()) {
                System.err.println("Sold out!!!\n");
                displayListOrder(lo);
                System.out.print("Enter name: ");
                String name = Validation.checkInputString();
                ht.put(name, lo);
                System.err.println("Add successfull");
                return;
            }

            if (Validation.checkInputYN()) {
                displayListOrder(lo);
                System.out.print("Enter name: ");
                String name = Validation.checkInputString();
                ht.put(name, lo);
                System.err.println("Add successfull");
                return;
            }

        }

    }

    //display list fruit in shop
    static void displayListFruit(ArrayList<Fruit> lf) {
        int countItem = 1;
        System.out.println("+------+--------------------+------------+-------+");
        System.out.printf("|%-6s|%-20s|%-12s|%-7s|\n", "No.", "Fruit name", "Origin", "Price");
        System.out.println("+------+--------------------+------------+-------+");
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                System.out.printf("|%6d|%-20s|%-12s|%6.0f$|\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
        System.out.println("+------+--------------------+------------+-------+");
    }

    //get fruint user want to by
    static Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    //display list order
    static void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        int countItemp = 1;
        System.out.println("+-----+--------------------+----------+-------+--------+");
        System.out.printf("|%-5s|%20s|%10s|%7s|%8s|\n", "No.", "Product", "Quantity", "Price", "Amount");
        System.out.println("+-----+--------------------+----------+-------+--------+");

        for (Order order : lo) {
            System.out.printf("|%5s|%-20s|%10d|%6.0f$|%7.0f$|\n", countItemp++, order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("+-----+--------------------+----------+-------+--------+");
        System.out.printf("|\t\t\t\t\tTotal |%7.0f$|\n", total);
        System.out.println("+-----+--------------------+----------+-------+--------+");
    }

    //if order exist then update order
    static void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

    public static void delete(ArrayList<Fruit> lf, Fruit item) {
        for (Fruit fruit : lf) {
            if (fruit.getFruitId().equals(item.getFruitId()) && item.getQuantity() == 0) {
                lf.remove(fruit);
                return;
            }
        }
    }

}
