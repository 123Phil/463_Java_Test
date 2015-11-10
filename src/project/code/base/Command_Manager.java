/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.code.base;

import java.util.PriorityQueue;

/**
 *
 * @author Hugh
 * This class manages the queue of commands to be executed.  The commands are
 * the command with the highest priority is returned first.  Within a group of
 * commands with the same priority, the oldest one is returned first.
 * 
 * Throws:
 *  Null_Unit_ID_Exception
 */
public class Command_Manager {
    private PriorityQueue <Command> Queue = new PriorityQueue <> 
            (16, new Command_Comparator ());
    
    /**
     * This subprogram removes and returns the next command on the queue.
     * @return 
     */
    public Command Next_Command () {
        return Queue.poll();
    } //end Next_Command
    
    /**
     * This subprogram adds the specified command to the queue
     */
    public void Enqueue_Command (Command New_Command) {
        Queue.offer (New_Command);
    } //end Enqueue_Command

    /**
     * This subprogram removes and executes the next command on the queue.
     * @throws Null_Unit_ID_Exception 
     */
    public void Execute_Next_Command () throws Null_Unit_ID_Exception {
        Next_Command().Execute();
    } //end Execute_Next_Command ()

    /**
     * This subprogram returns True if the command queue is empty, and False
     * otherwise.
     * @return 
     */
    public Boolean Queue_Empty (){
        return Queue.size() <= 0;
    } //end Queue_Empty
    
} // end Command_Manager
