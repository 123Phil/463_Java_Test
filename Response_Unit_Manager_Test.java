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
 *    TODO: expect an error? something like "not implemented"
 */

/* Test case F-01:
 *  Add_Response_Unit with valid input
 *  Description:
 *    Call Add_Response_Unit with a valid non-duplicate Response_Unit
 *  Expected result:
 *    Response_Unit should be successfully added to Response_Unit_DB.
 */

/* Test case F-01:
 *  Add_Response_Unit multiple calls
 *  Description:
 *    Call Add_Response_Unit with MANY valid Response_Units
 *  Expected result:
 *    All Response_Units should be successfully added to Response_Unit_DB.
 */

/* Test case F-01:
 *  Add_Response_Unit with null unit
 *  Description:
 *    Call Add_Response_Unit with a null Response_Unit
 *  Expected result:
 *    Null_Object_Exception expected
 */

/* Test case F-01:
 *  Add_Response_Unit with duplicate unit
 *  Description:
 *    Call Add_Response_Unit with a Response_Unit with ID already in Response_Unit_DB
 *  Expected result:
 *    Duplicate_Item_Exception expected
 */


//...

/* Test case F-01:
 *  Response_Unit_Named with existing Response_Unit Unit_ID
 *  Description:
 *    Add a valid Response_Unit to the Response_Unit_DB,
 *    Then call Response_Unit_Named to retrieve it.
 *  Expected result:
 *    Named Response_Unit should be successfully returned.
 */

/* Test case F-01:
 *  Response_Unit_Named with non-existing Response_Unit
 *  Description:
 *    Call Response_Unit_Named giving a Response_Unit not in the Response_Unit_DB
 *  Expected result:
 *    null returned.
 */

/* Test case F-01:
 *  Response_Unit_Named with null Response_Unit
 *  Description:
 *    Call Response_Unit_Named giving a null String ID
 *  Expected result:
 *    TODO: Not sure what should be returned...
 */

/* Test case F-01:
 *  Response_Unit_Named with empty String
 *  Description:
 *    Call Response_Unit_Named giving an empty String
 *  Expected result:
 *    TODO: Not sure what should be returned...
 */

/* Test case F-01:
 *  Response_Unit_Named with empty string literal
 *  Description:
 *    Call Response_Unit_Named giving an empty string literal
 *  Expected result:
 *    TODO: Not sure what should be returned...
 */



//Response_Unit_Exists
/* Test case F-01:
 *  Response_Unit_Exists with existing Response_Unit Unit_ID
 *  Description:
 *    Add a valid Response_Unit to the Response_Unit_DB,
 *    Then call Response_Unit_Exists to see if it exists.
 *  Expected result:
 *    true
 */

/* Test case F-01:
 *  Response_Unit_Exists with non-existing Response_Unit Unit_ID
 *  Description:
 *    Call Response_Unit_Exists giving a Unit_ID not in Response_Unit_DB.
 *  Expected result:
 *    false
 */

//null string, empty string, empty string literal..


// ORIGINAL CODE FOR UNIT IS INCLUDED BELOW FOR QUICK REFERENCE.
// IT HAS BEEN STRIPPED OF EXTRANEOUS COMMENTS AND FORMATTED FOR CLARITY.
// ENSURE THIS HAS BEEN DELETED BEFORE SUBMITTING ASSIGNMENT.


public class Response_Unit_Manager {
    
    private static HashMap<String, Response_Unit> Response_Unit_DB = new HashMap<> ();
    
    /**
     * This subprogram adds a new Response_Unit to the data store.  The
     * new response unit must be valid Response_Unit object and it's ID must be 
     * unique (i.e., must not already exist in the data store.
     * 
     * Exceptions Thrown:  Null_Object_Exception
     */
    public static void Add_Response_Unit (Response_Unit New_Unit) throws Null_Object_Exception, Duplicate_Item_Exception {
        String Unit_ID = New_Unit.Unit_ID ();
        
        if (New_Unit == null)
            throw new Null_Object_Exception ();
        
        else if (Response_Unit_Exists (Unit_ID))
            throw new Duplicate_Item_Exception (Unit_ID);
        
        else
            Response_Unit_DB.put (Unit_ID, New_Unit);
    } //end Add_Response_Unit
    
    /**
     * This subprogram retrieves the Response Unit with the specified name
     * from the data store and returns it to the caller.
     */
    public static Response_Unit Response_Unit_Named (String Unit_ID) {
        //HashMap.get returns null if param nonexistent
        return Response_Unit_DB.get(Unit_ID);
    }
    
    /**
     * This subprogram returns True if a Response Unit with the specified
     * name exists in the data store, and False otherwise.
     */
    public static boolean Response_Unit_Exists (String Unit_ID) {
        return Response_Unit_DB.containsKey(Unit_ID);
    } // end Response_Unit_Exists
} //end Response_Unit_Manager

