/**
 * Name: Kavya Srikumar
 * Mrs. Kankelborg
 * Period 3 
 * Project 2 Recursive Art Project Part 1: Transform2D
 * Last Updated: 12/10/21
 * 
 * Class Description:
 */

public class Transform2D {
	
	/**
	 * Returns a new array object that is an exact copy of the given array.
	 * The given array is not mutated.
	 */
	public static double[] copy(double[] array) 
	{
		double[] result = new double[array.length];
		
		for (int i = 0; i < array.length; i++)
		{
			result[i] = array[i];
		}
		
		return result;
	}
	
	/**
	 * Scales the polygon by the factor alpha.
	 * The given array is mutated.
	 */
	public static void scale(double[] x, double[] y, double alpha) 
	{
		for ( int i = 0; i < x.length; i++)
		{
			x[i] *= alpha;
			y[i] *= alpha;
		}
	}
	
	/**
	 * Translates the polygon by (dx, dy)
	 * The given array is mutated.
	 */
	public static void translate (double[] x, double[] y, double dx, double dy) 
	{
		for ( int i = 0; i < x.length; i++)
		{
			x[i] += dx;
			y[i] += dy;
		}
	}
	
	/**
	 * Rotates the polygon theta degrees counterclockwise, about the origin.
	 * The given array is mutated.
	 */
	public static void rotate (double[] x, double[] y, double theta) 
	{
		double radians = Math.toRadians(theta);
		double temp;
		
		for ( int i = 0; i < x.length; i++)
		{
			temp = x[i];
			
			x[i] = x[i] * Math.cos(radians) - y[i] * Math.sin(radians);
			y[i] = y[i] * Math.cos(radians) + temp * Math.sin(radians);
			
		}
	}
	
	/**
	 * You can use this method to test that each other method works properly.
	 */
	public static void main (String[] args) 
	{
		/*StdDraw.setScale(-4.0, 4.0);
		
		double[] x = {1, 2, 2, 1};
		double[] y = {1, 1, 3, 2};
		
		StdDraw.polygon(x, y);
		
		Transform2D.rotate(x, y, 90.0);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.polygon(x, y);
		*/
	}
}
