public class FieldInitValueExamlple {
    public static void main(String[] args) {
        
        FieldInitValue fiv = new FieldInitValue();

        System.out.println("byteField:" +fiv.byteField);
        System.out.println("shortField:" +fiv.shortField);
        System.out.println("intField:" +fiv.intField);
        System.out.println("longField:" +fiv.longField);
        System.out.println("booleanField:" +fiv.booleanField); //초기값은 false
        System.out.println("charField:" +fiv.charField);
        System.out.println("floatField:" +fiv.floatField);
        System.out.println("doubleField:" +fiv.doubleField);

        System.out.println("arrField:" +fiv.arrField); //객체형(참조형) 초기값은 null
        System.out.println("referenceField:" +fiv.referenceField); //객체형(참조형) 초기값은 null

    }
}
