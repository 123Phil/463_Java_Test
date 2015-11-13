/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 12 Nov 2015
 */

package project.code.test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import project.code.base.*;
import project.code.base.Response_Unit.Status_Type;


/* Unit under test:
 *   Command_Manager.java
 * 
 * Prerequisites:
 *   Prior to testing, perform tests on the following units:
 *     - Null_Unit_ID_Exception
 *     - Null_Object_Exception
 *     - Duplicate_Item_Exception
 *     - Location
 *     - Response_Unit
 *     - Response_Unit_Manager
 *     - Command
 *     - Toggle_Emergency_Command
 *     - Send_Message_To_Operator_Command
 *     - Set_Unit_Location_Command
 *     - Set_Unit_Status_Command
 *     - Command_Comparator
 *   Data required:
 *     - None
 *   Equipment required:
 *     - None
 *   Note:
 *     - A good portion of these tests are designed to test the abstract parent
 *       Command class, and so some tests defined here are repeated in the fellow
 *       classes which extend Command.
 */



public class Command_Manager_Test {
	
	/* Helper function for some tests which create response units */
	static Response_Unit AddResponseUnit(String s, Location l) {
		Response_Unit ru = null;
		if (l == null) {
			l = new Location(0.0f, 0.0f);
		}
		if (Response_Unit_Manager.Response_Unit_Exists(s)) {
			ru = Response_Unit_Manager.Response_Unit_Named(s);
			ru.Set_Location(l);
			return ru;
		}
		try {
			ru = new Response_Unit(s, l);
		} catch (Null_Object_Exception e) {
			fail("Response unit creation failed.");
		} catch (Null_Unit_ID_Exception e) {
			fail("Response unit creation failed.");
		}
		try {
			Response_Unit_Manager.Add_Response_Unit(ru);
		} catch (Null_Object_Exception e1) {
			fail("Response unit addition failed.");
		} catch (Duplicate_Item_Exception e1) {
			fail("Response unit addition failed.");
		}
		return ru;
	}
			
	
	/* Test case M-01:
	 *  Constructor - Normal conditions
	 *  Description:
	 *    Call the constructor (implicit constructor)
	 *  Expected result:
	 *    A valid instance of Command_Manager should be created
	 */
	@Test
	public void ConstructorNormalTest() {
		Command_Manager com = new Command_Manager();
		assertNotNull(com);
	}
	
	/* Test case M-02:
	 *  Next_Command with empty queue
	 *  Description:
	 *    Call Next_Command before enqueueing any commands.
	 *  Expected result:
	 *    null
	 */
	@Test
	public void NextCommandEmptyTest() {
		Command_Manager comm_mgr = new Command_Manager();
		Command command = comm_mgr.Next_Command();
		assertNull(command);
	}
	
	/* Test case M-03:
	 *  Enqueue_Command with valid command
	 *  Description:
	 *    Enqueue valid Command objects
	 *  Expected result:
	 *    The commands should be enqueued
	 */
	@Test
	public void EnqueueCommandTest() {
		AddResponseUnit("Unit 1", null);
		AddResponseUnit("Unit 2", null);
		AddResponseUnit("Unit 3", null);
		AddResponseUnit("Unit 4", null);
		Command_Manager comm_mgr = new Command_Manager();
		Command command = new Toggle_Emergency_Command("Unit 1");
		comm_mgr.Enqueue_Command(command);
		command = new Set_Unit_Location_Command("Unit 2", new Location(0.0f, 0.0f));
		comm_mgr.Enqueue_Command(command);
		command = new Send_Message_To_Operator_Command("Unit 3", "Example message");
		comm_mgr.Enqueue_Command(command);
		command = new Set_Unit_Status_Command("Unit 4", Status_Type.Enroute);
		comm_mgr.Enqueue_Command(command);
		
		//TODO: verify enqueues?  -test 5 kinda does that...
	}
	
