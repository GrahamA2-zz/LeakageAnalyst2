package uk.co.hydodev.analysis.components.losses;

public interface LossComponent {

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract String getType();

	public abstract void setType(String type);

	/* (non-Javadoc)
	 * @see uk.co.hydodev.analysis.components.losses.LossComponent#getValue()
	 */
	public abstract Double getValue();

}