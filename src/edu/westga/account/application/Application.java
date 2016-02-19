/**
 * 
 */
package edu.westga.account.application;

import edu.westga.account.controller.AccountController;

/**
 * Application class that contains main method.
 * 
 * @author danielburkhart
 * @version Spring 2016
 */
public class Application {

	/**
	 * Main method that serves as the entry point to the program.
	 * 
	 * @param args
	 *            The arguments passed in.
	 */
	public static void main(String[] args) {

		AccountController controller = new AccountController();
		controller.openAccount();

	}

}
