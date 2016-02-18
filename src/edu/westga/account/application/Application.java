/**
 * 
 */
package edu.westga.account.application;

import edu.westga.account.controller.AccountController;

/**
 * @author danielburkhart
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AccountController controller = new AccountController();
		controller.openAccount();


	}

}
