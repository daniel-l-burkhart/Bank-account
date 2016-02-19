/**
 * 
 */
package edu.westga.account.controller;

import java.util.ArrayList;

import edu.westga.account.model.Account;
import edu.westga.account.model.Person;
import edu.westga.account.model.Semaphore;

/**
 * Controller class that implements all the threads and their applications.
 * 
 * @author danielburkhart
 * @version Spring 2016
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
	 * Initializes all variables and collections.
	 */
	public AccountController() {

		this.initializeVariables();
		this.populatePeopleAndThreads();
	}

	private void initializeVariables() {

		this.account = new Account();
		this.semaphore = new Semaphore(0);

		this.sansaStark = new Person("Sansa Stark", this.semaphore, this.account);
		this.aryaStark = new Person("Arya Stark", this.semaphore, this.account);
		this.jonSnow = new Person("Jon Snow", this.semaphore, this.account);
		this.jamieLannister = new Person("Jamie Lannister", this.semaphore, this.account);

		this.people = new ArrayList<Person>();
		this.peopleThreads = new ArrayList<Thread>();

		this.sansaThread = new Thread(this.sansaStark);
		this.aryaThread = new Thread(this.aryaStark);
		this.jonThread = new Thread(this.jonSnow);
		this.jamieThread = new Thread(this.jamieLannister);

	}

	private void populatePeopleAndThreads() {

		this.people.add(this.sansaStark);
		this.people.add(this.aryaStark);
		this.people.add(this.jonSnow);
		this.people.add(this.jamieLannister);

		this.peopleThreads.add(this.sansaThread);
		this.peopleThreads.add(this.aryaThread);
		this.peopleThreads.add(this.jonThread);
		this.peopleThreads.add(this.jamieThread);

	}

	/**
	 * Begins threads, sleeps for five seconds, and stops threads.
	 */
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
		} catch (InterruptedException exception) {
			exception.printStackTrace();
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
