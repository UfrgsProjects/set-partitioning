import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Converte os arquivos de dados no formato para usar no GLPK
 *
 */
public class MathProgDatConversor {

	public static void main(String[] args) {
		String diretoryPath =  "/home/rodrigo/set-partitioning/instancias";
		String diretoryDat = "/home/rodrigo/set-partitioning/glpk/dat";
		
		
		switch(args.length){
			case 2 :
					diretoryPath = args[0];
					diretoryDat = args[1];
					break;
			default:
				System.out.println("Use: java -cp class MathProgDatConversor [directory path] [directoryDat]");
				return;
		}
		
		File f = new File(diretoryPath);
		for(File files : f.listFiles()){
			String fileName = files.getAbsolutePath();
			if(fileName.contains("txt")){
				int index = files.getName().indexOf(".");
				String dat = diretoryDat+"/"+files.getName().substring(0, index)+".dat";
				System.out.println("Starting File Convertion: "+files.getName());
				createDat(fileName, dat);
				System.out.println("File "+dat+ " Converted");
			}
		}
		
	}
	
	private static void createDat(String originFile, String destinyFile){
		Archive archive = new Archive(originFile);
		ArchiveWrite archiveWrite = new ArchiveWrite(destinyFile);
		String paramM = "param m := "; 
		String paramN = "param n := ";
		StringBuilder paramC = new StringBuilder("param c := \n");
		StringBuilder paramPartitions = new StringBuilder("param partitions : ");
		int line = 0;	
		int[][] matriz = null;
		int column = 0;
		int row = 0;
		while(archive.canRead()){
			String data = archive.getData();
			String[] splitData = data.trim().split(" +");
				if(line == 0){
					paramM += getLines(splitData) + ";";
					paramN += getColumns(splitData) + ";";
					writePartitionsLine(paramPartitions, getColumns(splitData));
					matriz = new int[getLines(splitData)][getColumns(splitData)];
					initMatriz(matriz);
				}else{
					paramC.append(line); 
					paramC.append(" ");
					paramC.append(getCost(splitData, line));
					paramC.append("\n");
					for (Integer element : getSubSet(splitData)){ 
						column = line - 1;
						row = element - 1; 
						matriz[row][column] = 1;
					}
				}
			line++;
			
			//System.out.println(data.trim());
		}
		archive.closeArchive();
		//colocar strings em arquivo
		archiveWrite.writeLine(paramM);
		archiveWrite.writeLine(paramN);
		paramC.append(";");
		archiveWrite.writeLine(paramC.toString());
		archiveWrite.writeLineNoBreak(paramPartitions.toString());
		writePartitionsMatriz(matriz, archiveWrite);	
		archiveWrite.close();
	}
	/**
	 * Inicializa vetor com zeros
	 * @param matriz
	 */
	private static void initMatriz(int[][] matriz){
		for(int i = 0; i < matriz.length; i++)
			for(int j = 0; j < matriz[i].length; j++)
				matriz[i][j] = 0;
	}
	/**
	 * Escreve indice de linha da matriz
	 * @param matriz
	 * @param partition
	 * @return
	 */
	private static void writePartitionsMatriz(int[][] matriz, ArchiveWrite archive){
		for(int i = 0; i < matriz.length; i++){
			archive.writeLineNoBreak(Integer.toString((i+1)));
			archive.writeLineNoBreak(" ");
			for(int j = 0; j < matriz[i].length; j++){
				archive.writeLineNoBreak(Integer.toString(matriz[i][j]));
				archive.writeLineNoBreak(" ");	
			}
			archive.writeLine("");
		}
		archive.writeLineNoBreak(";");
		archive.writeLine("");
		archive.writeLineNoBreak("end;");
	}
	/**
	 * Escreve quantas colunas matriz terá. Ex: param partition : 1 2 3 :=
	 * @param line
	 * @param qtdColumn
	 * @return
	 */
	private static void writePartitionsLine(StringBuilder line, int qtdColumn){
		for (int i = 0; i < qtdColumn; i++){ 
			line.append((i+1));
			line.append(" ");
		}
		line.append(" := \n");
	}
	
/*----- metodos para tomar dados da string lida pelo arquivo ------ */	
	
	private static int getLines(String[] line){
		return Integer.parseInt(line[0]);
	}
	
	private static int getColumns(String[] line){
		return Integer.parseInt(line[1]);
	}
	
	private static int getCost(String[] line, int numberline){
		int i = 0;
		try{
			i = Integer.parseInt(line[0]);
		}catch(NumberFormatException e){
			System.out.println("Erro ao parse Linha: "+numberline);
			i = numberline;
		}
		return i;
	}
	
	private static List<Integer> getSubSet(String[] line){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 2; i < line.length; i++)
			list.add(Integer.parseInt(line[i]));
		return list;
	}
}