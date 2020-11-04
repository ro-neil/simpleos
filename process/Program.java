/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.process;

import java.util.ArrayList;
import java.util.List;


public class Program {
	
	private List<Instruction> instructions; // the program instructions
	private int currentInstruction; // used to step through the program
    
    
    public Program() {
    	System.out.println("INITIALIZING A NEW PROCESS");
    	instructions = new ArrayList<Instruction>();
    	currentInstruction = 0;
    }

    /**
     * @param instruction - an instruction to add to the program
     */
    public void addInstruction(Instruction instruction) {
       instructions.add(instruction);
    }
    
    /**
     * @return the next instruction
     */
    public Instruction getNextInstruction() {
    	try {
	    	Instruction nextInstruction = instructions.get(currentInstruction);
	    	currentInstruction++;
	    	return nextInstruction;
    	} catch(Exception e){
    		currentInstruction = 0;
            return null;
        }
	}
    
    /**
     * @return the size of the program (instruction count)
     */
    public int size() {
		return instructions.size();
	}

}
