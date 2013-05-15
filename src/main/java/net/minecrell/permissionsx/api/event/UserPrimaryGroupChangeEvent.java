package net.minecrell.permissionsx.api.event;

import net.minecrell.permissionsx.api.entity.OfflinePermissionUser;
import net.minecrell.permissionsx.api.entity.PermissionGroup;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Called when a permission user's primary group changes.
 * @author Minecrell
 * @since 0.0.1a
 * @version 0.0.1a
 */
public class UserPrimaryGroupChangeEvent extends OfflinePermissionUserEvent implements Cancellable {
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;
	private final PermissionGroup from, to;

	/**
	 * Creates a PrimaryGroupChangeEvent for a player.
	 * @param who Permission user who is involved in this event
	 * @param from 
	 * @param to 
	 */
	public UserPrimaryGroupChangeEvent(OfflinePermissionUser user, PermissionGroup from, PermissionGroup to) {
		super(user);
		this.from = from;
		this.to = to;
	}
	
	/**
	 * Gets the previous permission group of the permission user.
	 * @return Previous permission group
	 */
	public PermissionGroup getPreviousGroup() {
		return from;
	}
	
	/**
	 * Gets the new permission group for the permission user.
	 * @return New permission group
	 */
	public PermissionGroup getNewGroup() {
		return to;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.event.Cancellable#isCancelled()
	 */
	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.event.Cancellable#setCancelled(boolean)
	 */
	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.event.Event#getHandlers()
	 */
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
