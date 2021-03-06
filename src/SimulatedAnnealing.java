import java.util.Set;

public class SimulatedAnnealing {

	private Solution best;
	private Solution current;
	private int inicialSoltution;
	public SimulatedAnnealing(Set<SubSet> partitions){
		this.current = new Solution();
		Heuristic.findInicialSolution(partitions, this.current);
		this.best = Solution.clone(this.current);
		this.inicialSoltution = this.current.getCost();
	}
	
	public void execute(double temperature, double coolerRate, int repeat, int time){
		int currentEnergy = 0;
		int neighbourEnergy = 0;
		int loop = repeat;
		long endTime = 0;
		long startTime = System.currentTimeMillis();
		boolean stop = false;
		// Loop ate temperatura resfriar
		while(temperature > 0.1){
			if(stop == true)
				break;
			while(loop != 0){
			
				// saida do laço pelo tempo
				endTime = System.currentTimeMillis();
				if((endTime - startTime) / 1000d >= time){
					stop = true;
					break;
				}		
				// Create new neighbour
				Solution newSolution = Heuristic.neighbour(current);
				
				// Get energy of solutions
	            currentEnergy =  current.getCost(); 	
	            neighbourEnergy = newSolution.getCost(); 
	            
	            // Decide se aceita o novo vizinho
	            if (probability(currentEnergy, neighbourEnergy, temperature) > Math.random()) 
	               current = Solution.clone(newSolution);
	                       	            
	            //  Analisa se a melhor soluçao encontrada 
	            if(current.getCost() < best.getCost()){
	            	if(! best.feasible() ){
	            		 best = Solution.clone(current);
	            		 System.out.println("Find better solution"); 
	            	}else if(current.feasible()){
	            		 best = Solution.clone(current);
	            		 System.out.println("Find Feasible solution");
	            	}
	            }else if(current.feasible() && ! best.feasible()){
	            	best = Solution.clone(current);
	            	System.out.println("Find Feasible");
	            }
	            
	          //  if (current.getCost() < best.getCost() && current.feasible()) 
	            //    best = Solution.clone(current); 
	                       
	            loop--;
			}
			loop = repeat;
	        // Resfria sistema
            temperature *= 1-coolerRate;
		}
	}
		
	public static double probability(int energy, int newEnergy, double temperature){
		double value = 0;
		
		if(newEnergy < energy)
 		// Solução melhor, aceita - Minimizar custo
			value = 1.0;
		else 
		// solução pior, calcula-se probabilidade para aceitação
			value =  Math.exp((energy - newEnergy) / temperature); 
		return value;
	}

	public Solution getBest() {
		return best;
	}

	public int getInicialSoltution() {
		return inicialSoltution;
	}	
}