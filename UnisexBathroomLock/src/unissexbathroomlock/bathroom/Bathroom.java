/*
 * GNU License.
 */
package unissexbathroomlock.bathroom;

import java.util.LinkedHashSet;
import unissexbathroomlock.person.Sex;
import unissexbathroomlock.person.Person;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class respresents the bathroom.
 *
 * @author Breno & Patricia
 * @version 29/05/2017
 */
public class Bathroom {

    // Bathroom capacity
    private static final int CAPACITY = 5;

    // Singleton
    private static Bathroom instance = new Bathroom(CAPACITY);
    //Using sex
    private Sex currentSex;
    // Bathroom capacity
    private final int capacity;
    // Users list
    private LinkedHashSet<Person> users;
    // Lock
    private Lock lock = new ReentrantLock();

    /**
     * Constructor.
     *
     * @param capacity Bathroom capacity
     */
    public Bathroom(int capacity) {
        this.capacity = capacity;
        this.currentSex = Sex.NONE;
        this.users = new LinkedHashSet<>();
    }

    /**
     * Get instance of bathroom.
     *
     * @return Instance of bathroom
     */
    public static Bathroom getInstance() {
        return instance;
    }

    /**
     * Add a user in the bathroom.
     *
     * @param person A person
     */
    public void addUser(Person person) {
        this.lock.lock();
        try {
            //if it is the first person to enter the bathroom
            if (this.isEmpty()) {
                this.currentSex = person.getSex();
            }
            // Check if the bathroom isn't full
            if (!this.isFull() && !this.users.contains(person)
                    && getCurrentSex().equals(person.getSex())) {
                // Add the person
                if (this.users.add(person)) {
                    System.out.println(person.getName() + " entered the bathroom");
                }
                // Check if the bathroom is full
                if (this.isFull()) {
                    System.out.println("The bathroom is full");
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /**
     * Remove a user from the bathroom.
     *
     * @param person A person
     */
    public void removeUser(Person person) {
        this.lock.lock();
        try {
            // Check if the bathroom in't empty
            if (!this.isEmpty()) {
                if (this.users.remove(person)) {
                    System.out.println(person.getName() + " left the bathroom");
                }
                // Check if the bathroom is empty
                if (this.isEmpty()) {
                    System.out.println("The bathroon is empty");
                    this.currentSex = Sex.NONE;
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /**
     * Get true if the selected person is in the bathroom and false otherwise.
     *
     * @param person A person
     * @return True if the selected person is in the bathroom and false
     * otherwise
     */
    public boolean isInTheBathroom(Person person) {
        return this.users.contains(person);
    }

    /**
     * Get true if the bathroom is full and false otherwise.
     *
     * @return True if the bathroom is full and false otherwise
     */
    public boolean isFull() {
        return this.capacity == this.users.size();
    }

    /**
     * Get true if the bathroom is full and false otherwise.
     *
     * @return True if the bathroom is full and false otherwise
     */
    public boolean isEmpty() {
        return this.users.isEmpty();
    }

    /**
     * Get current sex.
     *
     * @return Current sex
     */
    public Sex getCurrentSex() {
        return this.currentSex;
    }

    @Override
    public String toString() {
        return "Bathroom{" + "currentSex = " + this.currentSex
                + ", capacity = " + this.capacity
                + ", numberOfUsers = " + this.users.size() + '}';
    }
}
