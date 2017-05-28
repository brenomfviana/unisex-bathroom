/*
 * GNU License.
 */
package unisexbathroomsemaphore;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import unisexbathroomsemaphore.person.Man;
import unisexbathroomsemaphore.person.Woman;
import unisexbathroomsemaphore.person.Person;
import unisexbathroomsemaphore.bathroom.Bathroom;

/**
 * This is the main class of Unisex Bathroom.
 *
 * @author Breno & Patricia
 * @version 27/05/2017
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Bathroom
        Bathroom bathroom = Bathroom.getInstance();
        // Person list
        List<Person> users = new ArrayList<>();
        // Creates people
        for (int i = 0; i < ((new Random()).nextInt(3) + 5); i++) {
            // Creates man and woman
            if (new Random().nextInt(2) == 0) {
                // Creates man
                users.add(new Man(("João" + i), bathroom));
            } else {
                // Creates woman
                users.add(new Woman(("Maria" + i), bathroom));
            }
        }
        // Stats persons
        users.stream().map((Person) -> new Thread(Person)).forEach((t) -> {
            t.start();
        });
    }
}
