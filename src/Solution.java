import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

/**
*
* Classe responsável por manter a solução do sistema
*		
*/
public class Solution{

	private Set<Integer> universe; // Elementos do conjunto
	private Set<Integer> cover; 	// Elementos cobertos do universo
	private Set<Integer> notCover; // Elementos não cobertos do universo
	private Set<SubSet> partitionSolution; 
	private Set<SubSet> PartitionNotUsed;
	private int cost;
	
	
	public Solution(Set<Integer> universe){
		this.universe = universe; 
		this.partitionSolution = new HashSet<SubSet>();
		this.PartitionNotUsed = new HashSet<SubSet>();
		this.cover = new HashSet<Integer>();
		this.notCover = new HashSet<Integer>();
		this.cost = 0;
		//new ConstructiveHeuristic().findInicialSolution(partitions, this);
	}

/* -------- METHODS -------- */
	/**
	 * Retorna valor boolean se solução é factível
	 * @return boolean
	 */
	public boolean feasible(){
		//notCover.isEmpty();
		return Sets.difference(universe, cover).isEmpty();
	}
	/**
	 * 	Imprime Solução	  
	 */
	public void ShowSolution(){
		for (SubSet subSet : partitionSolution) 
			System.out.println(subSet.toString());
		
		if(! notCover.isEmpty()){
			System.out.println("Solução não Factível: ");
			for (Integer i : notCover) 
				System.out.print(i +" ");
			System.out.println();
		}
	}	
	
	public void showPartitionsNotUsed(){
		for (SubSet s : PartitionNotUsed) 
			System.out.println(s.toString());
	}
	
	public void addCost(int value){
		this.cost += value;
	}
	
	public void subCost(int value){
		this.cost -= value;
	}
/* ----- GETTERS E SETTERS ----- */
	
	public Set<Integer> getUniverse(){
		return this.universe;
	}
	
	public Set<SubSet> getPartitionSolution() {
		return partitionSolution;
	}

	public int getCost(){
		return this.cost;		
	}

	public Set<Integer> getCover() {
		return this.cover;
	}

	public Set<SubSet> getPartitionNotUsed() {
		return this.PartitionNotUsed;
	}

	public Set<Integer> getNotCover() {
		return this.notCover;
	}
}