	/* Test case M-04:
	 *  Enqueue_Command with null
	 *  Description:
	 *    Attempt to Enqueue null.
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test
	public void EnqueueNullTest() {
		Command_Manager comm_mgr = new Command_Manager();
		Command command = null;
		try {
			comm_mgr.Enqueue_Command(command);
			fail("Null_Object_Exception should have been thrown.");
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
				e instanceof Null_Object_Exception);
		}
		//TODO: verify queue empty?
	}
		
	/* Test case M-05:
	 *  Next_Command with enqueued command
	 *  Description:
	 *    Enqueue a valid Command object
	 *    Call Next_Command
	 *  Expected result:
	 *    The enqueued command should be returned.
	 */
	@Test
	public void NextCommandTest() {
		Command_Manager comm_mgr = new Command_Manager();
		AddResponseUnit("Unit 5", null);
		Command command = new Toggle_Emergency_Command("Unit 5");
		comm_mgr.Enqueue_Command(command);
		Command command2 = comm_mgr.Next_Command();
		assertEquals("Same object should be polled with Next_Command.", command, command2);
	}
	
	/* Test case M-06:
	 *  Execute_Next_Command with empty queue
	 *  Description:
	 *    Call Execute_Next_Command before enqueueing any commands.
	 *  Expected result:
	 *    Null_Object_Exception
	 */
	@Test
	public void ExecuteNextCommandEmptyTest() {
		Command_Manager comm_mgr = new Command_Manager();
		try {
			comm_mgr.Execute_Next_Command();
		} catch (Throwable e) {
			assertTrue("Should have thrown a Null_Object_Exception",
					e instanceof Null_Object_Exception);
		}
	}
	
