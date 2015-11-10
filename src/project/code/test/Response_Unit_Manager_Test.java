package project.code.test;
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 05 Oct 2015
 */

/* Unit under test:
 *   Response_Unit_Manager.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Unit_ID_Exception
 *     - Null_Object_Exception
 *     - Duplicate_Item_Exception
 *     - Location
 *     - Response_Unit
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */


/* Test case F-01:
 *  Attempt construction
 *  Description:
 *    Attempt to create an instance of Response_Unit_Manager
 *  Expected result:
 *    Object should not be instantiated.
 *    -All methods and variables are static
 */

/* Test case F-02:
 *  Add_Response_Unit with valid input
 *  Description:
 *    Call Add_Response_Unit with a valid non-duplicate Response_Unit
 *  Expected result:
 *    Response_Unit should be successfully added to Response_Unit_DB.
 */

/* Test case F-03:
 *  Add_Response_Unit multiple calls (capacity test)
 *  Description:
 *    Call Add_Response_Unit with MANY valid Response_Units
 *  Expected result:
 *    All Response_Units should be successfully added to Response_Unit_DB.
 */

/* Test case F-04:
 *  Add_Response_Unit with null unit
 *  Description:
 *    Call Add_Response_Unit with a null Response_Unit
 *  Expected result:
 *    Null_Object_Exception expected
 */

/* Test case F-05:
 *  Add_Response_Unit with duplicate unit
 *  Description:
 *    Call Add_Response_Unit with a Response_Unit with ID already in Response_Unit_DB
 *  Expected result:
 *    Duplicate_Item_Exception expected
 */

/* Test case F-06:
 *  Response_Unit_Named with existing Response_Unit Unit_ID
 *  Description:
 *    Add a valid Response_Unit to the Response_Unit_DB,
 *    Then call Response_Unit_Named to retrieve it.
 *  Expected result:
 *    Named Response_Unit should be successfully returned.
 */

/* Test case F-07:
 *  Response_Unit_Named with non-existing Response_Unit
 *  Description:
 *    Call Response_Unit_Named giving a Response_Unit not in the Response_Unit_DB
 *  Expected result:
 *    null returned.
 */

/* Test case F-08:
 *  Response_Unit_Named with null Response_Unit
 *  Description:
 *    Call Response_Unit_Named giving a null String ID
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case F-09:
 *  Response_Unit_Named with empty String
 *  Description:
 *    Call Response_Unit_Named giving an empty String
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case F-10:
 *  Response_Unit_Named with empty string literal
 *  Description:
 *    Call Response_Unit_Named giving an empty string literal
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case F-11:
 *  Response_Unit_Exists with existing Response_Unit Unit_ID
 *  Description:
 *    Add a valid Response_Unit to the Response_Unit_DB,
 *    Then call Response_Unit_Exists to see if it exists.
 *  Expected result:
 *    true
 */

/* Test case F-12:
 *  Response_Unit_Exists with non-existing Response_Unit Unit_ID
 *  Description:
 *    Call Response_Unit_Exists giving a Unit_ID not in Response_Unit_DB.
 *  Expected result:
 *    false
 */

/* Test case F-13:
 *  Response_Unit_Exists with null Response_Unit Unit_ID
 *  Description:
 *    Call Response_Unit_Exists giving a null Unit_ID.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case F-14:
 *  Response_Unit_Exists with empty String Response_Unit Unit_ID
 *  Description:
 *    Call Response_Unit_Exists giving an empty String.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case F-15:
 *  Response_Unit_Exists with empty string literal Response_Unit Unit_ID
 *  Description:
 *    Call Response_Unit_Exists giving an empty string literal.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

