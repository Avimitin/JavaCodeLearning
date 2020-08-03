package programTest;

public class QueueWithTwoStack {
    // 用两个栈来模拟队列
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void enQueue(int item){
        in.push(item);
    }

    public int deQueue(){
        if (out.isEmpty()){
            if (in.isEmpty()) return -1;
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}