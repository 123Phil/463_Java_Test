package project.code.test;
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 16 Nov 2015
 */

//import static org.junit.Assert.assertNotNull;
//import org.junit.Test;
//import project.code.base.*;

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


public class Command_Test {
	// Both tests give compiler errors.
	// Command is an abstract class, we cannot test it directly
	
//	/* Test case G-01:
//	 *  Command(Integer, String) constructor test - Normal conditions
//	 *  Description:
//	 *    Call the constructor with a valid Integer and a String
//	 *  Expected result:
//	 *    Should not be able to instantiate an abstract class
//	 */
//	@Test
//	public void ConstructorNormalTest() {
//		 Command command = new Command();
//		 assertNotNull("Comparator should have been instantiated.", command);
//	}
//	
//	/* Test case G-02:
//	 *  Command(Integer, String) constructor test - null values
//	 *  Description:
//	 *    Call the constructor with null Integer and null String
//	 *  Expected result:
//	 *    Should not be able to instantiate an abstract class
//	 */
//	@Test
//	public void ConstructorNullTest() {
//		Integer i = null;
//		String s = null;
//		Command command = new Command(i, s);
//		assertNotNull("Comparator should have been instantiated.", command);
//	}
}

