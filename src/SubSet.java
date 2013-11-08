import java.util.Iterator;
import java.util.Set;
/**
*
* Cria Partições, subconjuntos  com seus custos.
*
*/
public class SubSet{

	private Set<Integer> partition;
	private int cost;
	private int id;

	public SubSet(){}

	public SubSet(int id, int cost, Set<Integer> partition){
		this.id = id;
		this.cost = cost;
		this.partition = partition;
		
	}

	public Set<Integer> getPartition(){
		return this.partition;
	}

	public int getCost(){
		return this.cost;
	}

	public int getId(){
		return this.id;
	}

	@Override
	public String toString() {
		String s = "";
		Iterator<Integer> i  = partition.iterator();
		while(i.hasNext())
			s += i.next()+" ";	
		return "SubSet [id=" + id + ", cost=" + cost +", SubSet= "+ s + "]";
	}
	
}
