public class Parsing {

	private Set<SubSet> partitions;
	    // Outros Atributos ...
	public Parsing(String path, int order){
		partitions = chooseOrdenation(order); 
		//inicializacoes ...
	}
		// Escolhe Modo de Ordenamento
	public Set<SubSet> chooseOrdenation(int ordenation){
		Set<SubSet> choice = null;
		switch(ordenation){
		  case 0: choice = new TreeSet<SubSet>(new SubSetIdComparator()); 
					 break;
		  case 1: choice = new TreeSet<SubSet>(new SubSetCostComparator()); 
					 break;
		  case 2: choice = new TreeSet<SubSet>(new SubSetSizeComparator()); 
					 break;
		}
		return choice;
	}
}
