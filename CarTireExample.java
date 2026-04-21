public class CarTireExample {
    public static void main(String[] args) {
        CarTire c = new CarTire();

        for(int i=1; i<=5; i++){
            int problemLocation = c.run();
            switch(problemLocation){
                case 1:
                System.out.println("앞왼쪽 한국타이어로 교체");
                c.frontLeftTire = new HankookTire("앞왼쪽", 15);
                break;
             
                case 2:
                System.out.println("앞오른쪽 금호타이어로 교체");
                c.frontRightTire = new KumhoTire("앞오른쪽", 13);
                break;

                case 3:
                System.out.println("뒤왼쪽 한국타이어로 교체");
                c.backLeftTire = new HankookTire("뒤왼쪽", 14);
                break;

                case 4:
                System.out.println("뒤오른쪽 금호타이어로 교체");
                c.backRightTire = new KumhoTire("뒤오른쪽", 17);
                break;
            }
            System.out.println("----------------------------------------");
        }
    }
}
