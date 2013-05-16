package net.minecrell.permissionsx.api.entity;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import net.minecrell.permissionsx.api.PermissionManager;

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
	public abstract Player getBukkitPlayer();
	
	//TODO PermissionUser interface
	
}
