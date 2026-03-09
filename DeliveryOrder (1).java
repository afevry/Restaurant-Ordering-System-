public class DeliveryOrder extends FoodOrder{
    //constrcutor calling super
    public DeliveryOrder(String name, String item, int prio){
        super(name, item, prio);
    }

    //abstract methods
    public void prepareOrder(){
        System.out.printf("Preparing delivery order for %s: %s\n", this.getName(), this.getItem());
    }
}