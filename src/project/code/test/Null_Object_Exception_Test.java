
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 01 Oct 2015
 */
 
package project.code.test;
import static org.junit.Assert.*;
import org.junit.Test;

import project.code.base.Null_Object_Exception;

/* Unit under test:
 *   Null_Object_Exception.java
 * Prerequisites:
 *     - None
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */

public class Null_Object_Exception_Test {
 
	/* Test case B-01:
	*  Null_Object_Exception construction with no arguments
	*  Description:
	*    Throw a new Null_Object_Exception with no arguments.
	*  Expected result:
	*    A Null_Object_Exception should be thrown.
	*/
	@Test
	public void NullObjectException_NoArguments_Test() {
		assertThat(throw New Null_Object_Exception())
			.isInstanceOf(Null_Object_Exception.class);
	}

	/* Test case B-02:
	*  Null_Object_Exception construction with empty string literal
	*  Description:
	*    Throw a new Null_Object_Exception given an empty string literal.
	*  Expected result:
	*    A Null_Object_Exception should be thrown.
	*/
	@Test
	public void NullObjectException_EmptyStringLiteral_Test() {
		assertThat(throw New Null_Object_Exception(""))
			.isInstanceOf(Null_Object_Exception.class)
			.hasMessage("");
	}


	/* Test case B-03:
	*  Null_Object_Exception construction with non-empty string literal
	*  Description:
	*    Throw a new Null_Object_Exception given a non-empty string literal.
	*  Expected result:
	*    A Null_Object_Exception should be thrown.
	*/
	@Test
	public void NullObjectException_NonEmptyStringLiteral_Test() {
		assertThat(throw New Null_Object_Exception("Test"))
			.isInstanceOf(Null_Object_Exception.class)
			.hasMessage("Test");
	}	

	/* Test case B-04:
	*  Null_Object_Exception construction with empty String
	*  Description:
	*    Throw a new Null_Object_Exception given an empty String object
	*  Expected result:
	*    A Null_Object_Exception should be thrown.
	*/
	@Test
	public void NullObjectException_EmptyString_Test() {
		assertThat(throw New Null_Object_Exception(new String("")))
			.isInstanceOf(Null_Object_Exception.class)
			.hasMessage("");
	}	

	/* Test case B-05:
	*  Null_Object_Exception construction with non-empty String
	*  Description:
	*    Throw a new Null_Object_Exception given a non-empty String object.
	*  Expected result:
	*    A Null_Object_Exception should be thrown.
	*/
	@Test
	public void NullObjectException_NonEmptyString_Test() {
		assertThat(throw New Null_Object_Exception(new String("Test")))
			.isInstanceOf(Null_Object_Exception.class)
			.hasMessage("Test");
	}	

	/* Test case B-06:
	*  Null_Object_Exception construction with two floats
	*  Description:
	*    Throw a new Null_Object_Exception given two floating point values.
	*    -The two floating point values represent lattitude and longitude.
	*  Expected result:
	*    A Null_Object_Exception should be thrown.
	*/
	@Test
	public void NullObjectException_TwoFloats_Test() {
		Float Latitude, Longitude;
		Latitude = 1.23f;
		Longitude = 1.23f;
		assertThat(throw New Null_Object_Exception(Latitude,Longitude))
			.isInstanceOf(Null_Object_Exception.class)
			.hasMessage("Location " + "1.23" + ", " + "1.23" + "is not valid");
	}

	/* Test case B-07:
	*  Null_Object_Exception construction with two integers
	*  Description:
	*    Throw a new Null_Object_Exception given two integer values.
	*    -The two values represent lattitude and longitude.
	*  Expected result:
	*    A Null_Object_Exception should be thrown. 
	*/
	@Test
	public void NullObjectException_TwoIntegers_Test() {
		int Latitude, Longitude;
		Latitude = 1;
		Longitude = 1;
		assertThat(throw New Null_Object_Exception(Latitude,Longitude))
			.isInstanceOf(Null_Object_Exception.class)
			.hasMessage("Location " + "1" + ", " + "1" + "is not valid");
	}

	/* Test case B-08:
	*  Null_Object_Exception construction with empty location object
	*  Description:
	*    Throw a new Null_Object_Exception given and empty location object
	*  Expected result:
	*    A Null_Object_Exception should be thrown.
	*/
	@Test
	public void NullObjectException_EmptyLocation_Test() {

	}
 } //end public class