package net.minecrell.permissionsx.entity;

import org.bukkit.OfflinePlayer;

/**
 * Represents a Specific Offline Permission User
 * @since 0.0.1a
 * @author MP5K
 * @version 0.0.1a
 */
public interface OfflinePermissionUser {

	/**
	 * Returns the Name used to identify the User
	 * @return the Username.
	 */
	public abstract String getName();
	
	/**
	 * Returns the User as a Valid Bukkit OfflinePlayer
	 * @return the OfflinePlayer Object, never null
	 * @see org.bukkit.entity.OfflinePlayer
	 */
	public abstract OfflinePlayer getBukkitPlayer();
	
	//TODO OfflinePermissionUser interface
	
}
