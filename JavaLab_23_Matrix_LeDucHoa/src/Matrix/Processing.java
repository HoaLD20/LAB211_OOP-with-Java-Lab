/**
 *
 * @author Le Duc Hoa
 */
package Matrix;

public class Processing {

    private int[][] Matrix1 = new int[10][10];//contain element of matrix 1
    private int[][] Matrix2 = new int[10][10];//contain element of matrix 2

    //get element of matrix 1
    public void enterMatrix1(int Row, int Column) {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                System.out.print("Enter Matrix1[" + (i + 1) + "]" + "[" + (j + 1) + "] :");
                Matrix1[i][j] = Checking.checkInputElement();
            }
        }
    }

    //get element of matrix 2
    public void enterMatrix2(int Row, int Column) {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                System.out.print("Enter Matrix2[" + (i + 1) + "]" + "[" + (j + 1) + "] :");
                Matrix2[i][j] = Checking.checkInputElement();
            }
        }
    }

    //Display result 
    public void printMatrix(int Row, int Column, int[][] Matrix) {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                System.out.print(" [" + Matrix[i][j] + "] ");
            }
            System.out.println("");
        }
    }

    //Add two matrix
    public void addMatrix() {
        int i, j;//i ~ row , j ~ column
        int Row1;
        int Row2;
        int Column1;
        int Column2;
        int[][] Sum = new int[10][10];//contain result after count sum

        //get row and column of matrix 1
        System.out.print("Enter Row Matrix 1: ");
        Row1 = Checking.checkInputRL();

        System.out.print("Enter Column Matrix 1: ");
        Column1 = Checking.checkInputRL();
        //start get element
        enterMatrix1(Row1, Column1);

        //check condition row and column of two matrix must be same
        while (true) {
            try {
                System.out.print("Enter Row Matrix 2: ");
                Row2 = Checking.checkInputRL();
                if (Row2 != Row1) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Two row must be same");

            }
        }

        while (true) {
            try {
                System.out.print("\nEnter Column Matrix 2: ");
                Column2 = Checking.checkInputRL();
                if (Column2 != Column1) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Two Column must be same");

            }
        }
        //condition pass and start get input
        enterMatrix2(Row2, Column2);

        //Display result after count
        System.out.println("-------- Result --------");
        printMatrix(Row1, Column1, Matrix1);
        System.out.println("+");
        printMatrix(Row2, Column2, Matrix2);

        for (i = 0; i < Row1; i++) {
            for (j = 0; j < Column1; j++) {
                Sum[i][j] = Matrix1[i][j] + Matrix2[i][j];
            }
        }
        System.out.println("=");
        printMatrix(Row1, Column1, Sum);
    }

    //Count subtration of two matrix
    public void subMatrix() {
        int i, j;//i ~ row , j ~ column
        int Row1;
        int Row2;
        int Column1;
        int Column2;
        int[][] Sub = new int[10][10];

        System.out.print("Enter Row Matrix1: ");
        Row1 = Checking.checkInputRL();
        System.out.print("Enter Column Matrix1: ");
        Column1 = Checking.checkInputRL();
        enterMatrix1(Row1, Column1);

        while (true) {
            try {
                System.out.print("Enter Row Matrix2: ");
                Row2 = Checking.checkInputRL();
                if (Row1 != Row2) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Tow row must be same");
            }
        }
        while (true) {
            try {
                System.out.print("Enter Column Matrix2: ");
                Column2 = Checking.checkInputRL();

                if (Column2 != Column1) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Two Column must be same");
            }
        }
        enterMatrix2(Row2, Column2);

        System.out.println("-------- Result --------");
        printMatrix(Row1, Column1, Matrix1);
        System.out.println("-");
        printMatrix(Row2, Column2, Matrix2);

        for (i = 0; i < Row1; i++) {
            for (j = 0; j < Column1; j++) {
                Sub[i][j] = Matrix1[i][j] - Matrix2[i][j];

            }
        }
        System.out.println("=");
        printMatrix(Row1, Column1, Sub);
    }

    public void mulMatrix() {
        int i, j, k;//i ~ row , [j,k ~ column]
        int Row1, Row2;
        int Column1, Column2;
        int[][] Mul = new int[10][10];

        //get row of matrix 1
        System.out.print("Enter Row Matrix1: ");
        Row1 = Checking.checkInput(1, 10);
        //get column of matrix 1
        System.out.print("Enter Column Matrix1: ");
        Column1 = Checking.checkInput(1, 10);
        //start getting element of matrix 1
        enterMatrix1(Row1, Column1);

        //get row of matrix 2
        System.out.print("Enter Row Matrix2: ");
        Row2 = Checking.checkInput(1, 10);

        //check condition of column / must be same with row of matrix 1
        while (true) {
            try {
                System.out.print("Enter Column Matrix2: ");
                Column2 = Checking.checkInput(1, 10);
                if(Column2 != Row1){
                    throw new Exception();
                }
                break;
            }catch(Exception e){
                System.out.println("Column 2 must be same with Row 1!");
            }
        }

        //start getting element of matrix 2
        enterMatrix2(Row2, Column2);

        //display result of matrix
        System.out.println("-------- Result --------");
        printMatrix(Row1, Column1, Matrix1);
        System.out.println("*");
        printMatrix(Row2, Column2, Matrix2);

        //mltiple two matrix
        for (i = 0; i < Row1; i++) {
            for (j = 0; j < Column2; j++) {
                Mul[i][j] = 0;
                for (k = 0; k < Column1; k++) {
                    Mul[i][j] += Matrix1[i][k] * Matrix2[k][j];
                }
            }
        }
        System.out.println("=");
        //Display result after counting
        printMatrix(Row1, Column2, Mul);
    }
}
