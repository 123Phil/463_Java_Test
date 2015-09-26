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


public class Send_Message_To_Operator_Command extends Command {
    private String Operator_Message;
    
    @Override
    public void Execute () throws Null_Unit_ID_Exception {
        Response_Unit Subject_Unit = Response_Unit_Manager.Response_Unit_Named(Unit_ID);
        
        if (Subject_Unit == null)
            throw new Null_Unit_ID_Exception (Unit_ID);
        
        else
            //Temporary implementation until the operator message capability
            //is finished
            System.out.println ("Message from " + Unit_ID + "reads " +
                                Operator_Message);
    } //end Execute
    
    //WTF??
    public Send_Message_To_Operator_Command (String Unit_ID, String Message) {
        //WTF is this?? what's the 3??
        super (3, Unit_ID);
        Operator_Message = Message;
    } //end Set_Unit_Status_Command
    
}
