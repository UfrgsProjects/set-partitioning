import java.util.Comparator;
/**
*
* Compara dois SubSet  através do seu custo
* Complexidade O(n logn) - Merge Sort	
*
*/
public class SubSetSizeComparator implements Comparator<SubSet>{

	@Override
	public int compare(SubSet S1, SubSet S2){
		int s1Size = S1.getPartition().size();
		int s2Size = S2.getPartition().size();
		int value = 0;

		if(s1Size < s2Size)
			value = -1;
		else if(s1Size > s2Size)	
			value = 1;
		else if(s1Size == s2Size)
			value = idAnalysis(S1, S2);
		return value;
	}
	
	public int idAnalysis(SubSet o1, SubSet o2){
		int value = 0;
		if(o1.getId() < o2.getId())
			value = -1;
		else if(o1.getId() > o2.getId())
			value = 1;
		return value;
	
	}
	
	
}
