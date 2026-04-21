public class CarTire2Example {
    public static void main(String[] args) {
        
        CarTire2 mycar = new CarTire2();

        mycar.run();
        mycar.frontLeftTire = new KumhoTire2();
        mycar.frontRightTire = new KumhoTire2();

        mycar.run();
    }
}
