import java.util.Date;


/**
*
* Aplicação do Algoritmo
* Uso: java -cp class SetPartition [Data path] [TypeOrdenation] [Solution path] [Temperature] [Cooler] [Loop] [Time] 
* [Data_path] = Arquivos com dado da instancia
* [TypeOrdenation] = Tipo de ordenação => 0 : nenhuma ordenação(Leitura do arquivo)
* [TypeOrdenation] = Tipo de ordenação => 1 : Ordenar Arvore por custo
* [TypeOrdenation] = Tipo de ordenação => 2 : Ordenar pelo tamanho da partição
* [TypeOrdenation] = Tipo de ordenação => 3 : Ordenar pelo tamanho da partição e custo
*/
public class SetPartition{

	public static void main(String[] args){
      String directory = "";
      String directorySolution = "";
      int ordenation = 0;
      int repeat = 1000;
      int time = 3600;
      double temperature = 1000;
      double coolerRate = 0.005;
       
	  	switch(args.length){
	  		case 1: 
	  				directory = args[0]; 
	  				break; 
	  		case 2: 
	  				directory = args[0]; 
	  				ordenation = Integer.parseInt(args[1]); 
	  				break;
	  		case 3:
	  				directory = args[0]; 
	  				ordenation = Integer.parseInt(args[1]);
	  				args[2] = args[2].replace(".txt", "-");
	  				directorySolution =  args[2]+new Date().toString()+".txt";
	  				break;
	  		case 7:
	  				directory = args[0]; 
	  				ordenation = Integer.parseInt(args[1]);
	  				args[2] = args[2].replace(".txt", "-");
	  				directorySolution = args[2]+new Date().toString()+".txt";
	  				temperature = Double.valueOf(args[3]);
	  				coolerRate = Double.valueOf(args[4]);
	  				repeat = Integer.parseInt(args[5]);
	  				repeat = Integer.parseInt(args[6]);
	  				break;
	  		default: 
	  			System.out.println("Number of Parameters invalid");
			    System.out.println("Use: java -cp class SetPartition [data_path] [typeOrdenation]");
			    return;	
	  	}
	   
	   System.out.println();  	  
	   System.out.println("Reading..... "+directory);	
	   Parsing parsing = new Parsing(directory, ordenation); 	
	   System.out.println("***** Start *****");	   
	   long tempoInicial = System.currentTimeMillis();
	   SimulatedAnnealing SA = new SimulatedAnnealing(parsing.getPartitions()); 
	   SA.execute(temperature, coolerRate, repeat, time);
	   long tempoFinal = System.currentTimeMillis();
	   System.out.printf("Time SA: %.3f segundos%n", (tempoFinal - tempoInicial) / 1000d);
	   System.out.println("Writing..... "+directorySolution);
	   
	   
	   ArchiveWrite archiveWrite = new ArchiveWrite(directorySolution);
	   archiveWrite.writeLine("Time: "+(tempoFinal - tempoInicial) / 1000d);
	   archiveWrite.writeLine("****** Solution ********");
	   for(SubSet s : SA.getBest().getPartitionSolution())
		   archiveWrite.writeLine(s.toString());
	   archiveWrite.writeLine("Feasible solution: "+SA.getBest().feasible());
	   if( !SA.getBest().feasible() ){
		   archiveWrite.writeLineNoBreak("Elements Not Cover: ");;
		   for (Integer i : SA.getBest().getNotCover())
				archiveWrite.writeLineNoBreak(i+", ");
	   }
	    archiveWrite.writeLine("");
	    archiveWrite.writeLine("Custo: "+SA.getBest().getCost());
		System.out.println();
		archiveWrite.close();
		
		System.out.println("***** END *******");
	}
    
    
}


