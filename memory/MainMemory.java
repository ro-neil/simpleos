/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.memory;

import simpleos.process.*;

// Represents the CPU Random Access Memory, that is also a type of Memory
public class MainMemory extends Memory {
	
		private int startLocation;

        public MainMemory(int size){
            super(size);
        }

        
        /*
         * @param startLocation - the starting location of the first program instruction
         */
        public void loadProgram(Program program, int startLocation) {
        	
        	System.out.println("\n***LOADING PROGRAM INTO MEMORY***\n");
        	
        	Instruction nextInstruction = program.getNextInstruction();	// retrieve the next program instruction
        	setStartLocation(startLocation);
        	
        	// Instruction Loading
        	while (nextInstruction != null) {
        		storeInstruction(startLocation, nextInstruction);	// load instruction to memory at start
        		nextInstruction = program.getNextInstruction();	// retrieve the next program instruction
        		startLocation++; 	// move to the next block of memory
        	}
        	
		}
        
   
        public void printSize(){
            System.out.println("The size of Main Memory is: " + getSize());
        }

		/**
		 * @return the startLocation
		 */
		public int getStartLocation() {
			return startLocation;
		}

		/**
		 * @param startLocation the startLocation to set
		 */
		public void setStartLocation(int startLocation) {
			this.startLocation = startLocation;
		}
		
		
}//end abstract class memory
