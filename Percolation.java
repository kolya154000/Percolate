
/**
 * Write a description of class Percolation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
   char[][] grid; 
   /**
    * Constructor for objects of class Percolation
    */
   public Percolation(int n) // create n-by-n grid, with all sites blocked
   {
       if(n <= 0) throw java.lang.IllegalArgumentException; 
       grid = new char[n][n];
       for(int i = 1; i <= n; i++)
       {
           for(int j = 1; j <= n; j++)
           {
               grid[i][j] = 'c';
           }
       }   
   }
       
   public void open(int row, int col) // open site (row, col) if it is not open already
   {
       if(!isOpen(row, col))
       {
           grid[row][col] = 'o';
       }    
   }
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
       if(grid[row][col] = 'c')
       return false;
       return true;
   }
   public boolean isFull(int row, int col)  // is site (row, col) full?
   {
       
   }
   public int numberOfOpenSites()       // number of open sites
   public boolean percolates()              // does the system percolate?

   public static void main(String[] args)   // test client (optional)

       /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
