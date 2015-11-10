package project.code.test;
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 05 Oct 2015
 */

/* Unit under test:
 *   Response_Unit.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Unit_ID_Exception
 *     - Null_Object_Exception
 *     - Location
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */


/* Test case E-01:
 *  Normal Construction
 *  Description:
 *    Construct a Response_Unit with normal parameters
 *    -Normal parameters are (String, Location)
 *       where String is a non-empty identifier and Location is a valid instance.
 *  Expected result:
 *    A valid Response_Unit instance
 *    No exceptions expected
 */

/* Test case E-02:
 *  Construction with null String
 *  Description:
 *    Construct a Response_Unit with a null String
 *    -Normal parameters are (String, Location)
 *  Expected result:
 *    Null_Unit_ID_Exception expected
 */

/* Test case E-03:
 *  Construction with empty String
 *  Description:
 *    Construct a Response_Unit with an empty String
 *    -Normal parameters are (String, Location)
 *  Expected result:
 *    Null_Unit_Exception message
 */

/* Test case E-04:
 *  Construction with empty string literal
 *  Description:
 *    Construct a Response_Unit with an empty string literal - ""
 *    -Normal parameters are (String, Location)
 *  Expected result:
 *    Null_Unit_Exception message
 */

/* Test case E-05:
 *  Construction with null location
 *  Description:
 *    Construct a Response_Unit with null Location parameter
 *    -Normal parameters are (String, Location)
 *  Expected result:
 *    Null_Object_Exception expected
 */
    
/* Test case E-06:
 *  Unit_ID getter, normal path
 *  Description:
 *    Create a valid object and call the Unit_ID getter to verify
 *    supplied ID matches object's stored ID
 *  Expected result:
 *    Unit_ID accessed from getter matches set Unit_ID.
 */

/* Test case E-07:
 *  Current_Location accessors, normal path
 *  Description:
 *    Create a valid object and call the Set_Location and Location accessors
 *    with valid Location input
 *  Expected result:
 *    Location accessed from getter matches set Location.
 */

/* Test case E-08:
 *  Current_Location setter, null
 *  Description:
 *    Create a valid object and call the Set_Location giving null.
 *  Expected result:
 *    Null_Object_Exception message
 */

/* Test case E-09:
 *  Emergency_Exists accessors, normal path
 *  Description:
 *    Create a valid object and call the Emergency_Exists accessors
 *    with both true and false, checking for match after each set.
 *  Expected result:
 *    Emergency_Exists accessed from getter matches set Emergency_Exists.
 */

/* Test case E-10:
 *  Emergency_Exists setter, null
 *  Description:
 *    Create a valid object and call the Set_Emergency_Exists giving null.
 *  Expected result:
 *    Null_Object_Exception message
 */

/* Test case E-11:
 *  Status_Type accessors, normal path
 *  Description:
 *    Create a valid object and call the Status_Type accessors
 *    with valid Status_Type input
 *    -Valid Status_Type are {Not_In_Service, In_Station, Enroute, On_Scene}
 *  Expected result:
 *    Location accessed from getter matches set Location.
 */

/* Test case E-12:
 *  Status_Type setter, null
 *  Description:
 *    Create a valid object and call Set_Status_Type giving null.
 *  Expected result:
 *    Null_Object_Exception message
 */

/* Test case E-13:
 *  Status_Type setter, invalid input
 *  Description:
 *    Create a valid object and call Set_Status_Type giving an integer value.
 *  Expected result:
 *    An Enum error should occur
 */

