package uk.co.hydodev.analysis.components.nets;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateMidnight;


public class DefaultNetFlow implements NetFlow {

	private final Map<DateMidnight, Double> mnf = new HashMap<DateMidnight, Double>();

	public void setMNF(final DateMidnight dt, final double mnf) {
		this.mnf.put(dt, mnf);
	}

	/* (non-Javadoc)
	 * @see uk.co.hydodev.analysis.nets.NetFlow#getMNF(org.joda.time.DateMidnight)
	 */
	@Override
	public Double getMNF(final DateMidnight dt) {
		return mnf.get(dt);
	}

}
