import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 
 * Cria Heurística Construtiva do problema set partitioning
 * Cria uma solução inicial para o problema.
 * 
 *
 */
public class ConstructiveHeuristic {
	/**
	 * Cria solução inicial do problema
	 * XXX Solução nao é factível, pois o SPP é muito restrito
	 * @param partitions
	 * @param solution
	 */
	public static void findInicialSolution(Set<SubSet> partitions, Solution solution){
		Set<Integer> universe = new HashSet<Integer>();
		for (SubSet subSet : partitions) {
			if(Sets.intersection(subSet.getPartition(), solution.getCover()).isEmpty()){
				solution.getPartitionSolution().add(subSet);
				solution.getCover().addAll(subSet.getPartition());
				solution.addCost(subSet.getCost());
				universe.addAll(subSet.getPartition());
			}else{
				solution.getPartitionNotUsed().add(subSet);
				universe.addAll(subSet.getPartition());
			}
		}
		solution.getNotCover().addAll(Sets.difference(universe, solution.getCover()));
	}
}