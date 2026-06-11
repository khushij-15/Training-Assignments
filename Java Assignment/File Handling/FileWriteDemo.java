/**
 * Concepts Covered:
 * 1. FileOutputStream Class
 * 2. Writing Data to a File
 */

import java.io.*;

/**
*FileOutputStream(File obj)
*FileOutputStream(File obj, boolean appendMode)
*
*Method
*Write(byte[] b)
**/

public class FileWriteDemo{
	public static void main(String[] args) {
		try{
			File f = new File("./Sample Files/output.kj");
			FileOutputStream Fout = new FileOutputStream(f,true);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String line="";
			System.out.println("Enter the contents of file!Enter \"exit\" to stop!");
			while(!((line=br.readLine()).equalsIgnoreCase("exit"))){
				line=line+"\n";
				Fout.write(line.getBytes());
			}
			System.out.println("Contents written to file");
		}catch(IOException e){
			System.out.println("IOException caught!");
		}
	}
}