public class InstanceofExample2 {
    
    public static void main(String[] args) {
        
        Taxi2 taxi2 = new Taxi2();
        Bus2 bus2 = new Bus2();

        ride(taxi2);
        System.out.println();
        ride(bus2);
    }

    public static void ride(Vehicle2 vehicle){

        if(vehicle instanceof Bus2){
            Bus2 bus2 = (Bus2)vehicle;
            bus2.cheakFare();
        }
        vehicle.run();
    }
}
