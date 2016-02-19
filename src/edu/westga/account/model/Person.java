package edu.westga.account.model;

/**
 * 
 * Person class that manipulates account.
 * 
 * @author danielburkhart
 * @version Spring 2016
 */
public class Person implements Runnable {

	private boolean keepWorking;
	private Semaphore mutex;
	private String name;
	private Account account;
	private int randomValue;

	/**
	 * Initializes variables.
	 * 
	 * @param name
	 *            The name of the person.
	 * @param mutex
	 *            The mutex of the account.
	 * @param account
	 *            The account.
	 * 
	 * @Preconditon: name, mutex and account cannot be null.
	 * @Postcondition: a person object is created.
	 */
	public Person(String name, Semaphore mutex, Account account) {

		if (name == null) {
			throw new IllegalArgumentException("Name is null");
		} else if (mutex == null) {
			throw new IllegalArgumentException("mutex is null");
		} else if (account == null) {
			throw new IllegalArgumentException("Account is null");
		}

		this.mutex = mutex;
		this.name = name;
		this.account = account;
		this.keepWorking = true;

	}

	/**
	 * Run method for the thread of each person
	 */
	@Override
	public void run() {

		while (this.keepWorking) {

			this.getRandomValue();
			this.evaluateRandom();
			this.sleepForHalfSecond();

		}
	}

	private void getRandomValue() {
		this.randomValue = (int) Math.floor((Math.random() * 21 - 10));
	}

	private void evaluateRandom() {

		if (this.randomValue > 0) {

			this.makeDeposit();

		} else if (this.randomValue < 0) {

			this.makeWithdrawl();
		}
	}

	private void makeDeposit() {

		this.mutex.up(this.randomValue);

		this.account.addFunds(this.randomValue);

		System.out.println(this.name + " adds " + this.randomValue);
		System.out.println(this.account.toString());

	}

	private void makeWithdrawl() {

		this.mutex.down(this.negateValue(this.randomValue));

		this.account.subtractFunds(this.negateValue(this.randomValue));

		System.out.println(this.name + " takes " + this.negateValue(this.randomValue));
		System.out.println(this.account.toString());

	}

	private void sleepForHalfSecond() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

	}

	private int negateValue(int value) {
		return -value;
	}

	/**
	 * Method to stop thread's otherwise infinite run
	 */
	public void stop() {
		this.keepWorking = false;
	}

}
