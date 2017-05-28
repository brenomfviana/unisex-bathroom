/*
 * GNU License.
 */
package unisexbathroomsemaphore.person;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import unisexbathroomsemaphore.bathroom.Bathroom;

/**
 * This class respresents a person.
 *
 * @author Breno & Patricia
 * @version 27/05/2017
 */
public class Person implements Runnable {

    // Person name
    private final String name;
    // Person sex
    private final String sex;
    // Bathroom
    private final Bathroom bathroom;
    // Can leave
    private boolean canLeave;
    // Need to go to the bathroom
    private boolean needBathroom;

    /**
     * Constructor.
     *
     * @param name Person name
     * @param sex Person sex
     * @param bathroom Bathroom available to use
     */
    public Person(String name, String sex, Bathroom bathroom) {
        this.name = name;
        this.sex = sex;
        this.bathroom = bathroom;
        this.canLeave = false;
        this.needBathroom = true;
    }

    /**
     * Use the bathroom.
     */
    public void useBathroom() {
        // Enter the bathroom
        this.bathroom.addUser(this);
        System.out.println(this.getName() + " entered the bathroom.");
        try {
            // Spend the time inside
            TimeUnit.SECONDS.sleep((new Random()).nextInt(3) + 4);
            this.canLeave = true;
        } catch (InterruptedException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Leave the bathroom.
     */
    public void leaveBathroom() {
        // Leave the bathroom
        this.bathroom.removeUser(this);
        System.out.println(this.getName() + " left the bathroom.");
        this.canLeave = false;
        this.needBathroom = false;
    }

    /**
     * Get person name.
     *
     * @return Person name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get person sex.
     *
     * @return Person sex
     */
    public String getsex() {
        return this.sex;
    }

    @Override
    public String toString() {
        return "Person{" + "name = " + this.name + ", sex = " + this.sex
                + ", bathroom = " + this.bathroom + '}';
    }

    @Override
    public void run() {
        // If the person needs to go to the bathroom
        while (this.needBathroom) {
            // If they want to use
            if ((this.bathroom.getCurrentSex().equals(this.sex)
                    || this.bathroom.getCurrentSex().equals(""))
                    && !this.bathroom.isFull()) {
                this.useBathroom();
            } // If they want to leave
            else if (this.canLeave) {
                this.leaveBathroom();
            }
        }
    }
}
