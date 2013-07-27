package uk.co.hydodev.analysis.components.areas;

import org.joda.time.DateMidnight;

import uk.co.hydodev.analysis.components.losses.LossComponent;
import uk.co.hydodev.analysis.components.nets.NetFlow;

public interface Area {

	/*
	 * Managed by Lombok properties in concrete classes
	 */
	public String getName();
	public void setName(final String name);
	public String getReferance1();
	public void setReferance1( final String referance1);
	public String getReferance2();
	public void setReferance2( final String referance2);

	public Double getLeakage(final DateMidnight dt);
	public void setNetFlow(final NetFlow nf);
	public NetFlow getNetFlow();
	public void addComponent(final LossComponent component);



}
