/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.code.base;

/**
 *
 * @author Hugh
 */
public class Set_Unit_Status_Command extends Command {
    private Response_Unit.Status_Type New_Status;
    
    @Override
    public void Execute () throws Null_Unit_ID_Exception {
        Response_Unit Subject_Unit;
        
        Subject_Unit = Response_Unit_Manager.Response_Unit_Named(Unit_ID);
        
        if (Subject_Unit == null)
            throw new Null_Unit_ID_Exception (Unit_ID);
        
        else
            Subject_Unit.Set_Status (New_Status);
    } //end Execute
    
    public Set_Unit_Status_Command (String Unit_ID, 
                                    Response_Unit.Status_Type Desired_Status) {
        super (2, Unit_ID);
        New_Status = Desired_Status;
    } //end Set_Unit_Status_Command
    
} //end Set_Unit_Status_Command
