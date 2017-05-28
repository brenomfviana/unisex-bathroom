/*
 * GNU License.
 */
package unissexBathroom.person;

import unissexBathroom.bathroom.Bathroom;

/**
 * This class respresents a woman.
 *
 * @author Breno & Patricia
 * @version 27/05/2017
 */
public class Woman extends Person {

    /**
     * Constructor.
     *
     * @param name Person name
     * @param bathroom Bathroom available
     */
    public Woman(String name, Bathroom bathroom) {
        // Parent constructor
        super(name, "woman", bathroom);
    }
}
