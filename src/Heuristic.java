import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 
 * Classe responsável por gerenciar heuristicas de contrução e 
 * 	vizinhança de soluções 
 *
 */
public class Heuristic {
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
	
	
	/**
	 * Procura Solução na vizinhança
	 * @param solution
	 * @return Uma nova Solução
	 */
	public static Solution neighbour(Solution solution){
		Solution newSolution  = Solution.clone(solution);
		Set<SubSet> removeParts = selectPartitions(solution.getPartitionSolution());
		Set<Integer> removePartsElements = elementsInPartitions(removeParts);
			
		newSolution.setPartitionSolution((Sets.difference(solution.getPartitionSolution(), removeParts)));
		newSolution.setCover(Sets.difference(solution.getCover(), removePartsElements));
		newSolution.setNotCover(Sets.union(solution.getNotCover(), removePartsElements));
		
		// retira custo da solução das partições retiradas
		for(SubSet subset : removeParts)
			newSolution.subCost(subset.getCost());
		
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		Set<Integer> result = new HashSet<Integer>();
		Iterator<SubSet> it = newSolution.getPartitionNotUsed().iterator();
		 while(it.hasNext()){
			 endTime = System.currentTimeMillis();
			 if((endTime - startTime) / 1000d >= 180)
				 	break;
			SubSet subSet = it.next();
			// Quais elementos a partição cobre(Daqueles que nao estao cobertos)
			result = Sets.difference(subSet.getPartition(), newSolution.getNotCover());
			if(result.isEmpty()){
				// ADICIONA NOVA PARTIÇÃO A SOLUÇÃO
				newSolution.getPartitionSolution().add(subSet);
				// RETIRA ELEMENTOS DOS NAO COBERTOS
				newSolution.getNotCover().removeAll(subSet.getPartition());
				// ADICIONA NOVOS ELEMENTOS COBERTOS
				newSolution.getCover().addAll(subSet.getPartition());
				// RETIRA PARTIÇÃO DAS NAO UTILIZADAS
				it.remove();
				//  ATUALIZA CUSTO DA NOVA SOLUÇÃO
				newSolution.addCost(subSet.getCost());
			}
		}
		newSolution.getPartitionNotUsed().addAll(removeParts); // Adiciona partes retiradas anteriormente
		return newSolution;
	}
	/**
	 * Retorna todos elementos(Integers) que partições cobrem	
	 * @param subsets
	 * @return Set<Integer>
	 */
	private static Set<Integer> elementsInPartitions(Set<SubSet> subsets){
		Set<Integer> elements = new HashSet<Integer>(); 
		for (SubSet subSet : subsets) 
			elements.addAll(subSet.getPartition());
		return elements;
	}	
	/**
	 * Seleciona 3 partições ou menos a principio para remover da partição
	 * @param partitionsSolution
	 * @return Set<SubSet>
	 */
	private static Set<SubSet> selectPartitions(Set<SubSet> partitionSolution ){
		Set<SubSet> parts = new HashSet<SubSet>();
		int num = new Random().nextInt(5) + 1;
		Iterator<SubSet> it = partitionSolution.iterator(); 
		while(parts.size() != num && it.hasNext())
			parts.add(it.next());	
		return parts;
	}
		
}