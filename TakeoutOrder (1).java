public class TakeoutOrder extends FoodOrder{
    //constrcutor calling super
    public TakeoutOrder(String name, String item, int prio){
        super(name, item, prio);
    }

    //abstract methods
    public void prepareOrder(){
        System.out.printf("Preparing takeout order for %s: %s\n", this.getName(), this.getItem());
    }

}