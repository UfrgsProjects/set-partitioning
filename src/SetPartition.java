
/**
*
* Aplicação do Algoritmo
* Uso: java -cp class SetPartition [data path] [typeOrdenation]
* [data_path] = Arquivos com dados da instancia
* [TypeOrdenation] = Tipo de ordenação => 0 : nenhuma ordenação(Leitura do arquivo)
* [TypeOrdenation] = Tipo de ordenação => 1 : Ordenar Arvore por custo
* [TypeOrdenation] = Tipo de ordenação => 2 : Ordenar pelo tamanho da partição
* [TypeOrdenation] = Tipo de ordenação => 3 : Ordenar pelo tamanho da partição e custo
*/
public class SetPartition{

	public static void main(String[] args){
      String directory = "";
      int ordenation = 0;
       
	  	switch(args.length){
	  		case 1: 
	  				directory = args[0]; 
	  				break; 
	  		case 2: 
	  				directory = args[0]; 
	  				ordenation = Integer.parseInt(args[1]); 
	  				break;
	  		default: 
	  			System.out.println("Number of Parameters invalid");
			    System.out.println("Use: java -cp class SetPartition [data_path] [typeOrdenation]");
			    return;	
	  	}
	  	   
	   // "/home/rodrigo/set-partitioning/instancias/sppnw32.txt"   14877
	   // "/home/rodrigo/set-partitioning/instancias/sppnw41.txt"   11307	
	  	
	   Parsing parsing = new Parsing(directory, ordenation); 	
   	   //Solution solution = new Solution(parsing.getUniverse());   
	   Solution solution = new Solution();   
	   ConstructiveHeuristic.findInicialSolution(parsing.getPartitions(),solution);
	   solution.ShowSolution();
	   solution.showElements();
	   System.out.println("Custo: "+solution.getCost());
		   
   		SimulatedAnnealing SA = new SimulatedAnnealing(parsing.getPartitions());
   		System.out.println(SA.selectPartitions(solution.getPartitionSolution()));
   		
	   
	   
	   /*
	   Iterator<SubSet> i = partitions.iterator();	
	   long tempoInicial = System.currentTimeMillis();
	   while(i.hasNext())
		  System.out.println(i.next());
	   long tempoFinal = System.currentTimeMillis();
	   System.out.printf("%.3f segundos%n", (tempoFinal - tempoInicial) / 1000d);
	   System.out.println("quantidade: "+partitions.size());
	 */
  
	  
	}
    
    
}


