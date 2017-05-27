/*
 * GNU License.
 */
package unisexbathroomsemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import person.Man;
import person.Person;
import person.Woman;

/**
 * .
 *
 * @author Patricia
 * @version 27/05/2017
 */
public class Main {
    // Bathroom
    private static Bathroom bRoom = new Bathroom(3);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> users = new ArrayList<>();
        
        // Creates people
        for (int i = 0; i < ((new Random()).nextInt(3) + 3); i++) {
            
            // Creates man and woman
            if(new Random().nextInt(2) == 0){
                // Creates men
                users.add( new Man( (new Random().nextInt(10)+1), ("joão"+ i), bRoom));
            }
            else{
                // Creates woman
                users.add( new Woman( (new Random().nextInt(10)+1), ("Maria"+ i), bRoom));
            }
        }
        // Stats persons
        users.stream().map((Person) -> new Thread(Person)).forEach((t) -> {
            t.start();
        });
        
    }

}
