import java.util.Comparator;

/**
 * 
 * Comparador o qual deixa estruturas 
 * 	na mesma ordem que elementos foram lidos do arquivo
 *
 */
public class SubSetIdComparator implements Comparator<SubSet>{

	@Override
	public int compare(SubSet S1, SubSet S2) {
		int value = 0;
		if(S1.getId() > S2.getId())
			value = 1;
		else if(S1.getId() < S2.getId())
			value = -1;
		return value;
	}

}
