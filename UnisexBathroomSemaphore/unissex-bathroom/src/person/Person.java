/*
 * GNU License.
 */
package person;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import unisexbathroomsemaphore.Bathroom;

/**
 * .
 *
 * @author Breno & Patricia
 * @version 27/05/2017
 */
public class Person implements Runnable {

    // Bathroom use time
    protected int bathroomUseTime;
    // Person name
    private String name;
    // Person sex
    private String sex;
    // Bathroom
    private Bathroom bRoom;
    // Can leave
    private boolean canLeave;
    // Need to go to the bathroom
    private boolean needBRoom;
    

    /**
     * .
     * @param bathroomUseTime
     */
    public Person(int bathroomUseTime, String name, String sex, Bathroom bRoom) {
        this.bathroomUseTime = bathroomUseTime;
        this.sex = sex;
        this.name = name;
        this.bRoom = bRoom;
        this.canLeave = false;
        this.needBRoom = true;
    }

    @Override
    public void run() {
        //if the person needs to go to the bathroom
        while(needBRoom){
            //if they want to use
            if((bRoom.getCurrentSex().equals(this.sex) || bRoom.getCurrentSex().equals(""))&& !bRoom.isFull()){
                this.useBathroom();
            }

            //if they want to leave
            else if(canLeave){
                this.leaveBathroom();
            }
        }
    }

    /**
     * Leave the bathroom
     */
    public void leaveBathroom() {
        // leave the bRoom
        this.bRoom.removeUser(this);
        System.out.println(bRoom);
        
        this.canLeave = false;
        this.needBRoom = false;
    }
    
    /**
     * Use the bathroom
     */
    public void useBathroom() {
        //enter the bRoom
        this.bRoom.addUser(this);
        System.out.println(bRoom);
        
        try {
            // spend the time inside
            TimeUnit.SECONDS.sleep(bathroomUseTime);
            this.canLeave = true;
        } catch (InterruptedException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getName() {
        return name;
    }
    
    public String getsex(){
        return sex;
    }
}
