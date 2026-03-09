public class DineInOrder extends FoodOrder{
    //constrcutor calling super
    public DineInOrder(String name, String item, int prio){
        super(name, item, prio);
    }

    //abstract methods
    public void prepareOrder(){
        System.out.printf("Preparing dine-in order for %s: %s\n", this.getName(), this.getItem());
    }

}