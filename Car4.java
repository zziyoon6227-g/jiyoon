public class Car4 {
    
     //필드
     String company = "현대자동차";
     String model;
     String color;
     int maxSpeed;
     
     //생성자 4개
     Car4(){ 
     }
 
     Car4(String model){ 
         this(model,null,0); //생성자안에서 첫줄에서만 사용가능 다른 생성자에게 생성떠넘길때
     }
 
     Car4(String model,String color){ 
        this(model,color,0);
     }
 
     Car4(String model,String color,int maxSpeed){  //위에 this 여기서 생성
         this.model = model;
         this.color = color;
         this.maxSpeed = maxSpeed;
     }
}
