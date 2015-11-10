/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.code.base;

/**
 *
 * @author Hugh
 */
/**
 * This class represents a single response unit (e.g., engine company,
 * prowl car, ambulance.
 * 
 * Exceptions Thrown:  Null_Unit_ID_Exception, Null_Object_Exception
 */
public class Response_Unit {
    public enum Status_Type {Not_In_Service, In_Station, Enroute, On_Scene};
    
    private Location Current_Location;
    private Boolean Emergency_Exists;
    private Status_Type Status;
    private String Response_Unit_ID;
    
    /**
     * This constructs a new Response_Unit.  Unit_ID must not be null, and 
     * Staring_Location must be a valid Location object.
     * 
     * @param Unit_ID
     * @param Starting_Location
     * @throws Null_Unit_ID_Exception
     * @throws Null_Object_Exception
     */
    public Response_Unit (String Unit_ID, Location Starting_Location) 
        throws Null_Unit_ID_Exception, Null_Object_Exception {
        
        if ("".equals(Unit_ID))
           throw new Null_Unit_ID_Exception ();
       
        else if (Starting_Location == null)
            throw new Null_Object_Exception ();
            
        else {
            Emergency_Exists = false;
            Status = Status_Type.Not_In_Service;
            Response_Unit_ID = Unit_ID;
            Current_Location = Starting_Location;
        } //end if (Unit_ID == "")
    } //end Response_Unit
    
    public Boolean Emergency_Exists (){
        return Emergency_Exists;
    } //Emergency_Exists
    
    public Location Current_Location () {
        return Current_Location;
    } //end Current_Locztion
    
    public Status_Type Status () {
        return Status;
    } //end Status
    
    public String Unit_ID () {
        return Response_Unit_ID;
    } //end Unit_ID
    
    public void Set_Emergency (Boolean New_Setting) {
        Emergency_Exists = New_Setting;
    } //end Set_Emergency
    
    public void Set_Location (Location New_Location){
        Current_Location = New_Location;
    } //end Set_Location
    
    public void Set_Status (Status_Type New_Status) {
        Status = New_Status;
    } //end Set_Status
}//end Response_Unit
