/**
 * Concepts Covered:
 * 1. FileInputStream Class
 * 2. Reading Data from a File
 */

import java.io.*;
/**
*FileInputStream
*Constructor:
*FileInputStram(File file(object)) throws FileNotFoundException
*
*Method
*int read() throws IOException: returns -1 if the file has ended!
*void close(): closes the stream
*
*File class has one constructor
*File(String filepath)
**/
public class FileReadInputStream{
	public static void main(String[] args) {
		try{
			File f = new File("./Sample Files/sample_java.txt");
			FileInputStream fis = new FileInputStream(f);

			int character;
			while((character=fis.read())!=-1){
				System.out.println((char)character);
			}
			
			fis.close();
		}catch(FileNotFoundException e){
			System.out.println("File Not Found Exception caught!");
		}catch(IOException e){
			System.out.println("IOException caught!");
		}
	}
}