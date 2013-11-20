public class SubSetSizeComparator implements Comparator<SubSet>{

	@Override
	public int compare(SubSet S1, SubSet S2){
		int s1Size = S1.getPartition().size();
		int s2Size = S2.getPartition().size();
		int value = -1;
		if(s1Size < s2Size)
			value = 1;
		return value;
	}
}
