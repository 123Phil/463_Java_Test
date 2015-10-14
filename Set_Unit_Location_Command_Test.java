/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 10 Oct 2015
 */

/* Unit under test:
 *   Set_Unit_Location_Command.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Unit_ID_Exception
 *     - Null_Object_Exception
 *     - Duplicate_Item_Exception
 *     - Location
 *     - Response_Unit
 *     - Response_Unit_Manager
 *     - Command
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 *   Note:
 *     - A good portion of these tests are designed to test the abstract parent
 *       Command class, and so some tests defined here are repeated in the fellow
 *       classes which extend Command.
 */


/* Test case :
 *  Constructor, Normal conditions (String)
 *  Description:
 *    Call the constructor with a valid ID String
 *    TODO: does the Unit_ID need to exist in Response_Unit_DB first?
 *  Expected result:
 *    A valid Set_Unit_Location_Command object is instantiated with priority == 1
 */

/* Test case :
 *  Constructor, Normal conditions (string literal)
 *  Description:
 *    Call the constructor with a valid ID string literal
 *  Expected result:
 *    A valid Set_Unit_Location_Command object is instantiated with priority == 1
 */

//TODO: should empty string cause Null_Unit_ID_Exception ??
/* Test case :
 *  Constructor, null Unit_ID
 *  Description:
 *    Call the constructor with null String
 *  Expected result:
 *    Null_Unit_ID_Exception ??
 */

/* Test case :
 *  Constructor, empty String Unit_ID
 *  Description:
 *    Call the constructor with empty String
 *  Expected result:
 *    Null_Unit_ID_Exception ??
 */

/* Test case :
 *  Constructor, empty string literal Unit_ID
 *  Description:
 *    Call the constructor with empty string literal
 *  Expected result:
 *    Null_Unit_ID_Exception ??
 */

//TODO: can we add a command for a non-existent unit ID?
/* Test case :
 *  Constructor, Unit_ID NOT in Response_Unit_DB
 *  Description:
 *    Call the constructor with a Unit_ID that does not exist in the DB
 *  Expected result:
 *    Null_Unit_ID_Exception ??
 *    -should we allow construction and throw exception on execution??
 */

/* Test case :
 *  Execute command on Response_Unit in Response_Unit_DB
 *  Description:
 *    Add a unit to the Response_Unit_DB,
 *    Create a valid Set_Unit_Location_Command for it
 *    Execute the command
 *  Expected result:
 *    Emergency_Exists should toggle on the named unit.
 */

/* Test case :
 *  Execute command on Response_Unit NOT in Response_Unit_DB
 *  Description:
 *    Create a Set_Unit_Location_Command with a Unit_ID not in Response_Unit_DB
 *    Execute the command
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case :
 *  Priority accessors, normal path
 *  Description:
 *    Create a Set_Unit_Location_Command with valid parameters
 *    Use Priority() accessor to check value.
 *    Set a new priority
 *    Verify again with accessor
 *  Expected result:
 *    Priority should update normally
 */

/* Test case :
 *  Priority accessors, null value
 *  Description:
 *    Create a Set_Unit_Location_Command with valid parameters
 *    Attempt to set Priority to null.
 *  Expected result:
 *    Null_Unit_ID_Exception ?? //TODO
 */

/* Test case :
 *  Priority accessors, invalid value
 *  Description:
 *    Create a Set_Unit_Location_Command with valid parameters
 *    Attempt to set Priority to negative, INT_MAX, or other values outside of valid range.
 *  Expected result:
 *    Null_Unit_ID_Exception ?? //TODO
 */

/* Test case :
 *  Unit_ID accessors, normal path
 *  Description:
 *    Create a Set_Unit_Location_Command with valid parameters
 *    Use Unit_ID() accessor to check value.
 *    Set a new Unit_ID
 *    Verify again with accessor
 *  Expected result:
 *    Unit_ID should update normally
 */

/* Test case :
 *  Unit_ID accessors, null value
 *  Description:
 *    Create a Set_Unit_Location_Command with valid parameters
 *    Attempt to set Unit_ID to null.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case :
 *  Unit_ID accessors, empty String
 *  Description:
 *    Create a Set_Unit_Location_Command with valid parameters
 *    Attempt to set Unit_ID to empty String.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */

/* Test case :
 *  Unit_ID accessors, empty string literal
 *  Description:
 *    Create a Set_Unit_Location_Command with valid parameters
 *    Attempt to set Unit_ID to empty string literal.
 *  Expected result:
 *    Null_Unit_ID_Exception
 */






// ORIGINAL CODE FOR UNIT IS INCLUDED BELOW FOR QUICK REFERENCE.
// IT HAS BEEN STRIPPED OF EXTRANEOUS COMMENTS AND FORMATTED FOR CLARITY.
// ENSURE THIS HAS BEEN DELETED BEFORE SUBMITTING ASSIGNMENT.

public class Set_Unit_Location_Command extends Command {
    private Location New_Location;
    
    @Override
    public void Execute () throws Null_Unit_ID_Exception {
        Response_Unit Subject_Unit= Response_Unit_Manager.Response_Unit_Named(Unit_ID);
        
        if (Subject_Unit == null)
            throw new Null_Unit_ID_Exception (Unit_ID);
        else
            Subject_Unit.Set_Location (New_Location);
    } //end Execute
    

    //WTF??
    public Set_Unit_Location_Command (String Unit_ID, Location Updated_Location){
        super (2, Unit_ID);
        New_Location = Updated_Location;
    } //end Set_Unit_Location_Command
    
} //end Set_Unit_Location_Command
