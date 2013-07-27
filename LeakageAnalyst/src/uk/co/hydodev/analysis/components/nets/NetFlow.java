package uk.co.hydodev.analysis.components.nets;

import org.joda.time.DateMidnight;

public interface NetFlow {

	public abstract Double getMNF(final DateMidnight dt);

}