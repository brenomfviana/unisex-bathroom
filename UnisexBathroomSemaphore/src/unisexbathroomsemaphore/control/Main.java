/*
 * GNU License.
 */
package unisexbathroomsemaphore.control;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import unisexbathroomsemaphore.person.Sex;
import unisexbathroomsemaphore.person.Person;
import unisexbathroomsemaphore.bathroom.Bathroom;

/**
 * This is the main class of Unisex Bathroom.
 *
 * @author Breno & Patricia
 * @version 29/05/2017
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
        for (int i = 0; i < ((new Random()).nextInt(10) + 15); i++) {
            // Creates man and woman
            if (new Random().nextInt(2) == 0) {
                // Creates man
                users.add(new Person(("João" + i), Sex.MAN, bathroom));
            } else {
                // Creates woman
                users.add(new Person(("Maria" + i), Sex.WOMAN, bathroom));
            }
        }
        // Stats persons
        users.stream().map((Person) -> new Thread(Person)).forEach((t) -> {
            t.start();
        });
        //
        users.stream().map((Person) -> new Thread(Person)).forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
