/**
 * @author Yana Biliaieva
 * Task5. Дана квадратная матрица A порядка M (M — нечетное число).
 * Начиная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее элементы по спирали:
 * первая строка, последний столбец, последняя строка в обратном  порядке,
 * первый  столбец  в  обратном  порядке,  оставшиеся  элементы второй строки и т. д.;
 * последним выводится центральный элемент матрицы.
 */
public class Spiral {
    public static void main(String[] args) {
        int size = 5;
        int max = size * size;
        int[][] mas = new int[size][size];
        int left = 0, top = 0, right = size, bottom = size;
        int x = left, y = top;
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                mas[i][j]= (int) (Math.random() *9);
            }
        }
        System.out.println("Source matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mas[j][i]+" ");
            }
            System.out.println();
        }
        System.out.println("Result:");
        Position pos = Position.START;
        for (int i = 1; i <= max; i++) {
            switch (pos) {
                case START:
                    pos = Position.RIGHT;
                    break;
                case RIGHT:
                    if(x + 1 < right) x++;
                    else {
                        pos = Position.BOTTOM;
                        right--;
                        y++;
                    }
                    break;
                case BOTTOM:
                    if(y + 1 < bottom) y++;
                    else {
                        pos = Position.LEFT;
                        bottom--;
                        x--;
                    }
                    break;
                case LEFT:
                    if(x - 1 >= left) x--;
                    else {
                        pos = Position.TOP;
                        left++;
                        y--;
                    }
                    break;
                case TOP:
                    if(y - 1 > top) y--;
                    else {
                        pos = Position.RIGHT;
                        top++;
                        x++;
                    }
                    break;
            }
            System.out.print(mas[x][y]+" ");
        }

    }
    enum Position{
        START,
        RIGHT,
        BOTTOM,
        LEFT,
        TOP
    }
}
