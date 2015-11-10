/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.code.base;

/**
 *
 * @author Hugh
 */
import java.util.Comparator;

    /**
     * This class implements a comparator for the Command type
     */
    public class Command_Comparator implements Comparator <Command>
    {
        /**
         * This subprogram returns a positive value if Command1's
         * Priority is greater than Command2's, a negative value if
         * Command2's is greater than Command1's, and zero if their Priority
         * values are equal.
         * 
         * @param Command1
         * @param Command2
         * @return 
         */
        @Override
        public int compare (Command Command1, Command Command2) {
            return Command1.Priority() - Command2.Priority ();
        }//end compare
    } // end Command_Comparator
