public abstract class FoodOrder implements Comparable<FoodOrder>{
    private String customerName;
    private String item;
    private int priority;

    public FoodOrder(String customerName, String item, int priority){
        this.customerName = customerName;
        this.item = item;
        this.priority = priority;
    }

    public abstract void prepareOrder();

    public String getName(){
        return this.customerName;
    }

    public String getItem(){
        return this.item;
    }

    public int compareTo(FoodOrder other){
        if(other.priority < this.priority) return 1; // other has a higher priority since num is less
        if(other.priority > this.priority) return -1; // lower priority 

        return 0; //theyre equal
    }
}