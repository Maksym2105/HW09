package app;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class GitHW09Program {
    public static void main(String[] args) {

        Random random = new SecureRandom();
        int[][] array2D = new int[4][4];
        System.out.println("Матриця 4x4:");
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                array2D[i][j] = random.nextInt(50) + 1;
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println();
        }
        int sumEvenRow = 0, sumOddRow = 0;
        for (int i = 0; i < 4; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < 4; j++) {
                    sumEvenRow += array2D[i][j];
                }
            }else{
                for (int j = 0; j < 4; j++) {
                    sumOddRow += array2D[i][j];

                }
            }
        }
        long productEvenCol = 1, productOddCol = 1;
        for (int j = 0; j < 4; j++) {
            if(j % 2 == 0){
                for (int i = 0; i < 4; i++) {
                    productEvenCol *= array2D[i][j];
                }
            }else{
                for (int i = 0; i < 4; i++) {
                    productOddCol *= array2D[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + sumEvenRow);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + sumOddRow);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + productEvenCol);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + productOddCol);

        System.out.println();
        int order = array2D.length;

        int[] sumRow = new int[order];
        int[] sumCol = new int[order];
        int[] sumDiag = new int[2];

        Arrays.fill(sumRow, 0);
        Arrays.fill(sumCol, 0);
        Arrays.fill(sumDiag, 0);

        for (int row = 0; row < order; row++) {
            for (int col = 0; col < order; col ++) {
                sumRow[row] += array2D[row][col];
            }
            System.out.println("Сума рядків " + row + "\n" + sumRow[row]);
        }

        for (int col = 0; col < order; col++) {
            for (int row = 0; row < order; row ++) {
                sumCol[col] += array2D[row][col];
            }
            System.out.println("Сума стовпців " + col + "\n" + sumCol[col]);
        }

        for (int row = 0; row < order; row++) {
            sumDiag[0] += array2D[row][row];
        }
        System.out.println("Сума діагоналі 0 " + "\n" + sumDiag[0]);

        for(int row = 0; row < order; row++) {
            sumDiag[1] += array2D[row][order - 1 - row];
        }
        System.out.println("Сума діагоналі 1 " + "\n" + sumDiag[1]);

        boolean bool = true;

        int sum = sumRow[0];
        for (int i = 1; i < order; i++) {
            bool = bool && (sum == sumRow[i]);
        }
        for (int i = 0; i < order; i++) {
            bool = bool && (sum == sumCol[i]);
        }
        for (int i = 0; i < 2; i++) {
            bool = bool && (sum == sumDiag[i]);
        }

        String tOrF = "";
        if (bool) {
            tOrF = "є";
        } else {
            tOrF = "не є";
        }
        System.out.println("Матриця " + tOrF + " магічним квадратом.");

    }
}




