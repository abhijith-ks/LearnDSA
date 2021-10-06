package io.abhijith.challenges.problems;

/**
 * Implement a job scheduler which takes a function f and an integer n as arguments
 * and calls the function after n milliseconds
 * 
 * @author abhijith-ks
 */

import java.util.Timer;
import java.util.TimerTask;

import io.abhijith.resources.Command;

public class JobScheduler {

	public void findSolution() {
		doAction(new Command() {
			public void execute() {
				System.out.println("Prints something after 1000 ms");
			}
		},1000);
	}
	
	public void doAction(Command command, int n) {
		new Timer().schedule(new TimerTask() {
			public void run() {
				command.execute();
			}
		}, n);
	}

}
