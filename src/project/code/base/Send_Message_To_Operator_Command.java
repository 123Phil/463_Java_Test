/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.code.base;

/**
 *
 * @author Hugh
 */
public class Send_Message_To_Operator_Command extends Command {
    private String Operator_Message;
    
    @Override
    public void Execute () throws Null_Unit_ID_Exception {
        Response_Unit Subject_Unit;
        
        Subject_Unit = Response_Unit_Manager.Response_Unit_Named(Unit_ID);
        
        if (Subject_Unit == null)
            throw new Null_Unit_ID_Exception (Unit_ID);
        
        else
            //Temporary implementation until the operator message capability
            //is finished
            System.out.println ("Message from " + Unit_ID + "reads " +
                                Operator_Message);
    } //end Execute
    
    public Send_Message_To_Operator_Command (String Unit_ID, String Message) {
        super (3, Unit_ID);
        Operator_Message = Message;
    } //end Set_Unit_Status_Command
    
}
