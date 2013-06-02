package net.minecrell.permissionsx.api.entity;

import java.util.List;

import net.minecrell.permissionsx.api.meta.MetaDataHolder;

import org.bukkit.OfflinePlayer;
import org.bukkit.permissions.Permission;

/**
 * Represents a Specific Offline Permission User
 * @since 0.0.1a
 * @author MP5K
 * @version 0.0.1a
 */
public interface OfflinePermissionUser extends MetaDataHolder {

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

	/**
	 * Checks if the Group meets the Specific Permission Requirements.
	 * @param name the Permission to check
	 * @return true if the Permission could be found false otherwise
	 */
	public abstract boolean hasPermission(String name);

	/**
	 * Sets or unset's a Specific Permission
	 * @param name the Permission to set/unset
	 * @param flag true if the permission should be added false otherwise
	 */
	public abstract void setPermission(String name, boolean flag);

	/**
	 * Wrapper Function for: <code>setPermission({name} , true) </code>
	 * @param name the Permission to add
	 */
	public abstract void addPermission(String name);

	/**
	 * Wrapper Function for: <code>setPermission({name} , false) </code>
	 * @param name the Permission to remove
	 */
	public abstract void removePermission(String name);

	/**
	 * Returns the Players Permissions as a List<Permission>
	 * @return the permissions
	 * @see import org.bukkit.permissions.Permission;
	 */
	public abstract List<Permission> getPermissions();

	/**
	 * Returns the Users Primary Group
	 * @return the Group never null
	 */
	public abstract PermissionGroup getPrimaryGroup();

	/**
	 * Returns every Group the user is member in
	 * @return the Groups as a <code> ArrayList </code>
	 */
	public abstract List<PermissionGroup> getGroups();

	/**
	 * Checks if the User is member in the Specific Group
	 * @param group the Group Name
	 * @return true if the player is a member false otherwise
	 */
	public abstract boolean isMember(String group);

	// TODO: Documentation
	public abstract boolean setMember(PermissionGroup group, boolean flag);

	// TODO OfflinePermissionUser interface

}
