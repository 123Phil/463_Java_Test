/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 10 Oct 2015
 */

/* Unit under test:
 *   Toggle_Emergency_Command.java
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


/* Test case H-01:
 *  Constructor, Normal conditions (String)
 *  Description:
 *    Add Unit_ID to Response_Unit_DB
 *    Call the constructor with a valid ID String
 *  Expected result:
 *    A valid Toggle_Emergency_Command object is instantiated with priority == 1
 */

/* Test case H-02:
 *  Constructor, Normal conditions (string literal)
 *  Description:
 *    Add Unit_ID to Response_Unit_DB
 *    Call the constructor with a valid ID string literal
 *  Expected result:
 *    A valid Toggle_Emergency_Command object is instantiated with priority == 1
 */

//TODO: should empty string cause Null_Unit_ID_Exception ??
/* Test case H-03:
 *  Constructor, null Unit_ID
 *  Description:
 *    Call the constructor with null String
 *  Expected result:
 *    Null_Unit_ID_Exception ??
 */

/* Test case H-04:
 *  Constructor, empty String Unit_ID
 *  Description:
 *    Call the constructor with empty String
 *  Expected result:
 *    Null_Unit_ID_Exception ??
 */

/* Test case H-05:
 *  Constructor, empty string literal Unit_ID
 *  Description:
 *    Call the constructor with empty string literal
 *  Expected result:
 *    Null_Unit_ID_Exception ??
 */

//TODO: can we add a command for a non-existent unit ID?
/* Test case H-06:
 *  Constructor, Unit_ID NOT in Response_Unit_DB
 *  Description:
 *    Call the constructor with a Unit_ID that does not exist in the DB
 *  Expected result:
 *    Null_Unit_ID_Exception ??
 *    -should we allow construction and throw exception on execution??
 */

/* Test case H-07:
 *  Execute command on Response_Unit in Response_Unit_DB
 *  Description:
 *    Add a unit to the Response_Unit_DB,
 *    Create a valid Toggle_Emergency_Command for it
 *    Execute the command
 *  Expected result:
 *    Emergency_Exists should toggle on the named unit.
 */

/* Test case H-08:
 *  Execute command on Response_Unit NOT in Response_Unit_DB
 *  Description:
 *    Create a Toggle_Emergency_Command with a Unit_ID not in Response_Unit_DB
 *    Execute the command
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case H-09:
 *  Priority accessors, normal path
 *  Description:
 *    Create a Toggle_Emergency_Command with valid parameters
 *    Use Priority() accessor to check value.
 *    Set a new priority
 *    Verify again with accessor
 *  Expected result:
 *    Priority should update normally
 */

/* Test case H-10:
 *  Priority accessors, null value
 *  Description:
 *    Create a Toggle_Emergency_Command with valid parameters
 *    Attempt to set Priority to null.
 *  Expected result:
 *    Null_Unit_ID_Exception ?? //TODO
 */

/* Test case H-11:
 *  Priority accessors, invalid value
 *  Description:
 *    Create a Toggle_Emergency_Command with valid parameters
 *    Attempt to set Priority to negative, INT_MAX, or other values outside of valid range.
 *  Expected result:
 *    Null_Unit_ID_Exception ?? //TODO
 */

/* Test case H-12:
 *  Unit_ID accessors, normal path
 *  Description:
 *    Add Unit_IDs to Response_Unit_DB
 *    Create a Toggle_Emergency_Command with valid parameters
 *    Use Unit_ID() accessor to check value.
 *    Set a new Unit_ID
 *    Verify again with accessor
 *  Expected result:
 *    Unit_ID should update normally
 */

/* Test case H-13:
 *  Unit_ID accessors, null value
 *  Description:
 *    Create a Toggle_Emergency_Command with valid parameters
 *    Attempt to set Unit_ID to null.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case H-14:
 *  Unit_ID accessors, empty String
 *  Description:
 *    Create a Toggle_Emergency_Command with valid parameters
 *    Attempt to set Unit_ID to empty String.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case H-15:
 *  Unit_ID accessors, empty string literal
 *  Description:
 *    Create a Toggle_Emergency_Command with valid parameters
 *    Attempt to set Unit_ID to empty string literal.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case H-16:
 *  Unit_ID setter, invalid Unit_ID
 *  Description:
 *    Add Unit_ID to Response_Unit_DB
 *    Create a Toggle_Emergency_Command with valid parameters
 *    Attempt to set Unit_ID to a Unit_ID that does not exist in Response_Unit_DB.
 *  Expected result:
 *    Null_Unit_ID_Exception ??
 */

