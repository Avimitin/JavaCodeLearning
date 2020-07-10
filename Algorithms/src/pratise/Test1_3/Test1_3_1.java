package pratise.Test1_3;

public class Test1_3_1<Item> extends programTest.FixedCapacityStack<Item>{
    public Test1_3_1(int cap){
        super(cap);
    }

    public boolean isFull(){
        return N == a.length;
    }
}
