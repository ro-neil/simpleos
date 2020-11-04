/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.processor;

import simpleos.io.*;
import simpleos.memory.*;
import simpleos.process.Instruction;


public class Processor extends AbstractProcessor {

    private ProgramCounter PC;    
    private InstructionRegister IR;    
    private Accumulator ACC;
    private MainMemory RAM;
    private IOModule ioModule;
    
    // USEFUL VARIABLES //
    private String stringSequence; 	// A string representation of the fibonacci sequence
	private int gotoCounter = 0;
	private Register gotoLimit; // For program termination


	public Processor(MainMemory mainMemory){
    	RAM = mainMemory;
    	PC = new ProgramCounter("PC", RAM.getStartLocation());	// set initial PC value to memory starting location
    	IR = new InstructionRegister("IR");
    	ACC = new Accumulator("ACC");
    	ioModule = new IOModule();
    	gotoLimit = new Register("GOTO LIMIT");
    	stringSequence = "";
    }


    public int fetch(){
    	    	
        try {
        	
        	System.out.println("\n________________CYCLE___________________\n");
        	System.out.println("\nPROCESSOR IS NOW FETCHING...");
        	
        	/* Fetch the address of the next instruction from the PC */
        	int PC_Address = (int) PC.getValue();
        	
        	/* Fetch the next Instruction from memory using the PC_Address */
            Instruction nextInstruction = (Instruction) RAM.getValue(PC_Address);
            
            /* Check to ensure that instruction an was retrieved */
            /* HALT instruction should be the final instruction given */
			if (nextInstruction != null) {	
	            IR.loadInstruction(nextInstruction);	// Load the next instruction into the IR
				execute();
				Thread.sleep(1000); // Sleep for 1 second
			} else {
				System.out.println("\nNo more instructions to fetch. Terminating process execution..");
				System.exit(0);
			}
		} catch (InterruptedException e) {
			return -1;
		}
        return -1;
        
    }
    
    public int execute(){
    	
        System.out.println("\nPROCESSOR IS NOW EXECUTING...");
        
        Instruction currentInstruction = (Instruction) IR.getValue(); // retrieve current instruction from IR
        int dataAddress = currentInstruction.getAddress();	// retrieve data location from instruction
        String opcode = currentInstruction.getOpcode();		// retrieve opcode from instruction
        
        switch (opcode) {
		
			case "0001":
				System.out.printf("Loading AC from memory location %s\n", dataAddress);
				ACC.setValue(RAM.getValue(dataAddress));
				break;
			case "0010":
				System.out.printf("Storing AC to memory location %s\n", dataAddress);
				RAM.storeData(dataAddress, ACC.getValue());
				break;
			case "0011":
				System.out.printf("Loading AC from stdin\n");
				ACC.setValue(ioModule.getStdin().in());
				break;
			case "0100":
				ACC.update(- (int) RAM.getValue(dataAddress));
				System.out.printf("Subtracting from AC from memory location %s\n", dataAddress);
				break;
			case "0101":
				System.out.printf("Adding to AC from memory location %s\n", dataAddress);
				ACC.update((int) RAM.getValue(dataAddress));
				break;
			case "0110":	// Hardcoded
				System.out.printf("Storing value of '0', from stdin to memory location %s\n", dataAddress);
				RAM.storeData(dataAddress,0);
				break;
			case "0111":
				System.out.printf("%s\n","Storing AC to stdout");
				addToSequence((int) ACC.getValue() + ", ");
				String sequence = String.format("\nSequence: %s", getStrSequence());
				ioModule.getStdout().print(sequence);			
				break;
			case "1000":
				gotoCounter++;
				System.out.println("Goto Counter -> " + gotoCounter);
				if(gotoCounter == (int) gotoLimit.getValue()) {	// check goto limit
					System.out.println("Goto limit reached");
					try {
						Thread.sleep(4000);
						System.out.println("Continuing the normal sequence of execution");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.printf("Go to instruction at memory location %s\n", dataAddress);
					PC.setValue(dataAddress -1);
				}
				break;
			case "1001":
				RAM.storeData(dataAddress,1);	// Hardcoded
				System.out.printf("Storing value of '1', from stdin to memory location %s\n", dataAddress);
				break;
			case "1010":
				System.out.println("Final instruction reached. Halting program execution...");
				System.exit(0);
				break;
			default:
				System.out.println("Terminating process execution..");	// Invalid Instruction given
				System.exit(0);
		}
        PC.increment();	// Increment the PC
        fetch();	// Fetch the next instruction
		return 1;
       
    }


	/**
	 * @return the stdout
	 */
	public String getStrSequence() {
		return stringSequence;
	}


	/**
	 * @param value the next value to be added to the current fibonacci string sequence
	 */
	public void addToSequence(String value) {
		this.stringSequence += value;
	} 

	
	/**
	 * @param limit the limit of the gotoCounter
	 */
	public void setGotoLimit(int limit) {
		System.out.printf("%s\n\n%s -> %d\n\n\n", "INITIALIZING GOTO LIMIT","GOTO LIMIT",limit);
		gotoLimit.setValue(limit);
	}


} //end abstract class Processor
