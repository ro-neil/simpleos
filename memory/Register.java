/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.memory;

// Represents a general purpose CPU register
public class Register {
	
	private Object[] space;	// the register space
	private String type;
	
	public Register(String registerType) {
		type = registerType;	// the name of the register
		space = new Object[1];	// register holds only a single value
	}

    /**
     * @param int value 
     */
    public void setValue(Object value) {
        space[0] = value;
    }

    /**
     * @return the object contained in the register space
     */
    public Object getValue() {
        return space[0];
    }

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

}
