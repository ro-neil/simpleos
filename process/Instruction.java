/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.process;

import simpleos.utilities.BinToHex;

// Represents an instruction to be executed by the Processor
public class Instruction {

    private String opcode;
    private int address;

    
    public Instruction(String opcode, int address) {
        this.opcode = opcode;
        this.address = address;
    }


    /**
     * @return the opcode
     */
    public String getOpcode() {
        return opcode;
    }

    /**
     * @return the address of the data
     */
    public int getAddress() {
        return address;
    }

    // Represents an instruction in a human-readable format
	public String toString() {
		return String.format("%s%03d", BinToHex.convert(opcode), address);
	}
    
    

}
