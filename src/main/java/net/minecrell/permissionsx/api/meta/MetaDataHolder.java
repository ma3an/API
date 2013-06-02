package net.minecrell.permissionsx.api.meta;

/**
 * Represents a Specific Entity / Object with can handle MetaData Values
 * @since 0.0.1a
 * @author MP5K
 * @version 0.0.1a
 */
public interface MetaDataHolder {

	/**
	 * Sets a Specific MetaData Value
	 * @param data the MetaData to set
	 */
	public abstract void setMetaData(MetaData data);

	/**
	 * Checks if the Object has a Specfic MetaData set
	 * @param data the MetaData to check
	 * @return true if the Data is set false otherwise
	 */
	public abstract boolean hasMetaData(String data);

	/**
	 * Returns a Specific MetaData. Identified by it's name.
	 * @param name the Name
	 * @return the MetaData null if not found.
	 */
	public abstract MetaData getMetaData(String name);
}
