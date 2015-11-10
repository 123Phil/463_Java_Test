/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.code.base;

/**
 *
 * @author Hugh
 */
public class Null_Object_Exception extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>Null_Object_Exception</code> without detail message.
     */
    public Null_Object_Exception() {
    }

    /**
     * Constructs an instance of
     * <code>Null_Object_Exception</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public Null_Object_Exception(String msg) {
        super(msg);
    }
    
    /**
     * Constructs an instance of Null_Object_Exception with a message
     * showing the erroneous values
     * 
     * */
    public Null_Object_Exception (Float Latitude, Float Longitude){
        super ("Location " + Latitude + ", " + Longitude + "is not valid");
    }
}
