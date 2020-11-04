/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.memory;

import simpleos.process.Instruction;

// Represents the CPU Instruction-Register, that is also a type of Register
public class InstructionRegister extends Register {

    public InstructionRegister(String registerType) {
    	super(registerType);
    }


    /**
     * @param Instruction instruction
     */
    public void loadInstruction(Instruction instruction) {
        setValue(instruction);
        System.out.printf("Instruction %s loaded into %s\n", instruction, getType());
    }


}
