/*
 * GNU License.
 */
package unisexbathroomsemaphore.person;

/**
 * .
 *
 * @author Breno Viana
 * @version 25/05/2017
 */
public class Person implements Runnable {

    // Bathroom use time
    protected int bathroomUseTime;

    /**
     * .
     * @param bathroomUseTime
     */
    public Person(int bathroomUseTime) {
        this.bathroomUseTime = bathroomUseTime;
    }

    @Override
    public void run() {
        // TODO
    }

    /**
     * .
     */
    public void useBathroom() {
        //
    }
}
