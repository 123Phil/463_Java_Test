package project.code.test;
/* CPSC 463, Fall 2015 - Prof. Greenbaum
 * Team: Quality Assured
 * Members: Phillip Stewart, Timothy Ater, Kenneth Gunderson
 * Last date modified: 12 Nov 2015
 */

/* This Class is an extension of Thread,
 *   it is used by Command_Manager_Test for threaded tests.
 */

import project.code.base.*;


public class EnqueueThread extends Thread {
	private Command_Manager comm_mgr;
	private int priority;
	private int num_to_enqeue;

	public EnqueueThread(Command_Manager cm, int p, int num) {
		this.comm_mgr = cm;
		this.priority = p;
		this.num_to_enqeue = num;
		Command_Manager_Test.AddResponseUnit("Thread Unit", null);
	}

    public void run() {
        Command command = null;
		for (int i=0; i < this.num_to_enqeue; i++) {
			switch(this.priority) {
				case 1:
					command = new Toggle_Emergency_Command("Thread Unit");
					break;
				case 2:
					command = new Set_Unit_Location_Command("Thread Unit", new Location(0.0f, 0.0f));
					break;
				case 3:
					command = new Send_Message_To_Operator_Command("Thread Unit", "message");
					break;
				default:
					//oops!
					i = this.num_to_enqeue;
					break;
			}
			comm_mgr.Enqueue_Command(command);
		}
		
		
    }

    //(new HelloThread()).start();

}

