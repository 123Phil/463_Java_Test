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
    
    public Boolean Emergency_Exists () {
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
