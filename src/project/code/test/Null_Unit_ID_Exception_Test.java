
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 01 Oct 2015
 */

package project.code.test;
import static org.junit.Assert.*;
import org.junit.Test;

import project.code.base.Duplicate_Item_Exception;
import project.code.base.Null_Unit_ID_Exception;
 
/* Unit under test:
 *   Null_Unit_ID_Exception.java
 * Prerequisites:
 *     - None
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */

public class Null_Unit_ID_Exception_Test {
 
	/* Test case C-01:
	*  Null_Unit_ID_Exception construction with no arguments
	*  Description:
	*    Throw a new Null_Unit_ID_Exception with no arguments.
	*  Expected result:
	*    A Null_Unit_ID_Exception should be thrown.
	*/
	@Test
	public void NullUnitIDException_NoArguments_Test() {
		boolean thrown = false;
		try {
			throw new Null_Unit_ID_Exception();
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Null_Unit_ID_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), null);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case C-02:
	*  Null_Unit_ID_Exception construction with empty string literal
	*  Description:
	*    Throw a new Null_Unit_ID_Exception given an empty string literal.
	*  Expected result:
	*    A Null_Unit_ID_Exception should be thrown.
	*/
	@Test
	public void NullUnitIDException_EmptyStringLiteral_Test() {
		boolean thrown = false;
		try {
			throw new Null_Unit_ID_Exception("");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Null_Unit_ID_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), "");
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case C-03:
	*  Null_Unit_ID_Exception construction with non-empty string literal
	*  Description:
	*    Throw a new Null_Unit_ID_Exception given a non-empty string literal.
	*  Expected result:
	*    A Null_Unit_ID_Exception should be thrown.
	*/
	@Test
	public void NullUnitIDException_NonEmptyStringLiteral_Test() {
		boolean thrown = false;
		try {
			throw new Null_Unit_ID_Exception("Test");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Null_Unit_ID_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), "Test");
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case C-04:
	*  Null_Unit_ID_Exception construction with empty String
	*  Description:
	*    Throw a new Null_Unit_ID_Exception given an empty String object
	*  Expected result:
	*    A Null_Unit_ID_Exception should be thrown.
	*/
	@Test
	public void NullUnitIDException_EmptyString_Test() {
		boolean thrown = false;
		try {
			throw new Null_Unit_ID_Exception(new String());
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Null_Unit_ID_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), new String());
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case C-05:
	*  Null_Unit_ID_Exception construction with non-empty String
	*  Description:
	*    Throw a new Null_Unit_ID_Exception given a non-empty String object.
	*  Expected result:
	*    A Null_Unit_ID_Exception should be thrown.
	*/
	@Test
	public void NullUnitIDException_NonEmptyString_Test() {
		boolean thrown = false;
		try {
			throw new Null_Unit_ID_Exception(new String("Test"));
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Null_Unit_ID_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), new String("Test"));
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	
	/* Compiler errors */
//	/* Test case C-06:
//	*  Null_Unit_ID_Exception construction with an int
//	*  Description:
//	*    Throw a new Null_Unit_ID_Exception given an int
//	*  Expected result:
//	*    No Null_Unit_ID_Exception exception should be thrown.
//	*    -Some error should occur
//	*/
//	@Test
//	public void NullUnitIDException_Int_Test() {
//		boolean thrown = false;
//		try {
//			int test_val = 5;
//			throw new Null_Unit_ID_Exception(test_val);
//		} catch (Throwable e) {
//			assertTrue("Should have thrown a Duplicate_Item_Exception",
//					e instanceof Null_Unit_ID_Exception);
//			assertEquals("Exception message does not match expected.", e.getMessage(), "5");
//			thrown = true;
//		}
//		assertTrue("Exception should have been thrown.", thrown);
//	}
//
//	/* Test case C-07:
//	*  Null_Unit_ID_Exception construction with negative int
//	*  Description:
//	*    Throw a new Null_Unit_ID_Exception given negative int
//	*  Expected result:
//	*    No Null_Unit_ID_Exception exception should be thrown.
//	*    -Some error should occur
//	*/
//	@Test
//	public void NullUnitIDException_NegativeInt_Test() {
//		boolean thrown = false;
//		try {
//			throw new Null_Unit_ID_Exception(-5);
//		} catch (Throwable e) {
//			assertTrue("Should have thrown a Duplicate_Item_Exception",
//					e instanceof Null_Unit_ID_Exception);
//			assertEquals("Exception message does not match expected.", e.getMessage(), -5);
//			thrown = true;
//		}
//		assertTrue("Exception should have been thrown.", thrown);
//	}
//
//	/* Test case C-08:
//	*  Null_Unit_ID_Exception construction with float
//	*  Description:
//	*    Test with a float msg
//	*  Expected result:
//	*    No Null_Unit_ID_Exception exception should be thrown.
//	*    -Some error should occur
//	*/
//	@Test
//	public void NullUnitIDException_Float_Test() {
//		boolean thrown = false;
//		try {
//			throw new Null_Unit_ID_Exception(-5.0f);
//		} catch (Throwable e) {
//			assertTrue("Should have thrown a Duplicate_Item_Exception",
//					e instanceof Null_Unit_ID_Exception);
//			assertEquals("Exception message does not match expected.", e.getMessage(), "-5.0");
//			thrown = true;
//		}
//		assertTrue("Exception should have been thrown.", thrown);
//	}
//
//	/* Test case C-09:
//	*  Null_Unit_ID_Exception construction with Null Integer object
//	*  Description:
//	*    Throw Null_Unit_ID_Exception with a Null Integer argument
//	*  Expected result:
//	*    No Null_Unit_ID_Exception exception should be thrown.
//	*    -Some error should occur
//	*/
//	@Test
//	public void NullUnitIDException_NullInteger_Test() {
//		Integer test_val = null;
//		boolean thrown = false;
//		try {
//			throw new Null_Unit_ID_Exception(test_val);
//		} catch (Throwable e) {
//			assertTrue("Should have thrown a Duplicate_Item_Exception",
//					e instanceof Null_Unit_ID_Exception);
//			assertEquals("Exception message does not match expected.", e.getMessage(), -5);
//			thrown = true;
//		}
//		assertTrue("Exception should have been thrown.", thrown);
//	}
	
 } //end class


