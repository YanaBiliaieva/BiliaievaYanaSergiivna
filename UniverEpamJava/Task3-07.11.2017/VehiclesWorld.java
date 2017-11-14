import java.util.Arrays;
import java.util.Random;

/**
 * @author Biliaieva Yana
 * Task: Создать абстрактный класс CVehicle. На его основе реализовать классы CPlane, CCar, CShip.
 * Классы должны иметь возможность задавать и получать координаты, параметры средств передвижения(цена, скорость, год выпуска).
 * Для самолета должна быть определена высота, для самолета и корабля - количество пассажиров, для корабля - порт приписки.
 * 1. Найти механизмы(в каждом из сгенерированых масивов 1 механизм) с наименьшей ценой с наибольшей скоростью и не старше 5 лет(1машина,1самолет и 1корабль)
 * 2. Найти из механизмов Plane, которые имеют высоту полета выше 5000 и год выпуска после 2000
 * 3. Найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
 * 4. Добавить к данной иерархии машину-амфибию, и БетМобиль(от машины, а машина(имеет интреф мувэбл) от Механизма),
 * (скорость по сушеразделенная на пять будет скорость по воде, умноженная на пять - по суше)
 * создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble
 */
//имена можно создать массивами строк и их от и рандомно вытягивать
abstract class CVehicle{
    private int price;
    private int speed;
    private int date;
    private String name;
    public CVehicle(){}
    public CVehicle(int price, int speed, int date, String name) {
        this.price = price;
        this.speed = speed;
        this.date = date;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CVehicle{" +
                "name=" + name +
                '}';
    }
}
interface Flyable{
    int flySpeed();
    int flySpeed(int x);
    int flyingHeight();
}
interface Swimable{
    int swim();
}
interface Movable{
    int moveSpeed();
}
//генерируем 50 механизмов. берем инстанс оф. создаем 3 послеовательности, которые будут хранить ссылки на: летающих, ездящих и плавающих
class CPlane extends CVehicle implements Flyable{

    public CPlane(int price, int speed, int date, String name, int flyingHeight, int flySpeed) {
        super(price, speed, date, name);
        this.flyingHeight ();
        this.flySpeed(flySpeed);
    }

    public CPlane() {
    }

    @Override
    public int flySpeed() {
        return 700;
    }

    @Override
    public int flySpeed(int x) {
        return x*300;
    }

    @Override
    public int flyingHeight() {
        return 56568;
    }

    @Override
    public String toString() {
        return "CPlane{" +
                "} " + super.toString();
    }
}
class CCar extends CVehicle implements Movable{

    public CCar(int price, int speed, int date, String name) {
        super(price, speed, date, name);
    }
    public CCar() {
    }
    @Override
    public int moveSpeed() {
        return 10;
    }

    @Override
    public String toString() {
        return "CCar{} " + super.toString();
    }
}
class CShip extends CVehicle implements Swimable {
    private String port;
    public CShip(){}
    public CShip(int price, int speed, int date, String name, String port) {
        super(price, speed, date, name);
        this.port=port;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public int swim() {
        return 700;
    }

    @Override
    public String toString() {
        return "CShip{" +
                "port='" + port + '\'' +
                "} " + super.toString();
    }
}
class BatMobile extends CVehicle implements Movable, Swimable,Flyable{
    public BatMobile(){}
    public BatMobile(int price, int speed, int date, String name, int flyingHeight) {
        super(price, speed, date, name);
    }

    @Override
    public int swim() {
        return 800;
    }

    @Override
    public int flySpeed() {
        return 700;
    }

    @Override
    public int moveSpeed() {
        return 1000;
    }

    @Override
    public int flySpeed(int x) {
        return x*11;
    }

    @Override
    public int flyingHeight() {
        return 67854;
    }

    @Override
    public String toString() {
        return "BatMobile{} " + super.toString();
    }
}
class SwimmingCar extends CVehicle implements Movable, Swimable{
    public SwimmingCar() {
    }

    public SwimmingCar(int price, int speed, int date, String name) {
        super(price, speed, date, name);
    }

    @Override
    public int swim() {
        return 789678;
    }

