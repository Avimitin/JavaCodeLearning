package programTest;

public class StopWatch {
    private final long start;

    public StopWatch(){
        start = System.currentTimeMillis();
    }

    public double stop(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}