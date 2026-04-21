package airplane;

public class SupersonicAirplane extends Airplane{
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;

    public int flyMode = NORMAL; //노멀은 값 1?

    @Override
    public void fly(){
        if(flyMode == SUPERSONIC){
            System.out.println("초음속비행합니다.");
        }else{
            super.fly();
        }
    }
}
