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

class Key{
	private int id;
	private int cost;
	private int size;
	
	public Key(int id, int cost, int size) {
		this.id = id;
		this.cost = cost;
		this.size = size;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Key [id=" + id + ", cost=" + cost + ", size=" + size + "]";
	}
	
}
