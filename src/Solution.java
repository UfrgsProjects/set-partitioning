import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Classe responsável por manter a solução do sistema
 * 
 */
public class Solution {

	// private Set<Integer> universe; // Elementos do conjunto
	private Set<Integer> cover; // Elementos cobertos do universo
	private Set<Integer> notCover; // Elementos não cobertos do universo
	private Set<SubSet> partitionSolution;
	private Set<SubSet> PartitionNotUsed;
	private int cost;

	public Solution() {
		// this.universe = universe;
		this.partitionSolution = new HashSet<SubSet>();
		this.PartitionNotUsed = new HashSet<SubSet>();
		this.cover = new HashSet<Integer>();
		this.notCover = new HashSet<Integer>();
		this.cost = 0;
	}

	public static Solution clone(Solution solution) {
		Solution clone = new Solution();
		clone.setCover(solution.getCover());
		clone.setNotCover(solution.getNotCover());
		clone.setPartitionSolution(solution.getPartitionSolution());
		clone.setPartitionNotUsed(solution.getPartitionNotUsed());
		clone.setCost(solution.getCost());
		return clone;
	}

	/* -------- METHODS -------- */
	/**
	 * Retorna valor boolean se solução é factível
	 * 
	 * @return boolean
	 */
	public boolean feasible() {
		return notCover.isEmpty();
	}
	/**
	 * Imprime Solução
	 */
	public void ShowSolution() {
		for (SubSet subSet : partitionSolution)
			System.out.println(subSet.toString());

		if (!notCover.isEmpty()) {
			System.out.println("Solução não Factível: ");
			for (Integer i : notCover)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	public void showPartitionsNotUsed() {
		for (SubSet s : PartitionNotUsed)
			System.out.println(s.toString());
	}

	public void showElements() {
		System.out.print("Elementos Cobertos: ");
		for (Integer i : cover)
			System.out.print(i + " ");
		System.out.println();
		System.out.print("Elementos não Cobertos: ");
		for (Integer i : notCover)
			System.out.print(i + " ");
		System.out.println();
	}

	public void addCost(int value) {
		this.cost += value;
	}

	public void subCost(int value) {
		this.cost -= value;
	}

	public void addPartition(SubSet subset){
		this.partitionSolution.add(subset);
		this.PartitionNotUsed.remove(subset);
		this.cost += subset.getCost();
	}
	
	public void removePartition(SubSet subset){
		this.partitionSolution.remove(subset);
		this.PartitionNotUsed.add(subset);
		this.cost -= subset.getCost();
	}
	
	/* ----- GETTERS E SETTERS ----- */
	/*
	 * public Set<Integer> getUniverse(){ return this.universe; }
	 */
	public Set<SubSet> getPartitionSolution() {
		return partitionSolution;
	}

	public int getCost() {
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

	public void setCover(Set<Integer> cover) {
		Set<Integer> temp = new HashSet<Integer>();
		temp.addAll(cover);
		this.cover = temp;;
	}

	public void setNotCover(Set<Integer> notCover) {
		Set<Integer> temp = new HashSet<Integer>();
		temp.addAll(notCover);
		this.notCover = temp;
	}

	public void setPartitionSolution(Set<SubSet> partitionSolution) {
		Set<SubSet> temp = new HashSet<>();
		temp.addAll(partitionSolution);
		this.partitionSolution = temp; 
	}

	public void setPartitionNotUsed(Set<SubSet> partitionNotUsed) {
		Set<SubSet> temp = new HashSet<>();
		temp.addAll(partitionNotUsed);
		PartitionNotUsed = temp;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}