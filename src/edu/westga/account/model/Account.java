package edu.westga.account.model;

/**
 * Account class that deposits and withdraws funds.
 * 
 * @author Daniel Burkhart
 * @version Spring 2016.
 */
public class Account {

	private int balance;

	/**
	 * Initializes the account to a balance of 0.
	 */
	public Account() {

		this.balance = 0;
	}

	/**
	 * Adds funds to account
	 * 
	 * @param funds
	 *            The funds to be added.
	 * 
	 * @Precondition: funds > 0
	 * @Postcondition: balance is increased by the amount of funds..
	 */
	public void addFunds(int funds) {

		if (funds < 0) {
			throw new IllegalArgumentException("funds cannot be negative");
		}

		this.balance += funds;

	}

	/**
	 * Subtracts funds from account
	 * 
	 * @param funds
	 *            The funds to be withdrew
	 * 
	 * @Precondition: funds > 0
	 * @Postcondition: balance is decreased by the amount of funds.
	 */
	public void subtractFunds(int funds) {

		if (funds < 0) {
			throw new IllegalArgumentException("funds cannot be negative");
		}

		this.balance -= funds;

	}

	/**
	 * Returns a string representation of the balance.
	 * 
	 * @return a string containing the current balance of the account.
	 */
	public String toString() {
		return "New Balance is " + this.balance + "\n";
	}

}
