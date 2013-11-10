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

	
	public void findInicialSolution(Set<SubSet> partitions, Solution solution){
		boolean check = false;
		
		for (SubSet subSet : partitions) {
			if(Sets.intersection(subSet.getPartition(), solution.getPartitionSolutionUsed()).isEmpty()){
				solution.getPartitionSolution().add(subSet);
				solution.getPartitionSolutionUsed().addAll(subSet.getPartition());
				solution.addCost(subSet.getCost());
				check = true;
			}
				
			if(check == true && solution.solutionCoverUniverse()){
				System.out.println("find");
				break;
			}else
				check = false;
			
		}
	}
}