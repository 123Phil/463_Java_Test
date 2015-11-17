
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 25 Oct 2015
 */

package project.code.test;

import static org.junit.Assert.*;
import org.junit.Test;
import project.code.base.Command;
import project.code.base.Set_Unit_Location_Command;
import project.code.base.Toggle_Emergency_Command;
import project.code.base.Command_Comparator;
import project.code.base.Location;
import project.code.base.Null_Object_Exception;


/* Unit under test:
 *   Command_Comparator.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Command.java (and its prereqs)
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */

public class Command_Comparator_Test {
	
	 private final Command_Comparator comp = new Command_Comparator();

	/* Test case L-01:
	 *  Command_Comparator constructor test - Normal conditions
	 *  Description:
	 *    Call the constructor
	 *  Expected result:
	 *    A valid Command instance
	 *    No exceptions expected
	 */
	 @Test
	 public void ConstructorNormalTest() {
		 Command_Comparator comparer = new Command_Comparator();
		 assertNotNull("Comparator should have been instantiated.", comparer);
	 }
	
	 /* Compiler error */
//	/* Test case L-02:
//	 *  Command_Comparator constructor test - abnormal conditions
//	 *  Description:
//	 *    Call the constructor with an argument (like a null String)
//	 *  Expected result:
//	 *    Compiler Error
//	 */
//	 @Test
//	 public void ConstructorAbnormalTest() {
//		 //this gives a compiler error:
//		 Command_Comparator comparer = new Command_Comparator(null);
//		 assertNotNull(comparer);
//	 }
	
	/* Test case L-03:
	 *  Command.compare with equal priorities
	 *  Description:
	 *    Test comparator with Command1 priority == Command2 priority
	 *  Expected result:
	 *    compare returns 0
	 *    No exceptions expected
	 */
	 @Test
	 public void CompareEqualTest() {
		 Command_Manager_Test.AddResponseUnit("Unit 1", null);
		 Command_Manager_Test.AddResponseUnit("Unit 2", null);
		 Command c1 = new Toggle_Emergency_Command("Unit 1");
		 Command c2 = new Toggle_Emergency_Command("Unit 2");
		 int result = comp.compare(c1, c2);
		 assertTrue("Commands should have equal priority.", result == 0);
	 }
	
	/* Test case L-04:
	 *  Command.compare with priority 1 < priority 2 (higher priority)
	 *  Description:
	 *    Test comparator with:
	 *    Command1 priority == 1
	 *    Command2 priority == 2
	 *  Expected result:
	 *    compare returns <0
	 *    No exceptions expected
	 */
	 @Test
	 public void CompareLessTest() {
		 Command_Manager_Test.AddResponseUnit("Unit 3", null);
		 Command_Manager_Test.AddResponseUnit("Unit 4", null);
		 Command c1 = new Toggle_Emergency_Command("Unit 3");
		 Command c2 = new Set_Unit_Location_Command("Unit 4", new Location(0.0f, 0.0f));
		 int result = comp.compare(c1, c2);
		 assertTrue("Comparator should return <0.", result < 0);
	 }
	
	/* Test case L-05:
	 *  Command.compare with priority 1 > priority 2
	 *  Description:
	 *    Test comparator with:
	 *    Command1 priority == 2
	 *    Command2 priority == 1
	 *  Expected result:
	 *    compare returns >0
	 *    No exceptions expected
	 */
	 @Test
	 public void CompareGreaterTest() {
		 Command_Manager_Test.AddResponseUnit("Unit 5", null);
		 Command_Manager_Test.AddResponseUnit("Unit 6", null);
		 Command c1 = new Set_Unit_Location_Command("Unit 5", new Location(0.0f, 0.0f));
		 Command c2 = new Toggle_Emergency_Command("Unit 6");
		 int result = comp.compare(c1, c2);
		 assertTrue("Comparator should return >0", result > 0);
	 }
	
