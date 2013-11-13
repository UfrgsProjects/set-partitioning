import java.util.Set;

public class SimulatedAnnealing {

	private Solution best;
	private Solution current;
	
	public SimulatedAnnealing(Set<Integer> universe, Set<SubSet> partitions){
		this.current = new Solution(universe);
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
			//TODO Estrategia para criar nova solução
			Solution newSolution = new Solution(current.getUniverse());
			
			// Get energy of solutions
            currentEnergy =  current.getCost(); 	// currentSolution.getDistance();
            neighbourEnergy = newSolution.getCost(); // newSolution.getDistance();
                      
            // Decide if we should accept the neighbour
            if (probability(currentEnergy, neighbourEnergy, temperature) > Math.random()) {
                //currentSolution = new Tour(newSolution.getTour());
            	current = newSolution;
            }
                        
            // Keep track of the best solution found
            if (current.getCost() < best.getCost()) {
                best =  current; //new Tour(currentSolution.getTour());
            }
            /*
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }
            */
            
            // Cool system
            temperature *= 1-coolerRate;
		
		}
	}
		
	public static double probability(int energy, int newEnergy, double temperature){
		double value = 0;
		
		if(newEnergy > energy)
 		//Solução melhor, aceita
			value = 1.0;
		else 
		// solução pior, calcula-se probabilidade para aceitação
			value =  Math.exp((energy - newEnergy) / temperature); 
		return value;
	}
}