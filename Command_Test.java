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

public abstract class Command {
    protected Integer Priority;
    protected String  Unit_ID;
    
    public Command (Integer Initial_Priority, String Initial_Unit_ID) {
        Set_Priority (Initial_Priority);
        Set_Unit_ID (Initial_Unit_ID);
    }

    /**
     * This subprogram executes the command.  This subprogram must be 
     * implemented by each child Command
     */
    public abstract void Execute () throws Null_Unit_ID_Exception;
    
    /**
     * This subprogram returns true if this instance of Command has a higher
     * priority than the passed-in instance.
     */
    public boolean Is_Higher_Priority_Then (Command Right_Side) {
        return Priority > Right_Side.Priority;
    } //end Is_Higher_Priority
    
    /**
     * This subprogram returns the Command's current Priority value
     */
    public final int Priority() {
        return Priority;
    } //end Priority
    
    /**
     * This subprogram sets the value of the Priority attribute.
     */
    public final void Set_Priority (Integer New_Priority) {
        Priority = New_Priority;
    } //end Set_Priority
    
    /**
     * This subprogram sets the value of the Unit_ID attribute
     */
    public final void Set_Unit_ID (String New_Unit_ID) {
        Unit_ID = New_Unit_ID;
    } //end Set_Unit_ID
    
    /**
     * This subprogram returns the Command's current Unit_ID value
     */
    public final String Unit_ID () {
        return Unit_ID;
    } //end Unit_ID
} //end Command
