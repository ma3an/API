package net.minecrell.permissionsx.api.event;

import net.minecrell.permissionsx.api.entity.OfflinePermissionUser;

/**
 * Represents a permission user related event.
 * @author Minecrell
 * @since 0.0.1a
 * @version 0.0.1a
 */
public abstract class OfflinePermissionUserEvent extends PermissionEvent {
	private final OfflinePermissionUser user;
	
	/**
	 * Creates a permission user related event.
	 * @param user The event related permission user (can be offline)
	 */
	public OfflinePermissionUserEvent(final OfflinePermissionUser user) {
		this.user = user;
	}
	
	/**
	 * Returns the permission user involved in this event
	 * @return OfflinePermissionUser of this event
	 */
	public OfflinePermissionUser getUser() {
		return user;
	}

}
