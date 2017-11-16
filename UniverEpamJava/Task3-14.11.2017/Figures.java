

import java.util.Arrays;
import java.util.Random;

/**
 * @author Biliaieva Yana
 * Task: создать последовательность из фигур  используя фабрики цветных и нецветных фигур
 * получить масивы цветных и не цветных и сколько каждых фигур в нем присутсвует
 * групируем в масивах фигуры
 * тестируем методы фигур
 */

interface Colorable{
	int color();
}
class Point implements Cloneable{
	@Override
	protected Object clone()  {
		
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point(Point p) {
		this.x=p.getX();
		this.y=p.getY();
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}	
}
class ColorPoint extends Point implements Colorable{
	private int color;
	public ColorPoint(int x, int y, int color) {
		super(x, y);
		this.color = color;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "ColorPoint [color=" + color + ", X=" + getX() + ", Y=" + getY() + "]";
	}

	@Override
	public int color() {
		return this.color;
	}
}
class Line {
	private Point beg;
	private Point end;
	public Line(Point beg, Point end) {
		super();
		this.beg = beg;
		this.end = end;
	}
	public Line(int x1, int y1, int x2, int y2) {
		super();
		this.beg = new Point(x1,y1);
		this.end = new Point(x2,y2);
	}
	public Point getBeg() {
		//return new Point(beg);
		return beg;		
	}
	public void setBeg(Point beg) {
		this.beg = beg;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
	}
	
}
class ColorLine extends Line implements Colorable{
	private int color;
	public ColorLine(Point beg, Point end, int color) {
		super(beg, end);
		this.color();
	}

	@Override
	public String toString() {
		return "ColorLine [color=" + color() + ", Beg = " + getBeg() + ", End =" + getEnd() + "]";
	}

	@Override
	public int color() {
		return this.color;
	}
}
class Triangle{
	Point apexA, apexB, apexC;
	Line sideAB, sideBC, sideAC;
	public Triangle(Point apexA, Point apexB, Point apexC) {
		super();
		this.apexA = apexA;
		this.apexB = apexB;
		this.apexC = apexC;
		//sideAB= new Line(apexA, apexB);
	}
	public Line getSideAB() {
		if (sideAB==null) sideAB = new Line(apexA, apexB);
		return sideAB;
	}
	public void setApexA(Point p) {
		apexA=p;
		sideAB=null;
		sideAC=null;
	}
}
class ColorTriangle extends Triangle implements Colorable{
	private int color;
	public ColorTriangle(Point apexA, Point apexB, Point apexC, int color) {
		super(apexA, apexB, apexC);
		this.color();
	}

	@Override
	public int color() {
		return this.color;
	}
}
class ColorPolygon implements Colorable{
	Point [] poly;
	private int color;
	public ColorPolygon(int size, int c) {
		Point[]poly=new Point[size];
		for (int i = 0; i < size; i++) {
			Random r = new  Random();
			int x=r.nextInt(4);
			int y=r.nextInt(4);
			Point point=new Point(x,y);
		}
		this.color();
	}

