/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 10 Oct 2015
 */

/* Unit under test:
 *   Command.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Unit_ID_Exception
 *     - Null_Object_Exception
 *     - Duplicate_Item_Exception
 *     - Location
 *     - Response_Unit
 *     - Response_Unit_Manager
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 *   Notes:
 *     - Command is an abstract class. It's methods are tested for classes
 *       which extend Command.
 *     - Is_Higher_Priority_Than is tested for extended classes in the
 *       Command_Manager_Test module
 */


/* Test case G-01:
 *  Command(Integer, String) constructor test - Normal conditions
 *  Description:
 *    Call the constructor with a valid Integer and a String
 *  Expected result:
 *    Should not be able to instantiate an abstract class
 */

/* Test case G-02:
 *  Command(Integer, String) constructor test - null values
 *  Description:
 *    Call the constructor with null Integer and null String
 *  Expected result:
 *    Should not be able to instantiate an abstract class
 */

