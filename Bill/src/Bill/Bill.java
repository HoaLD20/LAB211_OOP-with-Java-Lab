package Bill;

/**
 *
 * @author Le Duc Hoa
 */
public class Bill {

    private int numberBills;
    private int[] bills;

    public Bill() {
    }

    public int getNumberBills() {
        return numberBills;
    }

    public void setNumberBills(int numberBills) {
        this.numberBills = numberBills;
    }

    public int[] getBills() {
        return bills;
    }

    public void setBills(int[] bills) {
        this.bills = bills;
    }

    public int calcTotal(int[] bills, int numberBills) {
        int sum = 0;
        for (int i = 0; i < numberBills; i++) {
            sum += bills[i];
        }
        return sum;
    }
}
