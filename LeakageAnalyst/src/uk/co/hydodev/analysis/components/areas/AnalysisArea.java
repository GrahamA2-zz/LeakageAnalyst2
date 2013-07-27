package uk.co.hydodev.analysis.components.areas;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.DateMidnight;

import uk.co.hydodev.analysis.components.losses.LossComponent;
import uk.co.hydodev.analysis.components.nets.NetFlow;


public class AnalysisArea extends AbstractArea {

	@Getter @Setter private NetFlow netFlow;
	List<LossComponent> lossComponents = new ArrayList<LossComponent>();

 
	@Override
	public Double getLeakage(final DateMidnight dt) {
		Double mnf = netFlow.getMNF(dt);
		//process each loss component and deduct the loss
		//TODO find a way to include the time
		for (final LossComponent fc : lossComponents){
			mnf -= fc.getValue();
		}
		return mnf;
	}


	@Override
	public void addComponent(final LossComponent component) {
		this.lossComponents.add(component);

	}





}
