import java.util.Arrays;

/**
 * @author Yana Biliaieva
 * Task2: В одномерном массиве сначала положительные потом отрицательные за О(n).
 */
public class ArraysSortOn {

    public static void main(String[] args) {
        int[] array = new int[10];
        int [] resultArray=new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 301) - 150);
        }
        int j=0;
        int k=array.length-1;
        for (int i =0;i<array.length;i++){
            if(array[i]>0){
                resultArray[j]=array[i];
                j++;
            }else {
                resultArray[k]=array[i];
                k--;
            }
        }
        System.out.println("Source array: "+Arrays.toString(array));
        System.out.println("Result array: "+Arrays.toString(resultArray));
    }

}
