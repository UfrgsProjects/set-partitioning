import java.util.Comparator;


public class SubSetIdComparator implements Comparator<SubSet>{

	@Override
	public int compare(SubSet o1, SubSet o2) {
		int value = 0;
		if(o1.getId() < o2.getId())
			value = -1;
		else if(o1.getId() > o2.getId())
			value = 1;
		return value;
	}
}
