/*
 * GNU License.
 */
package unissexbathroomlock.person;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import unissexbathroomlock.bathroom.Bathroom;

/**
 * This class respresents a person.
 *
 * @author Breno & Patricia
 * @version 29/05/2017
 */
public class Person implements Runnable {

    // Person name
    private final String name;
    // Person sex
    private final Sex sex;
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
    public Person(String name, Sex sex, Bathroom bathroom) {
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
        // System.out.println(this.getName() + " entered the bathroom.");
        if (this.bathroom.isInTheBathroom(this)) {
            try {
                // Spend the time inside
                TimeUnit.SECONDS.sleep((new Random()).nextInt(1) + 1);
                this.canLeave = true;
                System.out.println(getName() + " Done");
            } catch (InterruptedException ex) {
                Logger.getLogger(Person.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Leave the bathroom.
     */
    public void leaveBathroom() {
        // Leave the bathroom
        this.bathroom.removeUser(this);
        // System.out.println(this.getName() + " left the bathroom.");
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
    public Sex getSex() {
        return this.sex;
    }

    @Override
    public void run() {
        System.out.println(this.getName());
        // If the person needs to go to the bathroom
        while (this.needBathroom) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
            }
            // If they want to use
            if ((this.bathroom.getCurrentSex().equals(this.getSex())
                    || this.bathroom.getCurrentSex().equals(Sex.NONE))
                    && !this.bathroom.isFull()
                    && !this.bathroom.isInTheBathroom(this)) {
                this.useBathroom();
            }
            // If they want to leave
            if (this.canLeave) {
                this.leaveBathroom();
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" + "name = " + this.name + ", sex = " + this.sex + '}';
    }
}
