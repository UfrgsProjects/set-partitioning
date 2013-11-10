import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Classe generica para ler arquivos
 */
public class Archive {
	
	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	// Construtor
	public Archive(String filePath){
		makeFile(filePath);		
	}
	
	private final void makeFile(String filePath){
		try {
			file = new File(filePath);
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {	e.printStackTrace(); }
	}
	
	public boolean canRead(){
		boolean bool = false;
		try {
			bool  = bufferedReader.ready();
		} catch (IOException e) {	
			e.printStackTrace();
		}
		return bool;
	}
		
	/**
	 * Retorna linha do texto apenas 
	 * 
	 * @return
	 */
	public String getData(){
		String response = null;
		try {
			if(bufferedReader.ready()){
				response = bufferedReader.readLine();
				
			}
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return response;	
	}
		
	public void closeArchive(){
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) { e.printStackTrace();}
		
	}
	
	public void changeArquive(String filePath){
		closeArchive();
		makeFile(filePath);
	}

	@Override
	public String toString() {
		return "Archive [file=" + file.getName() + "]";
	}
	
	
	
}
