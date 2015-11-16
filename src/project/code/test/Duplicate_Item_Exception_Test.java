
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 15 November 2015
 */
 
package project.code.test;
import static org.junit.Assert.*;
import org.junit.Test;

import project.code.base.Duplicate_Item_Exception;

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
		assertThat(throw New Duplicate_Item_Exception())
			.isInstanceOf(Duplicate_Item_Exception.class);
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
		assertThat(throw New Duplicate_Item_Exception(""))
			.isInstanceOf(Duplicate_Item_Exception.class)
			.hasMessage("");
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
		assertThat(throw New Duplicate_Item_Exception("Test"))
			.isInstanceOf(Duplicate_Item_Exception.class)
			.hasMessage("Test");
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
		assertThat(throw New Duplicate_Item_Exception(new String("")))
			.isInstanceOf(Duplicate_Item_Exception.class)
			.hasMessage("");
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
		assertThat(throw New Duplicate_Item_Exception(new String("Test")))
			.isInstanceOf(Duplicate_Item_Exception.class)
			.hasMessage("Test");
	}
 } //end public class
