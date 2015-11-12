/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 10 Nov 2015
 */

package project.code.test;
import static org.junit.Assert.*;
import org.junit.Test;

import project.code.base.Location;
import project.code.base.Null_Object_Exception;


/* Unit under test:
 *   Location.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Object_Exception
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 *   Note:
 *     - Valid latitude: [-90, 90]
 *     - Valid longitude: [-180, 180]
 */


public class Location_Test {

	/* Test case D-01:
	 *  Normal construction
	 *  Description:
	 *    Call Location(float, float) with two valid float literals (0.0, 0.0)
	 *    Call Location(float, float) with two valid float variables (1.0, 1.0)
	 *  Expected result:
	 *    A valid Location instance
	 *    No exceptions expected
	 */
	@Test
	public void ConstructorNormalTest() {
		Location loc = new Location(0.0f, 0.0f);
		assertNotNull(loc);
		float f_val = 1.0f;
		Location loc2 = new Location(f_val, f_val);
		assertNotNull(loc2);
	}

// TODO: normal tests with half of bounds...
	
	
	/* Test case D-02:
	 *  Construction with single parameter on edge of range (Latitude = lower limit)
	 *  Description:
	 *    Call Location(float, float) with first parameter = -90
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid Location instance
	 *    No exceptions expected
	 */
	@Test
	public void ConstructorBoundaryTest1() {
		Location loc = new Location(-90.0f, 0.0f);
		assertNotNull(loc);
	}

	/* Test case D-03:
	 *  Construction with single parameter on edge of range (Latitude = upper limit)
	 *  Description:
	 *    Call Location(float, float) with first parameter = 90
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid Location instance
	 *    No exceptions expected
	 */
	@Test
	public void ConstructorBoundaryTest2() {
		Location loc = new Location(-90.0f, 0.0f);
		assertNotNull(loc);
	}


	/* Test case D-04:
	 *  Construction with single parameter on edge of range (Longitude = lower limit)
	 *  Description:
	 *    Call Location(float, float) with second parameter = -180
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid Location instance
	 *    No exceptions expected
	 */
	@Test
	public void ConstructorBoundaryTest3() {
		Location loc = new Location(0.0f, -180.0f);
		assertNotNull(loc);
	}


	/* Test case D-05:
	 *  Construction with single parameter on edge of range (Longitude = upper limit)
	 *  Description:
	 *    Call Location(float, float) with second parameter = 180
	 *  Expected result:
	 *    A valid Location instance
	 *    No exceptions expected
	 */
	@Test
	public void ConstructorBoundaryTest4() {
		Location loc = new Location(0.0f, 180.0f);
		assertNotNull(loc);
	}

	/* Test case D-06:
	 *  Construction with single parameter out of range (Latitude < lower limit)
	 *  Description:
	 *    Call Location(float, float) with first parameter < -90
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test()
	public void ConstructorInvalidTest1() {
		Location loc = null;
		try {
			loc = new Location(-90.00001f, 0.0f);
			fail("Null_Object_Exception should have been thrown.");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
				e instanceof Null_Object_Exception);
		}
		assertNull("Location should still be null", loc);
	}

	/* Test case D-07:
	 *  Construction with single parameter out of range (Latitude > upper limit)
	 *  Description:
	 *    Call Location(float, float) with first parameter > 90
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test()
	public void ConstructorInvalidTest2() {
		Location loc = null;
		try {
			loc = new Location(90.00001f, 0.0f);
			fail("Null_Object_Exception should have been thrown.");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
				e instanceof Null_Object_Exception);
		}
		assertNull("Location should still be null", loc);
	}
	
	/* Test case D-08:
	 *  Construction with single parameter out of range (Longitude < lower limit)
	 *  Description:
	 *    Call Location(float, float) with second parameter < -180
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test()
	public void ConstructorInvalidTest3() {
		Location loc = null;
		try {
			loc = new Location(0.0f, -180.00001f);
			fail("Null_Object_Exception should have been thrown.");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
				e instanceof Null_Object_Exception);
		}
		assertNull("Location should still be null", loc);
	}
	
	/* Test case D-09:
	 *  Construction with single parameter out of range (Longitude > upper limit)
	 *  Description:
	 *    Call Location(float, float) with second parameter > 180
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test()
	public void ConstructorInvalidTest4() {
		Location loc = null;
		try {
			loc = new Location(0.0f, 180.00001f);
			fail("Null_Object_Exception should have been thrown.");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
				e instanceof Null_Object_Exception);
		}
		assertNull("Location should still be null", loc);
	}
	
// TODO: construction with ints, int literals, float variables
//construction with values FAR outside range
	
	
	/* Test case D-10:
	 *  Set_Location normal operation
	 *  Description:
	 *    Call Set_Location(float, float) with two valid float literals (45.0, -45.0)
	 *    Call Set_Location(float, float) with two valid float literals (0.0, 0.0)
	 *    Call Set_Location(float, float) with two valid float variables (50.0, 50.0)
	 *    -Note: Floating point values compared with an epsilon of 0.000001f
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */
	@Test()
	public void SetLocationValidTest1() {
		Location loc = new Location(0.0f, 0.0f);
		loc.Set_Location(45.0f, -45.0f);
		assertEquals("Location latitude should have updated.", loc.Current_Latitude(), 45.0f, 0.000001f);
		assertEquals("Location longitude should have updated.", loc.Current_Longitude(), -45.0f, 0.000001f);
		loc.Set_Location(0.0f, 0.0f);
		assertEquals("Location latitude should have updated.", loc.Current_Latitude(), 0.0f, 0.000001f);
		assertEquals("Location longitude should have updated.", loc.Current_Longitude(), 0.0f, 0.000001f);
		float f_val = 50.0f;
		loc.Set_Location(f_val, f_val);
		assertEquals("Location latitude should have updated.", loc.Current_Latitude(), f_val, 0.000001f);
		assertEquals("Location longitude should have updated.", loc.Current_Longitude(), f_val, 0.000001f);
	}
	
