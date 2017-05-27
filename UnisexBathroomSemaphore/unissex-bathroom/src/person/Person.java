/*
 * GNU License.
 */
package person;

/**
 * .
 *
 * @author Breno & Patricia
 * @version 26/05/2017
 */
public class Person implements Runnable {

    // Bathroom use time
    protected int bathroomUseTime;
    // Person name
    private String name;

    /**
     * .
     * @param bathroomUseTime
     */
    public Person(int bathroomUseTime, String name) {
        this.bathroomUseTime = bathroomUseTime;
        this.name = name;
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

    public String getName() {
        return name;
    }
}
