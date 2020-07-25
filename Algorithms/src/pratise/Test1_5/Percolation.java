package pratise.Test1_5;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private class Bit{
        private int name;
        private boolean isOpen = false;
        public Bit(int name){ this.name = name; }
    }
    private Bit[] grid;
    private int width;
    private int[] size;
    private int openSitesCount;

    public Percolation(int n){
        width = n;
        int total = n*n;
        grid = new Bit[total];
        
        for (int i = 0; i < total; i++){ grid[i] = new Bit(i); }
        for (int i = 0; i < total; i++){ size[i] = 1; }
    }

    private int xyTo1D(int x, int y){
        // let x,y to 1D index
        return (x-1) + (y-1) * width;
    }

    private int findRoot(int point){
        while(point != grid[point].name){
            point = grid[point].name;
            grid[point] = grid[grid[point].name];
        }

        return point;
    }

    public boolean isFull(int row, int col){
        if ((row < 0 || row > width) || (col < 0 || col > width)){
            throw new IllegalArgumentException("index out of bound");
        }

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
        
        int index = xyTo1D(row, col);

        if (isOpen(row, col)) return;
        else grid[index].isOpen = true;

        openSitesCount ++;
    }

    public boolean isOpen(int row, int col){
        if ((row < 0 || row > width) || (col < 0 || col > width)){
            throw new IllegalArgumentException("index out of bound");
        }
        
        int index = xyTo1D(row, col);
        return grid[index].isOpen;
    }

    public int numberOfOpenSites(){ return openSitesCount; }

    public boolean percolates(){
        for (int i=0; i <= width; i++){
            for (int j = grid.length -1; j >= grid.length-1-width; j --){
                int root1 = findRoot(grid[i].name);
                int root2 = findRoot(grid[j].name);

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