	@Override
	public int color() {
		return this.color;
	}
}
class Polygon  {
	Point [] poly;
	public Polygon(int size) {
		Point[]poly=new Point[size];
		for (int i = 0; i < size; i++) {
			Random r = new  Random();
			int x=r.nextInt(4);
			int y=r.nextInt(4);
			Point point=new Point(x,y);
		}
	}
}

class RandomFigures {
	public static Object[] RandomFigures() {
		Object[]figures = new Object[10];
		for (int i = 0; i < figures.length; i++) {
			Random r = new Random();
			int key = r.nextInt(3);
			int num=(r.nextInt(3))+key;
			int num1=(r.nextInt(3))+key;
			Point point1 = new Point(num, num);
			Point point2 = new Point(num, num1);
			Point point3 = new Point(num1, num);
			int size=(r.nextInt(3))+key;
			switch (key) {
				case 0:
					figures[i] = new Line (point1, point2);
					System.out.println("i=="+i);
					System.out.println("figures[i] =new Line:==: "+figures[i].getClass());
					break;
				case 1:
					figures[i] = new Triangle(point1, point2, point3);
					System.out.println("figures[i] =new Triangle:==: "+figures[i].getClass());
					System.out.println("i=="+i);
					break;
				case 2:
					figures[i] = new Polygon((size));
					System.out.println("i=="+i);
					System.out.println("figures[i] =new Polygon:== "+figures[i].getClass());
					break;
			}
		}
		System.out.println("figures== "+ Arrays.toString(figures));
		return figures;
	}
}
class RandomColorfulFigures{
	public static Colorable[] RandomColorfulFigures() {
		Colorable[] colorfulFigures=new Colorable[10];
		for (int i = 0; i < colorfulFigures.length; i++) {
			Random r = new  Random();
			int key = r.nextInt(3);
			int num=(r.nextInt(3))+key;
			int num1=(r.nextInt(3))+key;
			Point point1 = new Point(num, num);
			Point point2 = new Point(num, num1);
			Point point3 = new Point(num1, num);
			int size=(r.nextInt(3))+key;
			switch (key) {
				case 0: colorfulFigures[i] =new ColorLine(point1, point2, 23423);
				System.out.println("colorfulFigures[i] =new ColorLine:==: "+colorfulFigures[i].getClass());
				break;
				case 1: colorfulFigures[i] =new  ColorTriangle(point1, point2, point3, 666);
				System.out.println("colorfulFigures[i] =new ColorTriangle:==: "+colorfulFigures[i].getClass());
				break;
				case 2: colorfulFigures[i] =new ColorPolygon( (size), 547567);
				System.out.println("colorfulFigures[i] =new ColorPolygon:==: "+colorfulFigures[i].getClass());
				break;
			}
		}
		System.out.println("colorfulFigures== "+ Arrays.toString(colorfulFigures));
		return colorfulFigures;
	}
}
public class Figures {
	    static Object[] sortFigures(Object[] figures, int numberOfLines, int numberOfTriangles, int numberOfPolygones){
		Object[] sortedFigures=new Object[figures.length];
		Line[] lines=new Line[numberOfLines];
		int l=0;
		Triangle[] triangles=new Triangle[numberOfTriangles];
		int t=0;
		Polygon[] polygons=new Polygon[numberOfPolygones];
		int p=0;
		for (int i = 0; i < figures.length; i++) {
			if(figures[i] instanceof Line){
				lines[l]=(Line) figures[i]; l++;
			}else if(figures[i] instanceof Triangle) {
				triangles[t] = (Triangle) figures[i];
				t++;
			} else if(figures[i] instanceof Polygon) {
				polygons[p] = (Polygon) figures[i];
				p++;
			}
		}
		System.out.println("lines== "+ Arrays.toString(lines));
		System.out.println("triangles== "+ Arrays.toString(triangles));
		System.out.println("polygons== "+ Arrays.toString(polygons));
		System.arraycopy(lines, 0, sortedFigures, 0, lines.length);
		System.arraycopy(triangles, 0, sortedFigures, lines.length, triangles.length);
		System.arraycopy(polygons, 0, sortedFigures, lines.length+triangles.length, polygons.length);
		System.out.println("sortedFigures== "+ Arrays.toString(sortedFigures));
		return sortedFigures;
	}
	static Colorable[] sortColorFigures(Colorable[] colorFigures, int numberOfColorLines, int numberOfColorTriangles, int numberOfColorPolygones){
		Colorable[] sortedColorFigures=new Colorable[colorFigures.length];
		ColorLine[] colorLines=new ColorLine[numberOfColorLines];
		int l=0;
		ColorTriangle[] colorTriangles=new ColorTriangle[numberOfColorTriangles];
		int t=0;
		ColorPolygon[] colorPolygons=new ColorPolygon[numberOfColorPolygones];
		int p=0;
		for (int i = 0; i < colorFigures.length; i++) {
			if(colorFigures[i] instanceof ColorLine){
				colorLines[l]=(ColorLine) colorFigures[i]; l++;
			}else if(colorFigures[i] instanceof ColorTriangle) {
				colorTriangles[t] = (ColorTriangle) colorFigures[i];
				t++;
			} else if(colorFigures[i] instanceof ColorPolygon) {
				colorPolygons[p] = (ColorPolygon) colorFigures[i];
				p++;
			}
		}
		System.out.println("lines== "+ Arrays.toString(colorLines));
		System.out.println("triangles== "+ Arrays.toString(colorTriangles));
		System.out.println("polygons== "+ Arrays.toString(colorPolygons));
		System.arraycopy(colorLines, 0, sortedColorFigures, 0, colorLines.length);
		System.arraycopy(colorTriangles, 0, sortedColorFigures, colorLines.length, colorTriangles.length);
		System.arraycopy(colorPolygons, 0, sortedColorFigures, colorLines.length+colorTriangles.length, colorPolygons.length);
		System.out.println("sorted COLOR Figures== "+ Arrays.toString(sortedColorFigures));
		return sortedColorFigures;
	}
	public static void main(String[] args) {
		//создать последовательность из фигур  используя фабрики цветных и нецветных фигур
		//получить масивы цветных и не цветных и сколько каждых фигур в нем присутсвует
		Colorable[] colorFigures=RandomColorfulFigures.RandomColorfulFigures();
		int numberOfColorLines=0;
		int numberOfColorTriangles=0;
		int numberOfColorPolygones=0;
		for (int i = 0; i < colorFigures.length; i++) {
			if(colorFigures[i] instanceof ColorLine){
				numberOfColorLines++;
			}else if(colorFigures[i] instanceof ColorTriangle){
				numberOfColorTriangles++;
			}else if(colorFigures[i] instanceof ColorPolygon){
				numberOfColorPolygones++;
			}
		}
		System.out.println("Number of ColorLines in array: "+numberOfColorLines);
		System.out.println("Number of ColorTriangles in array: "+numberOfColorTriangles);
		System.out.println("Number of ColorPolygons in array: "+numberOfColorPolygones);
		Object[] figures=RandomFigures.RandomFigures();
		int numberOfLines=0;
		int numberOfTriangles=0;
		int numberOfPolygones=0;
		for (int i = 0; i < figures.length; i++) {
			if(figures[i] instanceof Line){
				numberOfLines++;
			}else if(figures[i] instanceof Triangle){
				numberOfTriangles++;
			}else if(figures[i] instanceof Polygon){
				numberOfPolygones++;
			}
		}
		System.out.println("Number of Lines in array: "+numberOfLines);
		System.out.println("Number of Triangles in array: "+numberOfTriangles);
		System.out.println("Number of Polygons in array: "+numberOfPolygones);
		// групируем в масивах фигуры
		// тестируем методы фигур
		Object[] sortedFigures=sortFigures(figures,numberOfLines,numberOfTriangles,numberOfPolygones);
		Colorable[] sortedColorFigures=sortColorFigures(colorFigures,numberOfColorLines,numberOfColorTriangles,numberOfColorPolygones);


		//arraycopy(Object src,  int  srcPos,
		//Object dest, int destPos,
		//int length);

	}
}
