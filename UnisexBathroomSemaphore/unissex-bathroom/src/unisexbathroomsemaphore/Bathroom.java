/*
 * GNU License.
 */
package unisexbathroomsemaphore;

import java.util.ArrayList;
import java.util.List;
import person.Person;

/**
 * This class respresents the bathroom.
 *
 * @author Patricia 
 * @version 27/05/2017
 */
public class Bathroom {

    // Singleton
    private static Bathroom instance = new Bathroom(10);
    //Using sex
    private String currentSex;
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
        this.currentSex = "";
        users = new ArrayList<>();
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
        //if it is the first person to enter the bathroom
        if(this.isEmpty()){
            currentSex = person.getsex();
        }
        // Check if the bathroom isn't full
        if (!this.isFull() && !this.users.contains(person)){
            
            // Add the person
            this.users.add(person);            
            System.out.println(person.getName() + " entered the bathroom");
            
            // Check if the bathroom is full
            if (this.isFull()) {
                System.out.println("The bathroom is full");
            }
        }
    }

    /**
     * Remove a user from the bathroom.
     *
     * @param person A person
     */
    public void removeUser(Person person) {
        // Check if the bathroom in't empty
        if (!this.isEmpty()) {
            this.users.remove(person);
            System.out.println(person.getName() + " left the bathroom");            
            
            // Check if the bathroom is empty
            if (this.isEmpty()) {
                System.out.println("The bathroon is empty");
                this.currentSex = "";
            }
        }
    }

    /**
     * .
     * @return
     */
    public boolean isFull() {
        return this.capacity == this.users.size();
    }
    
    public String getCurrentSex(){
        return currentSex;
    }
    
    /**
     * .
     * @return
     */
    public boolean isEmpty() {
        return this.users.isEmpty();
    }
    
    public void run(){
        if(this.isEmpty()){
            //recebe pessoa
        }
    }

    @Override
    public String toString() {
        return "Bathroom{" + "currentSex=" + currentSex + ", capacity=" + capacity + ", numberOfUsers=" + this.users.size() + '}';
    }
    
    
}
