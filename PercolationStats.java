/**----------------------------------------------------
 * 
 * 
 * @author Mykola 
 * @version 19.11.2017
 *---------------------------------------------------*/
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdDraw;

public class PercolationStats {
   private int t;
   private Percolation perc;
   private double[] fractions;
   
   public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
   {
       if (n <= 0 || trials <= 0)
       throw new java.lang.IllegalArgumentException();
       this.t = trials;
       int size = n * n;
       perc = new Percolation(n);
       fractions = new double[t];
       for (int i = 0; i < t; i++)
       {
           while (!perc.percolates())
           {
               int r = StdRandom.uniform(1, n + 1);
               int j = StdRandom.uniform(1, n + 1);
               perc.open(r, j);
               //PercolationVisualizer.draw(perc, n);
              // StdDraw.show();
           }  
           fractions[i] = (double)perc.numberOfOpenSites() / size;
           System.out.println(i + 1 + " - " + fractions[i]);
           perc = new Percolation(n);
       }
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public double mean()            // sample mean of percolation threshold
   {
       return StdStats.mean(fractions);     
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public double stddev()          // sample standard deviation of percolation threshold
   {
       return StdStats.stddev(fractions);    
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public double confidenceLo()      //low  endpoint of 95% confidence interval
   {
       return mean() - 1.96 * stddev() / Math.sqrt(t);    
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public double confidenceHi()         // high endpoint of 95% confidence interval
   {
       return mean() + 1.96 * stddev() / Math.sqrt(t);
   }
   
   /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   public static void main(String[] args)        // test client (described below)
   {
       int n = 200; //     Integer.parseInt(args[0]); 
       int trials = 100; // Integer.parseInt(args[1]);
       PercolationStats stats = new PercolationStats(n, trials);
                      
       System.out.println("mean                    = " + stats.mean());
       System.out.println("stddev                  = " + stats.stddev());
       System.out.println("95% confidence interval = " + "[" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
    
}
