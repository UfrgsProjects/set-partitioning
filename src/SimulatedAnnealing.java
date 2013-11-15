import java.util.Set;

public class SimulatedAnnealing {

	private Solution best;
	private Solution current;
	
	public SimulatedAnnealing(Set<SubSet> partitions){
		this.current = new Solution();
		Heuristic.findInicialSolution(partitions, this.current);
		this.best = this.current;
		this.current.ShowSolution();
		this.current.showElements();
		System.out.println("Custo: "+this.current.getCost());
	}
	//TODO Passar como parametro valores como temperatura  e coller
	public void execute(){
		double temperature = 1000000; // Temperatura inicial
		double coolerRate = 0.003; // resfriamento
		int currentEnergy = 0;
		int neighbourEnergy = 0;
		
		// Loop ate temperatura esfriar
		while(temperature > 1){
			//System.out.println("temp :"+temperature);
			// Create new neighbour
			Solution newSolution = Heuristic.neighbour(current);
			
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