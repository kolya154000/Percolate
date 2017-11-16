/**
 * Write a description of class Percolation here.
 *
 * @author Mykola
 * @version (a version number or a date)
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
   private int side; 
   private char[][] cond; 
   private int[][] id;
   private int size;
   private int openNumber;
   WeightedQuickUnionUF id;
   private int xyTo1D(int row, int col) // convert 2D to 1D
   {
       return (row - 1) * side + (col - 1);
   }
   private boolean validate(int row, int col) // check invalid indicies
   {
       int p = xyTo1D(row, col);
       if(p < 0 || p >= size) {
           throw new IllegalArgumentException("index " + p + " is not between 0 and " + (size-1));  
       }       
   }
   /**
    * Constructor for objects of class Percolation
    */
   public Percolation(int n) // create n-by-n grid, with all sites blocked
   {
       if(n <= 0) throw java.lang.IllegalArgumentException; 
       side = n;
       size = n * n;
       id = new WeightedQuickUnionUF(size);
       cond = new char[n][n];
       for(int i = 0; i < n; i++)
       {
           for(int j = 0; j < n; j++)
           {
               grid[i][j] = 'c';
           }
       } 
       
   }
       
   public void open(int row, int col) // open site (row, col) if it is not open already
   {
       if(!isOpen(row, col))
       {
           grid[row - 1][col - 1] = 'o';
           
       }    
   }
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
       if(grid[row][col] == 'c')
       return false;
       return true;
   }
   public boolean isFull(int row, int col)  // is site (row, col) full?
   {
       if(grid[row][col] == 'f')
       return false;
       return true;
   }
   public int numberOfOpenSites()  // number of open sites
   {
       
   }
   public boolean percolates()         // does the system percolate?
   {
       
   }

   public static void main(String[] args)
   {
       
   }// test client (optional)

       /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
}
