package Bill;

import static Bill.Main.scanner;

/**
 *
 * @author Le Duc Hoa
 */
public class Manager {
    /**
     * check input number
     * @return 
     */
    private static int checkInputInt() {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if(number < 0){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println("Please input a number and greater equal zero.");
                System.out.print("Enter again: ");
            }
        }
    }
    /**
     * get input number of bill
     * @param size
     * @return 
     */
    private static int[] inputBills(int size) {
        int[] bills = new int[size];
        //allow user input bills
        for (int i = 0; i < bills.length; i++) {
            System.out.print("Input value of bill " + (i + 1) + ": ");
            bills[i] = checkInputInt();
        }
        return bills;
    }
    /**
     * display for user
     */
    public void display() {
        Bill bill = new Bill();
        Wallet wallet = new Wallet();
        
        System.out.println("======= Shopping program ========== ");
        System.out.print("Input number of bill: ");
        //Display and get input bill
        bill.setNumberBills(checkInputInt());
        bill.setBills(inputBills(bill.getNumberBills()));
        //count total
        int total = bill.calcTotal(bill.getBills(), bill.getNumberBills());
        //get value of walett
        System.out.print("Input value of wallet: ");
        wallet.setMoney(checkInputInt());
        //display total of bill
        System.out.println("This is total of bill: " + total);
        //get result buy or can not
        if (wallet.countTotal(total)) {
            System.out.println(" You can buy it.");
        } else {
            System.out.println(" You can't buy it.");
        }
    }
}
