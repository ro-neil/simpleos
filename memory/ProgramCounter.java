/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.memory;

// Represents the CPU Program-Counter, that is also a type of Register
public class ProgramCounter extends Register {

    public ProgramCounter(String registerType, int initialValue) {
        super(registerType);
        System.out.println("\nINITIALIZING THE PROGRAM COUNTER ( PC ) ");
        setValue(initialValue);
        System.out.println(toString());
    }


    /**
     * @return current PC value
     */
    public int increment() {
    	int currentValue = (int) getValue(); // The current value of the PC
    	
        setValue(currentValue + 1);
        currentValue = (int) getValue();
        System.out.println(toString());
        return (int) getValue();
    }

    public String toString() {
    	return String.format("\n%s -> %d\n", getType(), getValue());
    }
  

}
