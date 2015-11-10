package project.code.test;
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 25 Oct 2015
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
 *    Call the constructor (implicit constructor)
 *  Expected result:
 *    A valid onstance of Command_Manager should be created
 */

/* Test case M-02:
 *  Next_Command with empty queue
 *  Description:
 *    Call Next_Command before enqueueing any commands.
 *  Expected result:
 *    null
 */

/* Test case M-03:
 *  Enqueue_Command with valid command
 *  Description:
 *    Enqueue a valid Command object
 *  Expected result:
 *    The command should be enqueued
 */

/* Test case M-04:
 *  Enqueue_Command with null
 *  Description:
 *    Attempt to Enqueue null.
 *  Expected result:
 *    Null_Object_Exception
 */

/* Test case M-05:
 *  Next_Command with enqueued command
 *  Description:
 *    Enqueue a valid Command object
 *    Call Next_Command
 *  Expected result:
 *    The enqueued command should be returned.
 */

/* Test case M-06:
 *  Execute_Next_Command with empty queue
 *  Description:
 *    Call Execute_Next_Command before enqueueing any commands.
 *  Expected result:
 *    Null_Object_Exception
 */

/* Test case M-07:
 *  Execute_Next_Command with Toggle_Emergency_Command enqueued true->false
 *  Description:
 *    Create a Response_Unit with Emergency_Exists == true.
 *    Add Response_Unit to the Response_Unit_DB.
 *    Create a Toggle_Emergency_Command with the unit's Unit_ID.
 *    Enqueue the command.
 *    Call Execute_Next_Command.
 *    Verify the command was executed.
 *  Expected result:
 *    Response_Unit Emergency_Exists should toggle to false.
 */

/* Test case M-08:
 *  Execute_Next_Command with Toggle_Emergency_Command enqueued false->true
 *  Description:
 *    Create a Response_Unit with Emergency_Exists == false.
 *    Add Response_Unit to the Response_Unit_DB.
 *    Create a Toggle_Emergency_Command with the unit's Unit_ID.
 *    Enqueue the command.
 *    Call Execute_Next_Command.
 *    Verify the command was executed.
 *  Expected result:
 *    Response_Unit Emergency_Exists should toggle to true.
 */

/* Test case M-09:
 *  Execute_Next_Command with Set_Unit_Status_Command enqueued.
 *  Description:
 *    Create a Response_Unit, add it to the Response_Unit_DB.
 *    Create a Set_Unit_Status_Command with the unit's Unit_ID.
 *    Enqueue the command.
 *    Call Execute_Next_Command.
 *    Verify the command was executed.
 *  Expected result:
 *    Response_Unit Status should update.
 */

/* Test case M-10:
 *  Execute_Next_Command with Set_Unit_Location_Command enqueued.
 *  Description:
 *    Create a Response_Unit, add it to the Response_Unit_DB.
 *    Create a Set_Unit_Location_Command with the unit's Unit_ID.
 *    Enqueue the command.
 *    Call Execute_Next_Command.
 *    Verify the command was executed.
 *  Expected result:
 *    Response_Unit Location should toggle.
 */

/* Test case M-11:
 *  Execute_Next_Command with Send_Message_To_Operator_Command enqueued.
 *  Description:
 *    Create a Response_Unit, add it to the Response_Unit_DB.
 *    Create a Send_Message_To_Operator_Command with the unit's Unit_ID.
 *    Enqueue the command.
 *    Call Execute_Next_Command.
 *    Verify the command was executed.
 *  Expected result:
 *    Until fully implemented, should write message to stdout.
 */

/* Test case M-12:
 *  Queue_Empty with empty queue
 *  Description:
 *    Call Queue_Empty with an empty queue
 *  Expected result:
 *    true
 */

/* Test case M-13:
 *  Queue_Empty with non-empty queue
 *  Description:
 *    Call Queue_Empty with an non-empty queue
 *  Expected result:
 *    false
 */

/* Test case M-14:
 *  Priority test with 1 of each priority Command (in order)
 *  Description:
 *    Enqueue a valid Toggle_Emergency_Command. (Priority == 1)
 *    Enqueue a valid Set_Unit_Location_Command. (Priority == 2)
 *    Enqueue a valid Send_Message_To_Operator_Command. (Priority == 3)
 *    Call Next_Command 3 times and check priority of each.
 *  Expected result:
 *    Priority 1, then 2, then 3 returned in that order.
 */

/* Test case M-15:
 *  Priority test with 1 of each priority Command (reverse order)
 *  Description:
 *    Enqueue a valid Send_Message_To_Operator_Command. (Priority == 3)
 *    Enqueue a valid Set_Unit_Location_Command. (Priority == 2)
 *    Enqueue a valid Toggle_Emergency_Command. (Priority == 1)
 *    Call Next_Command 3 times and check priority of each.
 *  Expected result:
 *    Priority 1, then 2, then 3 returned in that order.
 */

/* Test case M-16:
 *  Next_Command test with Thread
 *  Description:
 *    Create a Thread to Enqueue 10 valid Toggle_Emergency_Command objects.
 *    Call Next_Command in a loop.
 *    Verify number of commands polled.
 *  Expected result:
 *    All 10 commands should be retrieved.
 */

/* Test case M-17:
 *  Priority test with Thread
 *  Description:
 *    Create a Thread to Enqueue 10 valid Toggle_Emergency_Command objects,
 *      and then 10 valid Toggle_Emergency_Command objects.
 *    Call Next_Command in a loop.
 *    Verify commands polled.
 *  Expected result:
 *    The 10 higher priority commands should be returned first,
 *      then the 10 low priority commands.
 */

/* Test case M-18:
 *  Multiple access on PriorityQueue with Threads (stress test)
 *  Description:
 *    Create a Thread which calls Next_Command in a loop and counts commands.
 *    Create 100 threads which each enqueue 100 commands.
 *    Verify the number of commands polled.
 *  Expected result:
 *    All 10000 commands should be enqueued and retrieved without race conditions.
 */