	/* Test case L-06:
	 *  Command.compare with null Command objects
	 *  Description:
	 *    Test comparator with:
	 *    -Command1 null
	 *    -Command2 null
	 *    -Command1 null and Command2 null
	 *  Expected result:
	 *    Any null comparison should throw a Null_Object_Exception
	 */
	 @Test
	 public void CompareNullTest() {
		 Command_Manager_Test.AddResponseUnit("Unit 7", null);
		 Command c1 = new Toggle_Emergency_Command("Unit 7");
		 try {
			 comp.compare(c1, null);
		 } catch (Throwable e) {
			 assertTrue("Should have thrown a Null_Object_Exception",
					 e instanceof Null_Object_Exception);
		 }
		 try {
			 comp.compare(null, c1);
		 } catch (Throwable e) {
			 assertTrue("Should have thrown a Null_Object_Exception",
					 e instanceof Null_Object_Exception);
		 }
		 try {
			 comp.compare(null, null);
		 } catch (Throwable e) {
			 assertTrue("Should have thrown a Null_Object_Exception",
					 e instanceof Null_Object_Exception);
		 }
	 }
	
	/* Test case L-07:
	 *  Command.compare with priority 1 == priority 2 with negative values
	 *  Description:
	 *    Test comparator with negative values
	 *    Command1 priority == 1
	 *    Command2 priority == 1
	 *  Expected result:
	 *    compare returns 0
	 */
	 @Test
	 public void CompareInvalidsTest1() {
		 Command_Manager_Test.AddResponseUnit("Unit 8", null);
		 Command_Manager_Test.AddResponseUnit("Unit 9", null);
		 Command c1 = new Toggle_Emergency_Command("Unit 8");
		 c1.Set_Priority(-5);
		 Command c2 = new Toggle_Emergency_Command("Unit 9");
		 c2.Set_Priority(-5);
		 int result = comp.compare(c1, c2);
		 assertTrue("Commands should have equal priority.", result == 0);
	 }
	
	/* Test case L-08:
	 *  Command.compare with priority 1 < priority 2 with negative values
	 *  Description:
	 *    Test comparator with negative values
	 *    Command1 priority == -10
	 *    Command2 priority == -5
	 *  Expected result:
	 *    compare returns <0
	 */
	 @Test
	 public void CompareInvalidsTest2() {
		 Command_Manager_Test.AddResponseUnit("Unit 3", null);
		 Command_Manager_Test.AddResponseUnit("Unit 4", null);
		 Command c1 = new Toggle_Emergency_Command("Unit 3");
		 c1.Set_Priority(-10);
		 Command c2 = new Toggle_Emergency_Command("Unit 4");
		 c2.Set_Priority(-5);
		 int result = comp.compare(c1, c2);
		 assertTrue("Comparator should return <0", result < 0);
	 }
	
	/* Test case L-09:
	 *  Command.compare with priority 1 > priority 2 with negative values
	 *  Description:
	 *    Test comparator with negative values
	 *    Command1 priority == -5
	 *    Command2 priority == -10
	 *  Expected result:
	 *    compare returns >0
	 */
	 @Test
	 public void CompareInvalidsTest3() {
		 Command_Manager_Test.AddResponseUnit("Unit 3", null);
		 Command_Manager_Test.AddResponseUnit("Unit 4", null);
		 Command c1 = new Toggle_Emergency_Command("Unit 3");
		 c1.Set_Priority(-5);
		 Command c2 = new Toggle_Emergency_Command("Unit 4");
		 c2.Set_Priority(-10);
		 int result = comp.compare(c1, c2);
		 assertTrue("Comparator should return >0", result > 0);
	 }
	
	/* Test case L-10:
	 *  Command.compare with priority 1 == priority 2 == MAX_INT
	 *  Description:
	 *    Test comparator with MAX_INT
	 *  Expected result:
	 *    compare returns 0
	 */
	 @Test
	 public void CompareInvalidsTest4() {
		 Command_Manager_Test.AddResponseUnit("Unit 3", null);
		 Command_Manager_Test.AddResponseUnit("Unit 4", null);
		 Command c1 = new Toggle_Emergency_Command("Unit 3");
		 c1.Set_Priority((int)Integer.MAX_VALUE);
		 Command c2 = new Toggle_Emergency_Command("Unit 4");
		 c2.Set_Priority((int)Integer.MAX_VALUE);
		 int result = comp.compare(c1, c2);
		 assertTrue("Commands should have equal priority.", result == 0);
	 }

}