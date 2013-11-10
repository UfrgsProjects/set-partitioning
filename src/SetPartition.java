import java.util.Iterator;
import java.util.Set;

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
      
	  Set<SubSet> partitions ;
	  Solution solution;
	  
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
	  	   
	   //"/home/rodrigo/set-partitioning/instancias/sppnw32.txt" 
	   Parsing parsing = new Parsing(directory, ordenation); 	
   	   partitions = parsing.getPartitions();
	   solution = parsing.getSolution();	
   	      	   
   	   
   	   
   	   
	   Iterator<SubSet> i = partitions.iterator();	
	   long tempoInicial = System.currentTimeMillis();
	   while(i.hasNext())
		  System.out.println(i.next());
	   long tempoFinal = System.currentTimeMillis();
	   System.out.printf("%.3f segundos%n", (tempoFinal - tempoInicial) / 1000d);
	   System.out.println("quantidade: "+partitions.size());
	  
	   
	}
    
    
}


