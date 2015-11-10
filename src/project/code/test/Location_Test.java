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
 */


public class Location_Test {

	/* Test case D-01:
	 *  Normal construction
	 *  Description:
	 *    Call Location(float, float) with two valid floats (0.0, 0.0)
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid Location instance
	 *    No exceptions expected
	 */
	@Test
	public void ConstructorNormalTest() {
		Location loc = new Location(0.0f, 0.0f);
		assertNotNull(loc);
	}


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
	 *    -Valid inputs are [-90, 90] and [-180, 180]
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
	 *    -Valid inputs are [-90, 90] and [-180, 180]
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
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */

	/* Test case D-08:
	 *  Construction with single parameter out of range (Longitude < lower limit)
	 *  Description:
	 *    Call Location(float, float) with second parameter < -180
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */

	/* Test case D-09:
	 *  Construction with single parameter out of range (Longitude > upper limit)
	 *  Description:
	 *    Call Location(float, float) with second parameter > 180
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */

	/* Test case D-10:
	 *  Set_Location normal operation
	 *  Description:
	 *    Call Set_Location(float, float) with two valid floats (0.0, 0.0)
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */

	/* Test case D-11:
	 *  Set_Location with single parameter on edge of range (Latitude = lower limit)
	 *  Description:
	 *    Call Set_Location(float, float) with first parameter = -90
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */

	/* Test case D-12:
	 *  Set_Location with single parameter on edge of range (Latitude = upper limit)
	 *  Description:
	 *    Call Set_Location(float, float) with first parameter = 90
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */

	/* Test case D-13:
	 *  Set_Location with single parameter on edge of range (Longitude = lower limit)
	 *  Description:
	 *    Call Set_Location(float, float) with second parameter = -180
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */

	/* Test case D-14:
	 *  Set_Location with single parameter on edge of range (Longitude = upper limit)
	 *  Description:
	 *    Call Set_Location(float, float) with second parameter = 180
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    A valid updated Location instance
	 *    No exceptions expected
	 */

	/* Test case D-15:
	 *  Set_Location with single parameter out of range (Latitude < lower limit)
	 *  Description:
	 *    Call Set_Location(float, float) with first parameter < -90
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */

	/* Test case D-16:
	 *  Set_Location with single parameter out of range (Latitude > upper limit)
	 *  Description:
	 *    Call Set_Location(float, float) with first parameter > 90
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */

	/* Test case D-17:
	 *  Set_Location with single parameter out of range (Longitude < lower limit)
	 *  Description:
	 *    Call Set_Location(float, float) with second parameter < -180
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */

	/* Test case D-18:
	 *  Set_Location with single parameter out of range (Longitude > upper limit)
	 *  Description:
	 *    Call Set_Location(float, float) with second parameter > 180
	 *    -Valid inputs are [-90, 90] and [-180, 180]
	 *  Expected result:
	 *    Null_Object_Exception
	 */




}
