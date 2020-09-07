package pratise.PriorityQueue;

public class MaxQ <Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxQ(int M) { pq = (Key[]) new Comparable[M+1]; }

    public boolean isEmpty() { return N == 0; }

    public int size() { return N; }

    public void insert (Key v) {
        // a[0] 不需要
        pq[++N] = v;
        swim(N);
    }

    public void swim (int k) {
        while (k > 0 && less(pq[k/2], pq[k])) {
            exchange(k/2, k);
            k = k/2;
        }
    }

    private boolean less(Key a, Key b) { return a.compareTo(b) < 0; }

    private void exchange(int i, int j) {
        Key item = pq[i];
        pq[i] = pq[j];
        pq[j] = item;
    }

    public Key deleteMax() {
        Key item = pq[1];
        exchange(1, N--);
        pq[N+1] = null;
        sink(1);
        return item;
    }

    public void sink(int k) {
        while (k*2 < N) {
            if (less(pq[k], pq[k*2])) {
                exchange(k,k*2);
                k = k*2;
            }
            else if (less(pq[k], pq[k*2+1])) {
                exchange(k, k*2);
                k = k*2+1;
            }
            else break;
        }
    }
}
