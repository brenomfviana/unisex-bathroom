/*
 * GNU License.
 */
package person;

import unisexbathroomsemaphore.Bathroom;

/**
 * .
 *
 * @author Breno & Patricia
 * @version 27/05/2017
 */
public class Woman extends Person {
    /**
     * 
     * @param bathroomUseTime
     * @param name 
     */
    public Woman(int bathroomUseTime, String name, Bathroom bRoom) {                
        super(bathroomUseTime, name, "woman", bRoom);
        System.out.println(name+ " wants to use the bathroom");
    }
}
