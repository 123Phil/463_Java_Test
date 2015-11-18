package project.code.test;
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 18 Nov 2015
 */

import static org.junit.Assert.*;
import org.junit.Test;

import project.code.base.*;

/* Unit under test:
 *   Set_Unit_Location_Command.java
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

public class Set_Unit_Location_Command_Test {
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


	/* Test case J-01:
	 *  Constructor, Normal conditions (String), existing Unit_ID
	 *  Description:
	 *    Call the constructor with a valid ID String
	 *  Expected result:
	 *    A valid Set_Unit_Location_Command object is instantiated with priority == 1
	 */
	@Test
	public void Constructor_Normal_Test() {
		AddResponseUnit("Unit 1", null);
		Command command = new Set_Unit_Location_Command(new String("Unit 1"), new Location(1.0f,1.0f));
		assertNotNull("Command object should have been instantiated.", command);
		assertEquals("Should be priority 1.", command.Priority(), 1);
	}


	/* Test case J-02:
	 *  Constructor, Normal conditions (string literal)
	 *  Description:
	 *    Call the constructor with a valid ID string literal
	 *  Expected result:
	 *    A valid Set_Unit_Location_Command object is instantiated with priority == 1
	 */
	@Test
	public void Constructor_NormalStringLiteral_Test() {
		AddResponseUnit("Unit 2", null);
		Command command = new Set_Unit_Location_Command("Unit 2", new Location(1.0f,1.0f));
		assertNotNull("Command object should have been instantiated.", command);
		assertEquals("Should be priority 1.", command.Priority(), 1);
	}

	/* Test case J-03:
	 *  Constructor, null Unit_ID
	 *  Description:
	 *    Call the constructor with null String
	 *  Expected result:
	 *    Null_Unit_ID_Exception message
	 */
	@Test
	public void Constructor_NullUnitID_Test() {
		//AddResponseUnit(null, null);
		boolean thrown = false;
		Command command = null;
		try {
			command = new Set_Unit_Location_Command(null, new Location(1.0f,1.0f));
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertNull("Command object should not have been instantiated.", command);
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case J-04:
	 *  Constructor, empty String Unit_ID
	 *  Description:
	 *    Call the constructor with empty String
	 *  Expected result:
	 *    Null_Unit_ID_Exception message
	 */
	@Test
	public void Constructor_EmptyStringUnitID_Test() {
		//AddResponseUnit(new String(), null);
		boolean thrown = false;
		Command command = null;
		try {
			command = new Set_Unit_Location_Command(new String(), new Location(1.0f,1.0f));
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertNull("Command object should not have been instantiated.", command);
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case J-05:
	 *  Constructor, empty string literal Unit_ID
	 *  Description:
	 *    Call the constructor with empty string literal
	 *  Expected result:
	 *    Null_Unit_ID_Exception message
	 */
	@Test
	public void Constructor_EmptyStringLiteralUnitID_Test() {
		//AddResponseUnit("", null);
		boolean thrown = false;
		Command command = null;
		try {
			command = new Set_Unit_Location_Command("", new Location(1.0f, 1.0f));
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertNull("Command object should not have been instantiated.", command);
		assertTrue("Exception should have been thrown.", thrown);
	}
	
	/* Test case J-06:
	 *  Constructor, null location
	 *  Description:
	 *    Call the constructor with null location
	 *  Expected result:
	 *    Null_Object_Exception message
	 */
	@Test
	public void Constructor_NullLocation_Test() {
		AddResponseUnit("Unit 3", null);
		boolean thrown = false;
		Command command = null;
		try {
			command = new Set_Unit_Location_Command("Unit 3", null);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Object_Exception);
			thrown = true;
		}
		assertNull("Command object should not have been instantiated.", command);
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case J-07:
	 *  Constructor, Unit_ID NOT in Response_Unit_DB
	 *  Description:
	 *    Call the constructor with a Unit_ID that does not exist in the DB
	 *  Expected result:
	 *    Null_Object_ID_Exception message
	 */
	@Test
	public void Constructor_UnitIDNotPresent_Test() {
		boolean thrown = false;
		Command command = null;
		try {
			command = new Set_Unit_Location_Command("Unit 4", new Location(1.0f,1.0f));
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertNull("Command object should not have been instantiated.", command);
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case J-08:
	 *  Execute command on Response_Unit in Response_Unit_DB
	 *  Description:
	 *    Add a unit to the Response_Unit_DB,
	 *    Create a valid Set_Unit_Location_Command for it
	 *    Execute the command
	 *  Expected result:
	 *    Emergency_Exists should toggle on the named unit.
	 */
	@Test
	public void Command_Execute_Test() {
		Response_Unit ru = AddResponseUnit("Unit 5", null);
		assertFalse(ru.Emergency_Exists());
		Command command = new Set_Unit_Location_Command("Unit 5", new Location(1.0f, 1.0f));
		try {
			command.Execute();
		} catch (Null_Unit_ID_Exception e) {
			fail("Should not have thrown exception");
		}
		assertTrue(ru.Emergency_Exists());
	}

	/* Test case J-09:
	 *  Execute command on Response_Unit NOT in Response_Unit_DB
	 *  Description:
	 *    Create a Set_Unit_Location_Command with a Unit_ID not in Response_Unit_DB
	 *    Execute the command
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void Command_ExecuteResponseUnitNotPresent_Test() {
		boolean thrown = false;
		Command command = new Set_Unit_Location_Command("Unit 6", new Location(1.0f, 1.0f));
		try {
			command.Execute();
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case J-10:
	 *  Priority accessors, normal path
	 *  Description:
	 *    Create a Set_Unit_Location_Command with valid parameters
	 *    Use Priority() accessor to check value.
	 *    Set a new priority
	 *    Verify again with accessor
	 *  Expected result:
	 *    Priority should update normally
	 */
	@Test
	public void PriorityAccessors_Test() {
		AddResponseUnit("Unit 7", null);
		Command command = new Set_Unit_Location_Command("Unit 7", new Location(1.0f, 1.0f));
		assertEquals("Should be priority 1.", command.Priority(), 1);
		command.Set_Priority(2);
		assertEquals("Should be priority 2.", command.Priority(), 2);
	}

	/* Test case J-11:
	 *  Priority accessors, null value
	 *  Description:
	 *    Create a Set_Unit_Location_Command with valid parameters
	 *    Attempt to set Priority to null.
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void SetPriorityToNull_Test() {
		AddResponseUnit("Unit 8", null);
		boolean thrown = false;
		Command command = new Set_Unit_Location_Command("Unit 8", new Location(1.0f, 1.0f));
		try {
			command.Set_Priority(null);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case J-12:
	 *  Priority accessors, invalid value
	 *  Description:
	 *    Create a Set_Unit_Location_Command with valid parameters
	 *    Attempt to set Priority to negative, INT_MAX, or other values outside of valid range.
	 *  Expected result:
	 *    Null_Unit_ID_Exception or some error.
	 */
	@Test
	public void SetPriorityToInvalid_Test() {
		AddResponseUnit("Unit 9", null);
		boolean thrown = false;
		Command command = new Set_Unit_Location_Command("Unit 9", new Location(1.0f, 1.0f));
		try {
			command.Set_Priority(-1);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case J-13:
	 *  Unit_ID accessors, normal path
	 *  Description:
	 *    Create a Set_Unit_Location_Command with valid parameters
	 *    Use Unit_ID() accessor to check value.
	 *    Set a new Unit_ID
	 *    Verify again with accessor
	 *  Expected result:
	 *    Unit_ID should update normally
	 */
	@Test
	public void UnitIDSet_Test() {
		AddResponseUnit("Unit 10", null);
		Command command = new Set_Unit_Location_Command("Unit 10", new Location(1.0f, 1.0f));
		assertEquals("Should be Unit 10.", command.Unit_ID(), "Unit 10");
		command.Set_Unit_ID("Unit 99");
		assertEquals("Unit_ID should have updated to 'Unit 99'.", command.Unit_ID(), "Unit 99");
	}

	/* Test case J-14:
	 *  Unit_ID accessors, null value
	 *  Description:
	 *    Create a Set_Unit_Location_Command with valid parameters
	 *    Attempt to set Unit_ID to null.
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void SetUnitIDToNull_Test() {
		AddResponseUnit("Unit 11", null);
		boolean thrown = false;
		Command command = new Set_Unit_Location_Command("Unit 11", new Location(1.0f,1.0f));
		try {
			command.Set_Unit_ID(null);
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case J-15:
	 *  Unit_ID accessors, empty String
	 *  Description:
	 *    Create a Set_Unit_Location_Command with valid parameters
	 *    Attempt to set Unit_ID to empty String.
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void SetUnitIDToEmptyString_Test() {
		AddResponseUnit("Unit 12", null);
		boolean thrown = false;
		Command command = new Set_Unit_Location_Command("Unit 12", new Location(1.0f,1.0f));
		try {
			command.Set_Unit_ID(new String());
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case J-16:
	 *  Unit_ID accessors, empty string literal
	 *  Description:
	 *    Create a Set_Unit_Location_Command with valid parameters
	 *    Attempt to set Unit_ID to empty string literal.
	 *  Expected result:
	 *    Null_Unit_ID_Exception
	 */
	@Test
	public void SetUnitIDToEmptyStringLiteral_Test() {
		AddResponseUnit("Unit 13", null);
		boolean thrown = false;
		Command command = new Set_Unit_Location_Command("Unit 13", new Location(1.0f,1.0f));
		try {
			command.Set_Unit_ID("");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Unit_ID_Exception",
					e instanceof Null_Unit_ID_Exception);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}
}

