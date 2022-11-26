package assg2_B01261294;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestExtendedCircle {

	private ExtendedCircle C1 ;
	private ExtendedCircle C2 ;
	private ExtendedCircle C3 ;
	private ExtendedCircle C4 ;
	
	private Point P1 ;
	private Point P2 ;
	private Point P3 ;
	
	@Before
	public void setUp(){
		
		P1 = new Point() ;
		P2 = new Point(2,3) ;
		P3 = new Point(1,2) ;
		
		C1 = new ExtendedCircle() ;
		C2 = new ExtendedCircle(35) ;
		C3 = new ExtendedCircle(20, P1) ;
		C4 = new ExtendedCircle(99, P3) ;
		
	}

	@Test
	public void testGetRadius() {
		assertEquals(1, C1.getRadius(), .01) ;
		assertEquals(35, C2.getRadius(), .01) ;
		assertEquals(20, C3.getRadius(), .01) ;
	}
	
	@Test
	public void testGetCenter() {
		assertEquals("C3 center:", P1, C3.getCenter()) ;
		assertEquals("C4 center:", P3, C4.getCenter()) ;
	}
	
	@Test
	public void testSetRadius() {
		C1.setRadius(27);
		assertEquals(27, C1.getRadius(), .001) ;
		
		C2.setRadius(12.99);
		assertEquals(12.99, C2.getRadius(), .001) ;
		
		C3.setRadius(100.5);
		assertEquals(100.5, C3.getRadius(), .001) ;
	}
	
	@Test
	public void testSetCenter() {
		C1.setCenter(P2);
		assertEquals("C1 center:", P2, C1.getCenter()) ;
		
		C2.setCenter(P1);
		assertEquals("C2 center:", P1, C2.getCenter()) ;
		
		C4.setCenter(P3);
		assertEquals("C4 center:", P3, C4.getCenter()) ;
	}
	
	@Test 
	public void testCompArea() {
		assertEquals(3.1415 * C1.getRadius() * C1.getRadius(), C1.compArea(), .001) ;
		assertEquals(3.1415 * C2.getRadius() * C2.getRadius(), C2.compArea(), 3) ;
	}
	
	@Test 
	public void testCompCircumference() {
		assertEquals(3.1415 * C1.getRadius() * 2, C1.compCircumference(), .01) ;
		assertEquals(3.1415 * C2.getRadius() * 2, C2.compCircumference(), .01) ;
	}
	
	@Test
	public void testToString() {
		assertEquals("C1:", "Radius: 1.0, Center: (0,0)", C1.toString()) ;
		assertEquals("C2:", "Radius: 35.0, Center: (0,0)", C2.toString()) ;
	}
	
	@Test
	public void testPositionToCircle() {
		assertEquals("C1:", 0, C1.positionToCircle(P1)) ;
		assertEquals("C2:", "Radius: 35.0, Center: (0,0)", C2.toString()) ;
	}
}
