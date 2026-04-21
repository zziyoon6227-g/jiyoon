public class Car3 {
    //필드
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;
    
    //생성자 4개
    Car3(){ //괄호안에는 필드에 초기화한 개수만 정의가능(명시적초기화빼고) 총 3개가능
    }

    Car3(String model){ //ex) 0x10번지
        this.model = model;
    }

    Car3(String model,String color){ //ex) 0x100번지
        this.model = model;
        this.color = color;
    }

    Car3(String model,String color,int maxSpeed){ //ex) 0x1000번지
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
