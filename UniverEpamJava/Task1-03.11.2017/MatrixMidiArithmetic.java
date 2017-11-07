import java.util.Arrays;

/**
 * @author Yana Biliaieva
 * Task3: Дана целочисленная прямоугольная матрица. Упорядочить столбцы по убыванию среднего значения.
 */

public class MatrixMidiArithmetic {
    public static void main(String[] args) {
        int[][] array = new int[2][3];

        for (int i = 0; i < 2; i++) {
                for (int k = 0; k < 3; k++){
                    array[i][k]= (int) ((Math.random() * 301) - 150);
                }
        }

        int []midArray=new int[3];
        for (int i = 0; i < 3; i++) {
            midArray[i]=getMid(array,i);
        }
        int[][]tmp=new int[2][3];
        for(int i=0;i<1;i++) {
            if (midArray[i] < midArray[i + 1] && midArray[i] < midArray[i + 2]) {
                //поставить первый столбец последним
                if(midArray[i + 1]<midArray[i + 2]){
                    for (int k = 0; k < 2; k++) {
                        tmp[k][2] = array[k][0];
                        tmp[k][1] = array[k][1];
                        tmp[k][0] = array[k][2];
                    }
                }else{
                    for (int k = 0; k < 2; k++) {
                        tmp[k][2] = array[k][0];
                        tmp[k][0] = array[k][1];
                        tmp[k][1] = array[k][2];
                    }
                }

            } else if (midArray[i] < midArray[i + 1] && midArray[i] > midArray[i + 2]) {
                //поставить первый вторым
                for (int t = 0; t < 2; t++) {
                    tmp[t][1] = array[t][0];
                    tmp[t][0] = array[t][1];
                    tmp[t][2] = array[t][2];
                }
            } else if (midArray[i] > midArray[i + 1] && midArray[i] > midArray[i + 2]) {
                //поставить первый первым

                if(midArray[i+1]>midArray[i+2]){
                    for (int s = 0; s < 2; s++) {
                        tmp[s][0] = array[s][0];
                        tmp[s][1] = array[s][1];
                        tmp[s][2] = array[s][2];

                    }
                }else {
                    for (int s = 0; s < 2; s++) {
                        tmp[s][0] = array[s][0];
                        tmp[s][2] = array[s][1];
                        tmp[s][1] = array[s][2];

                    }
                }

            }
        }
        System.out.println("Source array:");
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <3 ; j++) {
                System.out.print(array[i][j]+",");
            }
            System.out.print('\n');
        }
        System.out.println("-----------------");
        System.out.println("Mids:");
        System.out.println(Arrays.toString(midArray));
        System.out.println("Result array:");
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <3 ; j++) {
                System.out.print(tmp[i][j]+",");
            }
            System.out.print('\n');
        }
    }

    private static int getMid(int[][] mas, int i) {
        int mid = 0;
        int tmp = 0;
        for (int j = 0; j < 2; j++) {
            tmp = tmp + mas[j][i];
        }
        mid = tmp / 2;
        return mid;
    }

}
