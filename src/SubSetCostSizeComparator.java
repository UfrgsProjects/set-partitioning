import java.util.Comparator;


public class SubSetCostSizeComparator implements Comparator<SubSet>{

	@Override
	public int compare(SubSet S1, SubSet S2) {
		int value = 0;
		
		if( S1.getCost() < S2.getCost() ){
			if(S1.getPartition().size() >= S2.getPartition().size())
				value = -1;
			else
				value = 1;
		}else if(S1.getCost() > S2.getCost() ){
			if(S1.getPartition().size() < S2.getPartition().size())
				value = -1;
			else
				value = 1;
		}else if(S1.getCost() == S2.getCost()){
			if(S1.getPartition().size() < S2.getPartition().size())
				value = -1;
			else
				value = 1;
		}
		return value;
	}	
}
