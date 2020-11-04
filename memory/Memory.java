/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.memory;

// Represents an abstract CPU Memory
public abstract class Memory {

    private Object location [];
    private int size;

    public Memory(int size){
        System.out.printf("INITIALIZING MEMORY SIZE TO: %s\n",size);
        this.size = size;
        location = new Object[size];     
    }

    public int getSize(){
        return size;
    }

    public Object getValue(int index){
       return location[index]; 
    }

    /*
     * @param index - the memory location to store value
     * @param value - the value to store at location[index]
     */
    public int storeInstruction(int index, Object value) {
        try{
            location[index] = value;
            System.out.printf("Instruction %s stored at location %d\n",value, index);
            Thread.sleep(500); // Sleep for 0.5 second
            return 1;
        }catch(Exception e){
            System.out.println(e.toString());
            return -1;
        }
    }
    
    public int storeData(int index, Object value) {
        try{
            location[index] = value;
            Thread.sleep(2000); // Sleep for 2 seconds
            return 1;
        }catch(Exception e){
            System.out.println(e.toString());
            return -1;
        }
    }//set Value

}//end abstract class memory

