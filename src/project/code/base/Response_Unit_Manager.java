
package project.code.base;

import java.util.HashMap;
    

public class Response_Unit_Manager {
    
    private static HashMap<String, Response_Unit> Response_Unit_DB =
            new HashMap<> ();
    
    /**
     * 
     * This subprogram adds a new Response_Unit to the data store.  The
     * new response unit must be valid Response_Unit object and it's ID must be 
     * unique (i.e., must not already exist in the data store.
     * 
     * Exceptions Thrown:  Null_Object_Exception
     */
    public static void Add_Response_Unit (Response_Unit New_Unit) 
            throws Null_Object_Exception, Duplicate_Item_Exception {
        String Unit_ID = New_Unit.Unit_ID ();
        
        if (New_Unit == null)
            throw new Null_Object_Exception ();
        
        else if (Response_Unit_Exists (Unit_ID))
            throw new Duplicate_Item_Exception (Unit_ID);
        
        else
            Response_Unit_DB.put (Unit_ID, New_Unit);
    } //end Add_Response_Unit
    
    /**
     * This subprogram retrieves the Response Unit with the specified name
     * from the data store and returns it to the caller.
     * @param Unit_ID
     * @return Response_Unit
     */
    public static Response_Unit Response_Unit_Named (String Unit_ID) {
        return Response_Unit_DB.get(Unit_ID);
    }// end Response_Unit_Named
    
    /**
     * This subprogram returns True if a Response Unit with the specified
     * name exists in the data store, and False otherwise.
     * @param Unit_ID
     * @return Boolean
     */
    public static boolean Response_Unit_Exists (String Unit_ID) {
        return Response_Unit_DB.containsKey(Unit_ID);
    } // end Response_Unit_Exists
} //end Response_Unit_Manager