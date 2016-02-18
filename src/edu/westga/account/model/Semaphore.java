/**
 * 
 */
package edu.westga.account.model;

/**
 * Class that implements the semaphore concept.
 * 
 * @author danielburkhart
 *
 */
public class Semaphore {

	private int resourceCount;

	/**
	 * Constructor that initializes resource count to parameter.
	 * 
	 * @param resourceCount
	 *            The initial resources in the program.
	 * 
	 * @Precondition: resource count cannot be negative
	 * @Postcondition: a new semaphore object is made.
	 */
	public Semaphore(int resourceCount) {

		if (resourceCount < 0) {
			throw new IllegalArgumentException("Resources must be positive");
		}

		this.resourceCount = resourceCount;

	}

	/**
	 * Increases the amount in the semaphore.
	 * 
	 * @param amount
	 *            The amount to be put in.
	 * 
	 * @Precondition: amount must be positive
	 * @Postcondition: resource count is increased.
	 */
	synchronized public void up(int amount) {

		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}

		this.resourceCount += amount;
		this.notify();
	}

	/**
	 * Decreases the amount in the resources
	 * 
	 * @param amount
	 *            The amount to be removed.
	 * 
	 * @Precondition: amount must be positive.
	 * @Postcondition: resource count is decreased.
	 */
	synchronized public void down(int amount) {

		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}

		while ((this.resourceCount - amount) <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.resourceCount -= amount;

	}

}
