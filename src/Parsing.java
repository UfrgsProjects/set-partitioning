import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Classe responsável por criar as estruturas ao ler o arquivo
 *
 */
public class Parsing {

	private Set<SubSet> partitions;// Hash com todas as partições -need to be sorted
	private Archive archive;
	private Solution solution;
	
	// CONSTRUTOR
	public Parsing(String path){
		partitions = new HashSet<SubSet>();
		solution = new Solution();
		archive = new Archive(path);
		parse();
	}

	// METODOS
	public void parse(){
		int line = 0;	
		while(archive.canRead()){
			String data = archive.getData();
			String[] splitData = data.trim().split(" +");	
			if(line == 0)
				solution.createUniverse(getLines(splitData));
			else
				partitions.add(new SubSet(line, getCost(splitData), getSubSet(splitData)));
			line++;	
		}
		archive.closeArchive();
	}
	
	private int getLines(String[] line){
		return Integer.parseInt(line[0]);
	}
		
	private int getCost(String[] line){
		return Integer.parseInt(line[0]);
	}
	
	private Set<Integer> getSubSet(String[] line){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 2; i < line.length; i++)
			set.add(Integer.parseInt(line[i]));
		return set;
	}

	// GETTERS E SETTERS
	public Set<SubSet> getPartitions() {
		return partitions;
	}

	public Solution getSolution() {
		return solution;
	}
	
	
	
	
}
