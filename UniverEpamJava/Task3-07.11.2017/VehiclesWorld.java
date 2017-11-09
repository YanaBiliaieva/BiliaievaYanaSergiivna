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
}
interface Swimable{
    int swim();
}
interface Movable{
    int moveSpeed();
}
//генерируем 50 механизмов. берем инстанс оф. создаем 3 послеовательности, которые будут хранить ссылки на: летающих, ездящих и плавающих
class CPlane extends CVehicle implements Flyable{
    private int flyingHeight;

    public CPlane(int price, int speed, int date, String name, int flyingHeight, int flySpeed) {
        super(price, speed, date, name);
        this.flyingHeight = flyingHeight;
        this.flySpeed(flySpeed);
    }

    public int getFlyingHeight() {
        return flyingHeight;
    }

    public void setFlyingHeight(int flyingHeight) {
        this.flyingHeight = flyingHeight;
    }


    @Override
    public int flySpeed() {
        return 700;
    }

    @Override
    public int flySpeed(int x) {
        return x*300;
    }
}
class CCar extends CVehicle implements Movable{

    public CCar(int price, int speed, int date, String name) {
        super(price, speed, date, name);
    }

    @Override
    public int moveSpeed() {
        return 10;
    }
}
class CShip extends CVehicle implements Swimable {
    private String port;

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
}
class BatMobile extends CVehicle implements Movable, Swimable,Flyable{

    public BatMobile(int price, int speed, int date, String name) {
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
}

class RandomVehicle{

    public static CVehicle[] generateSwimableVehicle() {
        CVehicle[] swimableVehicle=new CVehicle[4];
        for(int i=0;i<4;i++){
            Random r = new  Random();
            int key=r.nextInt(4);
            switch (key) {
                case 0: swimableVehicle[i]=new CShip(2000,500, 2000, "ShipS","Port");
                case 1: swimableVehicle[i]=new BatMobile(9999,10000, 2017, "BadBat");
                case 2: swimableVehicle[i]=new CShip(700,50, 2007, "ShipS4","Port3");
                case 3: swimableVehicle[i]=new BatMobile(99988,88888, 2016, "BadBat2");
                default: return null;
            }
        }

        return swimableVehicle;
    }
    public static CVehicle[] flyableVehicles() {
        CVehicle[] flyableVehicles=new CVehicle[4];
        for(int i=0;i<4;i++){
            Random r = new  Random();
            int key=r.nextInt(4);
            switch (key) {
                case 0: flyableVehicles[i]=new CPlane(2000,500, 2000, "ShipS",7777,77);
                case 1: flyableVehicles[i]=new BatMobile(9999,10000, 2017, "BadBat7");
                case 2: flyableVehicles[i]=new CPlane(700,50, 2007, "ShipS4",555,66);
                case 3: flyableVehicles[i]=new BatMobile(99988,88888, 2016, "BadBat6");
                default: return null;
            }
        }

        return flyableVehicles;
    }
    public static CVehicle[] createMovableVehicles() {
        CVehicle[] movableVehicles=new CVehicle[4];
        for(int i=0;i<4;i++){
            Random r = new  Random();
            int key=r.nextInt(4);
            switch (key) {
                case 0: movableVehicles[i]=new CCar(200,500, 2001, "Toyota");
                case 1: movableVehicles[i]=new BatMobile(9999,10000, 2017, "BadBat7");
                case 2: movableVehicles[i]=new CCar(70,50, 2008, "Lotus");
                case 3: movableVehicles[i]=new BatMobile(99988,88888, 2016, "BadBat6");
                default: return null;
            }
        }
        return movableVehicles;
    }
}
public class VehiclesWorld {
    public static void main(String[] args) {
        CVehicle[] swimMas=RandomVehicle.generateSwimableVehicle();
        CVehicle[] flyMas=RandomVehicle.flyableVehicles();
        CVehicle[] movableMas=RandomVehicle.createMovableVehicles();
        //с наименьшей ценой с наибольшей скоростью и не старше 5 лет
        for (int i = 0; i < swimMas.length; i++) {
            if((2017-swimMas[i].getDate())<5){
                if(swimMas[i].getPrice()<swimMas[i+1].getPrice()&&swimMas[i].getSpeed()>swimMas[i+1].getSpeed()){
                    
                }
            }
           
        }
    }
}
