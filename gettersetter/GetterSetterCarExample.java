package gettersetter;

public class GetterSetterCarExample {
    public static void main(String[] args) {
        
        GetterSetterCar myCar = new GetterSetterCar();

        myCar.setSpeed(-50);

        System.out.println("현재속도: " + myCar.getSpeed());

        myCar.setSpeed(60);

        if(!myCar.isStop()){
            myCar.setStop(true);
        }
        System.out.println("현재 속도: " + myCar.getSpeed());
    }
}
