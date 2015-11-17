
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 15 November 2015
 */
 
package project.code.test;
import static org.junit.Assert.*;
import org.junit.Test;

import project.code.base.Duplicate_Item_Exception;
import project.code.base.Null_Object_Exception;

/* Unit under test:
 *   Duplicate_Item_Exception.java
 * 
 * Prerequisites:
 *     - None
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */
 
 public class Duplicate_Item_Exception_Test {

	/* Test case A-01:
	*  Duplicate_Item_Exception construction with no arguments
	*  Description:
	*    Throw a new Duplicate_Item_Exception with no arguments.
	*  Expected result:
	*    A Duplicate_Item_Exception should be thrown.
	*/
	@Test
	public void DuplicateItemException_NoArguments_Test() {
		boolean thrown = false;
		try {
			throw new Duplicate_Item_Exception();
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Duplicate_Item_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), null);
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case A-02:
	*  Duplicate_Item_Exception construction with empty string literal
	*  Description:
	*    Throw a new Duplicate_Item_Exception given an empty string literal.
	*  Expected result:
	*    A Duplicate_Item_Exception should be thrown.
	*/
	@Test
	public void DuplicateItemException_EmptyStringLiteral_Test() {
		boolean thrown = false;
		try {
			throw new Duplicate_Item_Exception("");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Duplicate_Item_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), "");
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case A-03:
	*  Duplicate_Item_Exception construction with non-empty string literal
	*  Description:
	*    Throw a new Duplicate_Item_Exception given a non-empty string literal.
	*  Expected result:
	*    A Duplicate_Item_Exception should be thrown.
	*/
	@Test
	public void DuplicateItemException_NonEmptyStringLiteral_Test() {
		boolean thrown = false;
		try {
			throw new Duplicate_Item_Exception("Test");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Duplicate_Item_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), "Test");
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case A-04:
	*  Duplicate_Item_Exception construction with empty String
	*  Description:
	*    Throw a new Duplicate_Item_Exception given an empty String object
	*  Expected result:
	*    A Duplicate_Item_Exception should be thrown.
	*/
	@Test
	public void DuplicateItemException_EmptyString_Test() {
		boolean thrown = false;
		try {
			throw new Duplicate_Item_Exception(new String());
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Duplicate_Item_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), new String());
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}

	/* Test case A-05:
	*  Duplicate_Item_Exception construction with non-empty String
	*  Description:
	*    Throw a new Duplicate_Item_Exception given a non-empty String object.
	*  Expected result:
	*    A Duplicate_Item_Exception should be thrown.
	*/
	@Test
	public void DuplicateItemException_NonEmptyString_Test() {
		boolean thrown = false;
		try {
			throw new Duplicate_Item_Exception(new String("Test"));
		} catch (Throwable e) {
			assertTrue("Should have thrown a Duplicate_Item_Exception",
					e instanceof Duplicate_Item_Exception);
			assertEquals("Exception message does not match expected.", e.getMessage(), new String("Test"));
			thrown = true;
		}
		assertTrue("Exception should have been thrown.", thrown);
	}
 } //end public class
