import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * @author ryang
 * Create a class to write phone info to a file
 */

public class InputOutput {
	public void writeFile(String file, SLList list) {
		// File magic happens here
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * try/catch block to verify file has been written/created
		 */
		
		try {
			o.writeObject(list);
			System.out.println("File Successfully Created!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			o.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * create a method to read the file once it's been written
	 */
	
	public SLList readFile(String file) {
		// Read it back in
		ObjectInputStream i = null;
		SLList temp = null;

		try {
			i = new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * try/catch to verify file has been restored
		 */
		
		try {
			temp = (SLList) i.readObject();
			//System.out.println(temp);
			System.out.println("Successfully restored data from file!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			i.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
}
