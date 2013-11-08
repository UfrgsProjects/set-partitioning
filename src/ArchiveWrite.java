import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ArchiveWrite {

	private File file;
	private FileWriter fileWrite;
	private BufferedWriter bufferedWrite;
	
	public ArchiveWrite(String path){
		makeFile(path);
	}
		
	private final void makeFile(String filePath){
		try {
			file = new File(filePath);
			if(file.exists()){
				file.delete();
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			fileWrite = new FileWriter(file, true);
			bufferedWrite = new BufferedWriter(fileWrite);
		} catch (FileNotFoundException e) {	
			 e.printStackTrace(); 
		} catch (IOException e){
			e.printStackTrace();	
		}
	}
	
	public void writeLine(String line){
		try {
			bufferedWrite.write(line);
			bufferedWrite.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeLineNoBreak(String line){
		try {
			bufferedWrite.write(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			bufferedWrite.close();
			fileWrite.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
