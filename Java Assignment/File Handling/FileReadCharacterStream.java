import java.io.*;

public class FileReadCharacterStream{
	public static void main(String[] args) {
		try{
			File f = new File("./Sample Files/sample_java.txt");
			FileInputStream fis = new FileInputStream(f);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line="";
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
			br.close();
			fis.close();
		}catch(FileNotFoundException e){
			System.out.println("File Not Found Exception caught!");
		}catch(IOException e){
			System.out.println("IOException caught!");
		}
	}
}