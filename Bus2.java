public class Bus2 implements Vehicle2 {
    @Override
    public void run(){
        System.out.println("버스가 달립니다.");
    }

    public void cheakFare(){
        System.out.println("승차 요금을 체크합니다.");
    }
}
