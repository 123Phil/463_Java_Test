package project.code.test;
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 01 Oct 2015
 */

package project.code.test;
import static org.junit.Assert.*;
import org.junit.Test;

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
		assertThat(throw New Null_Unit_ID_Exception())
			.isInstanceOf(Null_Unit_ID_Exception.class);
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
		assertThat(throw New Null_Unit_ID_Exception(""))
			.isInstanceOf(Null_Unit_ID_Exception.class)
			.hasMessage("");
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
		assertThat(throw New Null_Unit_ID_Exception("Test"))
			.isInstanceOf(Null_Unit_ID_Exception.class)
			.hasMessage("Test");
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
		assertThat(throw New Null_Unit_ID_Exception(new String("")))
			.isInstanceOf(Null_Unit_ID_Exception.class)
			.hasMessage("");
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
		assertThat(throw New Null_Unit_ID_Exception(new String("Test")))
			.isInstanceOf(Null_Unit_ID_Exception.class)
			.hasMessage("Test");
	}

	/* Test case C-06:
	*  Null_Unit_ID_Exception construction with an int
	*  Description:
	*    Throw a new Null_Unit_ID_Exception given an int
	*  Expected result:
	*    No Null_Unit_ID_Exception exception should be thrown.
	*    -Some error should occur
	*/
	@Test
	public void NullUnitIDException_Int_Test() {
		int test;
		test = 1;
		assertThat(throw New Null_Unit_ID_Exception(test))
			.isInstanceOf(Null_Unit_ID_Exception.class)
			.hasMessage("1");
	}

	/* Test case C-07:
	*  Null_Unit_ID_Exception construction with negative int
	*  Description:
	*    Throw a new Null_Unit_ID_Exception given negative int
	*  Expected result:
	*    No Null_Unit_ID_Exception exception should be thrown.
	*    -Some error should occur
	*/
	@Test
	public void NullUnitIDException_NegativeInt_Test() {
		int test;
		test = -1;
		assertThat(throw New Null_Unit_ID_Exception(test))
			.isInstanceOf(Null_Unit_ID_Exception.class)
			.hasMessage("-1");
	}

	/* Test case C-08:
	*  Null_Unit_ID_Exception construction with float
	*  Description:
	*    Test with a float msg
	*  Expected result:
	*    No Null_Unit_ID_Exception exception should be thrown.
	*    -Some error should occur
	*/
	@Test
	public void NullUnitIDException_Float_Test() {
		float test;
		test = 1.23;
		assertThat(throw New Null_Unit_ID_Exception(test))
			.isInstanceOf(Null_Unit_ID_Exception.class)
			.hasMessage("1.23");
	}

	/* Test case C-09:
	*  Null_Unit_ID_Exception construction with Null Integer object
	*  Description:
	*    Throw Null_Unit_ID_Exception with a Null Integer argument
	*  Expected result:
	*    No Null_Unit_ID_Exception exception should be thrown.
	*    -Some error should occur
	*/
	@Test
	public void NullUnitIDException_NullInteger_Test() {
		Integer test;
		test = null;
		assertThat(throw New Null_Unit_ID_Exception(test))
			.isInstanceOf(Null_Unit_ID_Exception.class);
	}
 } //end public class