	/* Test case M-07:
	 *  Execute_Next_Command with Toggle_Emergency_Command enqueued false->true
	 *  Description:
	 *    Create a Response_Unit with Emergency_Exists == false.
	 *    Add Response_Unit to the Response_Unit_DB.
	 *    Create a Toggle_Emergency_Command with the unit's Unit_ID.
	 *    Enqueue the command.
	 *    Call Execute_Next_Command.
	 *    Verify the command was executed.
	 *  Expected result:
	 *    Response_Unit Emergency_Exists should toggle to true.
	 */
	@Test
	public void NextToggleCommandTest1() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 6", null);
		assertFalse(ru.Emergency_Exists());
		Command command = new Toggle_Emergency_Command("Unit 6");
		comm_mgr.Enqueue_Command(command);
		try {
			comm_mgr.Execute_Next_Command();
		} catch (Throwable e) {
			fail("Execute_Next_Command failed with valid command.");
		}
		assertTrue(ru.Emergency_Exists());
		ru = Response_Unit_Manager.Response_Unit_Named("Unit 6");
		assertTrue(ru.Emergency_Exists());
	}
	
	/* Test case M-08:
	 *  Execute_Next_Command with Toggle_Emergency_Command enqueued true->false
	 *  Description:
	 *    Create a Response_Unit with Emergency_Exists == false.
	 *    Add Response_Unit to the Response_Unit_DB.
	 *    Create a Toggle_Emergency_Command with the unit's Unit_ID.
	 *    Enqueue the command.
	 *    Call Execute_Next_Command.
	 *    Verify the command was executed.
	 *  Expected result:
	 *    Response_Unit Emergency_Exists should toggle to true.
	 */
	@Test
	public void NextToggleCommandTest2() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 7", null);
		ru.Set_Emergency(true);
		assertTrue(ru.Emergency_Exists());
		Command command = new Toggle_Emergency_Command("Unit 7");
		comm_mgr.Enqueue_Command(command);
		try {
			comm_mgr.Execute_Next_Command();
		} catch (Throwable e) {
			fail("Execute_Next_Command failed with valid command.");
		}
		assertFalse(ru.Emergency_Exists());
		ru = Response_Unit_Manager.Response_Unit_Named("Unit 7");
		assertFalse(ru.Emergency_Exists());
	}
	
	/* Test case M-09:
	 *  Execute_Next_Command with Set_Unit_Status_Command enqueued.
	 *  Description:
	 *    Create a Response_Unit, add it to the Response_Unit_DB.
	 *    Create a Set_Unit_Status_Command with the unit's Unit_ID, with status 'Enroute'.
	 *    Enqueue the command.
	 *    Call Execute_Next_Command.
	 *    Verify the command was executed.
	 *    Retry with a Set_Unit_Status_Command with status 'On_Scene'.
	 *  Expected result:
	 *    Response_Unit Status should update.
	 */
	@Test
	public void NextStatusCommandTest() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		Response_Unit ru = AddResponseUnit("Unit 8", null);
		ru.Set_Status(Status_Type.Not_In_Service);
		assertEquals("Initial Status not as expected.", ru.Status(), Status_Type.Not_In_Service);
		Command command = new Set_Unit_Status_Command("Unit 8", Status_Type.Enroute);
		comm_mgr.Enqueue_Command(command);
		try {
			comm_mgr.Execute_Next_Command();
		} catch (Throwable e) {
			fail("Execute_Next_Command failed with valid command.");
		}
		assertEquals("Status should have updated.", ru.Status(), Status_Type.Enroute);
		ru = Response_Unit_Manager.Response_Unit_Named("Unit 8");
		assertEquals("Status should have updated.", ru.Status(), Status_Type.Enroute);
		command = new Set_Unit_Status_Command("Unit 8", Status_Type.On_Scene);
		comm_mgr.Enqueue_Command(command);
		try {
			comm_mgr.Execute_Next_Command();
		} catch (Throwable e) {
			fail("Execute_Next_Command failed with valid command.");
		}
		assertEquals("Status should have updated.", ru.Status(), Status_Type.On_Scene);
		ru = Response_Unit_Manager.Response_Unit_Named("Unit 8");
		assertEquals("Status should have updated.", ru.Status(), Status_Type.On_Scene);
	}

	/* Test case M-10:
	 *  Execute_Next_Command with Set_Unit_Location_Command enqueued.
	 *  Description:
	 *    Create a Response_Unit, add it to the Response_Unit_DB.
	 *    Create a Set_Unit_Location_Command with the unit's Unit_ID.
	 *    Enqueue the command.
	 *    Call Execute_Next_Command.
	 *    Verify the command was executed.
	 *  Expected result:
	 *    Response_Unit Location should toggle.
	 */
	@Test
	public void NextLocationCommandTest() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		Location loc = new Location(5.0f, 5.0f);
		Response_Unit ru = AddResponseUnit("Unit 9", loc);
		assertEquals("Unexpected initial location.", ru.Current_Location(), loc);
		loc = new Location(45.0f, 55.0f);
		Command command = new Set_Unit_Location_Command("Unit 9", loc);
		comm_mgr.Enqueue_Command(command);
		try {
			comm_mgr.Execute_Next_Command();
		} catch (Throwable e) {
			fail("Execute_Next_Command failed with valid command.");
		}
		assertEquals("Location did not update correctly.", ru.Current_Location(), loc);
		ru = Response_Unit_Manager.Response_Unit_Named("Unit 9");
		assertEquals("Location did not update correctly.", ru.Current_Location(), loc);
	}
	
	/* Test case M-11:
	 *  Execute_Next_Command with Send_Message_To_Operator_Command enqueued.
	 *  Description:
	 *    Create a Response_Unit, add it to the Response_Unit_DB.
	 *    Create a Send_Message_To_Operator_Command with the unit's Unit_ID.
	 *    Enqueue the command.
	 *    Call Execute_Next_Command.
	 *    Verify the command was executed.
	 *  Expected result:
	 *    Until fully implemented, should write message to stdout.
	 */
	@Test
	public void NextMessageCommandTest() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		AddResponseUnit("Unit 10", null);
		Command command = new Send_Message_To_Operator_Command("Unit 10", "Example message");
		comm_mgr.Enqueue_Command(command);
		try {
			comm_mgr.Execute_Next_Command();
		} catch (Throwable e) {
			fail("Execute_Next_Command failed with valid command.");
		}
		//Check the console/stdout for the following:
		//  "Message from Unit 10reads Example message"
		//TODO : how to automate in test??
	}
	
	/* Test case M-12:
	 *  Queue_Empty with empty queue
	 *  Description:
	 *    Call Queue_Empty with an empty queue
	 *  Expected result:
	 *    true
	 */
	@Test
	public void EmptyQueueEmptyTest() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		assertTrue("Queue should initially be empty.", comm_mgr.Queue_Empty());
	}
	
	/* Test case M-13:
	 *  Queue_Empty with non-empty queue
	 *  Description:
	 *    Call Queue_Empty with an non-empty queue
	 *  Expected result:
	 *    false
	 */
	@Test
	public void EmptyQueueNonEmptyTest() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		AddResponseUnit("Unit 11", null);
		comm_mgr.Enqueue_Command(new Toggle_Emergency_Command("Unit 11"));
		assertFalse("Queue should not be empty.", comm_mgr.Queue_Empty());
	}
	
	
	/* Test case M-14:
	 *  Priority test with 1 of each priority Command (in order)
	 *  Description:
	 *    Enqueue a valid Toggle_Emergency_Command. (Priority == 1)
	 *    Enqueue a valid Set_Unit_Location_Command. (Priority == 2)
	 *    Enqueue a valid Send_Message_To_Operator_Command. (Priority == 3)
	 *    Call Next_Command 3 times and check priority of each.
	 *  Expected result:
	 *    Priority 1, then 2, then 3 returned in that order.
	 */
	@Test
	public void PriorityTest1() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		AddResponseUnit("Unit 12", null);
		AddResponseUnit("Unit 13", null);
		AddResponseUnit("Unit 14", null);
		comm_mgr.Enqueue_Command(new Toggle_Emergency_Command("Unit 12"));
		comm_mgr.Enqueue_Command(new Set_Unit_Location_Command("Unit 13", new Location(0.0f, 0.0f)));
		comm_mgr.Enqueue_Command(new Send_Message_To_Operator_Command("Unit 14", "This is a message!"));
		Command command = comm_mgr.Next_Command();
		assertEquals("Priority 1 should be first command.", command.Priority(), 1);
		command = comm_mgr.Next_Command();
		assertEquals("Priority 2 should be second command.", command.Priority(), 2);
		command = comm_mgr.Next_Command();
		assertEquals("Priority 2 should be third command.", command.Priority(), 3);
	}
	
	/* Test case M-15:
	 *  Priority test with 1 of each priority Command (reverse order)
	 *  Description:
	 *    Enqueue a valid Send_Message_To_Operator_Command. (Priority == 3)
	 *    Enqueue a valid Set_Unit_Location_Command. (Priority == 2)
	 *    Enqueue a valid Toggle_Emergency_Command. (Priority == 1)
	 *    Call Next_Command 3 times and check priority of each.
	 *  Expected result:
	 *    Priority 1, then 2, then 3 returned in that order.
	 */
	@Test
	public void PriorityTest2() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		AddResponseUnit("Unit 15", null);
		AddResponseUnit("Unit 16", null);
		AddResponseUnit("Unit 17", null);
		comm_mgr.Enqueue_Command(new Send_Message_To_Operator_Command("Unit 15", "This is a message!"));
		comm_mgr.Enqueue_Command(new Set_Unit_Location_Command("Unit 16", new Location(0.0f, 0.0f)));
		comm_mgr.Enqueue_Command(new Toggle_Emergency_Command("Unit 17"));
		Command command = comm_mgr.Next_Command();
		assertEquals("Priority 1 should be first command.", command.Priority(), 1);
		command = comm_mgr.Next_Command();
		assertEquals("Priority 2 should be second command.", command.Priority(), 2);
		command = comm_mgr.Next_Command();
		assertEquals("Priority 3 should be third command.", command.Priority(), 3);
	}
	
	/* Test case M-16:
	 *  Next_Command test with Thread
	 *  Description:
	 *    Create a Thread to Enqueue 10 valid Toggle_Emergency_Command objects.
	 *    Call Next_Command in a loop.
	 *    Verify number of commands polled.
	 *  Expected result:
	 *    All 10 commands should be retrieved.
	 */
	@Test
	public void ThreadPriorityTest1() {
		Command_Manager comm_mgr = new Command_Manager();
		EnqueueThread et = new EnqueueThread(comm_mgr, 1, 10);
		et.run();
		try {
			et.join();
		} catch (InterruptedException e) {
			fail("Thread join error.");
		}
		Command command = null;
		for (int i=0; i < 10; i++) {
			command = comm_mgr.Next_Command();
			assertNotNull("10 Valid commands should have been queued", command);
			assertEquals("Commands should all be priority 1.", command.Priority(), 1);
		}
		assertTrue("Queue should have been emptied.", comm_mgr.Queue_Empty());
	}

	/* Test case M-17:
	 *  Priority test with Thread
	 *  Description:
	 *    Create a Thread to Enqueue 10 valid Toggle_Emergency_Command objects,
	 *      and a Thread to Enqueue 10 valid Set_Unit_Location_Command objects.
	 *    Call Next_Command in a loop.
	 *    Verify commands polled.
	 *  Expected result:
	 *    The 10 higher priority commands should be returned first,
	 *      then the 10 low priority commands.
	 */
	@Test
	public void ThreadPriorityTest2() {
		Command_Manager comm_mgr = new Command_Manager();
		EnqueueThread et1 = new EnqueueThread(comm_mgr, 1, 10);
		EnqueueThread et2 = new EnqueueThread(comm_mgr, 2, 10);
		et1.run();
		et2.run();
		try {
			et1.join();
			et2.join();
		} catch (InterruptedException e) {
			fail("Thread join error.");
		}
		Command command = null;
		for (int i=0; i < 10; i++) {
			command = comm_mgr.Next_Command();
			assertNotNull("10 Valid commands should have been queued", command);
			assertEquals("Commands should all be priority 1.", command.Priority(), 1);
		}
		for (int i=0; i < 10; i++) {
			command = comm_mgr.Next_Command();
			assertNotNull("10 Valid commands should have been queued", command);
			assertEquals("Commands should all be priority 2.", command.Priority(), 2);
		}
		assertTrue("Queue should have been emptied.", comm_mgr.Queue_Empty());
	}
	
	
	/* Test case M-18:
	 *  Multiple access on PriorityQueue with Threads (stress test)
	 *  Description:
	 *    Create a Thread which calls Next_Command in a loop and counts commands.
	 *    Create 100 threads which each enqueue 100 commands.
	 *    Verify the number of commands polled.
	 *  Expected result:
	 *    All 10000 commands should be enqueued and retrieved without race conditions.
	 */
	@Test
	public void ThreadPriorityTest3() {
		Command_Manager comm_mgr = new Command_Manager();
		ArrayList<EnqueueThread> threads = new ArrayList<EnqueueThread>();
		for (int i=0; i<100; i++) {
			EnqueueThread et = new EnqueueThread(comm_mgr, 1, 100);
			threads.add(et);
		}
		int count = 0;
		Command command = null;
		for (int i=0; i<100; i++) {
			threads.get(i).start();
		}
		while (count < 10000) {
			command = comm_mgr.Next_Command();
			if (command != null) {
				count++;
				command = null;
			}
		}
		assertEquals(count, 10000);
		assertTrue("Queue should have been emptied.", comm_mgr.Queue_Empty());
	}
	
	/* Test case M-19:
	 *  Enqueue_Command, Next_Command, and Queue_Empty with high number of Commands
	 *  Description:
	 *    Call Queue_Empty with an empty queue
	 *    Enqueue MANY commands (1,000,000)
	 *    Call Queue_Empty
	 *    Dequeue all commands with Next_Command
	 *    Call Queue_Empty with an non-empty queue
	 *  Expected result:
	 *    true for initial Queue_Empty call
	 *    false for second Queue_Empty call
	 *    true for final Queue_Empty call
	 */
	@Test
	public void QueueStressTest() {
		//Response_Unit_Manager rum = new Response_Unit_Manager();
		Command_Manager comm_mgr = new Command_Manager();
		assertTrue("Queue should start empty.", comm_mgr.Queue_Empty());
		AddResponseUnit("Unit 18", null);
		for (int i=0; i<1000000; i++) {
			comm_mgr.Enqueue_Command(new Toggle_Emergency_Command("Unit 18"));
		}
		assertFalse("Queue should not be empty.", comm_mgr.Queue_Empty());
		Command command = null;
		for (int i=0; i<1000000; i++) {
			command = comm_mgr.Next_Command();
			assertNotNull("Valid command should be dequeued", command);
			command = null;
		}
		assertTrue("Queue should be emptied.", comm_mgr.Queue_Empty());
	}
}//end of Command_Manager_Test
