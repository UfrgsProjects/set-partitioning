import java.util.Comparator;
/**
*
* Compara dois SubSet  através do seu custo
* Complexidade O(n logn) - Merge Sort	
*
*/
public class SubSetCostComparator implements Comparator<SubSet>{

	@Override
	public int compare(SubSet S1, SubSet S2){
		int value = 0;			
		if(S1.getCost() < S2.getCost())
			value = -1;
		else if(S1.getCost() > S2.getCost())	
			value = 1;
		return value;
	}
}
