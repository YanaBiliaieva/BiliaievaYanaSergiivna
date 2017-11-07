public class FiguresMain {
    public static void main(String[] args) {
        System.out.println("Прямоугольник:");
        rectangle();
        System.out.println("Прямогольный треугольник:");
        rectangularTriangle();
        System.out.println("Равносторонний треугольник:");
        equilateralTriangle();
        System.out.println("Ромб:");
        rhombus();
    }
    public static void rectangle () {
        for(int i=0;i<4;++i) {
            for(int j=0;j<10;++j){
                System.out.print("* ");
            } System.out.print("\n");
        }
    }
    public static void rectangularTriangle () {
        for(int i=0;i<10;++i) {
            for(int j=0;j<i+1;++j){
                System.out.print("* ");
            } System.out.print("\n");
        }
    }
    public static void equilateralTriangle () {
        int a = 0;
        while(a < 8){
            int i = 0;
            while (i < 7 - a) {
                System.out.print(" ");
                i++;
            }
            int j = 0;
            while (j < a+1) {
                System.out.print("* ");
                j++;
            }
            System.out.print("\n");
            a++;
        }
    }
    public static void rhombus () {
        equilateralTriangle();
        int a = 8;
        while (a > 0) {
            int i = -1;
            while (i < 8 - a) {
                System.out.print(" ");
                i++;
            }
            int j = 1;
            while (j < a ) {
                System.out.print("* ");
                j++;
            }
            System.out.print("\n");
            a--;
        }
    }
}
