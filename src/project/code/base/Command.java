/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.code.base;

/**
 *
 * @author Hugh
 */
public abstract class Command {
    protected Integer Priority;
    protected String  Unit_ID;
    
    /**
     * This subprogram is the constructor for the Command class
     * 
     * @param Initial_Priority
     * @param Initial_Unit_ID 
     */
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
     * @param Right_Side
     * @return 
     */
    public boolean Is_Higher_Priority_Then (Command Right_Side) {
        return Priority > Right_Side.Priority;
    } //end Is_Higher_Priority
    
    /**
     * This subprogram returns the Command's current Priority value
     * @return 
     */
    public final int Priority() {
        return Priority;
    } //end Priority
    
    /**
     * This subprogram sets the value of the Priority attribute.
     * @param New_Priority 
     */
    public final void Set_Priority (Integer New_Priority) {
        Priority = New_Priority;
    } //end Set_Priority
    
    /**
     * This subprogram sets the value of the Unit_ID attribute
     * @param New_Unit_ID 
     */
    public final void Set_Unit_ID (String New_Unit_ID) {
        Unit_ID = New_Unit_ID;
    } //end Set_Unit_ID
    
    /**
     * This subprogram returns the Command's current Unit_ID value
     *
     */
    public final String Unit_ID () {
        return Unit_ID;
    } //end Unit_ID
} //end Command
