public class CarTire2 {
    
    Tire2 frontLeftTire = new HankookTire2();
    Tire2 frontRightTire = new HankookTire2();
    Tire2 backLeftTire = new HankookTire2();
    Tire2 backRightTire = new HankookTire2();

    void run(){
        frontLeftTire.roll();
        frontRightTire.roll();
        backLeftTire.roll();
        backRightTire.roll();
    }
}
