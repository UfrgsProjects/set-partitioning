import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

/**
*
* Classe responsável por manter a solução do sistema
*		
*/
public class Solution{

	private Set<Integer> universe;
	private Set<Integer> partitionSolutionUsed;
	private Set<SubSet> partitionSolution; // solution
	private int cost;
	private Set<SubSet> idPartitionNotUsed;
	
	public Solution(Set<Integer> universe, Set<SubSet> partitions){
		this.universe = universe; // Set to be cover
		partitionSolution = new HashSet<SubSet>();
		idPartitionNotUsed = new HashSet<SubSet>();
		cost = 0;
		partitionSolutionUsed = new HashSet<Integer>();
		new ConstructiveHeuristic().findInicialSolution(partitions, this);
	}

/* -------- METHODS -------- */
		
	
	public void addCost(int value){
		this.cost += value;
	}
	
	public void subCost(int value){
		this.cost -= value;
	}
	
	public boolean solutionCoverUniverse(){
		return Sets.difference(universe, partitionSolutionUsed).isEmpty();
	}
	
	public Set<Integer> elementsCoverBySet(Set<SubSet> set){
		Set<Integer> s = new HashSet<Integer>();
		for (SubSet subSet : set) 
			s.addAll(subSet.getPartition());
		return s;
	}
	
	public void ShowSolution(){
		for (SubSet subSet : partitionSolution) 
			System.out.println(subSet.toString());
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

	public Set<Integer> getPartitionSolutionUsed() {
		return partitionSolutionUsed;
	}

	public Set<SubSet> getIdPartitionNotUsed() {
		return idPartitionNotUsed;
	}
}