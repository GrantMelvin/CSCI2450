/*
 * Class used to calculate and manipulate circles and their coordinates
 * @author Grant Melvin
 * September 6, 2022
 */
package assg2_B01261294; 

public class ExtendedCircle {
	
	public static final double  PI = 3.14159 ; 

	private double radius ;  
	
	private Point center ;  
	
	/*
	 * Constructor for circle with no params passed 
	 */
	public ExtendedCircle()
	{
		this.radius = 1 ;
		this.center = new Point(0,0);
	}
	
	/*
	 * Constructor with one param passed into
	 * @param 	radius 	integer radius of the circle
	 */
	public ExtendedCircle(double radius)
	{
		this.radius = radius ;
		this.center = new Point(0,0);
	}
	
	/*
	 * Constructor with two params passed into
	 * @param radius 	is radius of circle 
	 * @param point 	center of circle
	 */
	public ExtendedCircle(double radius, Point point)
	{
		this.radius = radius ;
		this.center = point ;
	}
	
	/*
	 * returns the value of the radius of the current circle
	 * @return radius value of circle
	 */
	public double getRadius()
	{
		return this.radius ;
	}
	
	/*
	 * returns the value of the center of the current circle
	 * @return center value of circle
	 */
	public Point getCenter()
	{
		return this.center ;
	}
	
	/*
	 * sets the value of the current radius to parameter
	 * @param 	radius 	will be passed into current circle
	 */
	public void setRadius(double radius)
	{
		this.radius = radius ;
	}
	
	/*
	 * sets the value of the current center to parameter
	 * @param 	point 	center that will be passed into current circle
	 */
	public void setCenter(Point point) {
		this.center = point ; 
	}
	
	/*
	 * calculates the value of the area of the circle 
	 * @return is the value of the current circle
	 */
	public double compArea()
	{
		return PI * this.radius * this.radius ;
	}
	
	/*
	 * calculates the value of the circumference of the current circle 
	 * @returns the circumference
	 */
	public double compCircumference()
	{
		return PI * this.radius * 2 ; 
	}
	
	/*
	 * Prints the radius and center of the current circle
	 * @return the value of the radius and center with formatting
	 */
	public String toString()
	{
		return "Radius: " + this.radius + ", Center: (" + center.getX() + "," + center.getY() + ")" ;
	}
	
	/*
	 * Checks to see if the point is inside the circle, outside the circle, or on the circle
	 * @param 	point 	the point to check if it's in the circle
	 * @return 1 if the point is outside the circle
	 * @return -1 if the point is inside the circle
	 * @return 0 if the point is on the circle
	 */
	public int positionToCircle(Point point)
	{
		//System.out.println(center.distance(point)) ; 		// Used for debugging
		//System.out.println(this.radius);			  		// Used for debugging
		
		if(Math.abs(center.distance(point) - this.radius) < .05)
		{
			return 0 ;
		}
		
		else if(Math.abs(center.distance(point)) > (this.radius))
		{
			return 1 ;
		}
		
		else
		{
			return -1 ;
		}
	}
	
	/*
	 * Shifts the coordinates of the current circle and returns the new circle
	 * @param 	x 	for x-coordinate of the center
	 * @param 	y 	for y-coordinate of the center
	 * @return new circle with updated coordinates
	 */
	public ExtendedCircle shift(int x, int y)
	{
		Point point = new Point(center.getX(), center.getY());
		
		point.setX(center.getX() + x);
		
		point.setY(center.getY() + y);
		
		return new ExtendedCircle(this.radius, point);
	}
	
	/*
	 * Increases the radius by the factor given
	 * @param 	factor 	factor of which to multiply the radius
	 * @return the new circle with an updated radius and same center point
	 */
	public ExtendedCircle scale(double factor)
	{
		Point point = new Point(center.getX(), center.getY());
		
		return new ExtendedCircle(this.radius * factor, point);
	}

	/*
	 * Checks to see if two circles overlap
	 * @param circle 	a circle that is to be compared to the current one
	 * @return true if they overlap
	 * @return false if they do not overlap
	 */
	public boolean overlap(ExtendedCircle circle)
	{
		if(this.center.distance(circle.center) < this.radius + circle.radius)
		{
			return true ;
		}
		
		return false ; 
	}
	
	/*
	 * Checks to see if two circles are equal in radius and center point
	 * @param  circle 	the circle to compare the current circle to
	 * @return true if they are equal
	 * @return false if they are not equal
	 */
	public boolean equals(ExtendedCircle circle)
	{
		if(circle == null)
		{
			return false ;
		}
		if(circle instanceof ExtendedCircle)
		{
			ExtendedCircle temp = (ExtendedCircle)circle ; 
			return this.radius == temp.radius ; 
		}
		else
		{
			return false  ;
		}
	}
}
