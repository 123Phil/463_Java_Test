package project.code.base;

/**
 *
 * @author Hugh
 */
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
            
    //This subprogram returns the value of the current Location's latitude
    //field.
    //
    //Exceptions thrown:  None
    //
    public float Current_Latitude () {
        return Latitude;
    } //end Current_Latitude
    
    //This subprogram returns the value of the current Location's longitude
    //field.
    //
    //Exceptions thrown:  None
    //
    public float Current_Longitude () {
        return Longitude;
    } //end Current_Longitude
    
    //This subprogram is the constructor for the Location class.  It validates
    //the supplied latitude and longitude before creating the new object.
    //
    //Exceptions propagated:  Null_Object_Exception
    //
    public Location (float New_Latitude, float New_Longitude) throws 
            Null_Object_Exception {
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
       if (New_Latitude < -90 | New_Latitude > 90 | New_Longitude < -180 |
          New_Longitude > 180)
               throw new Null_Object_Exception (New_Latitude, 
                       New_Longitude);
       
       else {
           Latitude = New_Latitude;
           Longitude = New_Longitude;
       } //end if (New_Latitude ...
    } //end Set_Location
   } //end Location class
