/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.code.base;

/**
 *
 * @author Hugh
 */
public class Set_Unit_Location_Command extends Command {
    private Location New_Location;
    
    @Override
    public void Execute () throws Null_Unit_ID_Exception {
        Response_Unit Subject_Unit;
        
        Subject_Unit = Response_Unit_Manager.Response_Unit_Named(Unit_ID);
        
        if (Subject_Unit == null)
            throw new Null_Unit_ID_Exception (Unit_ID);
        
        else
            Subject_Unit.Set_Location (New_Location);
    } //end Execute
    
    public Set_Unit_Location_Command (String Unit_ID, Location Updated_Location){
        super (2, Unit_ID);
        New_Location = Updated_Location;
    } //end Set_Unit_Location_Command
    
} //end Set_Unit_Location_Command