    @Override
    public int moveSpeed() {
        return 46757;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
class RandomVehicle{

    public static CVehicle[] generateSwimableVehicle() {
        CVehicle[] swimableVehicle=new CVehicle[4];
        for(int i=0;i<4;i++){
            Random r = new  Random();
            int key=r.nextInt(4);
            System.out.print(key);
            switch (key) {
                case 0: swimableVehicle[i]=new CShip(2000,500, 2000, "ShipS","Port");
                    System.out.println(swimableVehicle[i].getName());
                case 1: swimableVehicle[i]=new BatMobile(9999,10000, 2017, "BadBat",234546);
                    System.out.println(swimableVehicle[i].getName());
                case 2: swimableVehicle[i]=new CShip(700,50, 2007, "ShipS4","Port3");
                    System.out.println(swimableVehicle[i].getName());
                case 3: swimableVehicle[i]=new BatMobile(99988,88888, 2016, "BadBat2", 34645);
                    System.out.println(swimableVehicle[i].getName());
            }
        }
        return swimableVehicle;
    }
    public static CPlane[] flyableVehicles() {
        CPlane[] flyableVehicles=new CPlane[4];
        for(int i=0;i<4;i++){
            Random r = new  Random();
            int key=r.nextInt(4);
            switch (key) {
                case 0: flyableVehicles[i]=new CPlane(2000,500, 2000, "CPlane1",7777,77);
                case 1: flyableVehicles[i]=new CPlane(2000,500, 2000, "CPlane2",7777,77);
                case 2: flyableVehicles[i]=new CPlane(700,50, 2007, "CPlane3",555,66);
                case 3: flyableVehicles[i]=new CPlane(2000,500, 2000, "CPlane4",7777,77);
            }
        }
        System.out.println("CPlane[] flyableVehicles: "+Arrays.toString(flyableVehicles));
        return flyableVehicles;
    }
    public static CVehicle[] createMovableVehicles() {
        CVehicle[] movableVehicles=new CVehicle[4];
        for(int i=0;i<4;i++){
            Random r = new  Random();
            int key=r.nextInt(4);
            switch (key) {
                case 0: movableVehicles[i]=new CCar(200,500, 2001, "Toyota");
                case 1: movableVehicles[i]=new BatMobile(9999,10000, 2017, "BadBat7",3456);
                case 2: movableVehicles[i]=new CCar(70,50, 2008, "Lotus");
                case 3: movableVehicles[i]=new BatMobile(99988,88888, 2016, "BadBat6",54645);
            }
        }
        return movableVehicles;
    }
    public static CVehicle[] createAnyVehicles() {
        CVehicle[] anyVehicles=new CVehicle[4];
        for(int i=0;i<4;i++){
            Random r = new  Random();
            int key=r.nextInt(4);
            switch (key) {
                case 0: anyVehicles[i]=new CCar(200,500, 2001, "Toyota");
                case 1: anyVehicles[i]=new BatMobile(9999,10000, 2017, "BadBat7",3456);
                case 2: anyVehicles[i]=new  CPlane(700,50, 2007, "CPlane3",555,66);
                case 3: anyVehicles[i]=new CShip(700,50, 2007, "ShipS4","Port3");
            }
        }
        return anyVehicles;
    }
}
public class VehiclesWorld {
    public static void main(String[] args) {
        CVehicle[] swimMas=RandomVehicle.generateSwimableVehicle();

        CVehicle[] movableMas=RandomVehicle.createMovableVehicles();
        //с наименьшей ценой с наибольшей скоростью и не старше 5 лет

        System.out.print(Arrays.toString(swimMas));
        for (int i = 0; i < swimMas.length-1; i++) {
            if((2017-swimMas[i].getDate())<5){
                if(swimMas[i].getPrice()<swimMas[i+1].getPrice()&&swimMas[i].getSpeed()>swimMas[i+1].getSpeed()){
                    CVehicle bestSwimableCVehicle;
                    CVehicle lowPriceVeh=swimMas[i];
                    for (int j = 0; j < swimMas.length; j++) {
                        if(lowPriceVeh.getSpeed()>swimMas[j].getSpeed()){
                            if(lowPriceVeh instanceof CShip) {
                                bestSwimableCVehicle=new CShip();
                                bestSwimableCVehicle=lowPriceVeh;
                                System.out.println("Best Swimable CVehicle: "+bestSwimableCVehicle.toString());
                            }
                            if(lowPriceVeh instanceof BatMobile) {
                                bestSwimableCVehicle=new BatMobile();
                                bestSwimableCVehicle=lowPriceVeh;
                                System.out.println("Best Swimable CVehicle: "+bestSwimableCVehicle.toString());
                            }
                        }
                    }
                }
            }
        }
        System.out.println('\n');

        //Найти из механизмов Plane, которые имеют высоту полета выше 5000 и год выпуска после 2000
        CPlane[] flyMas=RandomVehicle.flyableVehicles();
        System.out.println("CPlane[] flyMas: "+Arrays.toString(flyMas));
        CPlane[] selectedPlanes=new CPlane[4];
        for (int i = 0; i < flyMas.length; i++) {
            if ((2017 - flyMas[i].getDate()) <= 17) {
                int k=0;
                if(flyMas[i].flyingHeight()>5000){
                    selectedPlanes[k]=flyMas[i];
                    k++;
                }
            }
        }
        System.out.println("Best CPlane with more than 5000 flyingHeight&date since 2000: "+Arrays.toString(selectedPlanes));
        //Найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
        CVehicle[] vehicleMas=RandomVehicle.createAnyVehicles();
        System.out.println("CPlane[] flyMas: "+Arrays.toString(flyMas));
        CVehicle[] selectedVehicles=new CVehicle[vehicleMas.length];
        for (int i = 0; i < vehicleMas.length; i++) {
            if(!(vehicleMas[i] instanceof CPlane)){
                int k=0;
                if(500>vehicleMas[i].getSpeed()&&vehicleMas[i].getSpeed()>200){
                    selectedVehicles[k]= vehicleMas[i];
                    k++;
                }
            }
        }

    }
}
