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


//This class is used to represent terrestial locations using latitude and 
//longitude in decimal degrees (e.g., 30.25 degrees instead of 30 degrees, 15 
//seconds). Positive values denote North latitude or East longitude; negative 
//values denote South latitude or West longitude.
//
//Exceptions Thrown:
//  Null_Object_Exception:  An attempt is made to set a Location with 
//                     either a latitude < -90 or > 90, or a longitude < -180 
//                     or > 180
public class Location {
    private float Latitude;
    private float Longitude;

    public float Current_Latitude () {
        return Latitude;
    }
    
    public float Current_Longitude () {
        return Longitude;
    }
    
    //This subprogram is the constructor for the Location class.  It validates
    //the supplied latitude and longitude before creating the new object.
    //
    //Exceptions propagated:  Null_Object_Exception
    //
    public Location (float New_Latitude, float New_Longitude) throws Null_Object_Exception {
        Set_Location (New_Latitude, New_Longitude);        
    } //end Location

    //This subprogram sets the value of the current Location object to have
    //the specified latitude and longitude.  The supplied values are validated
    //before the object is updated.
    //
    //Exceptions thrown:  Null_Object_Exception
    //
    public final void Set_Location(float New_Latitude, float New_Longitude) 
        throws Null_Object_Exception {
       if (New_Latitude < -90 | New_Latitude > 90 | New_Longitude < -180 | New_Longitude > 180) {
               throw new Null_Object_Exception (New_Latitude, New_Longitude);
       }
       else {
           Latitude = New_Latitude;
           Longitude = New_Longitude;
       }
    } //end Set_Location
} //end Location class
