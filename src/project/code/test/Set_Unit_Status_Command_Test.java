package project.code.test;
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 10 Oct 2015
 */

package project.code.test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import project.code.base.*;

/* Unit under test:
 *   Set_Unit_Status_Command.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Unit_ID_Exception
 *     - Null_Object_Exception
 *     - Duplicate_Item_Exception
 *     - Location
 *     - Response_Unit
 *     - Response_Unit_Manager
 *     - Command
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 *   Note:
 *     - A good portion of these tests are designed to test the abstract parent
 *       Command class, and so some tests defined here are repeated in the fellow
 *       classes which extend Command.
 */

public class Set_Unit_Command_Test {
	
		/* Helper function for some tests which create response units */
	static Response_Unit AddResponseUnit(String s, Location l) {
		Response_Unit ru = null;
		if (l == null) {
			l = new Location(0.0f, 0.0f);
		}
		if (Response_Unit_Manager.Response_Unit_Exists(s)) {
			ru = Response_Unit_Manager.Response_Unit_Named(s);
			ru.Set_Location(l);
			return ru;
		}
		try {
			ru = new Response_Unit(s, l);
		} catch (Null_Object_Exception e) {
			fail("Response unit creation failed.");
		} catch (Null_Unit_ID_Exception e) {
			fail("Response unit creation failed.");
		}
		try {
			Response_Unit_Manager.Add_Response_Unit(ru);
		} catch (Null_Object_Exception e1) {
			fail("Response unit addition failed.");
		} catch (Duplicate_Item_Exception e1) {
			fail("Response unit addition failed.");
		}
		return ru;
	}
	
/* Test case I-01:
 *  Constructor, Normal conditions (String), existing Unit_ID
 *  Description:
 *    Call the constructor with a valid ID String
 *  Expected result:
 *    A valid Set_Unit_Status_Command object is instantiated with priority == 1
 */
  	@Test
	public void Constructor_Normal_Test() {
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 1", null);
		Command command = new Set_Unit_Status_Command(new String("Unit 1"), Status_Type Enroute);
		assertEquals("Should be priority 1.", command.Priority(), 1);
	}

/* Test case I-02:
 *  Constructor, Normal conditions (string literal)
 *  Description:
 *    Call the constructor with a valid ID string literal
 *  Expected result:
 *    A valid Set_Unit_Status_Command object is instantiated with priority == 1
 */
   	@Test
	public void Constructor_NormalStringLiteral_Test() {
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 2", null);
		Command command = new Set_Unit_Status_Command("Unit 2", Status_Type Enroute);
		assertEquals("Should be priority 1.", command.Priority(), 1);
	}

/* Test case I-03:
 *  Constructor, null Unit_ID
 *  Description:
 *    Call the constructor with null String
 *  Expected result:
 *    Null_Unit_ID_Exception
 */
  	@Test
	public void Constructor_NullUnitID_Test() {
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 3", null);
		boolean thrown = false;
		try {
			Command command = new Set_Unit_Status_Command(null, Status_Type Enroute);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

/* Test case I-04:
 *  Constructor, empty String Unit_ID
 *  Description:
 *    Call the constructor with empty String
 *  Expected result:
 *    Null_Unit_ID_Exception
 */
  	@Test
	public void Constructor_EmptyStringUnitID_Test() {
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 4", null);
		boolean thrown = false;
		try {
			Command command = new Set_Unit_Status_Command(new String(), Status_Type Enroute);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

/* Test case I-05:
 *  Constructor, empty string literal Unit_ID
 *  Description:
 *    Call the constructor with empty string literal
 *  Expected result:
 *    Null_Unit_ID_Exception
 */
  	@Test
	public void Constructor_EmptyStringLiteralUnitID_Test() {
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 5", null);
		boolean thrown = false;
		try {
			Command command = new Set_Unit_Status_Command("", Status_Type Enroute);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

/* Test case I-06:
 *  Constructor, Unit_ID NOT in Response_Unit_DB
 *  Description:
 *    Call the constructor with a Unit_ID that does not exist in the DB
 *  Expected result:
 *    Null_Unit_ID_Exception
 */
  	@Test
	public void Constructor_UnitIDNotPresent_Test() {
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 6", null);
		boolean thrown = false;
		try {
			Command command = new Set_Unit_Status_Command("Unit 7", Status_Type Enroute);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

/* Test case I-07:
 *  Execute command on Response_Unit in Response_Unit_DB
 *  Description:
 *    Add a unit to the Response_Unit_DB,
 *    Create a valid Set_Unit_Status_Command for it
 *    Execute the command
 *  Expected result:
 *    Set_Status should be updated to desired_status.
 */
  	@Test
	public void Constructor_Execute_Test() {
		Status_type desired_status;
		desired_status = Enroute;
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 7", null);
		Command command = new Set_Unit_Status_Command("Unit 7", desired_status));
		command.execute();
		assertEquals("Should be enroute.", command.SubjectUnit.Status(), Enroute);
	}

/* Test case I-08:
 *  Execute command on Response_Unit NOT in Response_Unit_DB
 *  Description:
 *    Create a Set_Unit_Status_Command with a Unit_ID not in Response_Unit_DB
 *    Execute the command
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case I-09:
 *  Priority accessors, normal path
 *  Description:
 *    Create a Set_Unit_Status_Command with valid parameters
 *    Use Priority() accessor to check value.
 *    Set a new priority
 *    Verify again with accessor
 *  Expected result:
 *    Priority should update normally
 */

/* Test case I-10:
 *  Priority accessors, null value
 *  Description:
 *    Create a Set_Unit_Status_Command with valid parameters
 *    Attempt to set Priority to null.
 *  Expected result:
 *    Null_Object_Exception
 */

/* Test case I-11:
 *  Priority accessors, invalid value
 *  Description:
 *    Create a Set_Unit_Status_Command with valid parameters
 *    Attempt to set Priority to negative, INT_MAX, or other values outside of valid range.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case I-12:
 *  Unit_ID accessors, normal path
 *  Description:
 *    Create a Set_Unit_Status_Command with valid parameters
 *    Use Unit_ID() accessor to check value.
 *    Set a new Unit_ID
 *    Verify again with accessor
 *  Expected result:
 *    Unit_ID should update normally
 */

/* Test case I-13:
 *  Unit_ID accessors, null value
 *  Description:
 *    Create a Set_Unit_Status_Command with valid parameters
 *    Attempt to set Unit_ID to null.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case I-14:
 *  Unit_ID accessors, empty String
 *  Description:
 *    Create a Set_Unit_Status_Command with valid parameters
 *    Attempt to set Unit_ID to empty String.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case I-15:
 *  Unit_ID accessors, empty string literal
 *  Description:
 *    Create a Set_Unit_Status_Command with valid parameters
 *    Attempt to set Unit_ID to empty string literal.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

} //end class
