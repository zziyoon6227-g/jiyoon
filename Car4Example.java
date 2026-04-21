public class Car4Example {
    public static void main(String[] args) {
        

        Car4 c1 = new Car4();
        System.out.println("c1.company: " + c1.company);
        System.out.println("c1.model: " + c1.model);
        System.out.println("c1.color: " + c1.color); //참조형 String은 초기값이 null, 기본형은 0
        System.out.println("c1.maxSpeed: " + c1.maxSpeed);
        System.out.println(); //줄바꿈

        Car4 c2 = new Car4("자가용");
        System.out.println("c2.company: " + c2.company);
        System.out.println("c2.model: " + c2.model);
        System.out.println("c2.color: " + c2.color);
        System.out.println("c2.maxSpeed: " + c2.maxSpeed);
        System.out.println();

        Car4 c3 = new Car4("자가용", "빨강");
        System.out.println("c3.company: " + c3.company);
        System.out.println("c3.model: " + c3.model);
        System.out.println("c3.color: " + c3.color);
        System.out.println("c3.maxSpeed: " + c3.maxSpeed);
        System.out.println();

        Car4 c4 = new Car4("택시","검정",200);
        System.out.println("c4.company: " + c4.company);
        System.out.println("c4.model: " + c4.model);
        System.out.println("c4.color: " + c4.color);
        System.out.println("c4.maxSpeed: " + c4.maxSpeed);
    }
    }

