/*
 * Class used to contain the points used by the ExtendedCircle and ExtendedCircleTest within this package
 * @author Grant Melvin
 * September 6, 2022
 */

package assg2_B01261294;

import java.lang.Math ;

public class Point {

	private int x, y ;

	/*
	 * Constructor for a point with no params passed
	 */
	public Point()
	{
		x = 0 ;
		y = 0 ; 
	}
	
	/*
	 * Constructor for a point with x and y coordinates passed
	 * @param 	x 	is x-value of point
	 * @param 	y 	is y-value of point
	 */
	public Point(int x, int y)
	{
		this.x = x ;
		this.y = y ;
	}
	
	/*
	 * Gets the x value of the current point
	 * @return x value
	 */
	public int getX()
	{
		return x ; 
	}

	/*
	 * Gets the y value of the current point
	 * @return y value
	 */
	public int getY()
	{
		return y ; 
	}
	
	/*
	 * Replaces the current x value with the value passed by parameter
	 * @param 	x	new x value to set it to
	 */
	public void setX(int x)
	{
		this.x = x ;
	}
	
	/*
	 * Replaces the current y value with the value passed by parameter
	 * @param 	y	new y value to set it to
	 */
	public void setY(int y)
	{
		this.y = y ;
	}
	
	/*
	 * Displays the point with formatting
	 * @return the x and y coordinates of the point
	 */
	public String toString()
	{
		return "(" + x + "," + y + ")" ;
	}
	
	/*
	 * Calculates the distance from one point to another
	 * @param 	point	the point to calculate the distance from the current point
	 * @return the value that is being calculated
	 */
	public double distance(Point point)
	{	
		return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(this.y - point.y, 2)) ; 
	}
	
	/*
	 * Checks to see if the point is equal to the current point
	 * @param 	point 	the point to compare
	 * @return true if points are equal
	 * @return false if points are not equal
	 * @return false if x are equal and y is not equal
	 */
	public boolean equals(Point point)
	{
		if(point == null)
		{
			return false ;
		}
		if(point instanceof Point)
		{
			Point temp = (Point)point ; 
			if(this.x == temp.x)
			{
				return this.y == temp.y; 
			}
			return false ;
		}
		else
		{
			return false  ;
		}
	}
	
}
