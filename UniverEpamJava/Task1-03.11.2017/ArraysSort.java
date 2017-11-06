import java.util.Arrays;


/**
 * @author Yana Biliaieva
 * Task1: Упорядочить в одномерном масиве числа сначала отрицательные повозрастанию, затем положительные по убыванию.
 */
public class ArraysSort {

    public static void main(String[] args) {
       int[] array=new int [10];
        for (int i = 0; i < array.length; i++) {
            array[i]=(int)((Math.random()*301)-150);
        }
        System.out.println("Source array:"+Arrays.toString(array));
        int j=0;
        int k=0;
        int t=0;
        int [] negativeArray=new int[0];
        int [] positiveArray=new int[0];
        int [] zeroesArray=new int[0];
        for (int i = 0; i <array.length ; i++) {
            if(array[i]<0){
                negativeArray = Arrays.copyOf(negativeArray, negativeArray.length + 1);
                negativeArray[j]=array[i];
                j++;
            }else if(array[i]>0){
                positiveArray = Arrays.copyOf(positiveArray, positiveArray.length + 1);
                positiveArray[k]=array[i];
                k++;
            }else if(array[i]==0){
                zeroesArray= Arrays.copyOf(zeroesArray, zeroesArray.length + 1);;
                t++;
            }
        }
        System.out.println("Negative array:"+Arrays.toString(negativeArray)+" Length="+negativeArray.length);
        System.out.println("Positive array:"+Arrays.toString(positiveArray)+" Length="+positiveArray.length);
        System.out.println("Zero array:"+Arrays.toString(zeroesArray)+" Length="+zeroesArray.length);
        Arrays.sort(positiveArray);
        Arrays.sort(negativeArray);
        System.out.println("Sorted negative array:"+Arrays.toString(negativeArray));
        System.out.println("Sorted positive array:"+Arrays.toString(positiveArray));
        int[] resultArray=concat(negativeArray,zeroesArray,positiveArray);
        System.out.println("Result array:"+Arrays.toString(resultArray));

    }
    public static int[] concat(int[] a, int[] b, int[]d) {
        int aLen = a.length;
        int bLen = b.length;
        int dLen = d.length;
        int[] c= new int[aLen+bLen+dLen];
        if (a.length!=0&&b.length!=0&&d.length!=0){
            System.arraycopy(a, 0, c, 0, aLen);
            System.arraycopy(b, 0, c, aLen, bLen);
            System.arraycopy(d, 0, c, bLen+bLen, dLen);
        }else if(a.length!=0&&b.length==0&&d.length!=0){
            System.arraycopy(a, 0, c, 0, aLen);
            System.arraycopy(d, 0, c, aLen, dLen);
        }else if(a.length==0||d.length==0){
            System.out.println("Source array should have positive and negative numbers.");
        }
        return c;
    }
}
