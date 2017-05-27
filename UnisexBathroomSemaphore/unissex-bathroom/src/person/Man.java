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
public class Man extends Person {

    /**
     * 
     * @param bathroomUseTime
     * @param name 
     */
    public Man(int bathroomUseTime, String name, Bathroom bRoom) {
        super(bathroomUseTime, name, "men", bRoom);
        System.out.println(name+ " wants to use the bathroom");
    }    
}
