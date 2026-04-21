public class Member3Example {
    public static void main(String[] args) {
        Member3 original = new Member3("홍길동", 25, new int[] {90,90}, new Car8("소나타"));

        Member3 cloned = original.getMember3();
        cloned.scores[0] = 100;
        cloned.car8.model = "그랜저";

        System.out.println("[복채 객체의 필드값]");
        System.out.println("name: "+cloned.name);
        System.out.println("age: "+cloned.age);
        System.out.print("scores: {");
        for(int i = 0; i<cloned.scores.length;i++){ 
            System.out.print(cloned.scores[i]);
            System.out.print((i==(cloned.scores.length-1))?"":",");
        }
        System.out.println("}");
        System.out.println("car: " + cloned.car8.model);

        System.out.println("\n[원본 객체의 필드값]");
        System.out.println("name: " + original.name);
        System.out.println("age: " + original.age);
        System.out.print("scores: {");
      
        for(int i = 0; i<original.scores.length;i++){
            System.out.print(original.scores[i]);
            System.out.print((i==(original.scores.length-1))?"":",");
        }

        System.out.println("}");
        System.out.println("car: " +original.car8.model);

    }
}
