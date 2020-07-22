package pratise.Test1_5;

public class UnionFind{
    private int count;
    private int[] id;
    private int[] size;

    public UnionFind(int N){
        count = N;
        id = new int[N];
        size = new int[N];

        for (int i=0; i<N; i++){ id[i] = i; }
        for (int i=0; i<N; i++){ id[i] = 1; }
    }

    public int count(){ return count;}

    public int find(int point){
        // 其实没有必要开内存但是为了更加清晰显示
        // 于是开辟内存将 point 赋值 root
        int root = point;
        while (root != id[root]){
            root = id[root];
            // 将节点指向更根部的位置
            id[root] = id[id[root]];
        }
        return root;
    }

    public boolean connected(int p, int q){ return find(p) == find(q);}

    public void union(int p, int q){
         int root1 = find(p);
         int root2 = find(q);

         if (root1 == root2) return;
         else if (size[p] > size[q]) { id[q] = id[p]; size[p] += size[q];}
         else if (size[q] > size[p]) { id[p] = id[q]; size[q] += size[p];}
         count --;
    }
}