
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 12 Nov 2015
 */

package project.code.test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import project.code.base.*;
//import project.code.base.Response_Unit.Status_Type;


/* Unit under test:
 *   Response_Unit_Manager.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Unit_ID_Exception
 *     - Null_Object_Exception
 *     - Duplicate_Item_Exception
 *     - Location
 *     - Response_Unit
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */

public class Response_Unit_Manager_Test {
	
	/* Test case F-01:
	 *  Attempt construction
	 *  Description:
	 *    Attempt to create an instance of Response_Unit_Manager
	 *  Expected result:
	 *    Object should not be instantiated.
	 *    -All methods and variables are static
	 */
	@Test
	public void ConstructorTest() {
		//would wrap in try/catch, but this should be a compiler error.
		//R_U_M should be a static class.
		Response_Unit_Manager rum = new Response_Unit_Manager();
		assertNull(rum);
	}
	
	/* Test case F-02:
	 *  Add_Response_Unit with valid input
	 *  Description:
	 *    Call Add_Response_Unit with a valid non-duplicate Response_Unit
	 *  Expected result:
	 *    Response_Unit should be successfully added to Response_Unit_DB.
	 */
	@Test
	public void AddUnitValidTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 1", new Location(0.0f, 0.0f));
		} catch (Null_Object_Exception e) {
			fail("Response unit creation failed.");
		} catch (Null_Unit_ID_Exception e) {
			fail("Response unit creation failed.");
		}
		assertNotNull("Response Unit should have been instantiated", ru);
		try {
			Response_Unit_Manager.Add_Response_Unit(ru);
		} catch (Null_Object_Exception e1) {
			fail("Response unit addition failed.");
		} catch (Duplicate_Item_Exception e1) {
			fail("Response unit addition failed.");
		}
		//verify added? test F-06 does it...
	}
	
	/* Test case F-03:
	 *  Add_Response_Unit multiple calls (capacity test)
	 *  Description:
	 *    Call Add_Response_Unit with MANY (1,000,000) valid Response_Units
	 *  Expected result:
	 *    All Response_Units should be successfully added to Response_Unit_DB.
	 */
	@Test
	public void AddUnitManyTest() {
		Response_Unit ru = null;
		ArrayList<Response_Unit> rus = new ArrayList<Response_Unit>();
		try {
			for (int i=0; i < 10000; i++) {
				String id = "Unit Many " + Integer.toString(i);
				ru = new Response_Unit(id, new Location(0.0f, 0.0f));
				rus.add(ru);
			}
		} catch (Null_Object_Exception e) {
			fail("Response unit creation failed.");
		} catch (Null_Unit_ID_Exception e) {
			fail("Response unit creation failed.");
		}
		assertNotNull("Response Unit should have been instantiated", ru);
		try {
			for (int i=0; i < 10000; i++) {
				Response_Unit_Manager.Add_Response_Unit(rus.get(i));
			}
		} catch (Null_Object_Exception e) {
			fail("Response unit addition failed.");
		} catch (Duplicate_Item_Exception e) {
			fail("Response unit addition failed.");
		}
	}
	
	/* Test case F-04:
	 *  Add_Response_Unit with null unit
	 *  Description:
	 *    Call Add_Response_Unit with a null Response_Unit
	 *  Expected result:
	 *    Null_Object_Exception expected
	 */
	@Test
	public void AddUnitNullTest() {
		boolean thrown = false;
		try {
			Response_Unit_Manager.Add_Response_Unit(null);
		} catch (Null_Object_Exception e) {
			thrown = true;
		} catch (Duplicate_Item_Exception e) {
			fail("Response unit addition failed.");
		} catch (Throwable e) {
			fail("Unexpected exception thrown. Should have been Null_Object_Exception");
		}
		assertTrue("Null_Object_Exception should have been thrown.", thrown);
	}
	
	/* Test case F-05:
	 *  Add_Response_Unit with duplicate unit
	 *  Description:
	 *    Call Add_Response_Unit with a Response_Unit with ID already in Response_Unit_DB
	 *  Expected result:
	 *    Duplicate_Item_Exception expected
	 */
	@Test
	public void AddUnitDupTest() {
		Response_Unit ru1 = null;
		Response_Unit ru2 = null;
		try {
			ru1 = new Response_Unit("Unit 2", new Location(0.0f, 0.0f));
			ru2 = new Response_Unit("Unit 2", new Location(0.0f, 0.0f));
		} catch (Null_Object_Exception e) {
			fail("Response unit creation failed.");
		} catch (Null_Unit_ID_Exception e) {
			fail("Response unit creation failed.");
		}
		assertNotNull("Response Unit should have been instantiated", ru1);
		assertNotNull("Response Unit should have been instantiated", ru2);
		boolean thrown = false;
		try {
			Response_Unit_Manager.Add_Response_Unit(ru1);
			Response_Unit_Manager.Add_Response_Unit(ru2);
		} catch (Null_Object_Exception e1) {
			fail("Response unit addition failed.");
		} catch (Duplicate_Item_Exception e1) {
			thrown = true;
		}
		assertTrue("Duplicate_Item_Exception should have been thrown.", thrown);
	}
	
	/* Test case F-06:
	 *  Response_Unit_Named with existing Response_Unit Unit_ID
	 *  Description:
	 *    Add a valid Response_Unit to the Response_Unit_DB,
	 *    Then call Response_Unit_Named to retrieve it.
	 *  Expected result:
	 *    Named Response_Unit should be successfully returned.
	 */
	@Test
	public void ResponseUnitNamedTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 3", new Location(0.0f, 0.0f));
		} catch (Null_Object_Exception e) {
			fail("Response unit creation failed.");
		} catch (Null_Unit_ID_Exception e) {
			fail("Response unit creation failed.");
		}
		assertNotNull("Response Unit should have been instantiated", ru);
		try {
			Response_Unit_Manager.Add_Response_Unit(ru);
		} catch (Null_Object_Exception e1) {
			fail("Response unit addition failed.");
		} catch (Duplicate_Item_Exception e1) {
			fail("Response unit addition failed.");
		}
		Response_Unit ru2 = Response_Unit_Manager.Response_Unit_Named("Unit 3");
		assertEquals("Named unit should match added unit.", ru, ru2);
	}
	
	/* Test case F-07:
	 *  Response_Unit_Named with non-existing Response_Unit
	 *  Description:
	 *    Call Response_Unit_Named giving a Response_Unit not in the Response_Unit_DB
	 *  Expected result:
	 *    null returned.
	 */
	@Test
	public void ResponseUnitNamedNonTest() {
		Response_Unit ru = Response_Unit_Manager.Response_Unit_Named("Non-exiastant");
		assertNull("Non-existent unit should return null.", ru);
	}
	
	/* Test case F-08:
	 *  Response_Unit_Named with null Response_Unit
	 *  Description:
	 *    Call Response_Unit_Named giving a null String ID
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void ResponseUnitNamedNullTest() {
		boolean thrown = false;
		try {
			Response_Unit_Manager.Response_Unit_Named(null);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
					e instanceof Null_Object_Exception);
			thrown = true;
		}
		assertTrue("Null_Object_Exception should have been thrown.", thrown);
	}
	
	/* Test case F-09:
	 *  Response_Unit_Named with empty String
	 *  Description:
	 *    Call Response_Unit_Named giving an empty String
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void ResponseUnitNamedEmptyStringTest() {
		boolean thrown = false;
		try {
			Response_Unit_Manager.Response_Unit_Named(new String());
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
					e instanceof Null_Object_Exception);
			thrown = true;
		}
		assertTrue("Null_Object_Exception should have been thrown.", thrown);
	}
	
	/* Test case F-10:
	 *  Response_Unit_Named with empty string literal
	 *  Description:
	 *    Call Response_Unit_Named giving an empty string literal
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void ResponseUnitNamedEmptyLiteralTest() {
		boolean thrown = false;
		try {
			Response_Unit_Manager.Response_Unit_Named("");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
					e instanceof Null_Object_Exception);
			thrown = true;
		}
		assertTrue("Null_Object_Exception should have been thrown.", thrown);
	}
	
	/* Test case F-11:
	 *  Response_Unit_Exists with existing Response_Unit Unit_ID
	 *  Description:
	 *    Add a valid Response_Unit to the Response_Unit_DB,
	 *    Then call Response_Unit_Exists to see if it exists.
	 *  Expected result:
	 *    true
	 */
	@Test
	public void ResponseUnitExistsTest() {
		Response_Unit ru = null;
		try {
			ru = new Response_Unit("Unit 4", new Location(0.0f, 0.0f));
		} catch (Null_Object_Exception e) {
			fail("Response unit creation failed.");
		} catch (Null_Unit_ID_Exception e) {
			fail("Response unit creation failed.");
		}
		assertNotNull("Response Unit should have been instantiated", ru);
		try {
			Response_Unit_Manager.Add_Response_Unit(ru);
		} catch (Null_Object_Exception e1) {
			fail("Response unit addition failed.");
		} catch (Duplicate_Item_Exception e1) {
			fail("Response unit addition failed.");
		}
		boolean exists = Response_Unit_Manager.Response_Unit_Exists("Unit 4");
		assertTrue("Named unit should exist.", exists);
	}
	
	/* Test case F-12:
	 *  Response_Unit_Exists with non-existing Response_Unit Unit_ID
	 *  Description:
	 *    Call Response_Unit_Exists giving a Unit_ID not in Response_Unit_DB.
	 *  Expected result:
	 *    false
	 */
	@Test
	public void ResponseUnitExistsNoTest() {
		boolean exists = Response_Unit_Manager.Response_Unit_Exists("Unit 5 (which doesn't exist)");
		assertFalse("Named unit should exist.", exists);
	}
	
	/* Test case F-13:
	 *  Response_Unit_Exists with null Response_Unit Unit_ID
	 *  Description:
	 *    Call Response_Unit_Exists giving a null Unit_ID.
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void ResponseUnitExistsNullTest1() {
		boolean exists = false;
		boolean thrown = false;
		try {
			exists = Response_Unit_Manager.Response_Unit_Exists(null);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertFalse("Response_Unit_Exists should not return true.", exists);
		assertTrue("Null_Unit_ID_Exception should have been thrown.", thrown);
	}
	
	
	/* Test case F-14:
	 *  Response_Unit_Exists with empty String Response_Unit Unit_ID
	 *  Description:
	 *    Call Response_Unit_Exists giving an empty String.
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void ResponseUnitExistsNullTest2() {
		boolean exists = false;
		boolean thrown = false;
		try {
			exists = Response_Unit_Manager.Response_Unit_Exists(new String());
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertFalse("Response_Unit_Exists should not return true.", exists);
		assertTrue("Null_Unit_ID_Exception should have been thrown.", thrown);
	}
	
	/* Test case F-15:
	 *  Response_Unit_Exists with empty string literal Response_Unit Unit_ID
	 *  Description:
	 *    Call Response_Unit_Exists giving an empty string literal.
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void ResponseUnitExistsNullTest3() {
		boolean exists = false;
		boolean thrown = false;
		try {
			exists = Response_Unit_Manager.Response_Unit_Exists("");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertFalse("Response_Unit_Exists should not return true.", exists);
		assertTrue("Null_Unit_ID_Exception should have been thrown.", thrown);
	}

}
