/**
 * Name: Kavya Srikumar
 * Mrs. Kankelborg
 * Period 3
 * Project 2 Recursive Art Project Part 2: Sierpinski 
 * Last Updated: 12/13/21
 * 
 * Class Description:
 * This class plots a Sierpinski triangle of order n to standard drawing. After drawing the outline
 * and one filled equilateral triangle that points downwards, there are three recursive calls to fill 
 * all three spaces around each side of the downwards triangle accordingly. 
 */

public class Sierpinski {
    
	/** 
	 * Takes an integer parameter of n and draws the outline of an equilateral 
     * triangle(pointed upwards) of length 1 whose bottom-left vertex is (0,0) and 
     * bottom-right vertex is (1,0) and then calls the overloaded version of sierpinski 
     * of order n that fits snugly inside the outline.
     */
    public static void sierpinski(int n)
    {
    	// creates two double arrays with the x and y coordinates for the outline triangle
    	double[] x = {0, 1, 0.5};
    	double[] y = {0, 0, Math.sqrt(3) * 0.5};
    	
    	// draws the outline triangle
    	StdDraw.polygon(x, y);
    	
    	// calls the overloaded sierpinski method that fits snugly within the outline 
    	sierpinski(n, 0.5, 0, 0.5);
    }
    
    /**
     * Draws a Sierpinski triangle of order n, such that the largest filled
     * triangle has bottom vertex (x, y) and sides of the specified length.
     */
    private static void sierpinski(int n, double x, double y, double length)
    {
    	// continue recursion until n is zero
    	if (n != 0) 
    	{
    		// draw a filled triangle with bottom vertex (x, y) and sides of length length
    		filledTriangle(x, y, length);
    		
    		// calculates the height for the current triangle
    		double height = height(length);
    		
    		// calls sierpinski recursively three times to add the appropriate filled triangles
    		// on all three sides of the previous filled triangle
    		sierpinski(n-1, x, y + height, length / 2);
    		sierpinski(n-1, x + length / 2, y, length / 2);
    		sierpinski(n-1, x - length / 2, y, length / 2);
    		
    	}
    }
    
	/**
	 * Calculates the height of an equilateral triangle whose sides are of the specified
	 * length.
	 */
    private static double height(double length)
    {
    	return (length * Math.sqrt(3) * 0.5);
    }

    /**
     * Draws a filled equilateral triangle whose bottom vertex is (x, y) and whose sides
     * are of the specified length.
     */
    private static void filledTriangle(double x, double y, double length)
    {
    	double height = height(length);
    	double[] xCoord = {x, x - (0.5 * length), x + (0.5 * length)};
    	double[] yCoord = {y, y + height, y + height};
    	
    	StdDraw.filledPolygon(xCoord, yCoord);
    } 
}
