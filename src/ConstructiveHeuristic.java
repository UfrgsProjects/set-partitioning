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
		for (SubSet subSet : partitions) {
			if(Sets.intersection(subSet.getPartition(), solution.getCover()).isEmpty()){
				solution.getPartitionSolution().add(subSet);
				solution.getCover().addAll(subSet.getPartition());
				solution.addCost(subSet.getCost());
			}else
				solution.getPartitionNotUsed().add(subSet);
		}
		solution.getNotCover().addAll(Sets.difference(solution.getUniverse(), solution.getCover()));
	}
}