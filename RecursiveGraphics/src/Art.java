/**
 * <pre>
 * Name: Kavya Srikumar
 * Mrs. Kankelborg
 * Period 3
 * Project 2 Recursive Art Project Part 3: Art
 * Revision History: 1/2/22
 *
 * Class Description: This recursive algorithm uses circles plotted around other circles to create
 * a flower pattern. This algorithm uses recursive level and math randoms to dictate color. It also uses different 
 * standard draw methods than Sierpinski, and has different parameters. 
 * </pre>
 */

public class Art
{
   /**
	* All other functions other than draw must be private.
	* You must have at least 2 other methods besides draw.
	* You may not alter the header of this method.
	*/
	public static void draw(int n)
	{
		// draw the yellow center circle with radius 0.25
		double r = 0.25;
		
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledCircle(0.5, 0.5, r);
		
		draw(n, 0.5, 0.5, r);
	}
	
	private static void draw (int n, double x, double y, double radius) 
	{
		StdDraw.enableDoubleBuffering();
		
		// assigning random variables for colors in standard draw
		int r = (int)(Math.random() * 255);
		int g = (int)(Math.random() * 255);
		int b = (int)(Math.random() * 255);
		
		// continues to recurse until n is 0
		if ( n != 0 ) 
		{
			
			double xCoord = 0;
			double yCoord = 0;
			
			// draws eight equal circles exactly spanning the circumference of the circle inside them
			for (int i = 1; i <= 8; i++) 
			{
				xCoord = radius * Math.cos(i * Math.toRadians(45)) + x;
				yCoord = radius * Math.sin(i * Math.toRadians(45)) + y;
				
				// assigns a random pen color to each set of 8 circles
				StdDraw.setPenColor(r, g, b);
				// draws each individual circle
				StdDraw.filledCircle(xCoord, yCoord, outerCircleRadius(radius));
				// recursive call to draw the circles outside the first row of circles
				draw(n-1, xCoord, yCoord, outerCircleRadius(radius));
			}
			
			// shows the image
			StdDraw.show();	
		}
		
	}
	
	// calculates the radius of each of the smaller eight circles surrounding an 
	// inner circle of radius radius 
	private static double outerCircleRadius (double radius)
	{
		return radius * Math.tan(45) / 4;
	}
}
