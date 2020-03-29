package Bill;

/**
 *
 * @author Le Duc Hoa
 */
public class Wallet {
    int money;

    public Wallet() {
    }

    public int getmMney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    /**
     * get buy or can not buy
     * @param total
     * @return 
     */
    public boolean countTotal(int total){
        if(money>=total){
            return true;
        }
        return false;
    }
}
