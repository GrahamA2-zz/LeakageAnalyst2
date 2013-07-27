package uk.co.hydodev.analysis.components.losses;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractLossComponent implements LossComponent {

	@Getter @Setter String description;
	@Getter @Setter String type;


}