package net.minecrell.permissionsx.api.entity;

import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.permissions.Permission;

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
	 * @see org.bukkit.OfflinePlayer
	 */
	public abstract OfflinePlayer getBukkitPlayer();
	
	public abstract void setPermission(String name , boolean flag);
	public abstract boolean hasPermission(String name);
	
	/**
	 * Returns the Players Permissions as a List<Permission>
	 * @return the permissions
	 * @see import org.bukkit.permissions.Permission;
	 */
	public abstract List<Permission> getPermissions();
	
	//TODO OfflinePermissionUser interface
	
}
