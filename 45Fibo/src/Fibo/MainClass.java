/**
 *
 * @author Le Duc Hoa
 */
package Fibo;
public class MainClass {

    public static void main(String[] args) {
        int num = 45;
        Fibonaci.fibo(num);
    }
    static class Fibonaci {

        static void fibo(int n) {
            int n1 = 0;
            int n2 = 1;
            for (int i = 0; i <= n; i++) {
                System.out.printf("%d ", n1);
                int nextNum = n1 + n2;
                n1 = n2;
                n2 = nextNum;
            }
            System.out.println();

        }
    }

}
