public class Korean { //클래스명 Korean
    //필드
    String nation = "대한민국";
    String name;
    String ssn;

    public Korean(String nation, String name,String ssn){ //생성자명 Korean
        this.name = name;  
        this.ssn = ssn;   //this.은 new예약으로 생성자 호출할때마다 주소가 다름
    }

}


