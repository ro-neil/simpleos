/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.memory;

// Represents the CPU Accumulator, that is also a type of Register
public class Accumulator extends Register {

    public Accumulator(String registerType) {
        super(registerType);
        setValue(0);    // sets default AC value to zero
    }


    /**
     * @param int value 
     * @return the current AC value
     */
    public int update(int newValue) {
    	int currentValue = (int) getValue(); // The current value of the AC
    	
        setValue(currentValue + newValue);
        currentValue = (int) getValue();
        return (int) getValue();
    }

}
