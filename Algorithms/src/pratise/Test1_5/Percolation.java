package pratise.Test1_5;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private int[] grid;

    public Percolation(int n){
        int total = n*n;
        grid = new int[total];
        
        for (int i = 0; i < total; i++){ grid[i] = i; }
    }

    private int xyTo1D(int x, int y){
        // let x,y to 1D index
    }

    private int findRoot(int point){
        while(point != grid[point]){
            point = grid[point];
            grid[point] = grid[grid[point]];
        }

        return point;
    }

    public void open(int row, int col){

    }

    public boolean isOpen(int row, int col){
        return findRoot(row) == findRoot(col);
    }

    public static void main(String[] args){
        Percolation pc = new Percolation(5);
        StdOut.print(pc.grid.toString());
    }
}