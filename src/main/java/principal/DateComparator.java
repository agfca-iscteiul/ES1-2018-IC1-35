package principal;

import java.util.Comparator;

/**
 * Comparador para comparar as datas dos posts
 */
public class DateComparator implements Comparator<AbstractInfo> {
	@Override
	public int compare(AbstractInfo a1, AbstractInfo a2) {

		return a1.getData().compareTo(a2.getData());
	}

}
