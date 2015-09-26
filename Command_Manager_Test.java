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

/**
 * This class manages the queue of commands to be executed
 * highest priority is returned first
 * -or oldest highest is returned first.
 * 
 * Throws:
 *  Null_Unit_ID_Exception
 */
public class Command_Manager {
    private PriorityQueue <Command> Queue = new PriorityQueue <> (16, new Command_Comparator ());
    
    public Command Next_Command () {
        return Queue.poll();
    }
    
    public void Enqueue_Command (Command New_Command) {
        Queue.offer(New_Command);
    }

    /**
     * This subprogram removes and executes the next command on the queue.
     * @throws Null_Unit_ID_Exception 
     */
    public void Execute_Next_Command () throws Null_Unit_ID_Exception {
        //next_command() returns null if q empty...
        Next_Command().Execute();
    }

    public Boolean Queue_Empty (){
        return Queue.size() <= 0;
    }
} // end Command_Manager
