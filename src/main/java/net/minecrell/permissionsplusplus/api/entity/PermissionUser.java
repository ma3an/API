package net.minecrell.permissionsplusplus.api.entity;

import net.minecrell.permissionsplusplus.api.PermissionManager;

import org.bukkit.entity.Player;

/**
 * Represents a Specific Permission User
 * @since 0.0.1a
 * @author MP5K
 * @version 0.0.1a
 */
public interface PermissionUser extends OfflinePermissionUser {

	/**
	 * Returns the Permission Manager the Player is handled by.
	 * @return the Permission Manager, never null.
	 */
	public abstract PermissionManager getManager();

	/**
	 * Returns the User as a valid Bukkit Player
	 * @return the Player Object, never null
	 * @see org.bukkit.entity.Player
	 */
	@Override
	public abstract Player getBukkitPlayer();

	/**
	 * Sets the Player Operator status
	 * @param flag the Status to set (true for op, false for user)
	 */
	public abstract void setOP(boolean flag);

	// TODO PermissionUser interface

}
