import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Classe responsável por criar as estruturas ao ler o arquivo
 *
 */
public class Parsing {

	private Set<SubSet> partitions;
	private Archive archive;
	private Solution solution;
	
	// CONSTRUTOR
	public Parsing(String path, int order){
		partitions = chooseOrdenation(order); 
		solution = new Solution();
		archive = new Archive(path);
		parse();
	}

	// METODOS
	public Set<SubSet> chooseOrdenation(int ordenation){
		Set<SubSet> choice = null;
		switch(ordenation){
			case 0 : choice = new TreeSet<SubSet>( new SubSetIdComparator() ); break;
			case 1 : choice = new TreeSet<SubSet>( new SubSetCostComparator() ); break;
			case 2 : choice = new TreeSet<SubSet>( new SubSetSizeComparator() ); break;
			case 3 : choice = new TreeSet<SubSet>( new SubSetCostSizeComparator()); break; 
		}
		return choice;
	}
	
	
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
