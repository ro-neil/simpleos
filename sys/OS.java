/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.sys;

import simpleos.memory.*;
import simpleos.process.*;
import simpleos.processor.*;


public class OS {
	
	/*
	 * LIST OF OPCODES
	 * 
     * 0001 # Load AC from memory
     * 0010 # Store AC to memory
     * 0011 # Load AC from stdin
     * 0100	# Subtract from AC from memory
     * 0101 # Add to AC from memory
     * 0110 # Store 0 from stdin to memory
     * 0111 # Store AC to stdout
     * 1000 # GOTO instruction
     * 1001 # Store 1 from stdin to memory
     * 1010 # Halt
	*/

    public static void main(String[] args){

        try {
        	
        	/* MEMORY INITIALIZATION */
        	
            MainMemory memory = new MainMemory(500);
            System.out.println();
        	
        	/* INSTANTIATION OF INSTRUCTIONS */
        	
        	Instruction instruction1 = new Instruction("0110", 25);	// Store value '0' from stdin to memory location '25'
        	Instruction instruction2 = new Instruction("1001", 26);	// Store value '1' from stdin to memory location '26'
        	Instruction instruction3 = new Instruction("0001", 26);	// Load AC from memory location '26'
        	Instruction instruction4 = new Instruction("0111", 0);	// Store AC to stdout, memory location '0'
        	
        	Instruction instruction5 = new Instruction("0101", 25);	// Add to AC from memory location '25'
        	Instruction instruction6 = new Instruction("0111", 0);	// Store AC to stdout, memory location '0'
        	Instruction instruction7 = new Instruction("0010", 25);	// Store AC to memory location '25'
        	Instruction instruction8 = new Instruction("0101", 26);	// Add to AC from memory location '26'
        	Instruction instruction9 = new Instruction("0111", 0);	// Store AC to stdout, memory location '0'	
        	Instruction instruction10 = new Instruction("0010", 26);	// Store AC to memory location '26'
        	Instruction instruction11 = new Instruction("1000", 104);// Go to instruction 5
        	Instruction instruction12 = new Instruction("1010", 0);// Halt the program after goto limit has been reached
        	
        	
        	/* PROCESS CREATION */
        	
        	Program fibonacci = new Program();	// New Fibonacci Program
        	
        	/* ASSOCIATION OF INSTRUCTIONS TO THE FIBONACCI PROGRAM */
        	
        	fibonacci.addInstruction(instruction1);
        	fibonacci.addInstruction(instruction2);
        	fibonacci.addInstruction(instruction3);
        	fibonacci.addInstruction(instruction4);
        	fibonacci.addInstruction(instruction5);
        	fibonacci.addInstruction(instruction6);
        	fibonacci.addInstruction(instruction7);
        	fibonacci.addInstruction(instruction8);
        	fibonacci.addInstruction(instruction9);
        	fibonacci.addInstruction(instruction10);
        	fibonacci.addInstruction(instruction11);
        	fibonacci.addInstruction(instruction12);
            
            /* Load the fibonacci program into memory */
            
            memory.loadProgram(fibonacci, 100);	/* Store instructions starting at memory location '100' */
            
            /* PROCESSOR INITIALIZATION */
            
            Processor processor = new Processor(memory); // Processor is initialized with memory
            processor.setGotoLimit(3); // Program is set to terminate after 5 goto repetitions
            Thread.sleep(1000);
            
            /* BEGIN INSTRUCTION PROCESSING */
            
            /* The Fetch() operation will release control to the execute() operation;
             * Which in turn will do the same, until the program terminates
             * Program is set to terminate after the number of executions set by the limit
            */
  
            processor.fetch();
            
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }	// End main method

}	// END class OS
