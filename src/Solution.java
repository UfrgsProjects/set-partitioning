import java.util.HashSet;
import java.util.Set;

/**
*
* Classe responsável por manter a solução do sistema
*		
*/
public class Solution{

	private Set<Integer> universe;
	private Set<Integer> partitionUnion;
	private int cost;
	private Set<Integer> idPartition; // MAPPING OU HASHSET
	private Set<Integer> idPartitionNotUsed;
	
	public Solution(){
		universe = new HashSet<Integer>();
		partitionUnion = new HashSet<Integer>();
		cost = 0;
		idPartition = new HashSet<Integer>();
		idPartitionNotUsed = new HashSet<Integer>();
	}

/* -------- METHODS -------- */
	
	public void createUniverse(int elements){
		for(int i = 0; i < elements; i++)
			universe.add(i);
	}

/* ----- GETTERS E SETTERS ----- */
	
	public Set<Integer> getUniverse(){
		return this.universe;
	}
	
	public Set<Integer> getPartitionUnion(){
		return this.partitionUnion;	
	}
	
	public int getCost(){
		return this.cost;		
	}

	public Set<Integer> getIdPartition(){
		return this.idPartition;
	}

	public Set<Integer> getIdPartitionNotUsed() {
		return idPartitionNotUsed;
	}
	
	
	
}