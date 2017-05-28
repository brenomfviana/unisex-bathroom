/*
 * GNU License.
 */
package unisexbathroomsemaphore.person;

import unisexbathroomsemaphore.bathroom.Bathroom;

/**
 * This class respresents a man.
 *
 * @author Breno & Patricia
 * @version 27/05/2017
 */
public class Man extends Person {

    /**
     * Constructor.
     *
     * @param name Person name
     * @param bathroom Bathroom available to use
     */
    public Man(String name, Bathroom bathroom) {
        // Parent constructor
        super(name, "men", bathroom);
    }
}
