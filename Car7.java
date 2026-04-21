public class Car7 {
    
    int speed;
    void run(){
        System.out.println(speed+ "으로 달립니다.");
    }
    public static void main(String[] args) {
        Car7 mycar = new Car7();
        mycar.speed = 60;
        mycar.run();

    }
} //이런 소스코드는 지양함
