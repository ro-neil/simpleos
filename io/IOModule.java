/*
 * STUDENT ID: 620117471
 * 
 * COMP3101 – Operating Systems (Semester I, 2020)
 * Assignment #: 1
 * Lecturer: Dr. Kevin Miller
*/
package simpleos.io;

public class IOModule {
	
	private StandardInput stdin;
	private StandardOutput stdout;
	
	public IOModule() {
		stdin = new StandardInput();
		stdout = new StandardOutput();
	}

	/**
	 * @return the stdin
	 */
	public StandardInput getStdin() {
		return stdin;
	}

	/**
	 * @return the stdout
	 */
	public StandardOutput getStdout() {
		return stdout;
	}
	
	
	
	
}
