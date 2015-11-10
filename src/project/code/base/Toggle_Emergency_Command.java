/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.code.base;

/**
 *
 * @author Hugh
 */
public class Toggle_Emergency_Command extends Command {
    
    @Override
    public void Execute () throws Null_Unit_ID_Exception {
        Response_Unit Subject_Unit;
        
        Subject_Unit = Response_Unit_Manager.Response_Unit_Named(Unit_ID);
        
        if (Subject_Unit == null)
            throw new Null_Unit_ID_Exception (Unit_ID);
        
        else
            Subject_Unit.Set_Emergency (!Subject_Unit.Emergency_Exists());
    } //end Execute
    
    public Toggle_Emergency_Command (String Unit_ID) {
        super (1, Unit_ID);
    } //end Toggle_Emergency_Command
} //end Toggle_Emergency_Command