	/* Test case D-11:
	 *  Set_Location with single parameter on edge of range (Latitude = lower limit)
	 *  Description:
	 *    Call Set_Location(float, float) with first parameter = -90
	 *    -Note: Floating point values compared with an epsilon of 0.000001f
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */
	@Test()
	public void SetLocationValidTest2() {
		Location loc = new Location(0.0f, 0.0f);
		loc.Set_Location(-90.0f, 0.0f);
		assertEquals("Location latitude should have updated.", loc.Current_Latitude(), -90.0f, 0.000001f);
		assertEquals("Location longitude should have updated.", loc.Current_Longitude(), 0.0f, 0.000001f);
	}
	
	/* Test case D-12:
	 *  Set_Location with single parameter on edge of range (Latitude = upper limit)
	 *  Description:
	 *    Call Set_Location(float, float) with first parameter = 90
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */
	@Test()
	public void SetLocationValidTest3() {
		Location loc = new Location(0.0f, 0.0f);
		loc.Set_Location(90.0f, 0.0f);
		assertEquals("Location latitude should have updated.", loc.Current_Latitude(), 90.0f, 0.000001f);
		assertEquals("Location longitude should have updated.", loc.Current_Longitude(), 0.0f, 0.000001f);
	}
	
	/* Test case D-13:
	 *  Set_Location with single parameter on edge of range (Longitude = lower limit)
	 *  Description:
	 *    Call Set_Location(float, float) with second parameter = -180
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */
	@Test()
	public void SetLocationValidTest4() {
		Location loc = new Location(0.0f, 0.0f);
		loc.Set_Location(0.0f, -180.0f);
		assertEquals("Location latitude should have updated.", loc.Current_Latitude(), 0.0f, 0.000001f);
		assertEquals("Location longitude should have updated.", loc.Current_Longitude(), -180.0f, 0.000001f);
	}

	/* Test case D-14:
	 *  Set_Location with single parameter on edge of range (Longitude = upper limit)
	 *  Description:
	 *    Call Set_Location(float, float) with second parameter = 180
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */
	@Test()
	public void SetLocationValidTest5() {
		Location loc = new Location(0.0f, 0.0f);
		loc.Set_Location(0.0f, 180.0f);
		assertEquals("Location latitude should have updated.", loc.Current_Latitude(), 0.0f, 0.000001f);
		assertEquals("Location longitude should have updated.", loc.Current_Longitude(), 180.0f, 0.000001f);
	}

	/* Test case D-15:
	 *  Set_Location with single parameter out of range (Latitude < lower limit)
	 *  Description:
	 *    Call Set_Location(float, float) with first parameter < -90
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test()
	public void SetLocationInvalidTest1() {
		Location loc = new Location(0.0f, 0.0f);
		try {
			loc.Set_Location(-90.001f, 0.0f);
			fail("Null_Object_Exception should have been thrown.");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
				e instanceof Null_Object_Exception);
		}
		assertEquals("Location latitude should not have been updated.", loc.Current_Latitude(), 0.0f, 0.000001f);
		assertEquals("Location longitude should not have been updated.", loc.Current_Longitude(), 0.0f, 0.000001f);
	}

	/* Test case D-16:
	 *  Set_Location with single parameter out of range (Latitude > upper limit)
	 *  Description:
	 *    Call Set_Location(float, float) with first parameter > 90
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test()
	public void SetLocationInvalidTest2() {
		Location loc = new Location(0.0f, 0.0f);
		try {
			loc.Set_Location(90.001f, 0.0f);
			fail("Null_Object_Exception should have been thrown.");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
				e instanceof Null_Object_Exception);
		}
		assertEquals("Location latitude should not have been updated.", loc.Current_Latitude(), 0.0f, 0.000001f);
		assertEquals("Location longitude should not have been updated.", loc.Current_Longitude(), 0.0f, 0.000001f);
	}

	/* Test case D-17:
	 *  Set_Location with single parameter out of range (Longitude < lower limit)
	 *  Description:
	 *    Call Set_Location(float, float) with second parameter < -180
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test()
	public void SetLocationInvalidTest3() {
		Location loc = new Location(0.0f, 0.0f);
		try {
			loc.Set_Location(0.0f, -180.001f);
			fail("Null_Object_Exception should have been thrown.");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
				e instanceof Null_Object_Exception);
		}
		assertEquals("Location latitude should not have been updated.", loc.Current_Latitude(), 0.0f, 0.000001f);
		assertEquals("Location longitude should not have been updated.", loc.Current_Longitude(), 0.0f, 0.000001f);
	}

	/* Test case D-18:
	 *  Set_Location with single parameter out of range (Longitude > upper limit)
	 *  Description:
	 *    Call Set_Location(float, float) with second parameter > 180
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test()
	public void SetLocationInvalidTest4() {
		Location loc = new Location(0.0f, 0.0f);
		try {
			loc.Set_Location(0.0f, 180.001f);
			fail("Null_Object_Exception should have been thrown.");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
				e instanceof Null_Object_Exception);
		}
		assertEquals("Location latitude should not have been updated.", loc.Current_Latitude(), 0.0f, 0.000001f);
		assertEquals("Location longitude should not have been updated.", loc.Current_Longitude(), 0.0f, 0.000001f);
	}




}
