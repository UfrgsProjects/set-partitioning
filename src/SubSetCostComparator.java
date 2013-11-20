import java.util.Comparator;
/**
*
* Compara dois SubSet  através do seu custo
* Complexidade O(n logn) - Merge Sort	
*
*/
public class SubSetCostComparator implements Comparator<SubSet> {

	@Override
	public int compare(SubSet o1, SubSet o2) {
		int value = 1;
		if(o1.getCost() < o2.getCost())
			value = -1;
		return value;
	}
	
}
