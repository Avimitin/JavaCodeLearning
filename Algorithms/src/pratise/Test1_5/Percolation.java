package pratise.Test1_5;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private class Bit{
        private int name;
        private boolean isOpen;
    }
    private int[] grid;
    private int width;
    private int[] size;
    private int openSitesCount;

    public Percolation(int n){
        width = n;
        int total = n*n;
        grid = new int[total];
        
        for (int i = 0; i < total; i++){ grid[i] = i; }
        for (int i = 0; i < total; i++){ size[i] = 1; }
    }

    private int xyTo1D(int x, int y){
        // let x,y to 1D index
        return (x-1) + (y-1) * width;
    }

    private int findRoot(int point){
        while(point != grid[point]){
            point = grid[point];
            grid[point] = grid[grid[point]];
        }

        return point;
    }

    public boolean isFull(int row, int col){
        int index = xyTo1D(row, col);
        for (int i = 0; i < width; i++){
            if (findRoot(index) == findRoot(i)) return true;
        }
        return false;
    }

    public void open(int row, int col){
        
        if ((row < 0 || row > width) || (col < 0 || col > width)){
            throw new IllegalArgumentException("index out of bound");
        }

        if (isOpen(row, col)) return;

        int randSite = (int) StdRandom.uniform(0, width-1);
        int index = xyTo1D(row, col);

        int root1 = findRoot(randSite);
        int root2 = findRoot(index);

        if (root1 == root2) return;
        else if (size[root1] < size[root2]) {
            grid[root1] = grid[root2];
            size[root2] += size[root1];
        } else if (size[root1] >= size[root2]){
            grid[root2] = grid[root1];
            size[root1] += size[root2];
        }

        openSitesCount ++;
    }

    public boolean isOpen(int row, int col){
        int index = xyTo1D(row, col);
        return findRoot(index) != index;
    }

    public int numberOfOpenSites(){ return openSitesCount; }

    public boolean percolates(){
        for (int i=0; i <= width; i++){
            for (int j = grid.length -1; j >= grid.length-1-width; j --){
                int root1 = findRoot(grid[i]);
                int root2 = findRoot(grid[j]);

                if (root1 == root2) return true;
            }
        }

        return false;
    }


    public static void main(String[] args){
        Percolation pc = new Percolation(5);
        StdOut.print(pc.grid.toString());
    }
}