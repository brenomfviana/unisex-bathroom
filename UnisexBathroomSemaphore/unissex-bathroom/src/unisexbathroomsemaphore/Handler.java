/*
 * GNU License.
 */
package unisexbathroomsemaphore;

import person.Man;
import person.Woman;
import person.Person;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
/**
 * .
 *
 * @author Patricia
 * @version 26/05/2017
 */
public class Handler {
    // Bathroom
    private static Bathroom broom = new Bathroom(3);
        
    public void run(){
        List<Person> users = new ArrayList<>();
        
        // Creates people
        for (int i = 0; i < ((new Random()).nextInt(1) + 2); i++) {
            
            // Creates man and woman
            if(new Random().nextInt(2) == 0){
                // Creates men
                users.add( new Man( (new Random().nextInt(10)+1), ("joão"+ i) ));
            }
            else{
                // Creates woman
                users.add( new Woman( (new Random().nextInt(10)+1), ("Maria"+ i) ));
            }
        }
        // Stats persons
        users.stream().map((passenger) -> new Thread(passenger)).forEach((t) -> {
            t.start();
        });
    }
    
    
}
