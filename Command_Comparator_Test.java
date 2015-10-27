/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 04 Oct 2015
 */

/* Unit under test:
 *   Command_Comparator.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Command.java (and its prereqs)
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 */


//TODO: can the Comparator be constructed??
//TODO: number these

/* Test case ?:
 *  Command_Comparator constructor test - Normal conditions
 *  Description:
 *    Call the constructor with ...
 *  Expected result:
 *    A valid Command instance
 *    No exceptions expected
 */

/* Test case ?:
 *  Command_Comparator constructor test - abnormal conditions
 *  Description:
 *    Umm, call the constructor with ...
 *  Expected result:
 *    Exception
 */

/* Test case ?:
 *  Command.compare with equal priorities
 *  Description:
 *    Test comparator with Command1 priority == Command2 priority
 *  Expected result:
 *    compare returns 0
 *    No exceptions expected
 */

/* Test case ?:
 *  Command.compare with priority 1 > priority 2
 *  Description:
 *    Test comparator with Command1 priority > Command2 priority
 *  Expected result:
 *    compare returns >0
 *    No exceptions expected
 */

/* Test case ?:
 *  Command.compare with priority 1 < priority 2
 *  Description:
 *    Test comparator with Command1 priority < Command2 priority
 *  Expected result:
 *    compare returns <0
 *    No exceptions expected
 */

/* Test case ?:
 *  Command.compare with null Command objects
 *  Description:
 *    Test comparator with:
 *    -Command1 null
 *    -Command2 null
 *    -Command1 null and Command2 null
 *  Expected result:
 *    Any null comparison should throw a Null_Object_ID_Exception
 */

//TODO: result on these 4 cases:
/* Test case ?:
 *  Command.compare with priority 1 == priority 2 with negative values
 *  Description:
 *    Test comparator with negative values
 *  Expected result:
 *    Do we allow values outside the priorities {0, 1, 2} ??
 *    if so, compare returns 0
 */

/* Test case ?:
 *  Command.compare with priority 1 < priority 2 with negative values
 *  Description:
 *    Test comparator with negative values
 *  Expected result:
 *    Do we allow values outside the priorities {0, 1, 2} ??
 *    if so, compare returns <0
 */

/* Test case ?:
 *  Command.compare with priority 1 > priority 2 with negative values
 *  Description:
 *    Test comparator with negative values
 *  Expected result:
 *    Do we allow values outside the priorities {0, 1, 2} ??
 *    if so, compare returns >0
 */

/* Test case ?:
 *  Command.compare with priority 1 == priority 2 == MAX_INT
 *  Description:
 *    Test comparator with MAX_INT
 *  Expected result:
 *    Do we allow values outside the priorities {0, 1, 2} ??
 *    if so, compare returns 0
 */


