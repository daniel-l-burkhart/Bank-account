/**
 * 
 */
package edu.westga.account.controller;

import java.util.ArrayList;

import edu.westga.account.model.Account;
import edu.westga.account.model.Person;
import edu.westga.account.model.Semaphore;

/**
 * @author danielburkhart
 *
 */
public class AccountController {

	private Account account;
	private Semaphore semaphore;
	private Person sansaStark;
	private Person aryaStark;
	private Person jonSnow;
	private Person jamieLannister;
	private Thread sansaThread;
	private Thread aryaThread;
	private Thread jonThread;
	private Thread jamieThread;
	private ArrayList<Person> people;
	private ArrayList<Thread> peopleThreads;

	/**
	 * 
	 */
	public AccountController() {

		this.account = new Account();
		this.semaphore = new Semaphore(0);

		this.sansaStark = new Person("Sansa Stark", semaphore, account);
		this.aryaStark = new Person("Arya Stark", semaphore, account);
		this.jonSnow = new Person("Jon Snow", semaphore, account);
		this.jamieLannister = new Person("Jamie Lannister", semaphore, account);

		this.people = new ArrayList<Person>();

		this.people.add(sansaStark);
		this.people.add(aryaStark);
		this.people.add(jonSnow);
		this.people.add(jamieLannister);

		this.sansaThread = new Thread(sansaStark);
		this.aryaThread = new Thread(aryaStark);
		this.jonThread = new Thread(jonSnow);
		this.jamieThread = new Thread(jamieLannister);

		this.peopleThreads = new ArrayList<Thread>();

		this.peopleThreads.add(sansaThread);
		this.peopleThreads.add(aryaThread);
		this.peopleThreads.add(jonThread);
		this.peopleThreads.add(jamieThread);

	}

	public void openAccount() {

		System.out.println("Begin");

		this.startThreads();
		this.sleepForFiveSeconds();
		this.stopThreads();

		System.out.println("End");

	}

	private void sleepForFiveSeconds() {

		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void startThreads() {

		for (Thread currentThread : this.peopleThreads) {
			currentThread.start();
		}

	}

	private void stopThreads() {

		for (Person currentPerson : this.people) {
			currentPerson.stop();
		}
	}

}
