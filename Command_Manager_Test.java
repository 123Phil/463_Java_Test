/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 13 Oct 2015
 */

/* Unit under test:
 *   Command_Manager.java
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
 *     - Toggle_Emergency_Command
 *     - Send_Message_To_Operator_Command
 *     - Set_Unit_Location_Command
 *     - Set_Unit_Status_Command
 *     - Command_Comparator
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 *   Note:
 *     - A good portion of these tests are designed to test the abstract parent
 *       Command class, and so some tests defined here are repeated in the fellow
 *       classes which extend Command.
 */


/* Test case M-01:
 *  Constructor - Normal conditions
 *  Description:
 *    Call the constructor... but there isn't one... (implicit)
 *  Expected result:
 *    ??
 */

/* Test case M-02:
 *  Next_Command with empty queue
 *  Description:
 *    Call Next_Command before enqueueing any commands.
 *  Expected result:
 *    null
 */

/* Test case M-03:
 *  Next_Command with enqueued command
 *  Description:
 *    Enqueue a valid Command object
 *    Call Next_Command
 *  Expected result:
 *    The enqueued command should be returned.
 */

/* Test case M-04:
 *  Execute_Next_Command with empty queue
 *  Description:
 *    Call Execute_Next_Command before enqueueing any commands.
 *  Expected result:
 *    Null_Unit_ID_Exception <- should really be Null_Obj..
 */

/* Test case M-04:
 *  Execute_Next_Command with 
 *  Description:
 *    Call 
 *  Expected result:
 *    
 */

/* Test case M-04:
 *  Queue_Empty with 
 *  Description:
 *    Call 
 *  Expected result:
 *    
 */

/* Test case M-04:
 *  Queue_Empty with 
 *  Description:
 *    Call 
 *  Expected result:
 *    
 */


/* Test case M-05:
 *  Priority test with 1 each type Command
 *  Description:
 *    Enqueue
 *    Call Next_Command before enqueueing any commands.
 *  Expected result:
 *    null
 */

/* Test case M-05:
 *  Priority test with 1 each type Command
 *  Description:
 *    Enqueue
 *    Call Next_Command before enqueueing any commands.
 *  Expected result:
 *    null
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
