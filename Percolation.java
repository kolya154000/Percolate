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
   private int size;
   private int openNumber;
   WeightedQuickUnionUF id;
   
   /**
    * Constructor for objects of class Percolation
    */
   public Percolation(int n) // create n-by-n cond, with all sites blocked
   {
       if(n <= 0)
       throw new IllegalArgumentException("Side of grid must be bigger than 0"); 
       side = n;
       size = n * n;
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
       return (row - 1) * side + (col - 1);
   }
   
   private boolean validate(int row, int col) // check invalid indicies
   {
      if(row < 0 || row > side || col < 0 || col > side) {
          throw new IllegalArgumentException("row " + row + " or col " + col + " is not between 1 and " + side);
          }  
      else
      return true;
   }
   
   private void connectNeighbours(int row, int col) // connect open neighbours that are below, above, right or left
   {
       int p = xyTo1D(row, col);
       if(isOpen(Math.max(1, row - 1), col))   //left neighbour
       {
           int q = xyTo1D(Math.max(1, row - 1), col);
           id.union(p, q);
       }
       if(isOpen(Math.max(1, col - 1), row)) //above neighbour
       {
           int q = xyTo1D(Math.max(1, col - 1), row);
           id.union(p, q);
       }
       if(isOpen(Math.min(side, row + 1), col))  // right neighbour
       {
           int q = xyTo1D(Math.min(side, row + 1), col);
           id.union(p, q);
       }
       if(isOpen(Math.min(side, col + 1), row))  // below neighbour
       {
           int q = xyTo1D(Math.min(side, col + 1), row);
           id.union(p, q);
       }
   }
   public void open(int row, int col) // open site (row, col) if it is not open already
   {
       validate(row, col);
       int p = xyTo1D(row, col);
       if(!(isOpen(row, col)))
       {
           cond[row - 1][col - 1] = 'o';
           connectNeighbours(row, col);
           openNumber++;
       }    
   }
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
       validate(row, col);
       if(cond[row - 1][col - 1] == 'c')
       return false;
       return true;
   }
   public boolean isFull(int row, int col)  // is site (row, col) full?
   {
       validate(row, col);
       int p = xyTo1D(row, col);
       for(int i = 0; i < side; i++)
       {
           if(id.connected(i, p))
           return true;
       }
       return false;
   }
   public int numberOfOpenSites()  // number of open sites
   {
       return openNumber;    
   }
   public boolean percolates()         // does the system percolate?
   {
       for(int i = 1; i <= side; i++)
       {
           if(isFull(side, i))
           return true;
       }   
       return false;
   }
   
   
   public static void main(String[] args)
   {
       
   } // test client (optional)

       /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
}
