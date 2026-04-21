package airplane;

public class SupersonicAirplaneExamlple {
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane(); //SupersonicAirplane 을 sa에 넣음

        sa.takeoff();
        sa.fly();
        sa.flyMode = SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flyMode =SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
    }
}
