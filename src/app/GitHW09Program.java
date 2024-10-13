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
        int sumEvenRow = 0, sumOddColumn = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(array2D[i][j] % 2 == 0){
                    sumEvenRow += array2D[i][j];
                }
                else{
                    sumOddColumn += array2D[i][j];
                }
            }
        }
        long pEvenColumn = 1, pOddColumn = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(array2D[i][j] % 2 == 0){
                    pEvenColumn *= array2D[i][j];
                }
                else {
                    pOddColumn *= array2D[i][j];
                }
            }
        }
        System.out.println();
        System.out.printf("Сума елементів у парних рядках (рядок 0, 2): %d\n" +
                "Сума елементів у непарних рядках (рядок 1, 3): %d\n" +
                 "Добуток елементів у парних стовпцях (стовпець 0, 2): %d \n" +
                 "Добуток елементів у непарних стовпцях (стовпець 1, 3): %d " , sumEvenRow
                , sumOddColumn , pEvenColumn , pOddColumn);

        int l = array2D.length;
        int sumDiagonal1 = 0, sumDiagonal2 = 0;
        for (int i = 0; i < l; i++) {
            sumDiagonal1 += array2D[i][i];
        }
        for (int i = 0; i < l; i++) {
            sumDiagonal2 += array2D[i][l - 1 - i];
        }
        boolean isMagicSquare = true;
        if (sumDiagonal1 != sumDiagonal2){
            isMagicSquare = false;
        }
        for (int i = 0; i < l; i++) {
            int sumRow = 0, sumColumn = 0;
            for (int j = 0; j < l; j++) {
                sumRow = array2D[i][j];
                sumColumn = array2D[j][i];
            }
            if (sumDiagonal1 != sumRow || sumDiagonal1 != sumColumn){
                isMagicSquare = false;
                break;
            }
        }
        System.out.println();
        if(isMagicSquare){
            System.out.println("\nМатриця є магічним квадратом.");
        }
        else {
            System.out.println("\nМатриця не є магічним квадратом.");
        }


    }
}






