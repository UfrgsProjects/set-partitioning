import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
*
* Cria Partições, subconjuntos  com seus custos.
*
*/
public class SubSet {

	private Set<Integer> partition;
	private int cost;
	private int id;
		
	public SubSet(int id, int cost, Set<Integer> partition){
		this.id = id;
		this.cost = cost;
		this.partition = partition;
	}
	/**
	 * Clona SubSet
	 * @param subset
	 * @return
	 */
	public static SubSet clone(SubSet subset){
		return new SubSet(subset.id, subset.cost, new TreeSet<Integer>(subset.getPartition()));
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
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubSet other = (SubSet) obj;
		if (id != other.id)
			return false;
		return true;
	}
	*/
}