/**
 * Class Percolation.
 *
 * @author Mykola
 * @version 19.11.2017
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
   private int side; 
   private char[][] cond; 
   private int openNumber;
   private final WeightedQuickUnionUF id;
   
   /**
    * Constructor for objects of class Percolation
    */
   public Percolation(int n) // create n-by-n cond, with all sites blocked
   {
       if (n <= 0)
       throw new IllegalArgumentException("Side of grid must be bigger than 0"); 
       side = n;
       int size = n * n;
       id = new WeightedQuickUnionUF(size);
       cond = new char[n][n];
       for(int i = 0; i < n; i++)
       {
           for(int j = 0; j < n; j++)
           {
               cond[i][j] = 'c';
           }
       } 
   }
  
   private int xyTo1D(int row, int col) // convert 2D to 1D
   {
       int d = (row - 1) * side + (col - 1);
       return d;
   }
   
   private boolean validate(int row, int col) // check invalid indicies
   {
      if (row < 1 || row > side || col < 1 || col > side) {
          throw new IllegalArgumentException("row " + row + " or col " + col + " is not between 1 and " + side);
          }  
      else
      return true;
   }
   
   private void connectNeighbours(int row, int col) // connect open neighbours that are below, above, right or left
   {
       int p = xyTo1D(row, col);
       if (isOpen(row, Math.max(1, col - 1)))   //left neighbour
       {
           int q = xyTo1D(row, Math.max(1, col - 1));
           id.union(p, q);
       }
       if (isOpen(Math.max(1, row - 1), col)) //above neighbour
       {
           int q = xyTo1D(Math.max(1, row - 1), col);
           id.union(p, q);
       } 
       if (isOpen(row, Math.min(side, col + 1)))  // right neighbour
       {
           int q = xyTo1D(row, Math.min(side, col + 1));
           id.union(p, q);
       }
       if (isOpen(Math.min(side, row + 1), col))  // below neighbour
       {
           int q = xyTo1D(Math.min(side, row + 1), col);
           id.union(p, q);
       }
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public void open(int row, int col) // open site (row, col) if it is not open already
   {
       validate(row, col);
       if (!(isOpen(row, col)))
       {
           cond[row - 1][col - 1] = 'o';
           connectNeighbours(row, col);
           openNumber++;
       }    
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
       validate(row, col);
       if (cond[row - 1][col - 1] == 'c')
       return false;
       return true;
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public boolean isFull(int row, int col)  // is site (row, col) full?
   {
       validate(row, col);
       int p = xyTo1D(row, col);
       for (int i = 0; i < side; i++)
       {
           if(isOpen(1, i + 1) && id.connected(i, p))
           {
               return true;
           }   
       }
       return false;
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public int numberOfOpenSites()  // number of open sites
   {
       return openNumber;    
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public boolean percolates()         // does the system percolate?
   {
       for (int i = 1; i <= side; i++)
       {
           if(isFull(side, i))
           return true;
       }   
       return false;
   }
}
