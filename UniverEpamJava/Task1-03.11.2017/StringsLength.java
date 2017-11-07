import java.util.Arrays;

/**
 * @author Yana Biliaieva
 * Task4. Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
 */

public class StringsLength {
    public static void main(String[] args) {
    int[][] mas=new int[4][4];
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                mas[i][j]= (int) (Math.random() *2);
            }
        }
        System.out.println("Source array:");
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.print(mas[i][j]+",");
            }
            System.out.print('\n');
        }
        int[] quantity=new int[4];
        for (int i = 0; i <4 ; i++) {
            int tmp=0;
            for (int j = 0; j <3 ; j++) {

                if(mas[i][j]==mas[i][j+1]){
                    tmp++;
                }
               quantity[i]=tmp;
            }
        }
        int[] sortedArray=new int[4];
        sortedArray= Arrays.copyOf(quantity,4);
        Arrays.sort(sortedArray);
        int[][] positionArray=new int[2][4];

            for (int j = 0; j < 4; j++) {
                positionArray[0][j]=quantity[j];
                positionArray[1][j]=sortedArray[j];
            }

        int[][] resultArray=new int[4][4];

            for (int j = 0; j <1 ; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int t = 0; t < 4; t++) {
                        if (positionArray[j][k] == positionArray[j + 1][t]) {
                            for (int i = 0; i < 4; i++) {
                                resultArray[t][i] = mas[k][i];
                            }
                        }
                    }
                }
            }



        System.out.println("Result mas:");
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.print(resultArray[i][j]+",");
            }
            System.out.print('\n');
        }
        }


}
