/*
 * GNU License.
 */
package unisexbathroomsemaphore;

import java.util.List;
import unisexbathroomsemaphore.person.Person;

/**
 * This class respresents the bathroom.
 *
 * @author Breno Viana
 * @version 25/05/2017
 */
public class Bathroom {

    // Time of use available (seconds)
    private static int TIME_OF_USE_AVAILABLE = 10;

    // Singleton
    private static Bathroom instance = new Bathroom(10);

    // Bathroom capacity
    private final int capacity;
    // Users list
    private List<Person> users;

    /**
     * Constructor.
     *
     * @param capacity Bathroom capacity
     */
    public Bathroom(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get instance of bathroom.
     *
     * @return Instance of bathroom
     */
    public Bathroom getInstance() {
        return instance;
    }

    /**
     * Add a user in the bathroom.
     *
     * @param person A person
     */
    public void addUser(Person person) {
        // 
    }

    /**
     * Remove a user from the bathroom.
     *
     * @param person A person
     */
    public void removeUser(Person person) {
        // 
    }

    /**
     * .
     * @return
     */
    public boolean isFull() {
        return this.capacity == this.users.size();
    }

    /**
     * .
     * @return
     */
    public boolean isEmpty() {
        return this.users.isEmpty();
    }
}
