package project.code.test;
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 10 Oct 2015
 */

/* Unit under test:
 *   Send_Message_To_Operator_Command.java
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


/* Test case K-01:
 *  Constructor, Normal conditions (Strings)
 *  Description:
 *    Ensure the Unit_ID exists in Response_Unit_DB
 *    Call the constructor with a valid ID and message String
 *  Expected result:
 *    A valid Send_Message_To_Operator_Command object is instantiated
 *    with priority == 3, and Operator_Message == message
 */

/* Test case K-02:
 *  Constructor, Normal conditions (string literals)
 *  Description:
 *    Call the constructor with a valid ID and message string literal
 *  Expected result:
 *    A valid Send_Message_To_Operator_Command object is instantiated
 *    with priority == 3, and Operator_Message == message
 */

/* Test case K-03:
 *  Constructor, null Unit_ID
 *  Description:
 *    Call the constructor with null String for Unit_ID
 *  Expected result:
 *    Null_Unit_ID_Exception should throw an error message.
 */

/* Test case K-04:
 *  Constructor, empty String Unit_ID
 *  Description:
 *    Call the constructor with empty String for Unit_ID
 *  Expected result:
 *    Null_Unit_ID_Exception should throw an error message.
 */

/* Test case K-05:
 *  Constructor, empty string literal Unit_ID
 *  Description:
 *    Call the constructor with empty string literal for Unit_ID
 *  Expected result:
 *    Null_Unit_ID_Exception should throw an error message.
 */

/* Test case K-06:
 *  Constructor, null message
 *  Description:
 *    Call the constructor with null String for message
 *  Expected result:
 *    Null_Object_Exception thrown.
 */

/* Test case K-07:
 *  Constructor, empty String message
 *  Description:
 *    Call the constructor with empty String for message
 *  Expected result:
 *    Null_Object_Exception thrown.
 */

/* Test case K-08:
 *  Constructor, empty string literal message
 *  Description:
 *    Call the constructor with empty string literal for message
 *  Expected result:
 *    Null_Object_Exception thrown.
 */

/* Test case K-09:
 *  Constructor, Unit_ID NOT in Response_Unit_DB
 *  Description:
 *    Call the constructor with a Unit_ID that does not exist in the DB
 *  Expected result:
 *    Null_Object_Exception message.
 */

/* Test case K-10:
 *  Execute command on Response_Unit in Response_Unit_DB
 *  Description:
 *    Add a unit to the Response_Unit_DB,
 *    Create a valid Send_Message_To_Operator_Command for it
 *    Execute the command
 *  Expected result:
 *    Message should print to stdout.
 *    -TODO: see if result can be automatically verifiable
 */

/* Test case K-11:
 *  Execute command on Response_Unit NOT in Response_Unit_DB
 *  Description:
 *    Create a Send_Message_To_Operator_Command with a Unit_ID not in Response_Unit_DB
 *    Execute the command
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case K-12:
 *  Priority accessors, normal path
 *  Description:
 *    Create a Send_Message_To_Operator_Command with valid parameters
 *    Use Priority() accessor to check value.
 *    Set a new priority
 *    Verify again with accessor
 *  Expected result:
 *    Priority should update normally
 */

/* Test case K-13:
 *  Priority accessors, null value
 *  Description:
 *    Create a Send_Message_To_Operator_Command with valid parameters
 *    Attempt to set Priority to null.
 *  Expected result:
 *    Null_Object_Exception
 */

/* Test case K-14:
 *  Priority accessors, invalid value
 *  Description:
 *    Create a Send_Message_To_Operator_Command with valid parameters
 *    Attempt to set Priority to negative, INT_MAX, or other values outside of valid range.
 *  Expected result:
 *    Null_Object_Exception or some error.
 */

/* Test case K-15:
 *  Unit_ID accessors, normal path
 *  Description:
 *    Create a Send_Message_To_Operator_Command with valid parameters
 *    Use Unit_ID() accessor to check value.
 *    Set a new Unit_ID
 *    Verify again with accessor
 *  Expected result:
 *    Unit_ID should update normally
 */

/* Test case K-16:
 *  Unit_ID accessors, null value
 *  Description:
 *    Create a Send_Message_To_Operator_Command with valid parameters
 *    Attempt to set Unit_ID to null.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case K-17:
 *  Unit_ID accessors, empty String
 *  Description:
 *    Create a Send_Message_To_Operator_Command with valid parameters
 *    Attempt to set Unit_ID to empty String.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case K-18:
 *  Unit_ID accessors, empty string literal
 *  Description:
 *    Create a Send_Message_To_Operator_Command with valid parameters
 *    Attempt to set Unit_ID to empty string literal.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

