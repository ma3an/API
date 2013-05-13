package net.minecrell.permissionsx.entity;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import net.minecrell.permissionsx.PermissionManager;

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
	 * Returns the User as a Valid Bukkit Player
	 * @return the Player Object, nerver null
	 * @see org.bukkit.entity.player
	 */
	public abstract Player asBukkitPlayer();
	
	/**
	 * Returns the Players Permissions as a List<Permission>
	 * @return the permissions
	 * @see import org.bukkit.permissions.Permission;
	 */
	public abstract List<Permission> getPermissions();
	
	//TODO PermissionUser interface
	
}
