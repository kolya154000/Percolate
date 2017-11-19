/**
 * Write a description of class PercolationStats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdDraw;

public class PercolationStats {
   private int n;
   private int t;
   private Percolation perc;
   private double[] fractions;
   
   public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
   {
       if(n <= 0 || trials <= 0)
       throw new java.lang.IllegalArgumentException();
       this.n = n;
       this.t = trials;
       perc = new Percolation(n);
       fractions = new double[t];
       //StdDraw.enableDoubleBuffering();
       for(int i = 0; i < t; i++)
       {
           while (!perc.percolates())
           {
               int r = StdRandom.uniform(1, n + 1);
               int j = StdRandom.uniform(1, n + 1);
               perc.open(r, j);
               //PercolationVisualizer.draw(perc, n);
              // StdDraw.show();
           }  
           fractions[i] = (double)perc.numberOfOpenSites() / (n * n);
           System.out.println(i + " " + fractions[i]);
           perc = new Percolation(n);
       }
   }
   
   public double mean()            // sample mean of percolation threshold
   {
       return StdStats.mean(fractions);     
   }
   
   public double stddev()          // sample standard deviation of percolation threshold
   {
       return StdStats.stddev(fractions);    
   }
   
   public double confidenceLo()      //low  endpoint of 95% confidence interval
   {
       return mean() - 1.96 * stddev() / Math.sqrt(t);    
   }
   
   public double confidenceHi()         // high endpoint of 95% confidence interval
   {
       return mean() + 1.96 * stddev() / Math.sqrt(t);
   }
   
   public static void main(String[] args)        // test client (described below)
   {
       int n = 200; //Integer.parseInt(args[0]); 
       int trials = 10; // Integer.parseInt(args[1]);
       PercolationStats stats = new PercolationStats(n, trials);
                      
       System.out.println("mean                    = " + stats.mean());
       System.out.println("stddev                  = " + stats.stddev());
       System.out.println("95% confidence interval = " + "[" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
    
}
