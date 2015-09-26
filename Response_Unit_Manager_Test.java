/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 26 Sep 2015
 */

/* Unit under test:
 *   Command.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Unit_ID_Exception
 *     - asdf
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */


/* Test case 01:
 *  Command(Integer, String) constructor test - Normal conditions
 *  Description:
 *    Umm, call the constructor with a Integer(1, 2, or 3) and a String(ID)
 *  Expected result:
 *    A valid Command instance
 *    No exceptions expected
 */


/* Test case 02:
 *  Command(Integer, String) constructor test - Invalid Integer Initial_Priority
 *  Description:
 *    Umm, call the constructor with a Integer( greater than valid input... ) and a String(ID)
 *  Expected result:
 *    Some exception...
 */


/* Test case 03:
 *  Execute() - Normal conditions.
 *  Description:
 *    Create a valid Command instance and call Execute() on it.
 *  Expected result:
 *    Command is executed...
 */



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

