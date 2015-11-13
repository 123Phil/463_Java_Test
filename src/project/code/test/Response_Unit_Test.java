
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 05 Oct 2015
 */


package project.code.test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import project.code.base.*;
import project.code.base.Response_Unit.Status_Type;


/* Unit under test:
 *   Response_Unit.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Unit_ID_Exception
 *     - Null_Object_Exception
 *     - Location
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */


public class Response_Unit_Test {
	
	/* Test case E-01:
	 *  Normal Construction
	 *  Description:
	 *    Construct a Response_Unit with normal parameters
	 *    Note:
	 *      - Normal parameters are (String, Location)
	 *        where String is a non-empty identifier and Location is a valid instance.
	 *  Expected result:
	 *    A valid Response_Unit instance
	 *    No exceptions expected
	 */
	@Test
	public void ConstructorNormalTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			fail("Should not have thrown an exception.");
		}
		assertNotNull("Response unit should be instantiated.", ru);
	}
	
	/* Test case E-02:
	 *  Construction with null String
	 *  Description:
	 *    Construct a Response_Unit with a null String
	 *  Expected result:
	 *    Null_Unit_ID_Exception expected
	 */
	@Test
	public void ConstructorNullTest1() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit(null, new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
		}
		assertNull("Response unit should not be instantiated.", ru);
	}
	
	/* Test case E-03:
	 *  Construction with empty String
	 *  Description:
	 *    Construct a Response_Unit with an empty String
	 *  Expected result:
	 *    Null_Unit_Exception message
	 */
	@Test
	public void ConstructorNullTest2() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit(new String(), new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
		}
		assertNull("Response unit should not be instantiated.", ru);
	}
	
	/* Test case E-04:
	 *  Construction with empty string literal
	 *  Description:
	 *    Construct a Response_Unit with an empty string literal - ""
	 *  Expected result:
	 *    Null_Unit_Exception message
	 */
	@Test
	public void ConstructorNullTest3() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
		}
		assertNull("Response unit should not be instantiated.", ru);
	}
	
	/* Test case E-05:
	 *  Construction with null location
	 *  Description:
	 *    Construct a Response_Unit with null Location parameter
	 *  Expected result:
	 *    Null_Object_Exception expected
	 */
	@Test
	public void ConstructorNullTest4() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", null);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
					e instanceof Null_Object_Exception);
		}
		assertNull("Response unit should not be instantiated.", ru);
	}
	    
	/* Test case E-06:
	 *  Unit_ID getter, normal path
	 *  Description:
	 *    Create a valid object and call the Unit_ID getter to verify
	 *    supplied ID matches object's stored ID
	 *  Expected result:
	 *    Unit_ID accessed from getter matches set Unit_ID.
	 */
	@Test
	public void IdSetGetTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			fail("Should not have thrown an exception.");
		}
		assertNotNull("Response unit should not be instantiated.", ru);
		assertEquals("Unit_ID string should match.", ru.Unit_ID(), "Unit 1");
	}
	
	/* Test case E-07:
	 *  Current_Location accessors, normal path
	 *  Description:
	 *    Create a valid object and call the Set_Location and Location accessors
	 *    with valid Location input
	 *  Expected result:
	 *    Location accessed from getter matches set Location.
	 */
	@Test
	public void LocationSetGetTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			fail("Should not have thrown an exception.");
		}
		Location loc = new Location(20.0f, 30.0f);
		ru.Set_Location(loc);
		assertEquals("Location should match.", ru.Current_Location(), loc);
	}
	
	/* Test case E-08:
	 *  Current_Location setter, null
	 *  Description:
	 *    Create a valid object and call the Set_Location giving null.
	 *  Expected result:
	 *    Null_Object_Exception message
	 */
	@Test
	public void LocationNullTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			fail("Should not have thrown an exception.");
		}
		boolean thrown = false;
		try {
			ru.Set_Location(null);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
					e instanceof Null_Object_Exception);
			thrown = true;
		}
		assertTrue("Should have thrown a Null_Object_Exception", thrown);
	}
	
	/* Test case E-09:
	 *  Emergency_Exists accessors, normal path
	 *  Description:
	 *    Create a valid object and call the Emergency_Exists accessors
	 *    with both true and false, checking for match after each set.
	 *  Expected result:
	 *    Emergency_Exists accessed from getter matches set Emergency_Exists.
	 */
	@Test
	public void EmergencySetGetTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			fail("Should not have thrown an exception.");
		}
		assertFalse("Should instantiate with no emergency.", ru.Emergency_Exists());
		ru.Set_Emergency(true);
		assertTrue("Emergency should have toggled to true.", ru.Emergency_Exists());
		ru.Set_Emergency(false);
		assertFalse("Emergency should have toggled to false.", ru.Emergency_Exists());
	}
	
	/* Test case E-10:
	 *  Emergency_Exists setter, null
	 *  Description:
	 *    Create a valid object and call the Set_Emergency_Exists giving null.
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test
	public void EmergencyNullTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			fail("Should not have thrown an exception.");
		}
		boolean thrown = false;
		try {
			ru.Set_Emergency(null);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
					e instanceof Null_Object_Exception);
			thrown = true;
		}
		assertTrue("Should have thrown a Null_Object_Exception", thrown);
	}
	
	/* Test case E-11:
	 *  Status_Type accessors, normal path
	 *  Description:
	 *    Create a valid object and call the Status_Type accessors with valid Status_Type input
	 *    Note:
	 *      - Valid Status_Type are {Not_In_Service, In_Station, Enroute, On_Scene}
	 *  Expected result:
	 *    Status_Type accessed from getter matches set Status_Type.
	 */
	@Test
	public void StatusSetGetTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			fail("Should not have thrown an exception.");
		}
		assertEquals("Should instantiate 'Not_In_Service'.", ru.Status(), Status_Type.Not_In_Service);
		ru.Set_Status(Status_Type.In_Station);
		assertEquals("Should instantiate 'Not_In_Service'.", ru.Status(), Status_Type.In_Station);
		ru.Set_Status(Status_Type.Enroute);
		assertEquals("Should instantiate 'Not_In_Service'.", ru.Status(), Status_Type.Enroute);
		ru.Set_Status(Status_Type.On_Scene);
		assertEquals("Should instantiate 'Not_In_Service'.", ru.Status(), Status_Type.On_Scene);
	}
	
	/* Test case E-12:
	 *  Status_Type setter, null
	 *  Description:
	 *    Create a valid object and call Set_Status_Type giving null.
	 *  Expected result:
	 *    Null_Object_Exception message
	 */
	@Test
	public void StatusNullTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			fail("Should not have thrown an exception.");
		}
		boolean thrown = false;
		try {
			ru.Set_Status(null);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
					e instanceof Null_Object_Exception);
			thrown = true;
		}
		assertTrue("Should have thrown a Null_Object_Exception", thrown);
	}
	
	/* Test case E-13:
	 *  Status_Type setter, invalid input
	 *  Description:
	 *    Create a valid object and call Set_Status_Type giving an integer value.
	 *  Expected result:
	 *    An Enum error should occur
	 */
	@Test
	public void StatusIntTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Throwable e) {
			fail("Should not have thrown an exception.");
		}
		boolean thrown = false;
		try {
			//TODO: compiler error??
			//ru.Set_Status(0);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
					e instanceof Null_Object_Exception);
			thrown = true;
		}
		assertTrue("Should have thrown a Null_Object_Exception", thrown);
	}
	

}
