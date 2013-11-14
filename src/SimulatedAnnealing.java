import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SimulatedAnnealing {

	private Solution best;
	private Solution current;
	
	public SimulatedAnnealing(Set<SubSet> partitions){
		this.current = new Solution();
		ConstructiveHeuristic.findInicialSolution(partitions, this.current);
		this.best = this.current;
	}
	
	public void execute(){
		double temperature = 1000; // Temperatura inicial
		double coolerRate = 0.003; // resfriamento
		int currentEnergy = 0;
		int neighbourEnergy = 0;
		
		// Loop ate temperatura esfriar
		while(temperature > 1){
			// Create new neighbour
			// TODO Estrategia para criar nova solução
			Solution newSolution = new Solution();
			
			// Get energy of solutions
            currentEnergy =  current.getCost(); 	
            neighbourEnergy = newSolution.getCost(); 
                      
            // Decide se aceita o novo vizinho
            if (probability(currentEnergy, neighbourEnergy, temperature) > Math.random()) 
               current = newSolution;
                                   
            //  Analisa se a melhor soluçao encontrada 
            if (current.getCost() < best.getCost()) 
                best =  current; 
                                 
            // Cool system
            temperature *= 1-coolerRate;
		}
	}
	/**
	 * Procura Solução na vizinhança
	 * @param solution
	 * @return
	 */
	private Solution neighbour(Solution solution){
		Set<SubSet> removeParts = selectPartitions(solution.getPartitionSolution());
		
		
		
					
		return null;
	}	
	/**
	 * Seleciona 3 partições ou menos a principio para remover da partição
	 * @param partitionsSolution
	 * @return
	 */
	public Set<SubSet> selectPartitions(Set<SubSet> partitionSolution ){
		Set<SubSet> parts = new HashSet<SubSet>();
		Iterator<SubSet> it = partitionSolution.iterator(); 
		while(parts.size() != 3 && it.hasNext()){
			parts.add(it.next());	
			System.out.println("Enter here: "+parts.size());
		}
		return parts;
	}
	
	
	public static double probability(int energy, int newEnergy, double temperature){
		double value = 0;
		
		if(newEnergy > energy)
 		// Solução melhor, aceita
			value = 1.0;
		else 
		// solução pior, calcula-se probabilidade para aceitação
			value =  Math.exp((energy - newEnergy) / temperature); 
		return value;
	}

	public Solution getBest() {
		return best;
	}
}